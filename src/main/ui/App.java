package ui;

import model.Budget;
import model.Expense;
import model.ExpenseList;
import persistence.JsonReader;
import persistence.JsonWriter;
import ui.gui.ExpenseGUI;
import ui.gui.ExpenseListGUI;
import ui.tools.ExpenseListTools;
import ui.tools.WalletTools;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;

public class App extends JFrame {

    public static final String JSON_STORE = "./data/testBudget1.json";
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    private ExpenseListGUI expenseListGUI;

    private ExpenseList expenseList;
    private ExpenseListTools expenseListTools;
    private WalletTools walletTools;
    private Budget budgetApp;

    public static final int WIDTH = 1000;
    public static final int HEIGHT = 600;

    public App() throws FileNotFoundException {
        super("Budgeting App");

        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        loadBudget();
        initializeGraphics();
    }

    private void initializeGraphics() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setupExpense();
        pack();
        setVisible(true);
    }

    //EFFECTS: Setup expense list UI
    private void setupExpense() {
        expenseListGUI = new ExpenseListGUI(this, expenseList);
        add(expenseListGUI, BorderLayout.CENTER);
    }


    //MODIFIES: this
    //EFFECTS: loads Budget from file
    public void loadBudget() {
        try {
            budgetApp = jsonReader.readBudget();
            expenseList = new ExpenseList(budgetApp);
            walletTools = new WalletTools(budgetApp);
            System.out.println("Loaded BudgetApp from: " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read data from file: " + JSON_STORE);
        }
    }

}
