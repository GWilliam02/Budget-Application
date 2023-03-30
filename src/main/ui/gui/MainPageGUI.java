package ui.gui;

import model.Budget;
import model.ExpenseList;
import ui.App;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//MainPageGUI is a JPanel that displays the possible actions for users to make to their budget
public class MainPageGUI extends JPanel {

    private GridBagConstraints constraints;
    private Budget budget;
    private ExpenseList expenseList;
    private App app;

    //MODIFIES: this
    //EFFECTS: Create MainPageGUI Panel and sets layout
    public MainPageGUI(App app, Budget budget) {
        this.budget = budget;
        this.app = app;
        expenseList = budget.getExpenseList();
        setLayout(new GridBagLayout());
        constraints = new GridBagConstraints();
        constraints.ipady = 50;
        addBudget();
        addButtons();

    }

    //MODIFIES: this
    //EFFECTS: Adds a panel displaying the current budget
    private void addBudget() {
        constraints.gridy = 0;
        constraints.gridx = 1;
        JPanel budgetPanel = new JPanel();
        BoxLayout boxLayout = new BoxLayout(budgetPanel, BoxLayout.Y_AXIS);
        budgetPanel.setLayout(boxLayout);
        JLabel currentB = new JLabel("Current budget this month: " + budget.getMonthlyBudget());
        JLabel remainingB = new JLabel("Remaining Budget: "
                + (budget.getMonthlyBudget() - expenseList.getCurrentExpenses()));
        currentB.setAlignmentX(Component.CENTER_ALIGNMENT);
        remainingB.setAlignmentX(Component.CENTER_ALIGNMENT);
        budgetPanel.add(currentB);
        budgetPanel.add(remainingB);
        add(budgetPanel, constraints);
    }

    //MODIFIES: this
    //EFFECTS: Adds a panel containing buttons allowing users to:
    // 1. Set new budget
    // 2. Save current budget
    // 3. Load existing budget
    private void addButtons() {
        constraints.gridy = 1;
        constraints.gridx = 1;
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        String[] buttons = {"Set", "Save", "Load"};
        for (int i = 0; i < buttons.length; i++) {
            JButton button = new JButton(buttons[i] + " Budget");
            button.setActionCommand(buttons[i]);
            button.addActionListener(new ButtonClickHandler());
            button.setAlignmentX(Component.CENTER_ALIGNMENT);
            buttonPanel.add(button);
        }

        add(buttonPanel, constraints);
    }

    private class ButtonClickHandler implements ActionListener {

        //MODIFIES: this
        //EFFECTS: Perform actions depending on the button clicked
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if (command.equals("Set")) {
                setBudget();
            } else if (command.equals("Save")) {
                app.saveBudget();
            } else if (command.equals("Load")) {
                app.loadBudget();
                app.initializeGraphics();
            }
        }

        //MODIFIES: this
        //EFFECTS: Create a pop-up window prompting users to set a monthly budget
        private void setBudget() {
            JPanel optionPanel = new JPanel(new GridLayout(0, 1));
            optionPanel.add(new JLabel("Monthly Budget:"));
            JTextField budgetField = new JTextField(Integer.toString(budget.getMonthlyBudget()), 20);
            optionPanel.add(budgetField);
            int result = JOptionPane.showConfirmDialog(null, optionPanel,
                    "Edit Monthly Budget", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                budget.setMonthlyBudget(Integer.parseInt(budgetField.getText()));
            }
        }
    }
}
