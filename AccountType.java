package com.william.ennals;

public abstract class AccountType {

    private int accountNumber;
    private double balance;

    public AccountType(double balance) {
        if (balance < 0.00) {
            this.balance = 0.00;
        } else {
            this.balance = balance;
        }
        this.accountNumber = assignAccountNumber();
    }

    public AccountType() {
        this.balance = 0.0;
        this.accountNumber = assignAccountNumber();
    }

    public int assignAccountNumber() {
        return (int) (Math.random() * 999999999) + 100000000;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void makeDeposit(double deposit) {
        if (balance < 0) {
            System.out.println("Your deposit was unsuccessful, try making a deposit of more than 0.00");

        } else {
            balance += deposit;
            System.out.println("Your deposit was successful, your new balance is: " + getBalance());
        }
    }

    public double makeWithdrawal(double withdrawal) {
        if (withdrawal < 0) {
            System.out.println("Your withdrawal was unsuccessful, try making a withdrawal of more than 0.00");
            return 0.00;
        } else if (withdrawal > getBalance()) {
            System.out.println("Your withdrawal was unsuccessful because it exceeds your account balance");
            return 0.00;
        } else {
            balance -= withdrawal;
            System.out.println("Your withdrawal was successful, yoour new balande is: " + getBalance());
            return withdrawal;
        }
    }

    public void outboundTransfer(double transfer, AccountType receivingAccount){
        if (transfer < 0){
            System.out.println("Your transfer was unsuccessful, try making a transfer of more than 0.00");
            transfer = 0.00;
        } else if(transfer > getBalance()){
            System.out.println("Your transfer was unsuccessful because it exceeds your account balance");
        } else {
            if(receivingAccount != null) {
                balance -= transfer;
                receivingAccount.balance += transfer;
                System.out.println("Your transfer was successful");

            } else {
                System.out.println("The receiving account specified does not exist");
            }
        }
    }


}
