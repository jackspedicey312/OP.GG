package entity.FunFacts;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class FunFacts {
    private int totalPlaytime;
    private int totalWins;
    private int totalLosses;
    private int totalKills;
    private int totalDeaths;
    private long oldestGamePlayedUnix;
    private int longestGamePlayed;
    private long longestGamePlayedDate;
    private int totalSurrenders;
    private int totalPentakills;
    private int totalSurvivedSingleDigitHp;
    private int totalSnowballsHit;
    private int totalSavedAllies;

    public static String unixConverter(long unixCode) {
        Instant instant = Instant.ofEpochSecond(unixCode);

        // Define a formatter for a readable date-time format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss")
                .withZone(ZoneId.systemDefault());

        return formatter.format(instant);
    }

    public void setTotalPlaytime(int totalPlaytime) {
        this.totalPlaytime = totalPlaytime;
    }

    public void setTotalWins(int totalWins) {
        this.totalWins = totalWins;
    }

    public void setTotalLosses(int totalLosses) {
        this.totalLosses = totalLosses;
    }

    public void setTotalKills(int totalKills) {
        this.totalKills = totalKills;
    }

    public void setTotalDeaths(int totalDeaths) {
        this.totalDeaths = totalDeaths;
    }

    public void setOldestGamePlayedUnix(long oldestGamePlayedUnix) {
        this.oldestGamePlayedUnix = oldestGamePlayedUnix;
    }

    public void setLongestGamePlayed(int longestGamePlayed) {
        this.longestGamePlayed = longestGamePlayed;
    }

    public void setLongestGamePlayedDate(long longestGamePlayedDate) {
        this.longestGamePlayedDate = longestGamePlayedDate;
    }

    public void setTotalSurrenders(int totalSurrenders) {
        this.totalSurrenders = totalSurrenders;
    }

    public void setTotalPentakills(int totalPentakills) {
        this.totalPentakills = totalPentakills;
    }

    public void setTotalSurvivedSingleDigitHp(int totalSurvivedSingleDigitHp) {
        this.totalSurvivedSingleDigitHp = totalSurvivedSingleDigitHp;
    }

    public void setTotalSnowballsHit(int totalSnowballsHit) {
        this.totalSnowballsHit = totalSnowballsHit;
    }

    public void setTotalSavedAllies(int totalSavedAllies) {
        this.totalSavedAllies = totalSavedAllies;
    }

    public int getTotalPlaytime() {
        return totalPlaytime / 3600;
    }

    public int getLongestGamePlayed() {
        return longestGamePlayed / 60;
    }

    public String getOldestGamePlayed() {
        return unixConverter(oldestGamePlayedUnix);
    }

    public String getLongestGamePlayedDate() {
        return unixConverter(longestGamePlayedDate);
    }

    public int getTotalSurvivedSingleDigitHp() {
        return totalSurvivedSingleDigitHp;
    }

    public int getTotalSurrenders() {
        return totalSurrenders;
    }

    public int getTotalPentakills() {
        return totalPentakills;
    }

    public int getTotalKills() {
        return totalKills;
    }

    public int getTotalDeaths() {
        return totalDeaths;
    }

    public int getTotalLosses() {
        return totalLosses;
    }

    public int getTotalWins() {
        return totalWins;
    }

    public int getTotalSnowballsHit() {
        return totalSnowballsHit;
    }

    public int getTotalSavedAllies() {
        return totalSavedAllies;
    }
}
