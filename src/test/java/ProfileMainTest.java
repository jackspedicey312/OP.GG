import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class ProfileMainTest {
    @Test
    public void profileTest() throws IOException {
        String puuid = "8hoXdNc3LTEFi-kOUujabW4_Am7Hk_aH9vCCX2XkqxgtQ9z1myhd76IQk14Cjhd2bw4RPeZsev363w";
        String region = "NA";

        ProfileMain exampleProfile = new ProfileMain(puuid, region);
        exampleProfile.generateProfileData();

        assertEquals("nItPoQnTxCT4hMMqcmUyqNcjKdDHRlPEEmj5CLiK7TWRWUAw",
                exampleProfile.getSummonerID());

        assertEquals("J00LlLnPYQhzWQtJ3StJ4KLEbZUYIdpWdKiStLwClrT6HNG9qfkOs9W9",
                exampleProfile.getAccountID());

        assertEquals(454, exampleProfile.getSummonerLevel());

        assertEquals(4965, exampleProfile.getIconID());

    }
}
