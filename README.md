# projectMoneyManagment

This application provides a simple Excel-like interface for tracking daily spending across five categories (A–E). Each day is shown on the left while the categories appear as columns at the top. The sum for the day and the remaining money are calculated automatically.

## Usage

Compile all Java files:

```bash
javac *.java
```

Run the graphical interface:

```bash
java MoneyTrackerGUI
```

Enter your total amount of money in the field at the top and use the **Add Day** button to add rows. Edit the category values directly in the table; the *Sum* and *Left* columns update whenever you change a value.
