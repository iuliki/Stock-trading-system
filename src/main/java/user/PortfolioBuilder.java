package main.java.user;

import main.java.stock.Stock;

import java.util.List;

public class PortfolioBuilder {
    private List<Stock> stocks;

    // Metode pentru adăugarea de stocuri în portofoliu
    // ...

    public Portfolio build() {
        return new Portfolio(stocks);
    }
}