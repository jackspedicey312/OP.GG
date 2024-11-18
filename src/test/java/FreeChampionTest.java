import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class FreeChampionTest {

    @Test
    public void testFreeChampion() throws IOException {
        FreeChampionRotation rotation = new FreeChampionRotation();
        rotation.generateCurrentFreeRotation();

        assertEquals("Aatrox", rotation.getChampionName(266));
        assertEquals("Twitch", rotation.getChampionName(29));

    }
}
