package com.williamEnnals;

import java.util.List;

public class SavingsAccount extends BankAccount {

        public SavingsAccount(double balance) {
            super(balance);
        }

        public SavingsAccount() {
        }

        @Override
        public long assignAccountNumber() {
            return super.assignAccountNumber();
        }

        @Override
        public long getAccountNumber() {
            return super.getAccountNumber();
        }

        @Override
        public double getBalance() {
            return super.getBalance();
        }

        @Override
        public String getTypeOfAccount() {
            return "Savings";
        }

        @Override
        public List<String> getRecentTransactions() {
            return super.getRecentTransactions();
        }

        @Override
        public String recentTransactions(List recentTransactions) {
            return super.recentTransactions(recentTransactions);
        }

        @Override
            public void depositFunds(double deposit) {
                super.depositFunds(deposit);
            }

        @Override
        public double withdrawFunds(double withdrawal) {
            return super.withdrawFunds(withdrawal);
        }

        @Override
        public boolean transferFunds(double amount, BankAccount receivingAccount) {
            return super.transferFunds(amount, receivingAccount);
        }
}

