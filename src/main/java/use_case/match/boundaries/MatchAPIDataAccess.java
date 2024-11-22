package use_case.match.boundaries;

import entity.Match;

import java.io.IOException;
import java.util.List;

public interface MatchAPIDataAccess {
    List<String> fetchRecentMatchIds(String puuid, int count) throws IOException;

    List<Match> fetchMatchDetails(List<String> matchIds) throws IOException;
}
