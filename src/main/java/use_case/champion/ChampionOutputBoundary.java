package use_case.champion;

import java.util.List;

public interface ChampionOutputBoundary {
    void presentTopChampions(List<ChampionOutputData> champions);
}
