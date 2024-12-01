package entity.champion;

public class Champion {
    private final String championName;
    private final int championId;
    private final int magicDamage;
    private final int physicalDamage;
    private final int totalDamage;
    private final int trueDamage;
    private final int kills;
    private final int masteryPoints;

    // Constants for mastery calculation
    private static final int TOTAL_DAMAGE_MAX = 100000;
    private static final int MAGIC_DAMAGE_MAX = 50000;
    private static final int PHYSICAL_DAMAGE_MAX = 90000;
    private static final int TRUE_DAMAGE_MAX = 2000;
    private static final int KILLS_MAX = 30;

    public Champion(String championName, int championId, int magicDamage, int physicalDamage,
                    int totalDamage, int trueDamage, int kills) {
        this.championName = championName;
        this.championId = championId;
        this.magicDamage = magicDamage;
        this.physicalDamage = physicalDamage;
        this.totalDamage = totalDamage;
        this.trueDamage = trueDamage;
        this.kills = kills;
        this.masteryPoints = calculateMasteryPoints(totalDamage, magicDamage, physicalDamage, trueDamage, kills);
    }

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

    private int calculateMasteryPoints(int totalDamage, int magicDamage, int physicalDamage, int trueDamage, int kills) {
        int normTotalDamage = normalize(totalDamage, 0, TOTAL_DAMAGE_MAX);
        int normMagicDamage = normalize(magicDamage, 0, MAGIC_DAMAGE_MAX);
        int normPhysicalDamage = normalize(physicalDamage, 0, PHYSICAL_DAMAGE_MAX);
        int normTrueDamage = normalize(trueDamage, 0, TRUE_DAMAGE_MAX);
        int normKills = normalize(kills, 0, KILLS_MAX);

        return normTotalDamage + normMagicDamage + normPhysicalDamage + normTrueDamage + normKills;
    }

    private int normalize(int value, int min, int max) {
        return (int) (((double) (value - min) / (max - min)) * 1000);
    }

    @Override
    public String toString() {
        return "Champion{" +
                "championName='" + championName + '\'' +
                ", championId=" + championId +
                ", magicDamage=" + magicDamage +
                ", physicalDamage=" + physicalDamage +
                ", totalDamage=" + totalDamage +
                ", trueDamage=" + trueDamage +
                ", kills=" + kills +
                ", masteryPoints=" + masteryPoints +
                '}';
    }
}