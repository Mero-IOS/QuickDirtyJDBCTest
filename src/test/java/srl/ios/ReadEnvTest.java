package srl.ios;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ReadEnvTest implements ReadEnv {
    @Test
    public void checkPW() {
        assertEquals(ReadEnv.getDbPassword(), "root");
    }

    @Test
    public void checkUser() {
        assertEquals(ReadEnv.getDbUser(), "root");
    }

    @Test
    public void checkUrl() {
        assertEquals(ReadEnv.getDbUrl(), "jdbc:mysql://127.0.0.1/jdbc");
    }
}
