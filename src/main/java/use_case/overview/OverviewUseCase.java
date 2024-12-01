package use_case.overview;

public class OverviewUseCase implements OverviewInputBoundary {

    private final OverviewOutputBoundary overviewPresenter;

    public OverviewUseCase(OverviewOutputBoundary overviewPresenter) {
        this.overviewPresenter = overviewPresenter;
    }

    @Override
    public void execute() {
        overviewPresenter.prepareView();
    }
}
