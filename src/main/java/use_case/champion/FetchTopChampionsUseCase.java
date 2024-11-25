package use_case.champion;

import data_access.RiotAPIChampionDataAccess;

import java.util.Comparator;
import java.util.List;

public class FetchTopChampionsUseCase implements ChampionInputBoundary {

    private final RiotAPIChampionDataAccess championDataAccess;
    private final ChampionOutputBoundary outputBoundary;

    public FetchTopChampionsUseCase(RiotAPIChampionDataAccess championDataAccess, ChampionOutputBoundary outputBoundary) {
        this.championDataAccess = championDataAccess;
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void fetchTopChampions(String summonerID, String region) {
        try {
            championDataAccess.setSummonerIDAndRegion(summonerID, region);
            List<ChampionOutputData> champions = championDataAccess.fetchAllChampions();

            // Sort by mastery points and pick the top 3
            champions.sort(Comparator.comparingInt(ChampionOutputData::getMasteryPoints).reversed());
            List<ChampionOutputData> topChampions = champions.subList(0, Math.min(3, champions.size()));

            outputBoundary.presentTopChampions(topChampions);
        } catch (Exception e) {
            System.err.println("Error fetching champion data: " + e.getMessage());
        }
    }
}
