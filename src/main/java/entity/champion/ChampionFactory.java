package entity.champion;

import java.io.IOException;

public class ChampionFactory {

    public Champion createChampion(int championId, int championLevel, int championPoints) throws IOException {
        return new Champion(championId, championLevel, championPoints);
    }
}
