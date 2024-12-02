package interface_adapter.champion;

import interface_adapter.ViewModel;

public class ChampionViewModel extends ViewModel<ChampionState> {

    public ChampionViewModel() {
        super("championView");
        setState(new ChampionState());
    }
}