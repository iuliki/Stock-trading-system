package main.java.transaction;

import main.java.stock.Stock;

import java.util.Date;

public interface TransactionBuilder {
    <TransactionType> TransactionBuilder setType(TransactionType type);
    TransactionBuilder setStock(Stock stock);
    TransactionBuilder setQuantity(int quantity);
    TransactionBuilder setPrice(double price);
    TransactionBuilder setDate(Date date);

    Transaction build();
}