package interface_adapter.champion;

import java.util.ArrayList;
import java.util.List;

import entity.champion.Champion;

public class ChampionState {
    private List<Champion> champions = new ArrayList<>();
    private String fetchError;

    public List<Champion> getChampions() {
        return champions;
    }

    public String getFetchError() {
        return fetchError;
    }

    public void setChampions(List<Champion> champions) {
        this.champions = champions;
    }

    public void setFetchError(String fetchError) {
        this.fetchError = fetchError;
    }
}
