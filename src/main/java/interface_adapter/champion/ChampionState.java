package interface_adapter.champion;

import entity.champion.Champion;

import java.util.ArrayList;
import java.util.List;

public class ChampionState {
    private List<Champion> champions = new ArrayList<>(); // Holds the list of champions
    private String error; // Holds any error message

    // Getter for the list of champions
    public List<Champion> getChampions() {
        return champions;
    }

    // Getter for a specific champion by index
    public Champion getChampion(int index) {
        if (index >= 0 && index < champions.size()) {
            return champions.get(index);
        }
        throw new IndexOutOfBoundsException("Invalid index for champions list");
    }


    // Sets the list of champions (e.g., top 3)
    public void setChampions(List<Champion> champions) {
        this.champions = champions;
    }

}
