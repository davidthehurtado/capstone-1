import java.io.*;
import java.util.*;

public class Ledger {
    private static final String FILE_NAME = "transactions.csv";

    // READ ALL TRANSACTIONS
    public static List<Transaction> readTransactions() {
        List<Transaction> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|"); //Reads each line, splits it by |, and converts it back into a Transaction object.
                if (data.length == 5) {
                    list.add(new Transaction(
                            data[0], data[1], data[2], data[3],
                            Double.parseDouble(data[4])
                    ));
                }
            }
        } catch (IOException e) {
            System.out.println("No transactions found yet.");
        }
        return list;
    }

    // APPEND NEW TRANSACTION
    public static void addTransaction(Transaction t) {
        try (FileWriter fw = new FileWriter(FILE_NAME, true)) {
            fw.write(t.toString() + "\n");
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }
}
