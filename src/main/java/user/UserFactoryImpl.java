package main.java.user;



public class UserFactoryImpl implements UserFactory {
    @Override
    public User createUser(String name, String email, String password, Portfolio portfolio) {

        return new User(email, password, name, new Portfolio(), 1000.0);
    }
}
