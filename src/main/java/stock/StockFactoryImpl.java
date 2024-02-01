package main.java.stock;


public class StockFactoryImpl implements StockFactory {
    @Override
    public Stock createStock(String name, String symbol, double currentPrice, int quantity) {

        return new Stock(name, symbol, currentPrice, quantity);
    }
}
