package interface_adapter.match;

import org.json.JSONObject;
import use_case.match.MatchOutputBoundary;

import java.util.ArrayList;
import java.util.List;

/**
 * Presenter for formatting and displaying match data.
 */
public class MatchPresenter implements MatchOutputBoundary {

    private final List<JSONObject> matchDetailsList = new ArrayList<>();
    private final List<String> matchIdsList = new ArrayList<>();

    @Override
    public void presentMatches(List<String> matchIds) {
        // Store and log match IDs
        matchIdsList.clear();
        matchIdsList.addAll(matchIds);
        System.out.println("Presenter received match IDs: " + matchIds);
    }

    @Override
    public void presentMatchDetails(List<JSONObject> matchDetails) {
        // Store and log match details
        matchDetailsList.clear();
        matchDetailsList.addAll(matchDetails);
        System.out.println("Presenter received match details: " + matchDetails.size() + " matches");
    }

    @Override
    public void presentError(String message) {
        // Log the error
        System.err.println("Error: " + message);
    }

    // Expose stored data for UI components
    public List<JSONObject> getMatchDetails() {
        return new ArrayList<>(matchDetailsList);
    }

    public List<String> getMatchIds() {
        return new ArrayList<>(matchIdsList);
    }
}
