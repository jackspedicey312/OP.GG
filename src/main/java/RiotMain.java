import New.Match;
import New.MatchList;
import New.User;
import org.json.JSONArray;

public class RiotMain {

    private static final String API_KEY = "RGAPI-f4800267-6eb1-45a5-89d8-b130ffff4f87";
    private User user;

    public RiotMain(User user) {
        this.user = user;
    }

    /**
     * Generates PUUID data with the username and tag.
     */
    public String getPuuid() {
        return user.getPuuid();
    }

    public String getRegion() {
        return user.getRegion();
    }

    /**
     * Retrieves recent match IDs for a player based on their PUUID.
     */
    public JSONArray getMatchList() {
        return user.getMatchList();
    }

    /**
     * Retrieves details for a specific match using the match ID.
     */
    public Object getMatch(int index) {
        if (index <= user.getMatchList().length()) {
            return user.getMatchList().get(index);
        }
        else {
            throw new IndexOutOfBoundsException();
        }
    }
}
