package use_case.champion;

/**
 * Represents the output data for a champion, processed and ready for presentation or further use.
 */
public class ChampionOutputData {
    private final String championName;
    private final int championId;
    private final int magicDamage;
    private final int physicalDamage;
    private final int totalDamage;
    private final int trueDamage;
    private final int kills;
    private final int masteryPoints;

    public ChampionOutputData(String championName, int championId, int magicDamage, int physicalDamage,
                              int totalDamage, int trueDamage, int kills, int masteryPoints) {
        this.championName = championName;
        this.championId = championId;
        this.magicDamage = magicDamage;
        this.physicalDamage = physicalDamage;
        this.totalDamage = totalDamage;
        this.trueDamage = trueDamage;
        this.kills = kills;
        this.masteryPoints = masteryPoints;
    }

    // Getter methods
    public String getChampionName() {
        return championName;
    }

    public int getChampionId() {
        return championId;
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

    @Override
    public String toString() {
        return "ChampionOutputData{"
                +
                "championName='" + championName + '\''
                +
                ", championId=" + championId
                +
                ", magicDamage=" + magicDamage
                +
                ", physicalDamage=" + physicalDamage
                +
                ", totalDamage=" + totalDamage
                +
                ", trueDamage=" + trueDamage
                +
                ", kills=" + kills
                +
                ", masteryPoints=" + masteryPoints
                +
                '}';
    }
}
