package use_case;

import app.RiotApp;
import app.RiotMain;

import javax.swing.*;
import java.io.IOException;

public class TestFunFacts {

    public static void main(String[] args) throws IOException {
        final RiotApp app = new RiotApp();
        final JFrame application = app
                .addBackUseCase()
                .addLogoutUseCase()
                .addLoginView()
                .addProfileView()
                .addMatchHistoryView()
                .addFreeChampionRotationView()
                .addFunFactView()
                .addChampionView()
                .addProfileUseCase()
                .addMatchHistoryUseCase()
                .addFreeChampionRotationUseCase()
                .addFunFactsUseCase()
                .addChampionUseCase()
                .addLoggedInView()
                .addLoginUseCase()
                .build();
        application.pack();
        application.setVisible(true);
    }
}
