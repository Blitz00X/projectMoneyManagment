package budget;

import java.time.LocalDate;

import javafx.beans.property.ReadOnlyDoubleWrapper;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * Controller for the main application view.
 */
public class MainController {

    // Expense form fields
    @FXML private TextField expenseAmountField;
    @FXML private TextField expenseDescriptionField;
    @FXML private TextField expenseCategoryField;
    @FXML private DatePicker expenseDatePicker;
    @FXML private Button addExpenseButton;

    // Income form fields
    @FXML private TextField incomeAmountField;
    @FXML private TextField incomeDescriptionField;
    @FXML private DatePicker incomeDatePicker;
    @FXML private Button addIncomeButton;

    // Table
    @FXML private TableView<Object> transactionsTable;
    @FXML private TableColumn<Object, String> typeColumn;
    @FXML private TableColumn<Object, Number> amountColumn;
    @FXML private TableColumn<Object, String> descriptionColumn;
    @FXML private TableColumn<Object, String> categoryColumn;
    @FXML private TableColumn<Object, LocalDate> dateColumn;

    // Daily suggestion label
    @FXML private Label suggestionLabel;

    private final BudgetManager manager = new BudgetManager();
    private final ObservableList<Object> tableData = FXCollections.observableArrayList();

    /** Initializes the controller. */
    @FXML
    public void initialize() {
        // default dates
        expenseDatePicker.setValue(LocalDate.now());
        incomeDatePicker.setValue(LocalDate.now());

        // setup table columns
        typeColumn.setCellValueFactory(data -> new ReadOnlyStringWrapper(
                data.getValue() instanceof Expense ? "Expense" : "Income"));
        amountColumn.setCellValueFactory(data -> {
            if (data.getValue() instanceof Expense e) {
                return new ReadOnlyDoubleWrapper(e.getAmount());
            } else {
                return new ReadOnlyDoubleWrapper(((Income) data.getValue()).getAmount());
            }
        });
        descriptionColumn.setCellValueFactory(data -> {
            if (data.getValue() instanceof Expense e) {
                return new ReadOnlyStringWrapper(e.getDescription());
            } else {
                return new ReadOnlyStringWrapper(((Income) data.getValue()).getDescription());
            }
        });
        categoryColumn.setCellValueFactory(data -> {
            if (data.getValue() instanceof Expense e) {
                return new ReadOnlyStringWrapper(e.getCategory());
            } else {
                return new ReadOnlyStringWrapper("");
            }
        });
        dateColumn.setCellValueFactory(data -> {
            if (data.getValue() instanceof Expense e) {
                return new ReadOnlyObjectWrapper<>(e.getDate());
            } else {
                return new ReadOnlyObjectWrapper<>(((Income) data.getValue()).getDate());
            }
        });

        transactionsTable.setItems(tableData);
        updateSuggestion();
    }

    /** Handles adding an expense from the form. */
    @FXML
    private void handleAddExpense() {
        try {
            double amount = Double.parseDouble(expenseAmountField.getText());
            String description = expenseDescriptionField.getText();
            String category = expenseCategoryField.getText();
            LocalDate date = expenseDatePicker.getValue();

            Expense expense = new Expense(amount, description, category, date);
            manager.addExpense(expense);
            tableData.add(expense);
            clearExpenseForm();
            updateSuggestion();
        } catch (NumberFormatException ignored) {
        }
    }

    /** Handles adding an income from the form. */
    @FXML
    private void handleAddIncome() {
        try {
            double amount = Double.parseDouble(incomeAmountField.getText());
            String description = incomeDescriptionField.getText();
            LocalDate date = incomeDatePicker.getValue();

            Income income = new Income(amount, description, date);
            manager.addIncome(income);
            tableData.add(income);
            clearIncomeForm();
            updateSuggestion();
        } catch (NumberFormatException ignored) {
        }
    }

    private void clearExpenseForm() {
        expenseAmountField.clear();
        expenseDescriptionField.clear();
        expenseCategoryField.clear();
        expenseDatePicker.setValue(LocalDate.now());
    }

    private void clearIncomeForm() {
        incomeAmountField.clear();
        incomeDescriptionField.clear();
        incomeDatePicker.setValue(LocalDate.now());
    }

    private void updateSuggestion() {
        double suggestion = manager.getDailySpendingSuggestion(LocalDate.now());
        suggestionLabel.setText(String.format("Daily Suggestion: %.2f", suggestion));
    }
}
