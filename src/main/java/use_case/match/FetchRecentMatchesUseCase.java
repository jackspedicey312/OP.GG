package use_case.match;

import data_access.RiotAPIMatchDataAccess;

import java.util.List;

/**
 * Implements the use case for fetching recent matches.
 */
public class FetchRecentMatchesUseCase implements MatchInputBoundary {

    private final RiotAPIMatchDataAccess dataAccess;
    private final MatchOutputBoundary presenter;

    public FetchRecentMatchesUseCase(RiotAPIMatchDataAccess dataAccess, MatchOutputBoundary presenter) {
        this.dataAccess = dataAccess;
        this.presenter = presenter;
    }

    @Override
    public void fetchRecentMatches(String puuid, String region, int count) {
        try {
            List<String> matchIds = dataAccess.fetchRecentMatchIds(puuid, region, count);
            presenter.presentMatches(matchIds);
        } catch (Exception e) {
            presenter.presentError("Failed to fetch matches: " + e.getMessage());
        }
    }
}
