package com.william.ennals;

class Checking extends BankAccount {

    public final int accountNumber;

    public Checking(AccountType accountType, String customerName, String email, String phoneNumber, double balance) {
        super(accountType, customerName, email, phoneNumber, balance);
        this.accountNumber = assignAccountNumber();
    }

    public int getAccountNumber() {
        return accountNumber;
    }
}
