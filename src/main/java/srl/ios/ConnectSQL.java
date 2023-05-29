package srl.ios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectSQL implements ReadEnv {
    static final String url = ReadEnv.getDbUrl();
    static final String username = ReadEnv.getDbUser();
    static final String password = ReadEnv.getDbPassword();

    Connection dbConnected;

    private void connect() throws SQLException {
        dbConnected = DriverManager.getConnection(url, username, password);
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
