package model;

import java.util.ArrayList;

//ExpenseList is a list of Expenses and current expenses
//is the sum of all expenses in that list.
public class ExpenseList {

    private ArrayList<Expense> expensesList;
    private int currentExpenses;
    private EventLog eventLog = EventLog.getInstance();


    //private String month;

    //EFFECTS: currentExpenses is set to 0,
    //          initializes empty expense list.
    public ExpenseList() {
        eventLog.clear();
        eventLog.logEvent(new Event("New budget app created."));
        expensesList = new ArrayList<>();
        currentExpenses = 0;
    }

    //EFFECTS: initializes an expense list extracted from the Budget class
    public ExpenseList(Budget budget) {
        eventLog.clear();
        eventLog.logEvent(new Event("Existing budget app loaded from file."));
        this.expensesList = budget.getExpenseList().getExpensesList();
        this.currentExpenses = budget.getExpenseList().getCurrentExpenses();
    }

    // REQUIRES: expense is not null
    // MODIFIES: this
    // EFFECTS: adds expense to expense list,
    //          increases current expense by expense cost
    public void addExpense(Expense expense) {
        eventLog.logEvent(new Event("New expense has been added: " + expense.getName()));
        expensesList.add(expense);
        currentExpenses += expense.getCost();
    }

    // REQUIRES: expense is not null
    // MODIFIES: this
    // EFFECTS: removes expense from expense list
    //          decreases current expense by expense cost.
    public void removeExpense(Expense expense) {
        eventLog.logEvent((new Event("The following expense has been deleted: " + expense.getName())));
        expensesList.remove(expense);
        currentExpenses -= expense.getCost();
    }

    // REQUIRES: index > 0
    // MODIFIES: this
    // EFFECTS: removes expense from expense list at given index
    //          decreases current expense by expense cost.
    public void removeExpenseAtIndex(int index) {
        eventLog.logEvent((new Event("The following expense has been deleted: "
                + expensesList.get(index).getName())));
        currentExpenses -= expensesList.get(index).getCost();
        expensesList.remove(index);
    }

    // REQUIRES: expense is not null, index >= 0
    // MODIFIES: this
    // EFFECTS: Replaces expense at the given index with new expense
    //          recalculates current expenses
    public void editExpense(Expense expense, int index) {
        eventLog.logEvent((new Event("The following expense has been edited: " + expense.getName())));
        expensesList.set(index, expense);
        currentExpenses = calculateExpenses();
    }

    // EFFECTS: returns the current expense in cents
    public int calculateExpenses() {
        int result = 0;
        for (Expense expense : expensesList) {
            result += expense.getCost();
        }
        return result;
    }

    // REQUIRES: index >= 0
    // EFFECTS: returns the expense object at given index
    public Expense getExpenseAtIndex(int index) {
        return expensesList.get(index);
    }

    // Getters and Setters

    public int getCurrentExpenses() {
        return currentExpenses;
    }

    public void setCurrentExpenses(int currentExpenses) {
        this.currentExpenses = currentExpenses;
    }

    public int getExpenseCount() {
        return expensesList.size();
    }

    public ArrayList<Expense> getExpensesList() {
        return expensesList;
    }


}
