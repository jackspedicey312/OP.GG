package interface_adapter.profile;

import use_case.overview.OverviewOutputBoundary;

import javax.swing.*;

public class ProfilePresenter implements OverviewOutputBoundary {

    private ImageIcon profileIcon;
    private int profileLevel;
    private String gameMode;
    private String rank;
    private String division;
    private int leaguePoints;
    private int wins;
    private int losses;
    private int winRate;
    private String errorMessage;


    public void presentProfileIcon(ImageIcon icon) {
        this.profileIcon = icon;
        System.out.println(icon);
    }

    public void presentProfileLevel(int level) {
        this.profileLevel = level;
        System.out.println(level);
    }

    public void presentGamemode(String gameMode) {
        this.gameMode = gameMode;
        System.out.println(gameMode);
    }

    public void presentRank(String rank) {
        this.rank = rank;
        System.out.println(rank);
    }
    public void presentDivision(String division) {
        this.division = division;
        System.out.println(division);
    }
    public void presentLeaguePoints(int leaguePoints) {
        this.leaguePoints = leaguePoints;
        System.out.println(leaguePoints);
    }

    public void presentWins(int wins) {
        this.wins = wins;
    }
    public void presentLosses(int losses) {
        this.losses = losses;
    }

    public void presentWinRate(int winRate) {
        this.winRate = winRate;
        System.out.println(winRate);
    }

    public void presentError(String message) {
        this.errorMessage = message;
        System.out.println("Error" + errorMessage);
    }

    public ImageIcon getProfileIcon() {
        return profileIcon;
    }

    public int getProfileLevel() {

        return profileLevel;
    }
    public String getGameMode() {
        return gameMode;
    }
    public String getRank() {
        return rank;
    }
    public String getDivision() {
        return division;
    }
    public int getLeaguePoints() {
        return leaguePoints;
    }
    public int getWins() {
        return wins;
    }
    public int getLosses() {
        return losses;
    }
    public int getWinRate() {
        return winRate;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
