package use_case.match;

import data_access.RiotAPIMatchDataAccess;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Implements the use case for fetching recent matches with detailed information.
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
            // Fetch match IDs
            List<String> matchIds = dataAccess.fetchRecentMatchIds(puuid, region, count);

            // Fetch detailed match data for each match ID
            List<JSONObject> matchDetailsList = new ArrayList<>();
            for (String matchId : matchIds) {
                JSONObject matchDetails = dataAccess.fetchMatchDetails(matchId, region);
                matchDetailsList.add(matchDetails);
            }

            // Present match details to the presenter
            presenter.presentMatchDetails(matchDetailsList);
        } catch (Exception e) {
            presenter.presentError("Failed to fetch matches: " + e.getMessage());
        }
    }
}
