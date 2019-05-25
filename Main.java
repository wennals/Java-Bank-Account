package com.william.ennals;

class Main {

    public static void main(String[] args) {
        // Phase 1: Execute code using Polymorphism
        BankAccount myAccount = new BankAccount("Bob", "Sagget", 98958890, "bsag@example.com", "281-330-8004");
        myAccount.createAccount(AccountOptions.CHECKING, "myFirstChecking");
        AccountType myChecking = myAccount.getAccount("myFirstChecking");

        System.out.println(myChecking.getAccountNumber());
        System.out.println(myChecking.getBalance());
        myChecking.makeDeposit(999.00);
        myChecking.makeWithdrawal(200.30);
        myChecking.makeWithdrawal(-40);


        myAccount.createAccount(AccountOptions.SAVINGS, "myFirstSavings");
        AccountType mySavings = myAccount.getAccount("myFirstSavings");


        System.out.println(mySavings.getAccountNumber());
        System.out.println(mySavings.getBalance());
        mySavings.makeDeposit(999.00);
        mySavings.makeWithdrawal(998.99);
        mySavings.makeDeposit(9999.00);
        myAccount.makeTransfer("myFirstSavings", "myFirstChecking", 500);



    }
}

