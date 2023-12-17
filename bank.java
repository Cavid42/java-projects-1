public class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println(amount + " AZN hesaba yatırıldı.");
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(amount + " AZN hesaptan çıxarıldı.");
        } else {
            System.out.println("Kifayət qədər vəsait yoxdur.");
        }
    }

    public void transfer(BankAccount recipient, double amount) {
        if (balance >= amount) {
            balance -= amount;
            recipient.deposit(amount);
            System.out.println(amount + " AZN " + recipient.getAccountNumber() + " hesabına köçürüldü.");
        } else {
            System.out.println("Kifayət qədər vəsait yoxdur.");
        }
    }

    public void printTransactionHistory() {
        System.out.println("Əməliyyat tarixçəsi:");
        // Əməliyyat tarixçəsini çap etmək üçün kod burada əlavə ediləcək
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("1234567890");
        BankAccount account2 = new BankAccount("0987654321");

        account1.deposit(1000.0);
        account1.transfer(account2, 500.0);
        account1.withdraw(200.0);

        account1.printTransactionHistory();
        account2.printTransactionHistory();
    }
}