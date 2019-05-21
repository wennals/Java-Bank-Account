package com.william.ennals;

class Savings extends BankAccount {

    private double interestRate;
    private final int accountNumber;

    public Savings( String customerName, String email, String phoneNumber, double balance) {
        super(customerName, email, phoneNumber, balance);
        this.interestRate = 0.09;
        this.accountNumber = assignAccountNumber();
    }

    public double getInterestRate() {
        return interestRate;
    }
    @Override
    public int getAccountNumber() {
        return accountNumber;
    }
}
