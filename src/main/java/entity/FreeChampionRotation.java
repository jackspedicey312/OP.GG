package entity;

import javax.swing.*;
import java.util.ArrayList;

public class FreeChampionRotation {
    private final ArrayList<String> freeChampionsNames;
    private final ArrayList<ImageIcon> freeChampionIcons;

    public FreeChampionRotation(ArrayList<String> freeChampionsNames, ArrayList<ImageIcon> freeChampionIcons) {
        this.freeChampionsNames = freeChampionsNames;
        this.freeChampionIcons = freeChampionIcons;
    }

    public ArrayList<String> getFreeChampionsNames() {
        return freeChampionsNames;
    }

    public ArrayList<ImageIcon> getFreeChampionIcons() {
        return freeChampionIcons;
    }
}
