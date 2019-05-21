package com.william.ennals;


import javax.lang.model.type.NullType;
import java.util.HashMap;
import java.util.Map;

public abstract class BankAccount<type> {
    private final String customerName;
    private final String email;
    private final String phoneNumber;
    private double balance;
    private int accountNumber;
    public Map<AccountType, BankAccount> customerAccounts;
    private AccountType accountType;


//    public BankAccount(String customerName, String email, String phoneNumber) {
//        this.customerName = customerName;
//        this.email = email;
//        this.phoneNumber = phoneNumber;
//        this.balance = 0;
//        this.customerAccounts = new HashMap<>();
//
//    }

    public BankAccount(String customerName, String email, String phoneNumber, double balance) {
        this.customerName = customerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
        this.customerAccounts = new HashMap<>();
    }

    public void createAccount(AccountType accountType) {
        // If the account type al[123ready exists, return an already exists error
        // After creating the account, add it to a hashmap (account type) that contains  of bank accounts
        // Ensure the amount is >= 0
        // You can only have one of each account type
        // Create a name for each account

                    switch (accountType) {
                        case CHECKING:
                                if (this.customerAccounts.containsKey(AccountType.CHECKING)){
                                    System.out.println("We're sorry, you already have a checking account open with us");
                                }else {
                                    this.customerAccounts.put(AccountType.CHECKING,
                                            new Checking(customerName, email, phoneNumber, balance));
                                }
                                break;
                        case SAVINGS:
                            if (this.customerAccounts.get(AccountType.SAVINGS) instanceof Savings){
                                System.out.println("We're sorry, you already have a savings account open with us");
                            }else {
                                Savings savings = new Savings(customerName, email, phoneNumber, getBalance());
                                this.customerAccounts.put(AccountType.SAVINGS, savings);
                            }
                            break;
                        case CREDITCARD:
                            System.out.println("Credit Cards are not currently available");
                            break;
                    }
    }

    public int assignAccountNumber() {
        return 10000000 + (int) (Math.random() * 90000000);
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public double getBalance() {
        return balance;
    }

    public Map<AccountType, BankAccount> getCustomerAccounts() {
        return customerAccounts;
    }

    public AccountType getAccountType(){
                return accountType;
        }

    public BankAccount getAccount(AccountType accountType) {
        return customerAccounts.get(accountType);
    }

    public int getAccountNumber() {
        return accountNumber;
    }


    // Store duplicated variable/method calls to a variable.


    public void depositFunds(double deposit) {
        if (deposit > 0) {
            balance += deposit;
            System.out.println("Your amount of " + deposit + " was successful. Your new balance is: $" + balance);
        } else {
            System.out.println("Sorry " + "we are unable to process your amount of  " + deposit + ". Deposits must be more than $0.00");
        }
    }

    public double withdrawFunds(double withdrawal) {
        if (withdrawal > balance) {
            System.out.println("We are unable to process your withdrawal of  " + withdrawal + ", you only have " + balance + " available.");
            withdrawal = 0;
            return withdrawal;
        } else if (withdrawal < 0) {
            System.out.println("We are unable to process your withdrawal of  " + withdrawal + ", please use a positive number. You still have " + balance + " remaining.");
            withdrawal = 0;
            return withdrawal;
        } else {
            balance -= withdrawal;
            System.out.println("Your withdrawal of " + withdrawal + " was successful. Your new balance is: $" + balance);
            return withdrawal;
        }
    }

    public void transferFunds(double transfer, BankAccount toAccount ){
        // make sure each of the parameters exist, if not return an error message
        // minimize duplicate code
        if (!(toAccount instanceof BankAccount)) {
            System.out.println("The are trying to transfer funds to an account that does not exist");
        } else {
            if (transfer < 0) {
                System.out.println("Sorry " + getCustomerName() + "we are unable to process your transfer of  " + transfer +
                        ". Transfers must be more than $0.00");
            } else if (transfer > getBalance()) {
                System.out.println("Sorry " + getCustomerName() + "we are unable to process your transfer of  " + transfer +
                        "because this exceeds your balance of: " + getBalance());
            } else {
                toAccount.balance += transfer;
                System.out.println("You have successfully transferred " + transfer + " from your " +
                        getAccountType() + " account to your " + toAccount.getAccountType() + " account.");
                balance -= transfer;
                System.out.println("Your " + getAccountType() + " account has a new balance of: " + balance);
                System.out.println("Your " + toAccount.getAccountType() + " account has a new balance of: " + toAccount.balance);
            }
        }

    }

}

