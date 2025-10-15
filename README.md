# Accounting Ledger Application

This is my **Capstone 1 Project** for the *Java Development Fundamentals* course in the Year Up United Java Focus Academy.  
The Accounting Ledger Application is a simple program written in Java that allows users to track deposits, payments, and run basic financial reports.

---

## Features

- Add deposits or payments (debits)
- Automatically store transactions in `transactions.csv`
- View all entries, only deposits, or only payments
- Run basic reports:
    - Month-to-date
    - Previous month
    - Year-to-date
    - Previous year
    - Search by vendor name
- Transactions display newest first

---

## Screenshots

### Home Screen
![Home Screen](images/home_screen.png)

### Ledger Screen
![Ledger Screen](images/ledger_screen.png)

### Reports Screen
![Reports Screen](images/reports_screen.png)

## Interesting Piece of Code

Below is a small snippet that handles adding a new transaction and saves it automatically to the CSV file:

![Interesting Code](images/Interesting_Code.png)

This block:
* Gets the current date and time
* Prompts the user for input
* Automatically saves it to the CSV file