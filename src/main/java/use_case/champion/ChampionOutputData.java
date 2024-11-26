package use_case.champion;

/**
 * Output data for a champion.
 */
public class ChampionOutputData {
    private final String championName;
    private final int championID;
    private final int magicDamage;
    private final int physicalDamage;
    private final int totalDamage;
    private final int trueDamage;
    private final int kills;
    private final int masteryPoints;

    public ChampionOutputData(String championName, int championID, int magicDamage, int physicalDamage,
                              int totalDamage, int trueDamage, int kills, int masteryPoints) {
        this.championName = championName;
        this.championID = championID;
        this.magicDamage = magicDamage;
        this.physicalDamage = physicalDamage;
        this.totalDamage = totalDamage;
        this.trueDamage = trueDamage;
        this.kills = kills;
        this.masteryPoints = masteryPoints;
    }

    public String getChampionName() {
        return championName;
    }

    public int getChampionID() {
        return championID;
    }

    public int getMagicDamage() {
        return magicDamage;
    }

    public int getPhysicalDamage() {
        return physicalDamage;
    }

    public int getTotalDamage() {
        return totalDamage;
    }

    public int getTrueDamage() {
        return trueDamage;
    }

    public int getKills() {
        return kills;
    }

    public int getMasteryPoints() {
        return masteryPoints;
    }
}
