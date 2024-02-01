package main.java.user;

import main.java.stock.Stock;

import java.util.ArrayList;
import java.util.List;

public class Portfolio {
    private List<Stock> stocks;

    public Portfolio(List<Stock> stocks) {
        this.stocks = stocks;
    }


    public Portfolio() {
        this.stocks = new ArrayList<>();
    }


    public List<Stock> getStocks() {
        return stocks;
    }


    public void addStock(Stock stock, int quantityToAdd) {
        boolean stockExists = false;

        for (Stock existingStock : stocks) {
            if (existingStock.getSymbol().equals(stock.getSymbol())) {
                // Stocul există deja în portofoliu, actualizăm cantitatea
                existingStock.setQuantity(existingStock.getQuantity() + quantityToAdd);
                stockExists = true;
                break;
            }
        }

        if (!stockExists) {
            // Stocul nu există în portofoliu, adăugăm unul nou
            Stock newStock = new Stock(stock.getName(), stock.getSymbol(), stock.getCurrentPrice(), quantityToAdd);
            stocks.add(newStock);
        }
    }


    public void buyStock(Stock stock, int quantity) {

    }

    public void sellStock(Stock stock, int quantity) {

    }

    // Metodă pentru eliminarea unui stock din portofoliu
    public void removeStock(Stock stock, int quantity) {
        stocks.remove(stock);
    }
    public Stock getStockBySymbol(String symbol) {
        for (Stock stock : stocks) {
            if (stock.getSymbol().equalsIgnoreCase(symbol)) {
                return stock;
            }
        }
        return null; // Returnăm null dacă stocul nu este găsit
    }
    public boolean hasEnoughStock(Stock stock, int quantity) {
        // Verificăm dacă avem suficient stoc dintr-un anumit tip pentru a vinde
        return stocks.contains(stock) && stocks.get(stocks.indexOf(stock)).getQuantity() >= quantity;
    }

}
