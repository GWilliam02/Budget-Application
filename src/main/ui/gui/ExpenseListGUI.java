package ui.gui;

import model.Expense;
import model.ExpenseList;
import ui.App;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

//ExpenseListGUI is a JPanel that contains all details regarding all the Expenses
public class ExpenseListGUI extends JPanel {
    private JPanel summaryPanel;
    private JPanel expenseListPanel;
    private ExpenseList expenseList;

    private ArrayList<JButton> editButtons = new ArrayList<>();
    private ArrayList<JButton> deleteButtons = new ArrayList<>();

    public ExpenseListGUI(ExpenseList expenseList) {
        this.expenseList = expenseList;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        initializeGraphics();

    }

    //MODIFIES: this
    //EFFECTS: runs all functions to set up panel
    public void initializeGraphics() {
        addSummary();
        addExpenseList();
        addNewExpenseButton();
    }

    //MODIFIES: this
    //EFFECTS: Adds Expense Summary Panel to ExpenseListGUI Panel
    private void addSummary() {
        summaryPanel = new JPanel(new GridLayout(3, 1, 10, 5));
        summaryPanel.setMaximumSize(new Dimension(App.WIDTH, 100));
        summaryPanel.add(new JLabel("Summary of expenses"));
        summaryPanel.add(new JLabel("Number of expenses: " + expenseList.getExpenseCount()));
        summaryPanel.add(new JLabel("Total expenses this month (In cents): "
                + expenseList.getCurrentExpenses()));
        summaryPanel.setBorder(BorderFactory.createLineBorder(Color.green)); //Temporary
        add(summaryPanel);
    }

    //MODIFIES: this
    //EFFECTS: adds ExpenseList Panel to ExpenseListGUI Panel
    private void addExpenseList() {
        int index = 1;
        expenseListPanel = new JPanel();
        BoxLayout b = new BoxLayout(expenseListPanel, BoxLayout.Y_AXIS);
        expenseListPanel.setLayout(b);
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

    //MODIFIES: this
    //EFFECTS: Adds Edit/Delete buttons to each expense panel
    private JPanel addButtonsToExpense(Expense expense, int index) {
        JPanel expenseEntry = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(4, 4, 4, 4);
        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.HORIZONTAL;

        expenseEntry.add(new ExpenseGUI(expense, index), c);

        c.gridx++;
        JButton deleteButton = new JButton("Delete");
        deleteButton.setActionCommand("delete" + index);
        deleteButtons.add(deleteButton);
        deleteButton.addActionListener(new ExpenseOptionHandler());
        expenseEntry.add(deleteButton);

        c.gridx++;
        JButton editButton = new JButton("Edit");
        editButton.setActionCommand("edit" + index);
        editButtons.add(editButton);
        editButton.addActionListener(new ExpenseOptionHandler());
        expenseEntry.add(editButton);

        expenseEntry.setName("expense" + index);

        expenseEntry.setBorder(BorderFactory.createLineBorder(Color.black));

        return expenseEntry;
    }

    //MODIFIES: this
    //EFFECTS: creates the "Add Expense" button at bottom of screen
    private void addNewExpenseButton() {
        JButton addButton = new JButton("Add Expense");
        addButton.setActionCommand("addExpense");
        addButton.addActionListener(new ExpenseOptionHandler());

        add(addButton, BorderLayout.SOUTH);
    }

    //MODIFIES: this
    //EFFECTS: Clears the panel and re-run setup
    private void reRender() {
        removeAll();
        initializeGraphics();
        validate();
        repaint();
    }

    private class ExpenseOptionHandler implements ActionListener {

        @Override
        //MODIFIES: this
        //EFFECTS: Performs the specified actions based on the buttons clicked in this panel
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            int index = -1;
            if (command.contains("delete")) {
                index = Integer.parseInt(command.substring(6)) - 1;

                expenseList.removeExpenseAtIndex(index);
                expenseListPanel.remove(index);
                reRender();

            } else if (command.contains("edit")) {
                index = Integer.parseInt(command.substring(4)) - 1;
                new ExpenseOptionPane(expenseList.getExpenseAtIndex(index), index, expenseList);
                reRender();

            } else if (command.equals("addExpense")) {
                new ExpenseOptionPane(expenseList);
                reRender();
            }
        }

    }

}
