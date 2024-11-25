package use_case.match;

import java.util.List;

/**
 * Represents the output data for fetching recent matches.
 */
public class MatchOutputData {
    private final List<String> matchIds;

    public MatchOutputData(List<String> matchIds) {
        this.matchIds = matchIds;
    }

    public List<String> getMatchIds() {
        return matchIds;
    }
}
