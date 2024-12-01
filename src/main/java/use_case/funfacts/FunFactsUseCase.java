package use_case.funfacts;

public class FunFactsUseCase implements FunFactsInputBoundary {

    private final FunFactsOutputBoundary funFactPresenter;

    public FunFactsUseCase(FunFactsOutputBoundary funFactPresenter) {
        this.funFactPresenter = funFactPresenter;
    }

    @Override
    public void execute() {
        funFactPresenter.prepareView();
    }
}

