package com.william.ennals;


import java.util.*;

enum AccountOptions {
    CHECKING,
    SAVINGS,
    CREDITCARD
}

public class BankAccount {
    private final String firstName;
    private final String lastName;
    private final int socialSecurityNumber;
    private final String email;
    private final String phoneNumber;
    private Map<String, AccountType> customerAccounts;


    public BankAccount(String firstName, String lastName, int socialSecurityNumber,  String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.customerAccounts = new HashMap<>();
    }


    public void createAccount(AccountOptions accountOption, String accountName) {
        if (this.customerAccounts.get(accountName) == null) {
            switch (accountOption){
                case CHECKING:
                    customerAccounts.put(accountName, new Checking());
                    break;
                case SAVINGS:
                    customerAccounts.put(accountName, new Savings());
                    break;
                case CREDITCARD:
                    customerAccounts.put(accountName, new CreditCard());
            }

        } else {

            System.out.println("An account of this name already exists");
        }
    }



    // Future update needs to ensure that the account numbers are unique


    public String getfirstName() {
        return firstName;
    }

    public String lastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public AccountType getAccount(String accountName){
            return customerAccounts.get(accountName);
    }

    public void makeTransfer(String fromAccount, String toAccount, double transfer){
        AccountType sendingAccount = getAccount(fromAccount);
        AccountType receivingAccount = getAccount(toAccount);
        sendingAccount.outboundTransfer(transfer, receivingAccount);
        System.out.println("You have successfully transferred " + transfer + " from account: " + fromAccount
        + " it now has a balance of: " + sendingAccount.getBalance());
        System.out.println("Your account: " + toAccount + " has received a transfer of " + transfer +
                " it now has a balance of: " + receivingAccount.getBalance());

    }

}

