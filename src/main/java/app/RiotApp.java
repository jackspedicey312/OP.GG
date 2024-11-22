package app;

import entity.UserFactory;
import use_case.login.*;
import use_case.match.*;

import java.io.IOException;
import java.util.Scanner;

public class RiotApp {

    public void run() {
        // Step 1: Gather user input
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter username:");
        String username = scanner.nextLine();

        System.out.println("Enter tagline:");
        String tagline = scanner.nextLine();

        System.out.println("Enter your region (NA, ASIA, EU):");
        String region = scanner.nextLine();

        scanner.close();

        // Step 2: Initialize UserFactory
        UserFactory factory = new UserFactory();

        // Step 3: Create and execute login use case
        CLIOutputPresenter loginPresenter = new CLIOutputPresenter();
        LoginInteractor loginInteractor = factory.createLoginInteractor(loginPresenter);

        LoginInputData loginInputData = new LoginInputData(username, tagline, region);
        loginInteractor.login(loginInputData);

        // Step 4: Check if login was successful
        String puuid = loginPresenter.getPuuid();
        if (puuid != null) {
            System.out.println("\nFetching recent matches...");

            // Step 5: Fetch and display recent matches
            MatchPresenter matchPresenter = new MatchPresenter(); // Implements MatchOutputBoundary
            FetchRecentMatchesUseCase matchInteractor = factory.createFetchRecentMatchesUseCase(matchPresenter);

            try {
                matchInteractor.fetchRecentMatches(puuid, 5); // Fetch 5 recent matches
            } catch (IOException e) {
                System.err.println("Error fetching matches: " + e.getMessage());
            }
        } else {
            System.out.println("Login failed. Cannot fetch matches.");
        }
    }
}

