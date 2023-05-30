package srl.ios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectSQL {

    Connection dbConnected;
    DbEnvReader storedEnv;

    public ConnectSQL() {
        storedEnv = new DbEnvReader();
    }

    public ConnectSQL(DbEnvReader dbEnv) {
        storedEnv = dbEnv;
    }

    private void connect() throws SQLException {
        dbConnected = DriverManager.getConnection(storedEnv.getDbUrl(), storedEnv.getDbUser(),
                storedEnv.getDbPassword());
    }

    public void disconnect() throws SQLException {
        dbConnected.close();
    }

    protected void runTestStatement(String query) throws SQLException {
        if (dbConnected == null || dbConnected.isClosed()) {
            connect();
        }
        Statement testStatement = dbConnected.createStatement();
        testStatement.execute(query);
        dbConnected.close();
    }

}
