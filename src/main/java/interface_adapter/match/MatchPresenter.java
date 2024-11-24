package interface_adapter.match;

import use_case.match.MatchOutputBoundary;

import java.util.List;

/**
 * Presenter for formatting the output of match use case.
 */
public class MatchPresenter implements MatchOutputBoundary {

    @Override
    public void presentMatches(List<String> matchIds) {
        System.out.println("Recent Match IDs:");
        for (String matchId : matchIds) {
            System.out.println(matchId);
        }
    }

    @Override
    public void presentError(String message) {
        System.err.println("Error fetching matches: " + message);
    }
}
