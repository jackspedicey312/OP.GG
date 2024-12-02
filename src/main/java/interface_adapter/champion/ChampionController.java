package interface_adapter.champion;

import use_case.champion.ChampionInputBoundary;

public class ChampionController {
    private final ChampionInputBoundary championInputBoundary;
    private final String puuId;
    private final String region;

    public ChampionController(ChampionInputBoundary championInputBoundary, String puuId, String region) {
        this.championInputBoundary = championInputBoundary;
        this.puuId = puuId;
        this.region = region;
    }

    public void execute() {
        try {
            // Pass the puuId and region to the interactor for execution
            championInputBoundary.execute(puuId, region);
        } catch (Exception e) {
            // Handle errors during execution (e.g., log or notify the user)
            System.err.println("Error executing champion controller: " + e.getMessage());
        }
    }
}
