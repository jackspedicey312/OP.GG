package data_access;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * Get champion icon for champion view.
 */
public class RiotAPIChampionIconDataAccess {

    private static final String CHAMPION_ICON_BASE_URL = "https://ddragon.canisback.com/img/champion/tiles/";

    /**
     * Fetches the champion's icon as an ImageIcon.
     *
     * @param championName The name of the champion.
     * @return The ImageIcon for the champion.
     * @throws IOException If there is an issue fetching the icon.
     */
    public ImageIcon getChampionIcon(String championName) throws IOException {
        final String url = CHAMPION_ICON_BASE_URL + championName + "_0.jpg";
        final URL completeUrl = new URL(url);

        try {
            BufferedImage img = ImageIO.read(completeUrl);
            return new ImageIcon(img);
        }
        catch (IOException e) {
            System.err.println("Error fetching icon for champion: " + championName);
            return new ImageIcon();
        }
    }
}
