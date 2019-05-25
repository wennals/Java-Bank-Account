package com.william.ennals;

public class CreditCard extends AccountType {
    public CreditCard(double balance) {
        super(balance);
    }

    public CreditCard() {
        super();
    }

    @Override
    public int assignAccountNumber() {
        return super.assignAccountNumber();
    }

    @Override
    public int getAccountNumber() {
        return super.getAccountNumber();
    }

    @Override
    public double getBalance() {
        return super.getBalance();
    }



}
