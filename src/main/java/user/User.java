package main.java.user;

import main.java.stock.Stock;

public class User {
    private String email;
    private String password;
    private String name;
    private double balance;  // Adaugăm atributul pentru soldul utilizatorului
    private Portfolio portfolio;

    public User(String email, String password, String name, Portfolio portfolio, double initialBalance) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.portfolio = portfolio;
        this.balance = initialBalance; // Inițializăm soldul cu valoarea dată
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void buyStock(Stock stock, int quantity) {
        double totalPrice = stock.getCurrentPrice() * quantity;

        if (balance >= totalPrice) {
            portfolio.addStock(stock, quantity);
            balance -= totalPrice; // Actualizăm soldul după cumpărare
            System.out.println("Cumpărare reușită. Fonduri rămase: " + balance);
        } else {
            System.out.println("Fonduri insuficiente pentru cumpărare.");
        }
    }

    public void sellStock(Stock stock, int quantity) {
        if (portfolio.hasEnoughStock(stock, quantity)) {
            portfolio.removeStock(stock, quantity);
            double saleProceeds = stock.getCurrentPrice() * quantity;
            balance += saleProceeds; // Actualizăm soldul după vânzare
            System.out.println("Vânzare reușită. Fonduri disponibile: " + balance);
        } else {
            System.out.println("Cantitate insuficientă pentru vânzare.");
        }
    }

    public Stock getStockBySymbol(String symbol) {
        return portfolio.getStockBySymbol(symbol);
    }

    public void setBalance(double v) {
    }
}
