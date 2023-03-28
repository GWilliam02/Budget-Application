//package ui;
//
//import model.Budget;
//import model.Expense;
//import persistence.JsonReader;
//import persistence.JsonWriter;
//import ui.tools.BudgetTool;
//import ui.tools.ExpenseListTools;
//import ui.tools.WalletTools;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//
//public class BudgetingApp extends JFrame{
//
//    public static final String JSON_STORE = "./data/testBudget1.json";
//    private ExpenseListTools expenseListTools;
//    private WalletTools walletTools;
//    private Budget budgetApp;
//    private JsonWriter jsonWriter;
//    private JsonReader jsonReader;
//
//    public static final int WIDTH = 900;
//    public static final int HEIGHT = 700;
//    JPanel cards;
//
//
//    public BudgetingApp() throws FileNotFoundException {
//        super("Budgeting App");
//        budgetApp = new Budget();
//        expenseListTools = new ExpenseListTools(budgetApp);
//        walletTools = new WalletTools(budgetApp);
//        jsonWriter = new JsonWriter(JSON_STORE);
//        jsonReader = new JsonReader(JSON_STORE);
//        loadBudget();
//
//        initializeGUI();
//    }
//
//    private void initializeGUI() {
//        setMinimumSize(new Dimension(WIDTH, HEIGHT));
//        setPreferredSize(new Dimension(1000, 600));
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        addCardsToPane(this);
//        pack();
//        setVisible(true);
//    }
//
//    private void addDirectoryToPane(Container pane) {
//        JPanel directory = new JPanel();
//        directory.setLayout(new GridLayout(1, 3));
//
//        JButton homeButton = new JButton("Home");
//        JButton expenseButton = new JButton("Expense");
//        JButton walletButton = new JButton("Wallet");
//
//        expenseButton.addActionListener(new DirectoryClickHandler());
//        homeButton.addActionListener(new DirectoryClickHandler());
//        walletButton.addActionListener(new DirectoryClickHandler());
//
//        directory.add(expenseButton);
//        directory.add(homeButton);
//        directory.add(walletButton);
//
//        pane.add(directory, BorderLayout.PAGE_END);
//    }
//
//    private void addCardsToPane(Container pane) {
//        JPanel card1 = new JPanel(new GridLayout(1,1));
//        addExpensePanel(card1);
//
//        JPanel card2 = new JPanel();
//        card2.add(new JTextField("text", 20));
//
//        JPanel card3 = new JPanel();
//        card3.add(new JButton("Wallet"));
//
//        CardLayout cl = new CardLayout();
//        cards = new JPanel(cl);
//        cards.add("Expense", card1);
//        cards.add("Home", card2);
//        cards.add("Wallet", card3);
//
//        cl.show(cards, "Home");
//        addDirectoryToPane(pane);
//        pane.add(cards, BorderLayout.CENTER);
//    }
//
//    private void addExpensePanel(Container panel) {
//        JPanel expensePanel = new JPanel();
//        expensePanel.setLayout(new BoxLayout(expensePanel, BoxLayout.PAGE_AXIS));
//        addExpenseSummary(expensePanel);
//        expensePanel.setBorder(BorderFactory.createLineBorder(Color.red));
//
//        panel.add(expensePanel, BorderLayout.WEST);
//    }
//
//    private void addExpenseSummary(Container panel) {
//        panel.add(new JLabel("Summary of expenses"));
//        panel.add(new JLabel("Total expenses this month (In cents): "
//                + String.valueOf(expenseListTools.getCurrentExpenses())));
//        expenseListTools.makeExpensesPanel(panel);
//    }
//
//
//
//    //MODIFIES: this
//    //EFFECTS: loads Budget from file
//    public void loadBudget() {
//        try {
//            budgetApp = jsonReader.readBudget();
//            expenseListTools = new ExpenseListTools(budgetApp);
//            walletTools = new WalletTools(budgetApp);
//            System.out.println("Loaded BudgetApp from: " + JSON_STORE);
//        } catch (IOException e) {
//            System.out.println("Unable to read data from file: " + JSON_STORE);
//        }
//    }
//
//
//    private class DirectoryClickHandler implements ActionListener {
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            CardLayout cl = (CardLayout) cards.getLayout();
//            cl.show(cards, e.getActionCommand());
//        }
//    }
//
//}
