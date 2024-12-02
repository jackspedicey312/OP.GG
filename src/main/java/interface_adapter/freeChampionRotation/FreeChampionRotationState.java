package interface_adapter.freeChampionRotation;

import entity.freeChampionRotation.FreeChampionRotation;

import javax.swing.*;
import java.util.ArrayList;

public class FreeChampionRotationState {
    private FreeChampionRotation freeChampionRotation;

    public FreeChampionRotation getFreeChampionRotation() {
        return freeChampionRotation;
    }

    public String getFreeChampionsName(int index) {
        final ArrayList<String> freeChampionsName = freeChampionRotation.getFreeChampionsNames();
        final String name = freeChampionsName.get(index);
        return name;
    }

    public ImageIcon getFreeChampionIcons(int index) {
        final ArrayList<ImageIcon> freeChampionIcons = freeChampionRotation.getFreeChampionIcons();
        final ImageIcon icon = freeChampionIcons.get(index);
        return icon;
    }

    public int getChampionCount() {
        return freeChampionRotation.getChampionsCount();
    }

    public void setFreeChampionRotation(FreeChampionRotation freeChampionRotation) {
        this.freeChampionRotation = freeChampionRotation;
    }
}
