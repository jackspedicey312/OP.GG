package entity;

public class Champion {
    private final String championName;
    private final int championId;
    private final int magicDamage;
    private final int physicalDamage;
    private final int totalDamage;
    private final int trueDamage;
    private final int kills;

    public Champion(String championName, int championId, int magicDamage, int physicalDamage,
                    int totalDamage, int trueDamage, int kills) {
        this.championName = championName;
        this.championId = championId;
        this.magicDamage = magicDamage;
        this.physicalDamage = physicalDamage;
        this.totalDamage = totalDamage;
        this.trueDamage = trueDamage;
        this.kills = kills;
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
}
