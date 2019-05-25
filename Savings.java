package com.william.ennals;

class Savings extends AccountType {

    public Savings(double balance) {
        super(balance);
    }

    public Savings() {
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

    @Override
    public void makeDeposit(double deposit) {
        super.makeDeposit(deposit);
    }

    @Override
    public double makeWithdrawal(double withdrawal) {
        return super.makeWithdrawal(withdrawal);
    }
}
