package ui.gui;

import model.Expense;
import ui.App;

import javax.swing.*;
import java.awt.*;

public class ExpenseGUI extends JPanel {
    private Expense expense;
    private int index;

    public ExpenseGUI(Expense expense, int index) {
        this.expense = expense;
        this.index = index;
        setLayout(new GridLayout(6, 0));
        setMaximumSize(new Dimension(App.WIDTH, 250));
        addExpenseDetails();
    }

    private void addExpenseDetails() {
        add(new JLabel("Expense " + index + ": " + expense.getName()));
        add(new JLabel("Cost: " + expense.getCost()));
        add(new JLabel("Comments: " + expense.getComments()));
        add(new JLabel("Purchase Type: " + expense.getPurchaseType()));
        add(new JLabel("Purchase Date: " + expense.getPurchaseDate()));
        add(new JLabel("Recurring: " + expense.getRecurring()));
    }
}
