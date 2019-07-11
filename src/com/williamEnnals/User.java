package com.williamEnnals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private String firstName;
    private String lastName;
    private String userName;
    private int age;
    private long socialSecurityNumber;
    private List<BankAccount> checkings;
    private List<BankAccount> savings;
    private List<BankAccount> creditCards;
    private Map<AccountTypes, List<BankAccount>> openAccounts;

    public User(String firstName, String lastName, String userName, int age, long socialSecurityNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.age = age;
        this.socialSecurityNumber = socialSecurityNumber;
        this.openAccounts = new HashMap<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserName() {
        return userName;
    }

    public int getAge() {
        return age;
    }

    // This will be protected in the Bank class, the Bank class we store all User Accounts.
    public long getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public List<BankAccount> getCheckings() {
        return checkings;
    }

    public List<BankAccount> getSavings() {
        return savings;
    }

    public List<BankAccount> getCreditCards() {
        return creditCards;
    }

    public void openAccount(AccountTypes accountType) {
        if (this.openAccounts.get(accountType) == null) {
            switch (accountType) {
                case CHECKINGS:
                    this.checkings = new ArrayList<>();
                    checkings.add(new CheckingAccount());
                    openAccounts.put(accountType, checkings);
                    break;
                case SAVINGS:
                    this.savings = new ArrayList<>();
                    savings.add(new SavingsAccount());
                    openAccounts.put(accountType, savings);
                case CREDITCARD:
                    this.creditCards = new ArrayList<>();
                    creditCards.add(new CreditCard());
                    openAccounts.put(accountType, creditCards);
            }
        } else {
            switch (accountType) {
                case CHECKINGS:
                    checkings.add(new CheckingAccount());
                    openAccounts.put(accountType, checkings);
                    break;
                case SAVINGS:
                    savings.add(new SavingsAccount());
                    openAccounts.put(accountType, savings);
                    break;
                case CREDITCARD:
                    creditCards.add(new CreditCard());
                    openAccounts.put(accountType, creditCards);
                    break;
            }

        }
    }

    public void openAccount(AccountTypes accountType, double startingBalance) {
        if(startingBalance < 0){
            System.out.println("Cannot open account with negative balance, balance = 0.00");
            return;
        }
        if (this.openAccounts.get(accountType) == null) {
            switch (accountType) {
                case CHECKINGS:
                    this.checkings = new ArrayList<>();
                    checkings.add(new CheckingAccount(startingBalance));
                    openAccounts.put(accountType, checkings);
                    break;
                case SAVINGS:
                    this.savings = new ArrayList<>();
                    savings.add(new SavingsAccount(startingBalance));
                    openAccounts.put(accountType, savings);

            }
        } else {
            switch (accountType) {
                case CHECKINGS:
                    checkings.add(new CheckingAccount(startingBalance));
                    openAccounts.put(accountType, checkings);
                    break;
                case SAVINGS:
                    savings.add(new SavingsAccount(startingBalance));
                    openAccounts.put(accountType, savings);
                    break;
            }

        }
    }

    public void viewAccounts(){
        for(Map.Entry<AccountTypes, List<BankAccount>> accountMap : openAccounts.entrySet()){
            List<BankAccount> accounts = accountMap.getValue();
            for (BankAccount account : accounts){
                System.out.println(account);
            }
        }

    }



    public List<Long> getAccountNumbers(){
        List<Long> allAccounts = new ArrayList<>();
        for(Map.Entry<AccountTypes, List<BankAccount>> accountMap : openAccounts.entrySet()){
            List<BankAccount> accounts = accountMap.getValue();
            for (BankAccount account : accounts){
                System.out.format("Account number %d, has a balance of %s.\n", account.getAccountNumber(), account.getBalance());
                allAccounts.add(account.getAccountNumber());
            }
        }
        return allAccounts;

    }



    public BankAccount findAccountByAccountNumber(long accountNumber){
        for(Map.Entry<AccountTypes, List<BankAccount>> accountMap : openAccounts.entrySet()){
            List<BankAccount> accounts = accountMap.getValue();
            for (BankAccount account : accounts){
                if(account.getAccountNumber() == accountNumber){
                    return account;
                }
            }
        }
        return null;

    }

    public void viewAccountBalance(long accountNumber){
        BankAccount account = findAccountByAccountNumber(accountNumber);
        if(account != null){
            System.out.println("Account number " + accountNumber + "is of type: " + account.getTypeOfAccount() +
                    " and has a balance of " + account.getBalance());
        }
    }

    public void depositFunds(long accountNumber, double amount){
        BankAccount account = findAccountByAccountNumber(accountNumber);
        if(account != null){
            account.depositFunds(amount);
        }else{
            System.out.println("Invalid account number, please try again");
            return;
        }
    }

    public double withdrawFunds(long accountNumber, double amount){
        BankAccount account = findAccountByAccountNumber(accountNumber);
        if(account != null){
             return account.withdrawFunds(amount);
        }
        return 0.00d;
    }

    public void transferFunds(List<Long> accounts, double amount){
        BankAccount sendingAccount = findAccountByAccountNumber(accounts.get(0));
        BankAccount receivingAccount = findAccountByAccountNumber(accounts.get(1));
        if(( sendingAccount  != null) && (receivingAccount != null)){
            double sendingAccountOriginalBalance = sendingAccount.getBalance();
            double receivingAccountOriginalBalance = receivingAccount.getBalance();
            sendingAccount.transferFunds(amount, receivingAccount);
            System.out.println("\n\nAccount number "+ accounts.get(0) + " had an original balance of " +
                    sendingAccountOriginalBalance + ", it now has a balance of " + sendingAccount.getBalance() + "\n" +
                    "Account number "+ accounts.get(1) + " had an original balance of " +
                    receivingAccountOriginalBalance + ", it now has a balance of " + receivingAccount.getBalance());
        }
    }



}
