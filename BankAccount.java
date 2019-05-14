package com.william.ennals;

public class BankAccount {
    private String accountNumber;
    private double balance;
    private String customerName;
    private String email;
    private String phoneNumber;

    // Initializes the BankAccount object using a blank constructor with default values.
    public BankAccount(){
        this("000-0000-00001", 0.00, "Username", "Customer Email", "(XXX) - XXX -XXXX");
    }

    // Initializes the BankAccount object with user specified values.
    public BankAccount(String accountNumber, double balance, String customerName, String email, String phoneNumber){
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customerName = customerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public void setAccountNumber (String accountNumber){
        this.accountNumber = accountNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setCustomerName(String customerName){
        this.customerName = customerName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
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
    public double depositFunds(double deposit) {
        if (deposit > 0) {
          this.balance += deposit;
            System.out.println("Your deposit of " + deposit + " was successful. Your new balance is: $" + this.balance);
            return this.balance;
        }
        System.out.println("We are unable to process your deposit of  " + deposit + ", Deposits must be more than $0.00");
        return this.balance;
    }

    public double withdrawFunds(double withdrawal){
            if (withdrawal > balance ){
                System.out.println("We are unable to process your withdrawal of  " + withdrawal + ", you only have " + this.balance + " remaining.");
                return this.balance;
            } else if (withdrawal < 0){
                System.out.println("We are unable to process your withdrawal of  " + withdrawal + ", please use a positive number. You still have " + this.balance + " remaining.");
                return this.balance;
            }
            this.balance-= withdrawal;
            System.out.println("Your withdrawal of " + withdrawal + " was successful. Your new balance is: $" + this.balance);
            return this.balance;
        }
    }

