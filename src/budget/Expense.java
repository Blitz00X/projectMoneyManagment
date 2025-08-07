package budget;

import java.time.LocalDate;

/**
 * Represents a single expense entry.
 */
public class Expense {
    private final double amount;
    private final String description;
    private final String category;
    private final LocalDate date;

    /**
     * Constructs an expense.
     *
     * @param amount      amount of the expense
     * @param description optional description
     * @param category    category of the expense (e.g., Food, Transport)
     * @param date        date of the expense
     */
    public Expense(double amount, String description, String category, LocalDate date) {
        this.amount = amount;
        this.description = description;
        this.category = category;
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public LocalDate getDate() {
        return date;
    }
}
