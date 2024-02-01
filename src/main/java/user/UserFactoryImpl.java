package main.java.user;



public class UserFactoryImpl implements UserFactory {
    @Override
    public User createUser(String name, String email, String password, Portfolio portfolio) {
        // Implementarea efectivă a creării utilizatorului
        return new User(email, password, name, new Portfolio(), 1000.0);
    }
}
