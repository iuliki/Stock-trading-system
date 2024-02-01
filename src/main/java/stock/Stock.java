package main.java.stock;

public class Stock {
    private String name;
    private String symbol;
    private double currentPrice;
    private int quantity;

    // Constructor, getteri și setteri

    public Stock(String name, String symbol, double currentPrice, int quantity) {
        this.name = name;
        this.symbol = symbol;
        this.currentPrice = currentPrice;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void displayInfo() {
        System.out.println("Stoc: " + getName() + " (" + getSymbol() + ")");
        System.out.println("Preț curent: $" + getCurrentPrice());
        System.out.println("Stoc disponibil: " + getQuantity() + " unități");
    }
}