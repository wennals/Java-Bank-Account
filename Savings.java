package com.william.ennals;

class Savings extends BankAccount {

    private final int accountNumber;
    private final double interestRate;

    public Savings(AccountType accountType, String customerName, String email, String phoneNumber, double balance,
                   double interestRate) {
        super(accountType, customerName, email, phoneNumber, balance);
        this.interestRate = interestRate;
        this.accountNumber = assignAccountNumber();
    }

    public double getInterestRate() {
        return interestRate;
    }

    public int getAccountNumber() {
        return accountNumber;
    }
}
