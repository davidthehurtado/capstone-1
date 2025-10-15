import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Menu {
    private static Scanner scanner = new Scanner(System.in);

    public static void homeScreen() {
        while (true) {
            System.out.println("\n⋆✴˚｡⋆ HOME SCREEN ⋆✴˚｡⋆");
            System.out.println("D) Add Deposit");
            System.out.println("P) Make Payment (Debit)");
            System.out.println("L) Ledger");
            System.out.println("X) Exit");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine().toUpperCase();

            switch (choice) {
                case "D" -> addTransaction(true);
                case "P" -> addTransaction(false);
                case "L" -> ledgerScreen();
                case "X" -> {
                    System.out.println("See you later, alligator!");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void addTransaction(boolean isDeposit) {
        LocalDateTime now = LocalDateTime.now();
        String date = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String time = now.format(DateTimeFormatter.ofPattern("HH:mm:ss"));

        System.out.print("Enter description: ");
        String desc = scanner.nextLine();
        System.out.print("Enter vendor: ");
        String vendor = scanner.nextLine();
        System.out.print("Enter amount: ");
        double amount = Double.parseDouble(scanner.nextLine());
        if (!isDeposit) amount *= -1; // make payment negative

        Ledger.addTransaction(new Transaction(date, time, desc, vendor, amount));
        System.out.println("Transaction added!");
    }

    private static void ledgerScreen() {
        List<Transaction> all = Ledger.readTransactions();
        Collections.reverse(all); // newest first

        while (true) {
            System.out.println("\n⋆✴˚｡⋆ LEDGER ⋆✴˚｡⋆");
            System.out.println("A) All | D) Deposits | P) Payments | R) Reports | H) Home");
            System.out.print("Choose: ");
            String choice = scanner.nextLine().toUpperCase();

            switch (choice) {
                case "A" -> all.forEach(Menu::printTx);
                case "D" -> all.stream().filter(t -> t.getAmount() > 0).forEach(Menu::printTx);
                case "P" -> all.stream().filter(t -> t.getAmount() < 0).forEach(Menu::printTx);
                case "R" -> reportMenu(all);
                case "H" -> {
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private static void reportMenu(List<Transaction> all) {
        System.out.println("\n1) Month To Date");
        System.out.println("2) Previous Month");
        System.out.println("3) Year To Date");
        System.out.println("4) Previous Year");
        System.out.println("5) Search by Vendor");
        System.out.println("0) Back");
        System.out.print("Choose: ");
        String choice = scanner.nextLine();

        switch (choice) {
            case "5" -> {
                System.out.print("Enter vendor name: ");
                String vendor = scanner.nextLine().toLowerCase();
                all.stream()
                        .filter(t -> t.getVendor().toLowerCase().contains(vendor))
                        .forEach(Menu::printTx);
            }
            case "0" -> {
                return;
            }
            default -> System.out.println("(You can add more report logic later)");
        }
    }

    private static void printTx(Transaction t) {
        System.out.printf("%s | %s | %s | %s | %.2f%n",
                t.getDate(), t.getTime(), t.getDescription(), t.getVendor(), t.getAmount());
    }
}