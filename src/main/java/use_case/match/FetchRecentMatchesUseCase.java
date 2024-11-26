package use_case.match;

import data_access.RiotAPIMatchDataAccess;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Use Case Implementation for Fetching Recent Matches.
 */
public class FetchRecentMatchesUseCase implements MatchInputBoundary {

    private final RiotAPIMatchDataAccess matchDataAccess;
    private final MatchOutputBoundary outputBoundary;

    public FetchRecentMatchesUseCase(RiotAPIMatchDataAccess matchDataAccess, MatchOutputBoundary outputBoundary) {
        this.matchDataAccess = matchDataAccess;
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void fetchRecentMatches(MatchInputData inputData) {
        try {
            String puuid = inputData.getPuuid();
            String region = inputData.getRegion();
            int count = inputData.getCount();

            // Step 1: Fetch Match IDs
            List<String> matchIds = matchDataAccess.fetchRecentMatchIds(puuid, region, count);
            if (matchIds.isEmpty()) {
                outputBoundary.presentError("No matches found for the user.");
                return;
            }

            outputBoundary.presentMatches(matchIds);

            // Step 2: Fetch Match Details for each Match ID
            List<JSONObject> matchDetails = new ArrayList<>();
            for (String matchId : matchIds) {
                JSONObject matchDetail = matchDataAccess.fetchMatchDetails(matchId, region);
                matchDetails.add(matchDetail);
            }

            // Step 3: Send the match details to the output boundary
            outputBoundary.presentMatchDetails(matchDetails);

        } catch (IOException e) {
            outputBoundary.presentError("Failed to fetch matches due to an IO error: " + e.getMessage());
        } catch (Exception e) {
            outputBoundary.presentError("An unexpected error occurred: " + e.getMessage());
        }
    }
}




