package interface_adapter.champion;

import entity.champion.Champion;

import javax.swing.*;
import java.io.IOException;
import java.util.List;

public class ChampionState {
    private List<Champion> champions;


    public String getChampionName(int index) throws IOException {
        return champions.get(index).getChampionName();
    }

    public int getChampionLevel(int index) {
        return champions.get(index).getChampionLevel();
    }

    public int getChampionPoints(int index) {
        return champions.get(index).getChampionPoints();
    }

    public ImageIcon getChampionIcon(int index) throws IOException {
        return champions.get(index).getChampionImage();
    }


    public int getLength() {
        return champions.size();
    }

    public void setChampion(List<Champion> champion) {
        this.champions = champion;
    }
}
