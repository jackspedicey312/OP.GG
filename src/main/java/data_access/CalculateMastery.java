package data_access;

public class CalculateMastery {
    public static int calculateMasteryPoints(int totalDamage, int magicDamage, int physicalDamage, int trueDamage, int kills) {
        final int totalDamageMax = 100000;
        final int magicDamageMax = 50000;
        final int physicalDamageMax = 90000;
        final int trueDamageMax = 2000;
        final int killsMax = 30;

        int normTotalDamage = normalize(totalDamage, 0, totalDamageMax);
        int normMagicDamage = normalize(magicDamage, 0, magicDamageMax);
        int normPhysicalDamage = normalize(physicalDamage, 0, physicalDamageMax);
        int normTrueDamage = normalize(trueDamage, 0, trueDamageMax);
        int normKills = normalize(kills, 0, killsMax);

        return normTotalDamage + normMagicDamage + normPhysicalDamage + normTrueDamage + normKills;
    }

    private static int normalize(int value, int min, int max) {
        return (int) (((double) (value - min) / (max - min)) * 1000);
    }
}
