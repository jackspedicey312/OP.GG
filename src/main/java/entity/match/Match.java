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
    private final String winOrLoss;
    private final String duration;
    private final String gameMode;
    private final String date;

    public Match(ImageIcon championIcon, int kills, int deaths, int assissts, boolean winOrLoss, int time, String gameMode, long unixTime) {
        this.championIcon = championIcon;
        this.kills = kills;
        this.deaths = deaths;
        this.assissts = assissts;
        if (winOrLoss) {
            this.winOrLoss = "Win";
        }
        else {
            this.winOrLoss = "Defeat";
        }
        this.duration = secondsToMinutes(time);
        this.gameMode = gameMode;
        this.date = unixConverter(unixTime);
    }

    public static String unixConverter(long unixCode) {
        Instant instant = Instant.ofEpochMilli(unixCode);

        // Define a formatter for a readable date-time format with the system's time zone
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss")
                .withZone(ZoneId.systemDefault());

        // Format the Instant to a human-readable string
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

    public String getWinOrLoss() {
        return winOrLoss;
    }

    public String getDuration() {
        return duration;
    }

    public String getGameMode() {
        return gameMode;
    }

    public String getDate() {
        return date;
    }

    public String secondsToMinutes(int time) {
        final int hour = time / 3600;
        final int minute = (time - hour * 3600) / 60;
        final int second = (time - hour * 3600) % 60;
        final String hours = String.valueOf(hour);
        final String minutes = String.valueOf(minute);
        final String seconds = String.valueOf(second);
        final String h = "h";
        final String m = "min";
        final String s = "s";
        if (hour != 0) {
            return hours + h + minutes + m + seconds + s;
        }
        else if (minute != 0) {
            return minutes + m + seconds + s;
        }
        else {
            return seconds + s;
        }
    }
}
