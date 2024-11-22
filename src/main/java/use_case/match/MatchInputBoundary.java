package use_case.match;

import java.io.IOException;

public interface MatchInputBoundary {
    /**
     * Fetch recent matches based on the player's PUUID.
     *
     * @param puuid The player's unique identifier.
     * @param count The number of recent matches to fetch.
     * @throws IOException If an error occurs during the API request.
     */
    void fetchRecentMatches(String puuid, int count) throws IOException;
}
