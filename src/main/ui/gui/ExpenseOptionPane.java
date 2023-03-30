package ui.gui;

import model.Expense;
import model.ExpenseList;

import javax.swing.*;
import java.awt.*;

//ExpenseOptionPane is a pop-up window that acts as a form for filling in expense details.
public class ExpenseOptionPane extends JPanel {

    private JTextField nameField;
    private JTextField costField;
    private JTextField commentsField;
    private JTextField typeField;
    private JTextField dateField;
    private JTextField recurringField;

    private int index = -1; //Determines which expense to edit.

    private String panelName;
    private ExpenseList expenseList;

    //MODIFIES: this
    //EFFECTS: Create form for editing an expense at the given index in the expense list.
    public ExpenseOptionPane(Expense expense, int index, ExpenseList expenseList) {
        nameField = new JTextField(expense.getName(), 25);
        costField = new JTextField(expense.getCost().toString(), 25);
        commentsField = new JTextField(expense.getComments(), 50);
        typeField = new JTextField(expense.getPurchaseType(), 25);
        dateField = new JTextField(expense.getPurchaseDate(), 25);
        recurringField = new JTextField(expense.getRecurring().toString(), 5);

        panelName = "Edit Expense";
        this.expenseList = expenseList;
        this.index = index;
        buildOptionPane();
    }

    //MODIFIES: this
    //EFFECTS: Create form for adding a new expense
    public ExpenseOptionPane(ExpenseList expenseList) {
        nameField = new JTextField(25);
        costField = new JTextField(25);
        commentsField = new JTextField(50);
        typeField = new JTextField(25);
        dateField = new JTextField(25);
        recurringField = new JTextField(5);

        panelName = "Create Expense";
        this.expenseList = expenseList;

        buildOptionPane();
    }

    //MODIFIES: this
    //EFFECTS: creates the actual pop-up window
    private void buildOptionPane() {
        setLayout(new GridLayout(0, 1));
        add(new JLabel("Name"));
        add(nameField);
        add(new JLabel("Cost (Cents)"));
        add(costField);
        add(new JLabel("Comments"));
        add(commentsField);
        add(new JLabel("Purchase Type"));
        add(typeField);
        add(new JLabel("Purchase Date"));
        add(dateField);
        add(new JLabel("Recurring?"));
        add(recurringField);

        int result = JOptionPane.showConfirmDialog(null, this, panelName, JOptionPane.OK_CANCEL_OPTION);
        optionPaneHandler(result);
    }

    //MODIFIES: this
    //EFFECTS: Adds/Edits expense depending on user's selection in OK_CANCEL_OPTION window.
    private void optionPaneHandler(int result) {
        if (result == JOptionPane.OK_OPTION) {
            Expense newExpense = new Expense(Integer.parseInt(costField.getText()),
                    nameField.getText(),
                    commentsField.getText(),
                    typeField.getText(),
                    dateField.getText(), true);
            if (index != -1) {
                expenseList.editExpense(newExpense, index);
            } else {
                expenseList.addExpense(newExpense);
            }
        }
    }

}