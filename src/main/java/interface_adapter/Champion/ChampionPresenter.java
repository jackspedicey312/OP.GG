package interface_adapter.Champion;

import use_case.champion.ChampionOutputBoundary;
import use_case.champion.ChampionOutputData;

import java.util.List;

public class ChampionPresenter implements ChampionOutputBoundary {

    private List<ChampionOutputData> champions;

    @Override
    public void presentTopChampions(List<ChampionOutputData> champions) {
        this.champions = champions;
        System.out.println("Top Champions:");
        for (ChampionOutputData champion : champions) {
            System.out.println(champion.getChampionName() + " - " + champion.getMasteryPoints() + " points");
        }
    }

    public List<ChampionOutputData> getChampions() {
        return champions;
    }
}
