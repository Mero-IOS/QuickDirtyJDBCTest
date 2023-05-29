package srl.ios;

import io.github.cdimascio.dotenv.Dotenv;

interface ReadEnv {

    public static final Dotenv dotenv = Dotenv.load();
    public static final String dbUrl = dotenv.get("DB_URL");
    public static final String dbUser = dotenv.get("DB_USERNAME");
    public static final String dbPassword = dotenv.get("DB_PASSWORD");

    public static String getDbUrl() {
        System.out.println(dbUrl);
        return dbUrl;
    }

    public static String getDbUser() {
        System.out.println(dbUser);
        return dbUser;
    }

    public static String getDbPassword() {
        System.out.println(dbPassword);
        return dbPassword;
    }
}
