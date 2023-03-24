package ui.gui;

import ui.BudgetManager;

import javax.swing.*;

public abstract class DirectoryGUI {

    protected JButton jButton;
    protected BudgetManager budgetManager;
    private Boolean active;

    public DirectoryGUI(BudgetManager budgetManager, JComponent parent) {
        this.budgetManager = budgetManager;
        createButton(parent);
        addToParent(parent);
        active = false;
    }

    // MODIFIES: this
    // EFFECTS:  customize button
    protected JButton customizeButton(JButton button) {
        button.setBorderPainted(true);
        button.setFocusPainted(true);
        button.setContentAreaFilled(true);
        return button;
    }

    // EFFECTS: sets this Tool's active field to true
    public void activate() {
        active = true;
    }

    // EFFECTS: sets this Tool's active field to false
    public void deactivate() {
        active = false;
    }

    //Effects: creates a button for parent
    protected abstract void createButton(JComponent parent);

    //MODIFIES: parent
    //EFFECTS: adds the button to parent component
    protected void addToParent(JComponent parent) {
        parent.add(jButton);
    }


    public boolean isActive() {
        return active;
    }
}
