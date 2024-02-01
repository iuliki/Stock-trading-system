package main.java.mediator;

import main.java.transaction.Transaction;

public interface TransactionMediator {
    void notify(Transaction transaction);
}