package interface_adapter.champion;

import use_case.champion.ChampionInputBoundary;

import java.io.IOException;

public class ChampionController {

    private final ChampionInputBoundary championInputBoundary;

    public ChampionController(ChampionInputBoundary championInputBoundary) {
        this.championInputBoundary = championInputBoundary;
    }

    public void execute(String puuId, String region) throws IOException {
        championInputBoundary.execute(puuId, region);
    }
}
