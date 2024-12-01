package entity.champion;

/**
 * Factory class for creating Champion objects.
 */
public class ChampionFactory {

    /**
     * Creates a Champion object.
     *
     * @param championName   The name of the champion.
     * @param championId     The unique ID of the champion.
     * @param magicDamage    The magic damage dealt by the champion.
     * @param physicalDamage The physical damage dealt by the champion.
     * @param totalDamage    The total damage dealt by the champion.
     * @param trueDamage     The true damage dealt by the champion.
     * @param kills          The number of kills by the champion.
     * @return A new Champion object.
     */
    public Champion createChampion(String championName, int championId, int magicDamage, int physicalDamage,
                                   int totalDamage, int trueDamage, int kills) {
        return new Champion(championName, championId, magicDamage, physicalDamage, totalDamage, trueDamage, kills);
    }
}
