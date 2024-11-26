package interface_adapter.match;

import use_case.match.MatchInputBoundary;
import use_case.match.MatchInputData;

/**
 * Controller for handling match-related requests.
 */
public class MatchController {

    private final MatchInputBoundary matchInputBoundary;

    public MatchController(MatchInputBoundary matchInputBoundary) {
        this.matchInputBoundary = matchInputBoundary;
    }

    /**
     * Fetches recent matches for a user.
     *
     * @param puuid  The PUUID of the user.
     * @param region The region for the matches.
     * @param count  The number of matches to fetch.
     */
    public void fetchRecentMatches(String puuid, String region, int count) {
        MatchInputData inputData = new MatchInputData(puuid, region, count);
        matchInputBoundary.fetchRecentMatches(inputData);
    }
}

