package main.java.command;

import main.java.stock.Stock;
import main.java.user.Portfolio;

public class SellStockCommand implements Command {
    private Stock stock;
    private int quantity;
    private Portfolio portfolio;

    public SellStockCommand(Stock stock, int quantity, Portfolio portfolio) {
        this.stock = stock;
        this.quantity = quantity;
        this.portfolio = portfolio;
    }

    @Override
    public void execute() {
        // Implementarea comenzii de vânzare
    }
}