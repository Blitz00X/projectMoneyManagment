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

        setLayout(new BorderLayout());
        add(top, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
    }


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
