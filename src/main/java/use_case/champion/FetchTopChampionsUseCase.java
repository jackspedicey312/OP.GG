package use_case.champion;

import data_access.RiotAPIChampionDataAccess;

import java.util.ArrayList;
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
            var champions = championDataAccess.fetchAllChampions();

            List<ChampionOutputData> processedChampions = new ArrayList<>();
            for (var champion : champions) {
                int masteryPoints = CalculateMastery.calculateMasteryPoints(
                        champion.getTotalDamage(),
                        champion.getMagicDamage(),
                        champion.getPhysicalDamage(),
                        champion.getTrueDamage(),
                        champion.getKills()
                );

                ChampionOutputData outputData = new ChampionOutputData(
                        champion.getChampionName(),
                        champion.getChampionId(),
                        champion.getMagicDamage(),
                        champion.getPhysicalDamage(),
                        champion.getTotalDamage(),
                        champion.getTrueDamage(),
                        champion.getKills(),
                        masteryPoints
                );

                processedChampions.add(outputData);
            }

            processedChampions.sort(Comparator.comparingInt(ChampionOutputData::getMasteryPoints).reversed());
            List<ChampionOutputData> topChampions = processedChampions.subList(0, Math.min(3, processedChampions.size()));

            outputBoundary.presentTopChampions(topChampions);
        }
        catch (Exception e) {
            System.err.println("Error fetching champion data: " + e.getMessage());
        }
    }
}
