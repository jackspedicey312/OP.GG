package interface_adapter.match;

import org.json.JSONObject;
import use_case.match.MatchOutputBoundary;

import java.util.ArrayList;
import java.util.List;

/**
 * Presenter for handling match output.
 */
public class MatchPresenter implements MatchOutputBoundary {

    private final List<String> matchIds = new ArrayList<>();
    private final List<JSONObject> matchDetails = new ArrayList<>();
    private String errorMessage;

    @Override
    public void presentMatches(List<String> matchIds) {
        this.matchIds.clear();
        this.matchIds.addAll(matchIds);
        System.out.println("Match IDs received: " + matchIds);
    }

    @Override
    public void presentMatchDetails(List<JSONObject> matchDetails) {
        this.matchDetails.clear();
        this.matchDetails.addAll(matchDetails);
        System.out.println("Match details received: " + matchDetails.size() + " matches");
    }

    @Override
    public void presentError(String message) {
        this.errorMessage = message;
        System.err.println("Error: " + message);
    }

    public List<String> getMatchIds() {
        return new ArrayList<>(matchIds);
    }

    public List<JSONObject> getMatchDetails() {
        return new ArrayList<>(matchDetails);
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}

