package use_case.freechampionrotation;

import java.util.List;

public class FreeChampionRotationOuputData {
    private final List<Integer> championIds;

    public FreeChampionRotationOuputData(List<Integer> championIds) {
        this.championIds = championIds;
    }

    public List<Integer> getChampionIds() {
        return championIds;
    }
}
