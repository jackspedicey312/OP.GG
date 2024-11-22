package entity;

import use_case.login.*;
import use_case.match.*;
import data_access.*;

public class UserFactory {

    private final RiotAPILoginDataAccess loginDataAccess;
    private final MatchAPIService matchApiAccess;
    private final RiotAPIMatchDataAccess riotApiMatchAccess;
    private final RiotAPILoginDataAccess riotLoginMatchAccess;

    public UserFactory() {
        // Initialize data access dependencies
        this.loginDataAccess = new RiotAPILoginDataAccess();
        this.matchApiAccess = new MatchAPIService();
        this.riotApiMatchAccess = new RiotAPIMatchDataAccess();
        this.riotLoginMatchAccess = new RiotAPILoginDataAccess();
    }

    /**
     * Creates and returns a LoginInteractor with its dependencies.
     *
     * @param outputBoundary The output boundary to handle the presentation of login results.
     * @return A configured instance of LoginInteractor.
     */
    public LoginInteractor createLoginInteractor(LoginOutputBoundary outputBoundary) {
        return new LoginInteractor(loginDataAccess, outputBoundary);
    }

    /**
     * Creates and returns a FetchRecentMatchesUseCase with its dependencies.
     *
     * @param outputBoundary The output boundary to handle the presentation of match results.
     * @return A configured instance of FetchRecentMatchesUseCase.
     */
    public FetchRecentMatchesUseCase createFetchRecentMatchesUseCase(MatchOutputBoundary outputBoundary) {
        return new FetchRecentMatchesUseCase(riotApiMatchAccess, outputBoundary);
    }

    /**
     * Add methods for other use cases as needed.
     */

    public MatchAPIService getMatchApiAccess() {
        return matchApiAccess;
    }

    public RiotAPIMatchDataAccess getRiotApiMatchAccess() {
        return riotApiMatchAccess;
    }

    public RiotAPILoginDataAccess getRiotLoginMatchAccess() {
        return riotLoginMatchAccess;
    }
}

