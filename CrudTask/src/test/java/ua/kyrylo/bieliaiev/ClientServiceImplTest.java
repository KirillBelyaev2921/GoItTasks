package ua.kyrylo.bieliaiev;

import org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ClientServiceImplTest {

    @Test
    void create() throws SQLException {
        Connection connection = Database.getInstance().getConnection();
        ClientService service = new ClientServiceImpl(connection);
        long client = service.create("Client");
        String name = service.getById(client);

        assertEquals("Client", name);
    }

    @Test
    void createWithWrongName() throws SQLException {
        Connection connection = Database.getInstance().getConnection();
        ClientService service = new ClientServiceImpl(connection);
        assertThrows(JdbcSQLIntegrityConstraintViolationException.class, () -> service.create("1"));
    }


    @Test
    void setName() throws SQLException {
        Connection connection = Database.getInstance().getConnection();
        ClientService service = new ClientServiceImpl(connection);
        long client = service.create("Client");
        service.setName(client, "Client 2");
        String name = service.getById(client);

        assertEquals("Client 2", name);
    }

    @Test
    void setNameWithWrongName() throws SQLException {
        Connection connection = Database.getInstance().getConnection();
        ClientService service = new ClientServiceImpl(connection);
        long client = service.create("Client");
        assertThrows(JdbcSQLIntegrityConstraintViolationException.class, () -> service.setName(client, "1"));
    }


    @Test
    void deleteById() throws SQLException {
        Connection connection = Database.getInstance().getConnection();
        ClientService service = new ClientServiceImpl(connection);
        long client = service.create("Client");
        service.deleteById(client);
        String name = service.getById(client);

        assertNull(name);
    }
}