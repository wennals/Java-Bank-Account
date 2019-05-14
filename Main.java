package com.william.ennals;

public class Main {

    public static void main(String[] args) {
        BankAccount myAccount = new BankAccount("4849-8999-00001", 10_000,
                "Wilt Chamberlain","wchamberlain@example.com", "281-330-8004");

        myAccount.depositFunds(600);
        myAccount.withdrawFunds(90);
        myAccount.withdrawFunds(9000);
        myAccount.depositFunds(-0.01);
        myAccount.depositFunds(.52);
        myAccount.withdrawFunds(-500);


    }
}
