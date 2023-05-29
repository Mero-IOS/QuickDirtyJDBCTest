package srl.ios;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ConnectSQLTest extends ConnectSQL {
    private static ByteArrayOutputStream outputOnScreen;

    private String getCleanOutput() {
        return outputOnScreen.toString().replaceAll("[\r\n]", "");
    }

    @BeforeAll
    public static void setup() {
        outputOnScreen = new ByteArrayOutputStream();
    }

    @BeforeEach
    void prepareOut() {
        System.setOut(new PrintStream(outputOnScreen));
        outputOnScreen.reset();
    }

    @Test
    public void testQueries() throws SQLException {
        new ConnectSQLTest().runTestStatement(
                "CREATE TABLE test " +
                        "(id INTEGER not NULL, " +
                        " name VARCHAR(255), " +
                        " PRIMARY KEY ( id ))");
        System.out.println("Table created successfully");

        new ConnectSQLTest().runTestStatement(
                "DROP TABLE test");
        System.out.println("Table dropped successfully");

        assertEquals("Table created successfullyTable dropped successfully", getCleanOutput());
    }
}
