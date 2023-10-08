// a separate package declaration for the loan class
package com.calculator;

// loan class that calculates monthly and total payments for a loan
public class Loan {
    // private variables for annual interest rate, number of years, and loan amount
    private double annualInterestRate;
    private int numberOfYears;
    private double loanAmount;
    
    // constructor to initiate the loan requirements
    public Loan(double annualInterestRate, int numberOfYears, double loanAmount) {
        this.annualInterestRate = annualInterestRate;
        this.numberOfYears = numberOfYears;
        this.loanAmount = loanAmount;
    }
    
    // method to calculate monthly payment for the loan
    public double getMonthlyPayment() {
        double monthlyInterestRate = annualInterestRate / 1200;
        double monthlyPayment = loanAmount * monthlyInterestRate / (1 -
            (1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12)));
        return monthlyPayment;
    }
    
    // method to calculate total payment for the loan
    public double getTotalPayment() {
        return getMonthlyPayment() * numberOfYears * 12;
    }
}