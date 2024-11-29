package interface_adapter.funfacts;

import use_case.funfacts.FunFactsOutputBoundary;

public class FunFactPresenter implements FunFactsOutputBoundary {
    private int totalPlaytime;
    private int totalWins;
    private int totalLosses;
    private int totalKills;
    private int totalDeaths;
    private String oldestGamePlayed;
    private int longestGamePlayed;
    private String longestGamePlayedDate;
    private int totalSurrenders;
    private int totalPentakills;
    private int totalSurvivedSingleDigitHp;
    private int totalSnowballsHit;
    private int totalSavedAllies;

    public void presentTotalPlaytime(int Playtime) {
        this.totalPlaytime = Playtime;
    }

    public void presentTotalWins(int wins) {
        this.totalWins = wins;
    }

    public void presentTotalLosses(int loss) {
        this.totalLosses = loss;
    }

    public void presentTotalKills(int kills) {
        this.totalKills = kills;
    }

    public void presentTotalDeaths(int deaths) {
        this.totalDeaths = deaths;
    }

    public void presentLongestGamePlayed(int longestGame) {
        this.longestGamePlayed = longestGame;
    }

    public void presentLongestGamePlayedDate(String longestGameDate) {
        this.longestGamePlayedDate = longestGameDate;
    }

    public void presentOldestGamePlayed(String oldestGame) {
        this.oldestGamePlayed = oldestGame;
    }

    public void presentTotalSurvivedSingleDigitHp(int survivedSingleDigitHp) {
        this.totalSurvivedSingleDigitHp = survivedSingleDigitHp;
    }

    public void presentTotalSurrenders(int Surrenders) {
        this.totalSurrenders = Surrenders;
    }

    public void presentTotalPentakills(int Pentakills) {
        this.totalPentakills = Pentakills;
    }

    public void presentTotalSnowballs(int totalSnowballs) {
        this.totalSnowballsHit = totalSnowballs;
    }

    public void presentTotalSavedAllies(int savedAllies) {
        this.totalSavedAllies = savedAllies;
    }

    public int getTotalPlaytime() {
        return totalPlaytime;
    }

    public int getTotalWins() {
        return totalWins;
    }
    public int getTotalLosses() {
        return totalLosses;
    }
    public int getTotalKills() {
        return totalKills;
    }
    public int getTotalDeaths() {
        return totalDeaths;
    }
    public String getOldestGamePlayed() {
        return oldestGamePlayed;
    }
    public int getLongestGamePlayed() {
        return longestGamePlayed;
    }
    public String getLongestGamePlayedDate() {
        return longestGamePlayedDate;
    }
    public int getTotalSurrenders() {
        return totalSurrenders;
    }
    public int getTotalPentakills() {
        return totalPentakills;
    }
    public int getTotalSurvivedSingleDigitHp() {
        return totalSurvivedSingleDigitHp;
    }
    public int getTotalSnowballsHit() {
        return totalSnowballsHit;
    }
    public int getTotalSavedAllies() {
        return totalSavedAllies;
    }
}
