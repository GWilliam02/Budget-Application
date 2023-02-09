package model;

import ui.tools.ExpenseListTools;
import ui.tools.ExpenseTools;

import java.util.ArrayList;
import java.util.Scanner;

//May change from ArrayList to TreeSet for easier sorting

public class ExpenseList {

    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Expense> expenseList;
    private int currentExpenses;

    private ExpenseTools expenseTools;
    private ExpenseListTools expenseListTools;

    //private String month;

    public ExpenseList() {
        expenseList = new ArrayList<>();
        currentExpenses = 0;
        expenseTools = new ExpenseTools();
        expenseListTools = new ExpenseListTools();
    }

    private void addExpense(Expense expense) {
        expenseList.add(expense);
        currentExpenses += expense.getCost();
    }

    private void removeExpense(Expense expense) {
        expenseList.remove(expense);
        currentExpenses -= expense.getCost();
    }


    public void removeSelectedExpense() {
        int index = expenseListTools.selectExpenseUI(expenseList);
        Expense expense = expenseList.get(index - 1);
        removeExpense(expense);
    }

    public void editExpense() {
        int index = expenseListTools.selectExpenseUI(expenseList);
        Expense expense = expenseList.get(index - 1);
        expenseListTools.editExpenseUI(expense, index);
        calculateExpenses();
        }


    public void addNewExpense() {
        Expense expense = expenseListTools.addNewExpenseUI();
        expenseList.add(expense);
        currentExpenses += expense.getCost();
        System.out.println("Successfully added new expense!");
    }


    public int calculateExpenses() {
        int result = 0;
        for (Expense expense : expenseList) {
            result += expense.getCost();
        }
        return result;
    }

    public void printExpenses() {
        expenseListTools.printExpensesUI(expenseList);
    }


//    public ArrayList<Expense> sortByDecreasingPrice() {
//        return expenseList; /*Stub*/
//    }
//
//    public ArrayList<Expense> sortByAscendingPrice() {
//        return expenseList; /*Stub*/
//    }
//
//    public ArrayList<Expense> sortByPurchaseType() {
//        return expenseList; /*Stub*/
//    }
//
//    public ArrayList<Expense> sortByLatestPurchase() {
//        return expenseList; /*Stub*/
//    }


    public int getCurrentExpenses() {
        return currentExpenses;
    }

    public int getExpenseCount() {
        return expenseList.size();
    }

}
