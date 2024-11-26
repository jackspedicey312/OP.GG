package use_case.match;

/**
 * Input data for Match Use Case.
 */
public class MatchInputData {
    private final String puuid;
    private final String region;
    private final int count;

    public MatchInputData(String puuid, String region, int count) {
        this.puuid = puuid;
        this.region = region;
        this.count = count;
    }

    public String getPuuid() {
        return puuid;
    }

    public String getRegion() {
        return region;
    }

    public int getCount() {
        return count;
    }
}
