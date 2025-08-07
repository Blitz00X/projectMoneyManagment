package budget;

import java.time.LocalDate;

/**
 * Represents a single income entry.
 */
public class Income {
    private final double amount;
    private final String description;
    private final LocalDate date;

    /**
     * Constructs an income entry.
     *
     * @param amount      income amount
     * @param description optional description
     * @param date        date of the income
     */
    public Income(double amount, String description, LocalDate date) {
        this.amount = amount;
        this.description = description;
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDate() {
        return date;
    }
}
