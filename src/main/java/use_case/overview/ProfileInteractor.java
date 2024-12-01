package use_case.overview;

public class ProfileInteractor implements ProfileInputBoundary {

    private final ProfileOutputBoundary overviewPresenter;

    public ProfileInteractor(ProfileOutputBoundary overviewPresenter) {
        this.overviewPresenter = overviewPresenter;
    }

    @Override
    public void execute() {
        overviewPresenter.prepareView();
    }
}
