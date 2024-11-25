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

    public void fetchRecentMatches(String puuid, String region, int count) {
        matchInputBoundary.fetchRecentMatches(puuid, region, count);
    }
}
