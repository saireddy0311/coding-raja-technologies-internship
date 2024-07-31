import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Try-with-resources to ensure the Scanner is closed
        try (Scanner scanner = new Scanner(System.in)) {
            // Create accounts
            Account savings = new Account("123", "Savings", 1000.0);
            Account checking = new Account("456", "Checking", 500.0);

            // Create user
            User user = new User("john_doe", "password123");

            // Authenticate user
            System.out.print("Enter password: ");
            String enteredPassword = scanner.nextLine();

            if (user.authenticate(enteredPassword)) {
                System.out.println("User authenticated.");

                boolean exit = false;
                while (!exit) {
                    System.out.println("Select an option:");
                    System.out.println("1. Balance Enquiry");
                    System.out.println("2. Funds Transfer");
                    System.out.println("3. Loan Repayment");
                    System.out.println("4. View Transaction History");
                    System.out.println("5. Exit");
                    System.out.print("Enter your choice: ");
                    int choice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    switch (choice) {
                        case 1 -> {
                            BalanceEnquiry balanceEnquiry = new BalanceEnquiry();
                            System.out.print("Enter account type (Savings/Checking): ");
                            String accountType = scanner.nextLine();
                            if (accountType.equalsIgnoreCase("Savings")) {
                                balanceEnquiry.checkBalance(savings);
                            } else if (accountType.equalsIgnoreCase("Checking")) {
                                balanceEnquiry.checkBalance(checking);
                            } else {
                                System.out.println("Invalid account type.");
                            }
                        }
                        case 2 -> {
                            FundsTransfer fundsTransfer = new FundsTransfer();
                            System.out.print("Enter amount to transfer: ");
                            double amount = scanner.nextDouble();
                            scanner.nextLine(); // Consume newline
                            fundsTransfer.transfer(savings, checking, amount);
                        }
                        case 3 -> {
                            LoanAccount loan = new LoanAccount("789", 2000.0);
                            System.out.print("Enter amount to repay: ");
                            double repayAmount = scanner.nextDouble();
                            scanner.nextLine(); // Consume newline
                            loan.repayLoan(repayAmount);
                            System.out.println("Loan balance: " + loan.getLoanAmount());
                        }
                        case 4 -> {
                            TransactionHistory transactionHistory = new TransactionHistory();
                            System.out.println("Transaction History:");
                            for (String transaction : transactionHistory.getTransactions()) {
                                System.out.println(transaction);
                            }
                        }
                        case 5 -> exit = true;
                        default -> System.out.println("Invalid choice. Please try again.");
                    }
                }
            } else {
                System.out.println("Authentication failed.");
            }
        }
    }
}



