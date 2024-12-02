package interface_adapter.champion;

import entity.champion.Champion;

import java.util.List;

public class ChampionState {
    private List<Champion> champions;


    public int getChampionId(int index) {
        return champions.get(index).getChampionId();
    }


    public int getChampionLevel(int index) {
        return champions.get(index).getChampionLevel();
    }


    public int getChampionPoints(int index) {
        return champions.get(index).getChampionPoints();
    }


    public int getLength() {
        return champions != null ? champions.size() : 0;
    }

}
