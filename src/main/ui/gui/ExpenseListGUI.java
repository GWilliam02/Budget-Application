package ui.gui;

import model.Expense;
import model.ExpenseList;
import ui.App;

import javax.swing.*;
import java.awt.*;

public class ExpenseListGUI extends JPanel {
    private App app;
    private JPanel summaryPanel;
    private JPanel expenseListPanel;
    private ExpenseList expenseList;

    public ExpenseListGUI(App application, ExpenseList expenseList) {
        app = application;
        this.expenseList = expenseList;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
//            setLayout(new BorderLayout());
        addSummary();
        addExpenseList();

    }

    //EFFECTS: Adds Expense Summary Panel to ExpenseListGUI Panel
    public void addSummary() {
        summaryPanel = new JPanel(new GridLayout(2, 1, 10, 5));
        summaryPanel.setMaximumSize(new Dimension(App.WIDTH, 100));
        summaryPanel.add(new JLabel("Summary of expenses"));
        summaryPanel.add(new JLabel("Total expenses this month (In cents): "
                + expenseList.getCurrentExpenses()));
        summaryPanel.setBorder(BorderFactory.createLineBorder(Color.green)); //Temporary
        add(summaryPanel);
    }

    //EFFECTS: adds ExpenseList Panel to ExpenseListGUI Panel
    public void addExpenseList() {
        int index = 1;
        expenseListPanel = new JPanel();
        BoxLayout b = new BoxLayout(expenseListPanel, BoxLayout.Y_AXIS);
        expenseListPanel.setLayout(b);
//            expenseListPanel.setLayout(new GridBagLayout());
        if (expenseList.getExpenseCount() == 0) {
            expenseListPanel.add(new JLabel("No expenses"));
        } else {
            for (Expense expense : expenseList.getExpensesList()) {
                expenseListPanel.add(addButtonsToExpense(expense, index));
                index++;
            }
        }


        add(expenseListPanel);
    }

    public JPanel addButtonsToExpense(Expense expense, int index) {
        JPanel expenseEntry = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(4, 4, 4, 4);
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0;
        c.weighty = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        expenseEntry.add(new ExpenseGUI(expense, index), c);
        c.gridx++;
        expenseEntry.add(new JButton("Delete"));
        c.gridx++;
        expenseEntry.add(new JButton("Edit"));
        expenseEntry.setBorder(BorderFactory.createLineBorder(Color.black));

        return expenseEntry;
    }
}
