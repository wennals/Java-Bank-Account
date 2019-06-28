package com.williamEnnals;

import java.util.*;

public class Main {
    public static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.println("Welcome to Online Banking, it seems like you don't have an account with us.\n" +
                "Enter any key to open a new account with us, otherwise press n to quit.");
        AccountOwner accountOwner = null;
        boolean newUser = true;
        while (newUser) {
            String choice = scanner.nextLine();
            switch (choice) {
                case "n":
                    return;
                default:
                    accountOwner = createNewUser();
                    newUser = false;
                    break;
            }
        }

        boolean active = true;
        while (active) {
            System.out.println("Enter options to display account options");
            String choice = scanner.next().toLowerCase();
            switch (choice) {
                case "options":
                    displayOptions();
                    break;
                case "q":
                    active = false;
                    break;
                case "oc":
                    accountOwner.openAccount(AccountTypes.CHECKINGS);
                    break;
                case "os":
                    accountOwner.openAccount(AccountTypes.SAVINGS);
                    break;
                case "cc":
                    accountOwner.openAccount(AccountTypes.CREDITCARD);
                    break;
                case "ocwd":
                    double deposit = captureDeposit();
                    accountOwner.openAccount(AccountTypes.CHECKINGS, deposit);
                    break;
                case "oswd":
                    deposit = captureDeposit();
                    accountOwner.openAccount(AccountTypes.SAVINGS, deposit);
                    break;
                case "vb":
                    accountOwner.viewAccounts();
                    break;
                case "va":
                    long accountNumber = captureAccountNumber();
                    accountOwner.viewAccountBalance(accountNumber);
                case "d":
                    deposit = captureDeposit();
                    accountNumber = captureAccountNumber();
                    accountOwner.depositFunds(accountNumber, deposit);
                    break;
                case "w":
                    deposit = captureDeposit();
                    accountNumber = captureAccountNumber();
                    accountOwner.withdrawFunds(accountNumber, deposit);
                    break;
                case "t":
                    List<Long> accountList = captureAccountNumber(2);
                    double amount = captureDeposit();
                    accountOwner.transferFunds(accountList, amount);
                    break;
                default:
                    System.out.println("Invalid entry, try again.");
                    break;
            }
        }
    }

    public static void displayOptions() {
        System.out.println(
                        "Enter oc, to open a new Checkings Account without a deposit\n" +
                        "Enter os, to open a new Savings Account without a deposit\n" +
                        "Enter cc, to apply for a Credit card\n" +
                        "Enter ocwd, to open a new Checkings Account with a deposit\n" +
                        "Enter oswd, to open a new Savings Account with a deposit\n" +
                        "Enter vb, to view all account balances\n" +
                        "Enter va, to view a specific accounts balance\n" +
                        "Enter d, to make a deposit\n" +
                        "Enter w, to make a withdrawal\n" +
                        "Enter t, to transfer funds\n"

        );
    }

    public static AccountOwner createNewUser() {
        System.out.println("To set up an account with us, please tell us a little about yourself.");
        System.out.println("What's your full name ?");
        String[] fullName = scanner.nextLine().split(" ", 3);
        while ((fullName.length < 2) || (fullName[1].isEmpty())) {
            System.out.println("Please enter your first and last name");
            fullName = scanner.nextLine().split(" ", 3);
        }
        String firstName = fullName[0];
        String lastName = fullName[1];
        System.out.println("Please choose a username to help us identify your account");
        String userName = scanner.nextLine();
        boolean checkAge = true;
        int age = 0;
        while (checkAge) {
            System.out.println("How old are you ?");
            boolean hasInt = scanner.hasNextInt();
            if (hasInt) {
                age = scanner.nextInt();
                checkAge = false;
            } else {
                System.out.println("Invalid Entry, try again.");
            }
            scanner.nextLine();
        }
        boolean checkLong= true;
        long social = 0;
        while (checkLong) {
            System.out.println("And finally, what's your social security number ?");
            boolean hasLong = scanner.hasNextLong();
            if (hasLong) {
                social = scanner.nextLong();
                while (Long.toString(social).length() != 9) {
                    System.out.println("Invalid entry, a social security number is 9 digits long");
                    social = scanner.nextLong();
                }
                checkLong = false;
            }else {
                System.out.println("Invalid Entry, try again.");
            }
            scanner.nextLine();
        }
        return new AccountOwner(firstName, lastName, userName, age, social);
    }

    public static double captureDeposit(){
        System.out.println("How much would you like to deposit ?");
        boolean checkDouble= true;
        double deposit = 0;
        while (checkDouble) {
            boolean hasDouble = scanner.hasNextDouble();
            if (hasDouble) {
                deposit = scanner.nextDouble();
                while (deposit < 0) {
                    System.out.println("Deposits must be more than 0.");
                    deposit = scanner.nextLong();
                }
                checkDouble = false;
            }else {
                System.out.println("Invalid Entry, try again.");
            }
            scanner.nextLine();
        }
        return deposit;
    }

    public static List<Long> captureAccountNumber(int numberOfAccounts){
        int count = 1;
        List<Long> accountNumberList = new ArrayList<>();
        long accountNumber = 0;
        boolean checkLong = true;
        while((count != (numberOfAccounts + 1))|| checkLong) {
            System.out.println("Enter a valid account number for account " + count + " of " + numberOfAccounts);
            boolean hasLong = scanner.hasNextLong();
            if(hasLong) {
                accountNumber = scanner.nextLong();
                while (Long.toString(accountNumber).length() < 9) {
                    System.out.println("An account number is 9 digits long");
                    accountNumber = scanner.nextLong();
                }
                count++;
                accountNumberList.add(accountNumber);
                checkLong = false;
            }else {
                System.out.println("Invalid entry, an account number is 9 digits long");
            }

            scanner.nextLine();
        }
        return accountNumberList;

    }

    public static long captureAccountNumber(){
        long accountNumber = 0;
        boolean checkLong = true;
        while (checkLong) {
            System.out.println("Enter a valid account number");
            boolean hasLong = scanner.hasNextLong();
            if(hasLong){
            accountNumber = scanner.nextLong();
            while (Long.toString(accountNumber).length() < 9) {
                System.out.println("An account number is 9 digits long");
                accountNumber = scanner.nextLong();
            }
                checkLong = false;
            }else {
                System.out.println("Invalid entry, an account number is 9 digits long");
            }

            scanner.nextLine();
        }
        return accountNumber;
    }

}
