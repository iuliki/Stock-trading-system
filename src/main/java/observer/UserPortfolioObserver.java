package main.java.observer;

import main.java.user.Portfolio;

public class UserPortfolioObserver implements StockObserver {
    private Portfolio portfolio;

    public UserPortfolioObserver(Portfolio portfolio) {
        this.portfolio = portfolio;
    }

    @Override
    public void update() {

    }
}