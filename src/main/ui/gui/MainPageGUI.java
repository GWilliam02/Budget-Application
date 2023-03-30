package ui.gui;

import model.Budget;
import ui.App;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPageGUI extends JPanel {

    private GridBagConstraints constraints;
    private Budget budget;
    private App app;

    public MainPageGUI(App app, Budget budget) {
        this.budget = budget;
        this.app = app;
        setLayout(new GridBagLayout());
        constraints = new GridBagConstraints();
        constraints.ipady = 50;
        addBudget();
        addButtons();

    }

    private void addBudget() {
        constraints.gridy = 0;
        constraints.gridx = 1;
        JPanel budgetPanel = new JPanel(new BorderLayout());
        budgetPanel.add(new JLabel("Current budget this month: " + Integer.toString(budget.getMonthlyBudget())));

        add(budgetPanel, constraints);
    }

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
            buttonPanel.add(button);
        }

        add(buttonPanel, constraints);
    }

    private class ButtonClickHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if (command.equals("Set")) {
                setBudget();
            } else if (command.equals("Save")) {
                app.saveBudget();
            } else if (command.equals("Load")) {
                app.initializeGraphics();
            }
        }

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
