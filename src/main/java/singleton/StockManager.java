package main.java.singleton;

import main.java.stock.Stock;

import java.util.ArrayList;
import java.util.List;

public class StockManager {
    private static StockManager instance;
    private List<Stock> stocks;

    public StockManager() {
        this.stocks = new ArrayList<>();
    }

    public static StockManager getInstance() {
        if (instance == null) {
            instance = new StockManager();
        }
        return instance;
    }

    public List<Stock> getStocks() {
        return stocks;
    }

    public void addStock(Stock stock) {
        stocks.add(stock);
    }
    public Stock searchStock(String query) {
        // Caută stocul după simbol sau nume
        for (Stock stock : stocks) {
            if (stock.getSymbol().equalsIgnoreCase(query) || stock.getName().equalsIgnoreCase(query)) {
                return stock;
            }
        }
        return null; // Returnăm null dacă nu găsim nicio potrivire
    }

    public Stock getStockBySymbol(String symbol) {
        for (Stock stock : stocks) {
            if (stock.getSymbol().equalsIgnoreCase(symbol)) {
                return stock;
            }
        }
        return null; // Returnăm null dacă stocul nu este găsit
    }
    // Alte metode pentru gestionarea stocurilor
}
