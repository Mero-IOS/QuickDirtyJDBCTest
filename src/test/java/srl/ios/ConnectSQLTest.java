package srl.ios;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

public class ConnectSQLTest {

    @Test
    public void testQueries() throws SQLException {

        ConnectSQL.runTestStatement(
                "CREATE TABLE test " +
                        "(id INTEGER not NULL, " +
                        " name VARCHAR(255), " +
                        " PRIMARY KEY ( id ))");

        assertTrue(true);
    }

    @Test
    public void testDelete() throws SQLException {
        ConnectSQL.runTestStatement(
                "DROP TABLE test");
    }
}
