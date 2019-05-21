package com.william.ennals;

class Main {

    public static void main(String[] args) {
        // Phase 1: Execute code using Polymorphism
        BankAccount myChecking = new Checking("Bob Sagget", "bsag@example.com", "281-330-8004", 10_000);

        System.out.println(myChecking.getAccountNumber());
        System.out.println(myChecking.getBalance());
        myChecking.depositFunds(999.00);
        myChecking.withdrawFunds(998.99);
        myChecking.withdrawFunds(9999.00);

        BankAccount mySavings = new Savings("Bob Sagget", "bsag@example.com", "281-330-8004", 10_000);

        System.out.println(mySavings.getAccountNumber());
        System.out.println(mySavings.getBalance());
        mySavings.depositFunds(999.00);
        mySavings.withdrawFunds(998.99);
        mySavings.withdrawFunds(9999.00);

        // Phase 2: Execute Using Generics




    }
}
