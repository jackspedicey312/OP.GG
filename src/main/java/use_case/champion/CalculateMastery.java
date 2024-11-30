package use_case.champion;

/**
 * Handles the calculation of mastery points for champions.
 */
public class CalculateMastery {

    private static final int TOTAL_DAMAGE_MAX = 100000;
    private static final int MAGIC_DAMAGE_MAX = 50000;
    private static final int PHYSICAL_DAMAGE_MAX = 90000;
    private static final int TRUE_DAMAGE_MAX = 2000;
    private static final int KILLS_MAX = 30;

    /**
     * Calculates the mastery points based on champion stats.
     *
     * @param totalDamage    Total damage dealt by the champion.
     * @param magicDamage    Magic damage dealt by the champion.
     * @param physicalDamage Physical damage dealt by the champion.
     * @param trueDamage     True damage dealt by the champion.
     * @param kills          Number of kills made by the champion.
     * @return Calculated mastery points.
     */
    public static int calculateMasteryPoints(int totalDamage, int magicDamage, int physicalDamage, int trueDamage, int kills) {
        int normTotalDamage = normalize(totalDamage, 0, TOTAL_DAMAGE_MAX);
        int normMagicDamage = normalize(magicDamage, 0, MAGIC_DAMAGE_MAX);
        int normPhysicalDamage = normalize(physicalDamage, 0, PHYSICAL_DAMAGE_MAX);
        int normTrueDamage = normalize(trueDamage, 0, TRUE_DAMAGE_MAX);
        int normKills = normalize(kills, 0, KILLS_MAX);

        return normTotalDamage + normMagicDamage + normPhysicalDamage + normTrueDamage + normKills;
    }

    /**
     * Normalizes a value within the given range.
     *
     * @param value Value to normalize.
     * @param min   Minimum of the range.
     * @param max   Maximum of the range.
     * @return Normalized value.
     */
    private static int normalize(int value, int min, int max) {
        return (int) (((double) (value - min) / (max - min)) * 1000);
    }
}
