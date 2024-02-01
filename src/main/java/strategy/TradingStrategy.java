package main.java.strategy;


import main.java.transaction.Transaction;

public interface TradingStrategy {
    void applyStrategy(Transaction transaction);
}