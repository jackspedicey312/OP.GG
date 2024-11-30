package entity;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class ProfileOverview {
    private String summonerID;
    private int summonerLevel;
    private ImageIcon summonerImage;

    public ProfileOverview(String summonerID, int summonerLevel, int iconID) throws IOException {
        this.summonerID = summonerID;
        this.summonerLevel = summonerLevel;
        this.summonerImage = getIconPng(iconID);
    }

    public String getSummonerID() {
        return summonerID;
    }

    public int getSummonerLevel() {
        return summonerLevel;
    }

    public ImageIcon getSummonerImage() {
        return summonerImage;
    }

    /**
     * @throws IOException if icon png cannot be found with the given iconID.
     *                     Returns the icon png with the given iconID.
     */

    public ImageIcon getIconPng(int iconID) throws IOException {
        final String iconId2 = Integer.toString(iconID);
        final String pngURL = "https://ddragon.leagueoflegends.com/cdn/14.22.1/img/profileicon/"
                + iconId2 + ".png";

        try {
            final URL url = new URL(pngURL);
            final BufferedImage img = ImageIO.read(url);
            ImageIcon iconPng = new ImageIcon(img);
            return iconPng;
        }
        catch (IOException e) {
            System.err.println("Error fetching the icon: " + e.getMessage());
            return null;
        }
    }
}
