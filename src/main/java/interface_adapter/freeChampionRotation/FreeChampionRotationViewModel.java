package interface_adapter.freeChampionRotation;

import interface_adapter.ViewModel;

public class FreeChampionRotationViewModel extends ViewModel<FreeChampionRotationState> {

    public FreeChampionRotationViewModel() {
        super("freeChampionRotation");
        setState(new FreeChampionRotationState());
    }
}
