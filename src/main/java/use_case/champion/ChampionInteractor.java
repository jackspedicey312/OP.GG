package use_case.champion;

import data_access.RiotAPIChampionDataAccess;
import entity.champion.Champion;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class ChampionInteractor implements ChampionInputBoundary {
    private final ChampionOutputBoundary championPresenter;
    private final RiotAPIChampionDataAccess championDataAccess;

    public ChampionInteractor(ChampionOutputBoundary championPresenter, RiotAPIChampionDataAccess championDataAccess) {
        this.championPresenter = championPresenter;
        this.championDataAccess = championDataAccess;
    }

    @Override
    public void execute(String puuId, String region) {
        try {
            // Fetch all champions from the data access layer
            List<Champion> allChampions = championDataAccess.fetchAllChampions(puuId, region);

            // Sort by mastery points and take the top 3
            List<Champion> top3Champions = allChampions.stream()
                    .sorted((c1, c2) -> Integer.compare(c2.getMasteryPoints(), c1.getMasteryPoints()))
                    .limit(3)
                    .collect(Collectors.toList());

            // Pass the champions directly to the presenter
            championPresenter.presentChampions(top3Champions);
        } catch (IOException e) {
            // Handle the exception (log it or notify the presenter of failure)
            System.err.println("Error fetching champions: " + e.getMessage());
        }
    }
}


