package main.java.template;

import main.java.transaction.Transaction;

public abstract class TradingTemplate {
    // Metodă finală care definește scheletul tranzacției
    public final void executeTransaction(Transaction transaction) {
        validateTransaction(transaction);
        applyStrategy(transaction);
        finalizeTransaction(transaction);
    }

    // Metode abstracte ce trebuie implementate în subclase
    protected abstract void validateTransaction(Transaction transaction);
    protected abstract void applyStrategy(Transaction transaction);
    protected abstract void finalizeTransaction(Transaction transaction);
}