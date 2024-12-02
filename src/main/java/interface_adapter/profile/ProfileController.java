package interface_adapter.ProfilePresenter;

import use_case.overview.ProfileInputBoundary;

public class ProfileController {

    private final ProfileInputBoundary profileInputBoundary;

    public ProfileController(ProfileInputBoundary profileInputBoundary) {
        this.profileInputBoundary = profileInputBoundary;

    }

    public void execute() {
        profileInputBoundary.execute();
    }

}
