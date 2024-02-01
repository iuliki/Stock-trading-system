package main.java.facade;

import main.java.singleton.StockManager;
import main.java.stock.Stock;
import main.java.user.Portfolio;
import main.java.user.User;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StockTradingSystem {

    private StockManager stockManager;
    private User currentUser;
    private List<User> users;

    public StockTradingSystem() {
        this.stockManager = StockManager.getInstance();
        this.users = new ArrayList<>();
        initializeUsers();
        // Alte inițializări pot fi adăugate aici
    }

    private void initializeUsers() {
        User user1 = new User("john.doe@email.com", "password", "password", new Portfolio(), 1000.0);
        User user2 = new User("jane.smith@email.com", "password", "password", new Portfolio(),  1000.0);
        User user3 = new User("bob.jones@email.com", "\"password", "password", new Portfolio(),  1000.0);
        User user4 = new User("alice.white@email.com", "password", "password", new Portfolio(),  1000.0);
        User user5 = new User("charlie.brown@email.com", "password\",", "password", new Portfolio(),  1000.0);
        User user6 = new User("emma.johnson@email.com", "password", "password", new Portfolio(),  1000.0);

        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        users.add(user6);

        // Adaugăm stocuri în portofoliul inițial al fiecărui utilizator
        Stock appleStock = new Stock("Apple Inc.", "AAPL", 150.0, 100);
        Stock googleStock = new Stock("Alphabet Inc.", "GOOGL", 2500.0, 50);

        user1.getPortfolio().addStock(appleStock, 10);
        user1.getPortfolio().addStock(googleStock, 5);

        user2.getPortfolio().addStock(appleStock, 20);
        user2.getPortfolio().addStock(googleStock, 8);

        user3.getPortfolio().addStock(appleStock, 15);
        user3.getPortfolio().addStock(googleStock, 3);

        // Adăugăm stocuri în StockManager
        stockManager.addStock(appleStock);
        stockManager.addStock(googleStock);
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bun venit în sistemul de tranzacționare cu acțiuni!");

        while (true) {
            System.out.println("Selectați o opțiune:");
            System.out.println("1. Autentificare");
            System.out.println("2. Înregistrare");
            System.out.println("3. Ieșire");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    login();
                    break;
                case 2:
                    register();
                    break;
                case 3:
                    System.out.println("La revedere!");
                    return;
                default:
                    System.out.println("Opțiune invalidă. Încercați din nou.");
            }
        }
    }

    private void login() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduceți adresa de email:");
        String email = scanner.next();

        System.out.println("Introduceți parola:");
        String password = scanner.next();

        currentUser = authenticateUser(email, password);

        if (currentUser != null) {
            System.out.println("Autentificare reușită!");
            handleUser();
        } else {
            System.out.println("Autentificare eșuată. Verificați adresa de email și parola.");
        }
    }

    private User authenticateUser(String email, String password) {
        for (User user : users) {
            if (user.getEmail().equalsIgnoreCase(email) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    private void register() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduceți adresa de email:");
        String email = scanner.next();

        // Verificăm dacă email-ul este deja înregistrat
        for (User user : users) {
            if (user.getEmail().equalsIgnoreCase(email)) {
                System.out.println("Acest email este deja înregistrat. Încercați un altul.");
                return;
            }
        }

        System.out.println("Introduceți parola:");
        String password = scanner.next();

        System.out.println("Introduceți numele:");
        String name = scanner.next();

        // Creăm un portofoliu gol pentru noul utilizator
        Portfolio portfolio = new Portfolio();

        User newUser = new User(email, password, name, new Portfolio(), 1000.0);
        users.add(newUser);

        System.out.println("Înregistrare reușită! Bine ai venit, " + name + "!");
    }

    private void handleUser() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Selectați o opțiune:");
            System.out.println("1. Căutare stocuri");
            System.out.println("2. Cumpărare stocuri");
            System.out.println("3. Vânzare stocuri");
            System.out.println("4. Vizualizare portofoliu");
            System.out.println("5. Deconectare");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    searchStocks();
                    break;
                case 2:
                    buyStocks();
                    break;
                case 3:
                    sellStocks();
                    break;
                case 4:
                    viewPortfolio();
                    break;
                case 5:
                    System.out.println("Deconectare...");
                    currentUser = null;
                    return;
                default:
                    System.out.println("Opțiune invalidă. Încercați din nou.");
            }
        }
    }

    private void searchStocks() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduceți simbolul sau numele stocului căutat:");
        String query = scanner.next();
        Stock foundStock = stockManager.searchStock(query);

        if (foundStock != null) {
            foundStock.displayInfo();
        } else {
            System.out.println("Stocul nu a fost găsit.");
        }
    }

    private void buyStocks() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduceți simbolul stocului pentru cumpărare:");
        String stockSymbol = scanner.nextLine();

        // Verificăm dacă stocul există în sistem
        Stock selectedStock = stockManager.getStockBySymbol(stockSymbol);

        if (selectedStock == null) {
            System.out.println("Stocul cu simbolul " + stockSymbol + " nu există.");
            return;
        }

        System.out.println("Introduceți cantitatea pentru cumpărare:");
        int quantityToBuy = scanner.nextInt();

        // Verificăm dacă utilizatorul are suficiente fonduri pentru a cumpăra acțiunile
        double totalCost = selectedStock.getCurrentPrice() * quantityToBuy;

        if (currentUser.getBalance() < totalCost) {
            System.out.println("Fonduri insuficiente pentru cumpărare.");
            return;
        }

        // Efectuăm tranzacția de cumpărare
        currentUser.getPortfolio().addStock(selectedStock, quantityToBuy);
        currentUser.setBalance(currentUser.getBalance() - totalCost);

        System.out.println("Cumpărare reușită. Fonduri rămase: " + currentUser.getBalance());
    }

    private void sellStocks() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduceți simbolul stocului pentru vânzare:");
        String stockSymbol = scanner.nextLine();

        // Verificăm dacă stocul există în portofoliul utilizatorului
        Stock ownedStock = currentUser.getPortfolio().getStockBySymbol(stockSymbol);

        if (ownedStock == null) {
            System.out.println("Nu dețineți stocul cu simbolul " + stockSymbol + ".");
            return;
        }

        System.out.println("Introduceți cantitatea pentru vânzare:");
        int quantityToSell = scanner.nextInt();

        // Verificăm dacă utilizatorul deține suficiente acțiuni pentru a le vinde
        if (ownedStock.getQuantity() < quantityToSell) {
            System.out.println("Nu aveți suficiente acțiuni pentru vânzare.");
            return;
        }

        // Efectuăm tranzacția de vânzare
        currentUser.getPortfolio().removeStock(ownedStock, quantityToSell);
        double totalEarnings = ownedStock.getCurrentPrice() * quantityToSell;
        currentUser.setBalance(currentUser.getBalance() + totalEarnings);

        System.out.println("Vânzare reușită. Fonduri disponibile: " + currentUser.getBalance());
    }


    private void viewPortfolio() {
        System.out.println("Portofoliu pentru " + currentUser.getName() + ":");
        for (Stock stock : currentUser.getPortfolio().getStocks()) {
            System.out.println("Stoc: " + stock.getName() + " (" + stock.getSymbol() + ")");
            System.out.println("Cantitate în portofoliu: " + stock.getQuantity() + " unități");
            System.out.println("------------------------------");
        }
    }


}
