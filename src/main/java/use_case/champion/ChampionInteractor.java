package use_case.champion;

import interface_adapter.champion.ChampionDataAccessInterface;
import data_access.RiotAPIChampionDataAccess;
import java.io.IOException;
import java.util.List;

public class ChampionInteractor {
    private final ChampionDataAccessInterface championDataGateway;

    public ChampionInteractor(ChampionDataAccessInterface championDataGateway) {
        this.championDataGateway = championDataGateway;
    }

    public List<ChampionOutputData> getChampionData(String summonerID, String region) throws IOException {
        List<RawChampionData> rawChampionDataList = championDataGateway.fetchAllChampions(summonerID, region);
        List<ChampionOutputData> outputDataList = new ArrayList<>();


        for (RawChampionData rawData : rawChampionDataList) {
            int masteryPoints = calculateMasteryPoints(
                    rawData.getTotalDamage(), rawData.getMagicDamage(),
                    rawData.getPhysicalDamage(), rawData.getTrueDamage(), rawData.getKills()
            );

            outputDataList.add(new ChampionOutputData(
                    rawData.getChampionName(), rawData.getChampionId(),
                    rawData.getMagicDamage(), rawData.getPhysicalDamage(),
                    rawData.getTotalDamage(), rawData.getTrueDamage(),
                    rawData.getKills(), masteryPoints
            ));
        }

        return outputDataList;
    }

    private int calculateMasteryPoints(int totalDamage, int magicDamage, int physicalDamage, int trueDamage, int kills) {
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

    private int normalize(int value, int min, int max) {
        return (int) (((double) (value - min) / (max - min)) * 1000);
    }
}
