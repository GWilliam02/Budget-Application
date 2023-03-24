package ui;

import ui.gui.BudgetGUI;
import ui.tools.BudgetTool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BudgetManager extends JFrame {

    public static final int WIDTH = 900;
    public static final int HEIGHT = 700;

    private BudgetTool budgetTool;

    public BudgetManager() {
        super("Budget Manager");
        initializeGraphics();
    }

    private void initializeGraphics() {
        setLayout(new BorderLayout());
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
        createDirectory();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void createDirectory() {
        JPanel directory = new JPanel();
        directory.setLayout(new GridLayout(0,1));
        directory.setSize(new Dimension(0,0));
        add(directory, BorderLayout.SOUTH);

        BudgetGUI budget = new BudgetGUI(this, directory);

    }

    private void handleMouseClicked() {
        //...
    }

    private class mouseListener extends MouseAdapter{
        public void mouseClicked(MouseEvent e) {handleMouseClicked();}
    }
}
