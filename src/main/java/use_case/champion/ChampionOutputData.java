package use_case.champion;

public class ChampionOutputData {
    private final String championName;
    private final int masteryPoints;

    public ChampionOutputData(String championName, int masteryPoints) {
        this.championName = championName;
        this.masteryPoints = masteryPoints;
    }

    public String getChampionName() {
        return championName;
    }

    public int getMasteryPoints() {
        return masteryPoints;
    }
}
