package main.java.user;

public interface UserFactory {
    User createUser(String name, String email, String password, Portfolio portfolio);
}