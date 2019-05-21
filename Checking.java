package com.william.ennals;

class Checking extends BankAccount {

    private final int accountNumber;

    public Checking( String customerName, String email, String phoneNumber, double balance) {
        super(customerName, email, phoneNumber, balance);
        this.accountNumber = assignAccountNumber();
    }
    @Override
    public int getAccountNumber() {
        return accountNumber;
    }



}
