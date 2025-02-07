package ua.kyrylo.bieliaiev;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClientServiceImpl implements ClientService {

    private PreparedStatement createSt;
    private PreparedStatement getSt;
    private PreparedStatement updateSt;
    private PreparedStatement deleteSt;
    private PreparedStatement getAllSt;

    public ClientServiceImpl(Connection con) throws SQLException {
        createSt = con.prepareStatement(
                "INSERT INTO CLIENT (name) VALUES (?)", Statement.RETURN_GENERATED_KEYS
        );
        getSt = con.prepareStatement(
                "SELECT name FROM CLIENT WHERE ID = ?"
        );
        updateSt = con.prepareStatement(
                "UPDATE CLIENT SET NAME = ? WHERE ID = ?"
        );
        deleteSt = con.prepareStatement(
                "DELETE FROM CLIENT WHERE ID = ?"
        );
        getAllSt = con.prepareStatement(
                "SELECT CLIENT.ID, CLIENT.NAME FROM CLIENT"
        );
    }

    @Override
    public long create(String name) throws SQLException {
        createSt.setString(1, name);
        createSt.executeUpdate();
        ResultSet rs = createSt.getGeneratedKeys();
        if (rs.next()) {
            return rs.getInt(1);
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getById(long id) throws SQLException {
        getSt.setLong(1, id);
        ResultSet rs = getSt.executeQuery();

        if (!rs.next()) {
            return null;
        }

        return rs.getString("name");
    }

    @Override
    public void setName(long id, String name) throws SQLException {
        updateSt.setString(1, name);
        updateSt.setLong(2, id);
        updateSt.executeUpdate();
    }

    @Override
    public void deleteById(long id) throws SQLException {
        deleteSt.setLong(1, id);
        deleteSt.executeUpdate();
    }

    @Override
    public List<Client> listAll() throws SQLException {
        ResultSet rs = getAllSt.executeQuery();
        List<Client> clients = new ArrayList<>();
        while (rs.next()) {
            clients.add(new Client(
                    rs.getLong("id"),
                    rs.getString("name")
            ));
        }
        return clients;
    }
}
