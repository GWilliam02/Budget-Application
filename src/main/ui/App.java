package ui;

import model.Budget;
import model.ExpenseList;
import persistence.JsonReader;
import persistence.JsonWriter;
import ui.gui.ExpenseListGUI;
import ui.gui.MainPageGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

public class App extends JFrame {

    public static final String JSON_STORE = "./data/testBudget1.json";
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 600;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    private ExpenseListGUI expenseListGUI;
    private MainPageGUI mainPageGUI;
    private JPanel cards;

    private ExpenseList expenseList;
    private Budget budgetApp;

    public App() throws FileNotFoundException {
        super("Budgeting App");

        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        initializeGraphics();
    }

    public void initializeGraphics() {
//        setupExpense();
        loadBudget();
        addCardsToPane();
        addDirectoryToPane();
        pack();
        setVisible(true);
    }

    private void addDirectoryToPane() {
        JPanel directory = new JPanel(new GridLayout(1, 2));

        JButton homeButton = new JButton("Home");
        JButton expenseButton = new JButton("Expenses");
        expenseButton.addActionListener(new DirectoryClickHandler());
        homeButton.addActionListener(new DirectoryClickHandler());
        directory.add(homeButton);
        directory.add(expenseButton);

        add(directory, BorderLayout.PAGE_END);

    }

    private void addCardsToPane() {
        CardLayout cl = new CardLayout();
        cards = new JPanel(cl);
        cards.add("Expenses", new ExpenseListGUI(this, expenseList));
        cards.add("Home", new MainPageGUI(this, budgetApp));
        cl.show(cards, "Home");
        add(cards);
    }


    //MODIFIES: this
    //EFFECTS: loads Budget from file
    public void loadBudget() {
        try {
            budgetApp = jsonReader.readBudget();
            expenseList = new ExpenseList(budgetApp);
            System.out.println("Loaded BudgetApp from: " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read data from file: " + JSON_STORE);
        }
    }

    //EFFECTS: save the current Budget to file
    public void saveBudget() {
        try {
            jsonWriter.open();
            jsonWriter.write(budgetApp);
            jsonWriter.close();
            System.out.println("Saved Budget Progress to" + JSON_STORE);

        } catch (FileNotFoundException e) {
            System.out.println("Unable to save to file: " + JSON_STORE);
        }
    }

    private class DirectoryClickHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            CardLayout cl = (CardLayout) cards.getLayout();
            cl.show(cards, e.getActionCommand());
        }
    }


}
