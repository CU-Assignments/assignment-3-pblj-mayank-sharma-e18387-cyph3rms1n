import java.util.Scanner;

class InvalidPinException extends Exception {
    public InvalidPinException(String message) {
        super(message);
    }
}

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

public class ATMSystem {
    public static void main(String[] args) {
        final int correctPIN = 1234;
        double balance = 3000;
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter PIN: ");
            int pin = sc.nextInt();
            if (pin != correctPIN) {
                throw new InvalidPinException("Invalid PIN entered.");
            }

            System.out.print("Withdraw Amount: ");
            double amount = sc.nextDouble();
            if (amount > balance) {
                throw new InsufficientBalanceException("Insufficient balance.");
            }

            balance -= amount;
            System.out.println("Withdrawal successful. Current Balance: " + balance);
        } catch (InvalidPinException | InsufficientBalanceException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: Invalid input.");
        } finally {
            System.out.println("Current Balance: " + balance);
        }
    }
}
