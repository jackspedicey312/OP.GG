package interface_adapter.champion;

import use_case.champion.ChampionInputBoundary;

public class ChampionController {
    private final ChampionInputBoundary championInputBoundary;

    public ChampionController(ChampionInputBoundary championInputBoundary) {
        this.championInputBoundary = championInputBoundary;
    }

    public void execute() {
        championInputBoundary.execute();
    }
}
