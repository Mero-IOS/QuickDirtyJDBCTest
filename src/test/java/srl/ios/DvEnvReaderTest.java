package srl.ios;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DvEnvReaderTest extends DbEnvReader {
    @Test
    public void checkPW() {
        assertEquals(getDbPassword(), "root");
    }

    @Test
    public void checkUser() {
        assertEquals(getDbUser(), "root");
    }

    @Test
    public void checkUrl() {
        assertEquals(getDbUrl(), "jdbc:mysql://127.0.0.1/jdbc");
    }
}
