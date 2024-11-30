package use_case.login;

/**
 * The input boundary for the login use case.
 */
public interface LoginInputBoundary {
    void execute(LoginInputData inputData);
}
