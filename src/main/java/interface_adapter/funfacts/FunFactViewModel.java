package interface_adapter.funfacts;

import interface_adapter.ViewModel;

public class FunFactViewModel extends ViewModel<FunFactState> {

    public FunFactViewModel() {
        super("funFacts");
        setState(new FunFactState());
    }
}
