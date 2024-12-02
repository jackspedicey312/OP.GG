package entity.champion;

public class Champion {
    private final int championId;
    private final int championLevel;
    private final int championPoints;

    public Champion(int championId, int championLevel, int championPoints) {
        this.championId = championId;
        this.championLevel = championLevel;
        this.championPoints = championPoints;
    }

    // Getters
    public int getChampionId() {
        return championId;
    }

    public int getChampionLevel() {
        return championLevel;
    }

    public int getChampionPoints() {
        return championPoints;
    }
}

