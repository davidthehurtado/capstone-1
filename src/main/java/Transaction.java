public class Transaction {
    private final String date;
    private final String time;
    private final String description;
    private final String vendor;
    private final double amount; //Fields are marked final because they never change once created — this makes them immutable.

    //Each line in transactions.csv becomes one Transaction object.
    public Transaction(String date, String time, String description, String vendor, double amount) {
        this.date = date;
        this.time = time;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }

    // GETTERS
    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getDescription() {
        return description;
    }

    public String getVendor() {
        return vendor;
    }

    public double getAmount() {
        return amount;
    }

    // CSV FORMAT
    @Override
    public String toString() { //The toString() method formats each record in the correct CSV format.
        return date + "|" + time + "|" + description + "|" + vendor + "|" + amount;
    }
}
