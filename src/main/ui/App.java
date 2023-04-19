package ui;

import model.Budget;
import model.Event;
import model.EventLog;
import model.ExpenseList;
import persistence.JsonReader;
import persistence.JsonWriter;
import ui.gui.ExpenseListGUI;
import ui.gui.MainPageGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import static java.lang.System.exit;

//App is the main JFrame application
public class App extends JFrame implements WindowListener {

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

    private EventLog eventLog = EventLog.getInstance();

    //MODIFIES: this
    //EFFECTS: Creates the application
    public App() throws FileNotFoundException, InterruptedException {
        super("Budgeting App");

        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        addWindowListener(this);

        showSplashScreen();
        startUpOption();
        initializeGraphics();

    }

    //EFFECTS: Creates a loading splash screen with a loading gif
    private void showSplashScreen() throws InterruptedException {
        JWindow window = new JWindow();
        window.getContentPane().add(
                new JLabel("Loading Application",
                        new ImageIcon("./data/Spin-1s-200px.gif"), SwingConstants.CENTER));
        window.setBounds(500, 100, 500, 600);
        window.setVisible(true);
        Thread.sleep(3000);
        window.setVisible(false);
    }

    //MODIFIES: this
    //EFFECTS: Allows users to choose to load a current budget, or create a new one.
    private void startUpOption() {
        JPanel optionPanel = new JPanel(new GridLayout(0, 1));
        optionPanel.add(new JLabel("Load Existing Budget?"));
        optionPanel.add(new JLabel("(Cancel to create new budget)"));
        int result = JOptionPane.showConfirmDialog(null, optionPanel,
                "Edit Monthly Budget", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            loadBudget();
        } else {
            budgetApp = new Budget();
            expenseList = budgetApp.getExpenseList();
        }
    }

    //MODIFIES: this
    //EFFECTS: set up all the panels in JFrame.
    public void initializeGraphics() {
        addCardsToPane();
        addDirectoryToPane();
        pack();
        setVisible(true);
    }

    //MODIFIES: this
    //EFFECTS: adds a directory for card layout at bottom of window.
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

    //MODIFIES: this
    //EFFECTS: Adds a card layout pane with ExpenseListGUI panel and MainPageGUI panel as cards
    private void addCardsToPane() {
        CardLayout cl = new CardLayout();
        cards = new JPanel(cl);

        expenseListGUI =  new ExpenseListGUI(expenseList);
        mainPageGUI = new MainPageGUI(this, budgetApp, expenseList);

        cards.add("Expenses",expenseListGUI);
        cards.add("Home", mainPageGUI);
        cl.show(cards, "Home");
        add(cards);
    }


    //MODIFIES: this
    //EFFECTS: loads Budget from file
    public void loadBudget() {
        try {
            budgetApp = jsonReader.readBudget();
            expenseList = new ExpenseList(budgetApp);
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

        } catch (FileNotFoundException e) {
            System.out.println("Unable to save to file: " + JSON_STORE);
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {
        for (Event event: eventLog) {
            System.out.println(event);
        }
        exit(0);
    }

    @Override
    public void windowOpened(WindowEvent e) {}

    @Override
    public void windowClosing(WindowEvent e) {}

    @Override
    public void windowIconified(WindowEvent e) {}

    @Override
    public void windowDeiconified(WindowEvent e) {}

    @Override
    public void windowActivated(WindowEvent e) {}

    @Override
    public void windowDeactivated(WindowEvent e) {}

    private class DirectoryClickHandler implements ActionListener {

        @Override
        //EFFECTS: Switches card in card layout
        public void actionPerformed(ActionEvent e) {
            CardLayout cl = (CardLayout) cards.getLayout();
            cl.show(cards, e.getActionCommand());
            if (e.getActionCommand().equals("Home")) {
                initializeGraphics();
            }
        }
    }


}
