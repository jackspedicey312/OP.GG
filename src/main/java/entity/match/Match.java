package entity.match;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import javax.swing.ImageIcon;

/**
 * Represents a match retrieved from Riot API.
 */
public class Match {
    private final ImageIcon championIcon;
    private final int kills;
    private final int deaths;
    private final int assissts;
    private final int duration;
    private final String gameMode;
    private final String date;

    public Match(ImageIcon championIcon, int kills, int deaths, int assissts, int duration, String gameMode, long unixTime) {
        this.championIcon = championIcon;
        this.kills = kills;
        this.deaths = deaths;
        this.assissts = assissts;
        this.duration = duration;
        this.gameMode = gameMode;
        this.date = unixConverter(unixTime);
    }

    public static String unixConverter(long unixCode) {
        final Instant instant = Instant.ofEpochSecond(unixCode);

        // Define a formatter for a readable date-time format
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss")
                .withZone(ZoneId.systemDefault());

        return formatter.format(instant);
    }

    public ImageIcon getChampionIcon() {
        return championIcon;
    }

    public int getKills() {
        return kills;
    }

    public int getDeaths() {
        return deaths;
    }

    public int getAssissts() {
        return assissts;
    }

    public int getDuration() {
        return duration;
    }

    public String getGameMode() {
        return gameMode;
    }

    public String getDate() {
        return date;
    }
}
