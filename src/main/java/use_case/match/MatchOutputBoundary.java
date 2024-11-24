package use_case.match;

import java.util.List;

/**
 * The output boundary for presenting match data.
 */
public interface MatchOutputBoundary {
    void presentMatches(List<String> matchIds);
    void presentError(String message);
}
