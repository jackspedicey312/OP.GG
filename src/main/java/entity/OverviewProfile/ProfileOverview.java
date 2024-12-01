package entity.OverviewProfile;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class ProfileOverview {
    private String username;
    private String tagline;
    private String summonerId;
    private int summonerLevel;
    private ImageIcon summonerImage;

    public ProfileOverview(String username, String tagline, String summonerId, int summonerLevel, int iconID)
            throws IOException {
        this.username = username;
        this.tagline = tagline;
        this.summonerId = summonerId;
        this.summonerLevel = summonerLevel;
        this.summonerImage = getIconPng(iconID);
    }
    public String getUsername() {
        return username;
    }
    public String getTagline() {
        return tagline;
    }

    public String getSummonerId() {
        return summonerId;
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
