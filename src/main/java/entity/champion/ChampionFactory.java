package entity.champion;

public class ChampionFactory {

    public Champion createChampion(int championId, int championLevel, int championPoints) {
        return new Champion(championId, championLevel, championPoints);
    }
}
