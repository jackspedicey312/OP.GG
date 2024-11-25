package interface_adapter.match;

import use_case.match.MatchInputBoundary;

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
     * @param puuid The PUUID of the user.
     * @param region The region for the matches.
     * @param count The number of matches to fetch.
     */
    public void fetchRecentMatches(String puuid, String region, int count) {
        matchInputBoundary.fetchRecentMatches(puuid, region, count);
    }
}
