package interface_adapter.button;

import use_case.freechampionrotation.FreeChampionRotationUseCase;
import use_case.friends.FriendsUseCase;
import use_case.funfacts.FunFactsUseCase;
import use_case.logout.LogoutUseCase;
import use_case.matchhistory.MatchHistoryUseCase;
import use_case.overview.OverviewOutputBoundary;
import use_case.overview.OverviewUseCase;

@SuppressWarnings({"checkstyle:WriteTag", "checkstyle:SuppressWarnings"})
public class ButtonController {
    private final OverviewUseCase overviewUseCase;
    private final MatchHistoryUseCase matchHistoryUseCase;
    private final FriendsUseCase friendsUseCase;
    private final FreeChampionRotationUseCase freeChampionRotationUseCase;
    private final FunFactsUseCase funFactsUseCase;
    private final LogoutUseCase logoutUseCase;
    private final String puuid;
    private final String region;

    public ButtonController(String puuid, String region) {
        // THIS NEEDS TO BE CHANGED.
        this.overviewUseCase = new OverviewUseCase(null, null);
        this.matchHistoryUseCase = new MatchHistoryUseCase();
        this.friendsUseCase = new FriendsUseCase(puuid, region);
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

    @SuppressWarnings({"checkstyle:MethodName", "checkstyle:MissingJavadocMethod"})
    public void MatchHistoryButtonClicked() {
        this.matchHistoryUseCase.execute();
    }

    public void FriendsButtonClicked() {
        this.friendsUseCase.execute();
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