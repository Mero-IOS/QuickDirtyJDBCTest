package srl.ios;

import io.github.cdimascio.dotenv.Dotenv;

class StaticDbEnvReader {

    private final static String DB_URL = Dotenv.load().get("DB_URL");
    private final static String DB_USER = Dotenv.load().get("DB_USERNAME");
    private final static String DB_PASSWORD = Dotenv.load().get("DB_PASSWORD");

    protected static String getDbUrl() {
        return DB_URL;
    }

    protected static String getDbUser() {
        return DB_USER;
    }

    protected static String getDbPassword() {
        return DB_PASSWORD;
    }
}
