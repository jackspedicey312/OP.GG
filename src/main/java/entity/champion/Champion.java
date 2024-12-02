package entity.champion;

import data_access.RiotAPIChampionIconDataAccess;
import data_access.RiotAPIFreeRotationDataAccess;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Champion {
    private final int championId;
    private final int championLevel;
    private final int championPoints;
    private String championName = "Ekko";
    private RiotAPIChampionIconDataAccess championIconDataAccess = new RiotAPIChampionIconDataAccess();

    public Champion(int championId, int championLevel, int championPoints) throws IOException {
        this.championId = championId;
        this.championLevel = championLevel;
        this.championPoints = championPoints;

        RiotAPIFreeRotationDataAccess freeRotationDataAccess = new RiotAPIFreeRotationDataAccess();
        this.championName = freeRotationDataAccess.getChampionName(championId);

    }

    // Getters
    public String getChampionName() throws IOException {
        return championName;
    }

    public int getChampionLevel() {
        return championLevel;
    }

    public int getChampionPoints() {
        return championPoints;
    }

    public ImageIcon getChampionImage() throws IOException {
        ImageIcon image = championIconDataAccess.getChampionIcon(championName);
        if (image == null) {
            return null;
        }
        else {
            return image;
        }
    }
}




