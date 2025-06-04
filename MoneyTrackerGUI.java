import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MoneyTrackerGUI extends JFrame {
    private DefaultTableModel model;
    private JTextField totalField;

    public MoneyTrackerGUI() {
        super("Money Tracker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 400);

        totalField = new JTextField("0", 10);
        JLabel totalLabel = new JLabel("Total Money:");
        JButton addDayButton = new JButton("Add Day");

        JPanel top = new JPanel();
        top.add(totalLabel);
        top.add(totalField);
        top.add(addDayButton);

        String[] cols = {"Date", "A", "B", "C", "D", "E", "Sum", "Left"};
        model = new DefaultTableModel(cols, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column <= 5; // only date and categories editable
            }
        };

        JTable table = new JTable(model);
        table.setFillsViewportHeight(true);
        JScrollPane scroll = new JScrollPane(table);

        addDayButton.addActionListener(e -> {
            String date = JOptionPane.showInputDialog(this, "Enter date (dd.MM.yyyy)");
            if (date != null && !date.trim().isEmpty()) {
                model.addRow(new Object[]{date, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0});
            }
        });

        model.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                if (e.getType() == TableModelEvent.UPDATE) {
                    int row = e.getFirstRow();
                    if (row >= 0) {
                        updateRow(row);
                    }
                }
            }
        });

        setLayout(new BorderLayout());
        add(top, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
    }

    private void updateRow(int row) {
        double a = parse(model.getValueAt(row, 1));
        double b = parse(model.getValueAt(row, 2));
        double c = parse(model.getValueAt(row, 3));
        double d = parse(model.getValueAt(row, 4));
        double e = parse(model.getValueAt(row, 5));
        double sum = a + b + c + d + e;
        double total = parse(totalField.getText());
        double left = total - sum;
        model.setValueAt(sum, row, 6);
        model.setValueAt(left, row, 7);
    }

    private double parse(Object val) {
        if (val == null) return 0.0;
        try {
            return Double.parseDouble(val.toString());
        } catch (NumberFormatException ex) {
            return 0.0;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MoneyTrackerGUI().setVisible(true);
        });
    }
}
