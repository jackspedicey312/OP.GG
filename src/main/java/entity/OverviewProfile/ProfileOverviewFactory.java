package entity.OverviewProfile;

import java.io.IOException;

public class ProfileOverviewFactory {

    public ProfileOverview createProfileOverview(String username,
                                                 String tagline,
                                                 String summonerId,
                                                 int summonerLevel,
                                                 int iconID) throws IOException {
        return new ProfileOverview(username, tagline, summonerId, summonerLevel, iconID);
    }
}
