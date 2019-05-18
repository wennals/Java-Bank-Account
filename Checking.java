package com.william.ennals;

class Checking extends BankAccount {

    private final String accountNumber;

    public Checking(String accountType, String customerName, String email, String phoneNumber, double balance, String accountNumber) {
        super(accountType, customerName, email, phoneNumber, balance);
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}
