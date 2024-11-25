package use_case.login;

/**
 * The output boundary for the login use case.
 */
public interface LoginOutputBoundary {
    void present(LoginOutputData outputData);
}
