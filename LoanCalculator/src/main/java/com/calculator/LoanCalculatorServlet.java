// package for the calculator
package com.calculator;

// imported libraries for servlet handling
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

// declaring a servlet class that extends the HttpServlet class
public class LoanCalculatorServlet extends HttpServlet {
    
    // overriding the doPost method to handle post requests
    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        // retrieve and parse loan amount from the form 
        double loanAmount = Double.parseDouble(request.getParameter("loanAmount"));
        
        // retrieve and parse interest rate from the form
        double interestRate = Double.parseDouble(request.getParameter("interestRate"));
        
        // retrieve and parse number of years from the form input
        int numYears = Integer.parseInt(request.getParameter("numYears"));

        // creates a loan object with the provided input values
        Loan loan = new Loan(interestRate, numYears, loanAmount);
        
        // calculates the monthly payment using the loan object
        double monthlyPayment = loan.getMonthlyPayment();
        
        // calculates the total payment using the loan object
        double totalPayment = loan.getTotalPayment();

        // set the content type of the response to html
        response.setContentType("text/html");
        
        // creates a printWriter object to send the output to client
        PrintWriter out = response.getWriter();
        
        // HTML structure to display the results on webpage
        out.println("<html><head><title>Loan Payment</title></head><body>");
        out.println("<h1>Loan Payment</h1>");
        out.println("<p>Loan Amount: $" + loanAmount + "</p>");
        out.println("<p>Interest Rate: " + interestRate + "%</p>");
        out.println("<p>Number of Years: " + numYears + "</p>");
        out.println("<p>Monthly Payment: $" + monthlyPayment + "</p>");
        out.println("<p>Total Payment: $" + totalPayment + "</p>");
        out.println("</body></html>");
    }
}