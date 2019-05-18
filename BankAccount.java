package com.william.ennals;

//enum AccountType {
//    Checking,
//    Savings,
//    CreditCard
//}

class BankAccount {
    private final String customerName;
    private final String email;
    private final String phoneNumber;
    private final String accountType;
    private double balance;


    public BankAccount(String accountType, String customerName, String email, String phoneNumber, double balance) {
        this.accountType = accountType;
        this.customerName = customerName;
        this.email = email;
        this.phoneNumber = phoneNumber;

        if (balance < 0){
            this.balance = 0.0;
        } else {
            this.balance = balance;
        }

        // based on type do something
        createAccount(accountType);
    }

    private void createAccount(String accountType) {
            switch (accountType) {
            case "Checking":
                new Checking(accountType, customerName, email, phoneNumber, balance, assignAccountNumber());

                break;
            case "Savings":
                new Savings(accountType, customerName, email,
                        phoneNumber, balance, 0.09, assignAccountNumber());
                break;
            case "CreditCard":
                System.out.println("Credit Cards are not currently available");
                break;
        }
    }
    private String assignAccountNumber() {
        int accountNumber = 1000000 + (int) (Math.random() * 9000000);
        return String.valueOf(accountNumber);
    }


    private String getCustomerName() {
        return customerName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    private String getAccountType() {
        return accountType;
    }

    private double getBalance() {
        return balance;
    }


    private void depositFunds(double deposit) {
        if (deposit > 0) {
            balance += deposit;
            System.out.println("Your deposit of " + deposit + " was successful. Your new balance is: $" + balance);
        } else {
            System.out.println("Sorry " + getCustomerName() + "we are unable to process your deposit of  " + deposit + ". Deposits must be more than $0.00");
        }
    }

    public double withdrawFunds(double withdrawal) {
        if (withdrawal > balance) {
            System.out.println("We are unable to process your withdrawal of  " + withdrawal + ", you only have " + balance + " remaining.");
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

    public void transferFunds(double transfer, BankAccount fromAccount, BankAccount toAccount ){

            if (transfer < 0){
                System.out.println("Sorry " + fromAccount.getCustomerName() + "we are unable to process your transfer of  " + transfer +
                        ". Transfers must be more than $0.00");
            } else if (transfer > fromAccount.getBalance()) {
                System.out.println("Sorry " + fromAccount.getCustomerName() + "we are unable to process your transfer of  " + transfer +
                        "because this exceeds your balance of: " + fromAccount.getBalance());
            } else {
                toAccount.depositFunds(transfer);
                System.out.println("You have successfully transferred " + transfer + " from your " +
                                fromAccount.accountType + " account to your " + toAccount.accountType + " account.");
                fromAccount.balance -= transfer;
                System.out.println("Your " + fromAccount.getAccountType() + " account has a new balance of: " + fromAccount.balance);
                System.out.println("Your " + toAccount.getAccountType() + " account has a new balance of: " + toAccount.balance);
            }

    }

}

