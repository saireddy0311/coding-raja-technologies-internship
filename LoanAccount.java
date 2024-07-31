public class LoanAccount extends Account {
    private double loanAmount;

    public LoanAccount(String accountNumber, double loanAmount) {
        super(accountNumber, "Loan", 0);
        this.loanAmount = loanAmount;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void repayLoan(double amount) {
        if (amount <= loanAmount) {
            loanAmount -= amount;
        } else {
            System.out.println("Repayment amount exceeds loan amount.");
        }
    }
}

