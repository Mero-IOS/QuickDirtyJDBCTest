package srl.ios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public final class StaticConnectSQL implements AutoCloseable {
    private static Connection dbConnected;

    private static void connect() throws SQLException {
        dbConnected = DriverManager.getConnection(StaticDbEnvReader.getDbUrl(), StaticDbEnvReader.getDbUser(),
                StaticDbEnvReader.getDbPassword());
    }

    public static void disconnect() throws SQLException {
        dbConnected.close();
    }

    protected static void runTestStatement(String query) throws SQLException {
        if (dbConnected == null || dbConnected.isClosed()) {
            connect();
        }
        Statement testStatement = dbConnected.createStatement();
        testStatement.execute(query);
        disconnect();
    }

    @Override
    public void close() throws Exception {
        if (dbConnected != null) {
            dbConnected.close();
        }
    }

}
