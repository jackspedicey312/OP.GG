package interface_adapter.champion;

import use_case.champion.ChampionInputBoundary;

public class ChampionController {
    private final ChampionInputBoundary inputBoundary;

    public ChampionController(ChampionInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    public void onFetchTopChampionsClicked(String summonerID, String region) {
        inputBoundary.fetchTopChampions(summonerID, region);
    }
}
