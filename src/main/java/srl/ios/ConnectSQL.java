package srl.ios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public final class ConnectSQL implements AutoCloseable {
    private static Connection dbConnected;
    private static DbEnvReader storedEnv = null;

    private static void setStoredEnv() {
        storedEnv = new DbEnvReader();
    }

    private static void connect() throws SQLException {
        dbConnected = DriverManager.getConnection(storedEnv.getDbUrl(), storedEnv.getDbUser(),
                storedEnv.getDbPassword());
    }

    public static void disconnect() throws SQLException {
        dbConnected.close();
    }

    protected static void runTestStatement(String query) throws SQLException {
        if (dbConnected == null) {
            ConnectSQL.setStoredEnv();
        }
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
