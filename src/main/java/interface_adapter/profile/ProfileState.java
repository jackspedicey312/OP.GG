package interface_adapter.profile;

import entity.OverviewProfile.ProfileOverview;
import entity.OverviewProfile.Rank;

public class ProfileState {
    private ProfileOverview profileOverview;
    private Rank rank;

    public void setProfileOverview(ProfileOverview profileOverview) {
        this.profileOverview = profileOverview;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public ProfileOverview getProfileOverview() {
        return profileOverview;
    }

    public Rank getRank() {
        return rank;
    }
}
