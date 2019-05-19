package com.william.ennals;

class Main {

    public static void main(String[] args) {

        Checking myChecking = new Checking(AccountType.CHECKING, "Bob Sagget", "bsag@example.com",
                "281-330-8004", 0);

        Savings mySavings = new Savings(AccountType.SAVINGS, "Bob Sagget", "bsag@example.com",
                "281-330-8004", 0, 0.09);
        System.out.println("Checking account number: " + myChecking.getAccountNumber());
        System.out.println("Savings account number: " + mySavings.getAccountNumber());
       mySavings.depositFunds(1800);
       myChecking.depositFunds(3000);
       myChecking.transferFunds(200, myChecking, mySavings);
       myChecking.withdrawFunds(4000);
       myChecking.withdrawFunds(20);
       myChecking.depositFunds(32);
       myChecking.withdrawFunds(-3445);
       myChecking.depositFunds(-2);






    }
}
