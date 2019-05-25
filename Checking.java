package com.william.ennals;

class Checking extends AccountType {

    public Checking(double balance) {
        super(balance);
    }

    public Checking() {
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

    @Override
    public void makeDeposit(double deposit) {
        super.makeDeposit(deposit);
    }

    @Override
    public double makeWithdrawal(double withdrawal) {
        return super.makeWithdrawal(withdrawal);
    }


}
