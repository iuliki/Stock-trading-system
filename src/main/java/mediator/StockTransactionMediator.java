package main.java.mediator;

import main.java.transaction.Transaction;

import java.util.ArrayList;
import java.util.List;

public class StockTransactionMediator implements TransactionMediator {
    private List<Transaction> transactions = new ArrayList<>();

    @Override
    public void notify(Transaction transaction) {
        transactions.add(transaction);

    }
}