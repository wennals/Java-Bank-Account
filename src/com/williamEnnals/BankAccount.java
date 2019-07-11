package com.williamEnnals;

import java.util.ArrayList;
import java.util.List;

public abstract class BankAccount {

    private long accountNumber;
    private double balance;
    private String typeOfAccount;
    private List<String> recentTransactions;
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RESET = "\u001B[0m";

    public BankAccount(double balance) {
        if (balance < 0.00) {
            this.balance = 0.00;
        } else {
            this.balance = balance;
        }
        this.accountNumber = assignAccountNumber();
        this.recentTransactions = new ArrayList<>();
    }

    public BankAccount() {
        this.balance = 0.0;
        this.accountNumber = assignAccountNumber();
        this.recentTransactions = new ArrayList<>();
    }

    public long assignAccountNumber() {
        return (long) (Math.random() * 999999999) + 100000000;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public String getTypeOfAccount() {
        return typeOfAccount;
    }

    public List<String> getRecentTransactions() {
        return recentTransactions;
    }

    public void depositFunds(double deposit) {
        if (balance < 0) {
            System.out.println("Your deposit was unsuccessful, try making a deposit of more than 0.00");

        } else {
            balance += deposit;
            System.out.println("Your deposit was successful, your new balance is: " + getBalance());
            recentTransactions.add("Deposit: +" + deposit);
        }
    }

    public double withdrawFunds(double withdrawal) {
        if (withdrawal < 0) {
            System.out.println("Your withdrawal was unsuccessful, try making a withdrawal of more than 0.00");
            return 0.00;
        } else if (withdrawal > getBalance()) {
            System.out.println("Your withdrawal was unsuccessful because it exceeds your account balance");
            return 0.00;
        } else {
            balance -= withdrawal;
            System.out.println("Your withdrawal was successful, your new balance is: " + getBalance());
            recentTransactions.add("Withdrawal: -" + withdrawal);
            return withdrawal;
        }
    }

    public boolean transferFunds(double amount, BankAccount receivingAccount) {
        if (amount < 0) {
            return false;
        }

        if (amount > getBalance()) {
            return false;
        }

        balance -= amount;
        receivingAccount.balance += amount;
        recentTransactions.add("Transfer: -" + amount);
        return true;


    }

    public String recentTransactions(List recentTransactions) {
        StringBuilder sb = new StringBuilder("Most recent transactions\n");
        if(recentTransactions.isEmpty()){
            return ANSI_CYAN + "No transactions have been made" + ANSI_RESET;
        }
        for (int i = 0; ((recentTransactions.size()) > 5 ? i<5: i<recentTransactions.size()); i++) {
            sb.append("\t\t" + ANSI_CYAN + recentTransactions.get(i) + ANSI_RESET + "\n");

        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return ("Account number: " + getAccountNumber() +
                ", Type: " + getTypeOfAccount() +
                ", Balance " + getBalance() + "\n" +
                "\t\t" + recentTransactions(recentTransactions)
        );

    }
}
