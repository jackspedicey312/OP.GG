package interface_adapter.button;

@SuppressWarnings({"checkstyle:WriteTag", "checkstyle:SuppressWarnings"})
public class ButtonController {
    private final OverviewUseCase overviewUseCase;
    private final MatchHistoryUseCase matchHistoryUseCase;
    private final FriendsUseCase friendsUseCase;
    private final ChampionUseCase championUseCase;
    private final FreeChampionRotationUseCase freeChampionRotationUseCase;
    private final FunFactsUseCase funFactsUseCase;
    private final LogoutUseCase logoutUseCase;
    private String puuid;
    private String region;

    public ButtonController(String puuid, String region) {
        this.overviewUseCase = new OverviewUseCase(puuid, region);
        this.matchHistoryUseCase = new MatchHistoryUseCase(puuid, region);
        this.friendsUseCase = new FriendsUseCase(puuid, region);
        this.championUseCase = new ChampionUseCase(puuid, region);
        this.freeChampionRotationUseCase = new FreeChampionRotationUseCase(puuid, region);
        this.funFactsUseCase = new FunFactsUseCase(puuid, region);
        this.logoutUseCase = new LogoutUseCase();
        this.puuid = puuid;
        this.region = region;

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

    public void FreeChampionRotationButtonClicked() {
        this.freeChampionRotationUseCase.execute();
    }

    public void FunFactsButtonClicked() {
        this.funFactsUseCase.execute();
    }

    public void LogoutButtonClicked() {
        this.logoutUseCase.execute();
    }
}