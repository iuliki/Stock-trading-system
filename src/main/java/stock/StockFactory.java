package main.java.stock;


public interface StockFactory {
    Stock createStock(String name, String symbol, double currentPrice, int quantity);
}

