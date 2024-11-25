package interface_adapter.freeChampionRotation;

import use_case.freechampionrotation.FreeChampionRotationInputBoundary;
import use_case.freechampionrotation.FreeChampionRotationInputData;

public class FreeChampionRotationController {
    private final FreeChampionRotationInputBoundary freeChampionRotationUseCaseInteractor;

    public FreeChampionRotationController(FreeChampionRotationInputBoundary freeChampionRotationUseCaseInteractor) {
        this.freeChampionRotationUseCaseInteractor = freeChampionRotationUseCaseInteractor;
    }

    public void execute(String region) {
        final FreeChampionRotationInputData inputData = new FreeChampionRotationInputData(region);

        freeChampionRotationUseCaseInteractor.execute(inputData);
    }
}
