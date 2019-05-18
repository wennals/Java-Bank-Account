package com.william.ennals;

class Savings extends BankAccount {

    private final String accountNumber;
    private final double interestRate;

    public Savings(String accountType, String customerName, String email, String phoneNumber, double balance,
                   double interestRate, String accountNumber) {
        super(accountType, customerName, email, phoneNumber, balance);
        this.interestRate = interestRate;
        this.accountNumber = accountNumber;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}
