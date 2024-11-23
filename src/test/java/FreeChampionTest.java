import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FreeChampionTest {

    @Test
    public void testFreeChampion() throws IOException {
        FreeChampionRotation rotation = new FreeChampionRotation();
        rotation.generateCurrentFreeRotation();

        assertEquals("Aatrox", rotation.getChampionName(266));
        assertEquals("Twitch", rotation.getChampionName(29));
        assertEquals("Kaisa", rotation.getChampionName(145));

    }

    @Test
    public void testFreeChampion2() throws IOException {
        FreeChampionRotation rotation = new FreeChampionRotation();
        rotation.generateCurrentFreeRotation();

        // This rotation is updated for Nov 23. It updates every week.

        List<String> currentRotation = Arrays.asList("Kayle", "Alistar", "Warwick", "Corki", "Swain", "Caitlyn",
                "JarvanIV", "LeeSin", "Skarner", "Heimerdinger", "Mordekaiser", "KogMaw", "Fizz", "Rengar", "Viktor",
                "Fiora", "Jayce", "Lissandra", "Quinn", "Akshan", "Jinx", "TahmKench", "Ekko", "Vi", "Kalista", "Bard",
                "Pyke", "Ambessa", "Smolder");

        assertEquals(currentRotation, rotation.getFreeChampionsList());
        assertEquals(currentRotation, rotation.getFreeChampionsListIcons());

    }
}
