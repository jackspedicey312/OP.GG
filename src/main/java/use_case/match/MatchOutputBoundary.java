package use_case.match;

import org.json.JSONObject;

import java.util.List;

/**
 * The output boundary for presenting match data.
 */
public interface MatchOutputBoundary {
    void presentMatches(List<String> matchIds);
    void presentMatchDetails(List<JSONObject> matchDetails); // Add this method
    void presentError(String message);
}
