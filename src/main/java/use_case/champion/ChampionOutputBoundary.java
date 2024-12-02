package use_case.champion;


import entity.champion.Champion;

import java.util.List;

public interface ChampionOutputBoundary {
    void prepareView();

    void presentChampions(List<Champion> top3Champions);
}