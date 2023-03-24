package ui.gui;

import ui.BudgetManager;

import javax.swing.*;

public class BudgetGUI extends DirectoryGUI{

    public BudgetGUI(BudgetManager budgetManager, JComponent parent) {
        super(budgetManager, parent);
    }

    @Override
    protected void createButton(JComponent parent) {
        jButton = new JButton("Hello world");
    }
}
