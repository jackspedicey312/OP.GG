package interface_adapter.button;

@SuppressWarnings({"checkstyle:WriteTag", "checkstyle:SuppressWarnings"})
public class ButtonController {
    private final OverviewUseCase overviewUseCase;
    private final MatchHistoryUseCase matchHistoryUseCase;
    private final FriendsUseCase friendsUseCase;
    private final ChampionUseCase championUseCase;
    private final FunFactsUseCase funFactsUseCase;
    private final LogoutUseCase logoutUseCase;

    public ButtonController() {
        this.overviewUseCase = new OverviewUseCase();
        this.matchHistoryUseCase = new MatchHistoryUseCase();
        this.friendsUseCase = new FriendsUseCase();
        this.championUseCase = new ChampionUseCase();
        this.funFactsUseCase = new FunFactsUseCase();
        this.logoutUseCase = new LogoutUseCase();

    }

    @SuppressWarnings({"checkstyle:MissingJavadocMethod", "checkstyle:MethodName"})
    public void OverviewButtonClicked() {
        this.overviewUseCase.execute();
    }

    public void MatchHistoryButtonClicked() {
        this.matchHistoryUseCase.execute();
    }

    public void FriendsButtonClicked() {
        this.friendsUseCase.execute();
    }

    public void ChampionButtonClicked() {
        this.championUseCase.execute();
    }

    public void FunFactsButtonClicked() {
        this.funFactsUseCase.execute();
    }

    public void LogoutButtonClicked() {
        this.logoutUseCase.execute();
    }
}