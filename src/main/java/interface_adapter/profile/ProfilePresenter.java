package interface_adapter.profile;

import use_case.overview.OverviewOutputBoundary;

import javax.swing.*;

public class ProfilePresenter implements OverviewOutputBoundary {

    private ImageIcon profileIcon;
    private int profileLevel;
    private String errorMessage;

    public void presentProfileIcon(ImageIcon icon) {
        this.profileIcon = icon;
        System.out.println(icon);
    }

    public void presentProfileLevel(int level) {
        this.profileLevel = level;
        System.out.println(level);
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

    public String getErrorMessage() {
        return errorMessage;
    }

}
