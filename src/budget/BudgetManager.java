package budget;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

/**
 * Holds income and expense data and provides budget calculations.
 */
public class BudgetManager {
    private final List<Expense> expenses = new ArrayList<>();
    private final List<Income> incomes = new ArrayList<>();

    /** Adds an expense entry. */
    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    /** Adds an income entry. */
    public void addIncome(Income income) {
        incomes.add(income);
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public List<Income> getIncomes() {
        return incomes;
    }

    /**
     * Calculates total expenses for the given month.
     */
    public double getTotalExpensesForMonth(YearMonth month) {
        return expenses.stream()
                .filter(e -> YearMonth.from(e.getDate()).equals(month))
                .mapToDouble(Expense::getAmount)
                .sum();
    }

    /**
     * Calculates total income for the given month.
     */
    public double getTotalIncomeForMonth(YearMonth month) {
        return incomes.stream()
                .filter(i -> YearMonth.from(i.getDate()).equals(month))
                .mapToDouble(Income::getAmount)
                .sum();
    }

    /**
     * Computes the daily spending suggestion based on current month data.
     *
     * @param date today's date
     * @return suggested daily spending amount
     */
    public double getDailySpendingSuggestion(LocalDate date) {
        YearMonth month = YearMonth.from(date);
        double totalIncome = getTotalIncomeForMonth(month);
        double totalExpenses = getTotalExpensesForMonth(month);
        int remainingDays = date.lengthOfMonth() - date.getDayOfMonth() + 1;
        if (remainingDays <= 0) {
            return 0.0;
        }
        return (totalIncome - totalExpenses) / remainingDays;
    }
}
