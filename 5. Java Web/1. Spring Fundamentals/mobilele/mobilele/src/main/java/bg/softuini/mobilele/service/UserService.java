package bg.softuini.mobilele.service;

public interface UserService {
/*
returns true if the user is authenticated successfully
 */
    boolean authenticate(String userName, String password);
    void loginUser(String userName);
    void logoutCurrentUser();
}
