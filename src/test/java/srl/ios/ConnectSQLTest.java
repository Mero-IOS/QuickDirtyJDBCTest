package srl.ios;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

public class ConnectSQLTest {
    private ConnectSQL connection;

    @Test
    public void testQueries() throws SQLException {

        connection = new ConnectSQL();
        connection.runTestStatement(
                "CREATE TABLE test " +
                        "(id INTEGER not NULL, " +
                        " name VARCHAR(255), " +
                        " PRIMARY KEY ( id ))");
        connection.runTestStatement(
                "DROP TABLE test");

        assertTrue(true);
    }
}
