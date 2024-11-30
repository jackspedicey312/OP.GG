package interface_adapter.freeChampionRotation;

import use_case.freechampionrotation.FreeChampionRotationInputBoundary;

public class FreeChampionRotationController {
    private final FreeChampionRotationInputBoundary freeChampionRotationUseCaseInteractor;

    public FreeChampionRotationController(FreeChampionRotationInputBoundary freeChampionRotationUseCaseInteractor) {
        this.freeChampionRotationUseCaseInteractor = freeChampionRotationUseCaseInteractor;
    }

    public void execute() {
        freeChampionRotationUseCaseInteractor.execute();
    }
}
