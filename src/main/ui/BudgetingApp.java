package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BudgetingApp extends JFrame{

    public static final int WIDTH = 900;
    public static final int HEIGHT = 700;
    JPanel cards;

    public BudgetingApp() {
        super("Budgeting App");
        initializeGUI();
    }

    private void initializeGUI() {
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addCardsToPane(this);
        pack();
        setVisible(true);
    }

    private void addDirectoryToPane(Container pane) {
        JPanel directory = new JPanel();
        directory.setLayout(new GridLayout(1, 3));

        JButton homeButton = new JButton("Home");
        JButton expenseButton = new JButton("Expense");
        JButton walletButton = new JButton("Wallet");

        expenseButton.addActionListener(new DirectoryClickHandler());
        homeButton.addActionListener(new DirectoryClickHandler());
        walletButton.addActionListener(new DirectoryClickHandler());

        directory.add(expenseButton);
        directory.add(homeButton);
        directory.add(walletButton);

        pane.add(directory, BorderLayout.PAGE_END);
    }

    private void addCardsToPane(Container pane) {
        JPanel card1 = new JPanel();
        card1.add(new JButton("Button 1"));
        card1.add(new JButton("Button 2"));
        card1.add(new JButton("Button 3"));

        JPanel card2 = new JPanel();
        card2.add(new JTextField("text", 20));

        JPanel card3 = new JPanel();
        card3.add(new JButton("Wallet"));

        CardLayout cl = new CardLayout();
        cards = new JPanel(cl);
        cards.add("Expense", card1);
        cards.add("Home", card2);
        cards.add("Wallet", card3);

        cl.show(cards, "Home");
        addDirectoryToPane(pane);
        pane.add(cards, BorderLayout.CENTER);
    }


    private class DirectoryClickHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            CardLayout cl = (CardLayout) cards.getLayout();
            cl.show(cards, e.getActionCommand());
        }
    }

}
