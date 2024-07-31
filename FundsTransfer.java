public class FundsTransfer {
    public void transfer(Account fromAccount, Account toAccount, double amount) {
        if (fromAccount.getBalance() >= amount) {
            fromAccount.withdraw(amount);
            toAccount.deposit(amount);
            System.out.println("Transfer successful.");
        } else {
            System.out.println("Insufficient funds.");
        }
    }
}

