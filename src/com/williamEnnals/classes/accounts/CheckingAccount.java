package com.williamEnnals.classes.accounts;

import java.util.List;

public class CheckingAccount extends BankAccount{
    private String accountType = "checking";
    public CheckingAccount(double balance) {
        super(balance);
    }

    public CheckingAccount() {
        super();
    }

    @Override
    public long assignAccountNumber() {
        return super.assignAccountNumber();
    }

    @Override
    public long getAccountNumber() {
        return super.getAccountNumber();
    }

    @Override
    public double getBalance() {
        return super.getBalance();
    }

    @Override
    public String getTypeOfAccount() {
        return "Checkings";
    }

    @Override
    public String recentTransactions(List recentTransactions) {
        return super.recentTransactions(recentTransactions);
    }

    @Override
    public List<String> getRecentTransactions() {
        return super.getRecentTransactions();
    }

    @Override
    public void depositFunds(double deposit) {
        super.depositFunds(deposit);
    }

    @Override
    public double withdrawFunds(double withdrawal) {
        return super.withdrawFunds(withdrawal);
    }

    @Override
    public boolean transferFunds(double amount, BankAccount receivingAccount) {
        return super.transferFunds(amount, receivingAccount);
    }

    public String getAccountType() {
        return accountType;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
