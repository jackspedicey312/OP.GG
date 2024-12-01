package use_case.champion;
import java.io.IOException;

public interface ChampionInputBoundary {
    void execute(String puuId, String region) throws IOException;
}
