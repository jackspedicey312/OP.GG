package use_case.login;

import entity.User;

import java.io.IOException;

public interface LoginUserDataAccessInterface {
    String fetchPUUID(User user) throws IOException;
}
