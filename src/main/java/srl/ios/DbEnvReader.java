package srl.ios;

import io.github.cdimascio.dotenv.Dotenv;

class DbEnvReader {

    private final String DB_URL = Dotenv.load().get("DB_URL");
    private final String DB_USER = Dotenv.load().get("DB_USERNAME");
    private final String DB_PASSWORD = Dotenv.load().get("DB_PASSWORD");

    protected String getDbUrl() {
        return DB_URL;
    }

    protected String getDbUser() {
        return DB_USER;
    }

    protected String getDbPassword() {
        return DB_PASSWORD;
    }
}
