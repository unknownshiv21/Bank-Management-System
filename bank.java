import java.util.*;

class Bank {
    String name, address;
    char accountType;
    int balance, amount;

    Scanner sc = new Scanner(System.in);

    void openAccount() {
        System.out.print("Enter your full name: ");
        name = sc.nextLine();
        System.out.print("Enter your address: ");
        address = sc.nextLine();
        System.out.print("What type of account you want to open? Saving (s) or Current (c): ");
        accountType = sc.next().charAt(0);
        System.out.print("Enter amount for deposit: ");
        balance = sc.nextInt();
        System.out.println("Your account is created.");
    }

    void depositMoney() {
        System.out.print("Enter how much money you want to deposit: ");
        int a = sc.nextInt();
        balance += a;
        System.out.println("Your total deposit amount: " + balance);
    }

    void withdrawMoney() {
        System.out.print("Enter your amount for withdrawing: ");
        amount = sc.nextInt();
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Now your total amount left: " + balance);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    void displayAccount() {
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Type of account: " + (accountType == 's' || accountType == 'S' ? "Saving" : "Current"));
        System.out.println("Amount deposited: " + balance);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank obj = new Bank();
        char option;

        do {
            System.out.println("01) Open account");
            System.out.println("02) Deposit money");
            System.out.println("03) Withdraw money");
            System.out.println("04) Display account");
            System.out.println("05) Exit");
            System.out.print("Please select the option from above: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    obj.openAccount();
                    break;
                case 2:
                    obj.depositMoney();
                    break;
                case 3:
                    obj.withdrawMoney();
                    break;
                case 4:
                    obj.displayAccount();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("This is not a valid option, please try again.");
            }

            System.out.print("\nDo you want to select the next step? Press Y to continue or N to exit: ");
            option = sc.next().charAt(0);

        } while (option == 'y' || option == 'Y');

        System.out.println("Exiting...");
        sc.close();
    }
}
