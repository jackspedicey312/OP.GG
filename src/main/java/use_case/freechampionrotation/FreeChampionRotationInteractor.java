package use_case.freechampionrotation;

public class FreeChampionRotationInteractor implements FreeChampionRotationInputBoundary {
    private final FreeChampionRotationOutputBoundary freeChampionRotationPresenter;

    public FreeChampionRotationInteractor(FreeChampionRotationOutputBoundary freeChampionRotationPresenter) {
        this.freeChampionRotationPresenter = freeChampionRotationPresenter;
    }

    @Override
    public void execute() {
        freeChampionRotationPresenter.prepareView();
    }
}
