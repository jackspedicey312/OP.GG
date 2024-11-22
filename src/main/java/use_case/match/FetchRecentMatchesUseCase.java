package use_case.match;

import use_case.match.boundaries.MatchAPIDataAccess;

import java.io.IOException;

public class FetchRecentMatchesUseCase implements MatchInputBoundary {
    private final MatchAPIDataAccess dataAccess;
    private final MatchOutputBoundary outputBoundary;

    public FetchRecentMatchesUseCase(MatchAPIDataAccess dataAccess, MatchOutputBoundary outputBoundary) {
        this.dataAccess = dataAccess;
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void fetchRecentMatches(String puuid, int count) throws IOException {
        // Fetch recent match IDs
        var matchIds = dataAccess.fetchRecentMatchIds(puuid, count);

        // Fetch match details
        var matches = dataAccess.fetchMatchDetails(matchIds);

        // Present the matches
        outputBoundary.presentMatches(matches);
    }
}

