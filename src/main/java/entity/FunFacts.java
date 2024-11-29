package entity;

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
    private int totalsurvivedSingleDigitHp;
    private int totalSnowballsHit;
    private int totalSavedAllies;

    public static String unixConverter(long unixCode) {
        Instant instant = Instant.ofEpochSecond(unixCode);

        // Define a formatter for a readable date-time format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss")
                .withZone(ZoneId.systemDefault());

        return formatter.format(instant);
    }
    public int setTotalPlaytime(int totalPlaytime) {
        this.totalPlaytime = totalPlaytime;
    }
    public int setTotalWins(int totalWins) {
        this.totalWins = totalWins;
    }
    public int setTotalLosses(int totalLosses) {
        this.totalLosses = totalLosses;
    }
    public int setTotalKills(int totalKills) {
        this.totalKills = totalKills;
    }
    public int setTotalDeaths(int totalDeaths) {
        this.totalDeaths = totalDeaths;
    }
    public int setOldestGamePlayedUnix(long oldestGamePlayedUnix) {
        this.oldestGamePlayedUnix = oldestGamePlayedUnix;
    }
    public int setLongestGamePlayed(int longestGamePlayed) {
        this.longestGamePlayed = longestGamePlayed;
    }
    public int setLongestGamePlayedDate(long longestGamePlayedDate) {
        this.longestGamePlayedDate = longestGamePlayedDate;
    }
    public int setTotalSurrenders(int totalSurrenders) {
        this.totalSurrenders = totalSurrenders;
    }
    public int setTotalPentakills(int totalPentakills) {
        this.totalPentakills = totalPentakills;
    }
    public int setTotalSurvivedSingleDigitHp(int totalSurvivedSingleDigitHp) {
        this.totalsurvivedSingleDigitHp = totalSurvivedSingleDigitHp;
    }
    public int setTotalSnowballsHit(int totalSnowballsHit) {
        this.totalSnowballsHit = totalSnowballsHit;
    }
    public int setTotalSavedAllies(int totalSavedAllies) {
        this.totalSavedAllies = totalSavedAllies;
    }


    public int getTotalPlaytime() {
        return totalPlaytime / 3600;
    }

    public int getLongestGamePlayed() {
        return longestGamePlayed / 60;
    }

    public String getoldestGamePlayedUnix() {
        return unixConverter(oldestGamePlayedUnix);
    }

    public String getLongestGamePlayedDate() {
        return unixConverter(longestGamePlayedDate);
    }
    public int getTotalSurvivedSingleDigitHp() {
        return totalsurvivedSingleDigitHp;
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
