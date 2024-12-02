package entity.champion;

public class ChampionFactory {

    public Champion createChampion(String championName, int championId, int magicDamage, int physicalDamage,
                                   int totalDamage, int trueDamage, int kills, int masteryPoints) {
        return new Champion(championName, championId, magicDamage, physicalDamage, totalDamage, trueDamage, kills, masteryPoints);
    }
}
