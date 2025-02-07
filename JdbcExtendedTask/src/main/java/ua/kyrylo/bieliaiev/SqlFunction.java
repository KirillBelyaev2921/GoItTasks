package ua.kyrylo.bieliaiev;

import java.io.FileNotFoundException;
import java.sql.SQLException;

@FunctionalInterface
public interface SqlFunction<T, R> {

    R apply(T t) throws SQLException, FileNotFoundException;

}
