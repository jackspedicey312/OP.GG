package use_case.match;

/**
 * The input boundary for fetching recent matches.
 */
public interface MatchInputBoundary {
    void fetchRecentMatches(MatchInputData inputData);
}
