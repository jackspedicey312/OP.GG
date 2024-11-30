package interface_adapter.champion;

import java.io.IOException;
import java.util.List;

public interface ChampionDataAccessInterface {
    List<RawChampionData> fetchAllChampions(String summonerID, String region) throws IOException;
}

