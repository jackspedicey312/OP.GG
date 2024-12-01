package entity.freeChampionRotation;

import javax.swing.*;
import java.util.ArrayList;

public class FreeChampionRotationFactory {

    public FreeChampionRotation createFreeChampionRotation(ArrayList<String> freeChampionsNames,
                                                           ArrayList<ImageIcon> freeChampionIcons) {
        return new FreeChampionRotation(freeChampionsNames, freeChampionIcons);
    }
}
