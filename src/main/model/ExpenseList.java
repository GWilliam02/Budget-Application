package model;

import java.util.ArrayList;
import java.util.Scanner;

//May change from ArrayList to TreeSet for easier sorting

public class ExpenseList {

    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Expense> expenseList;
    private int currentExpenses;

    //private String month;

    public ExpenseList() {
        expenseList = new ArrayList<>();
        currentExpenses = 0;
    }

    public void addExpense(Expense expense) {
        expenseList.add(expense);
        currentExpenses += expense.getCost();
    }

    public void removeExpense(Expense expense) {
        expenseList.remove(expense);
        currentExpenses -= expense.getCost();
    }

    public void editExpense(Expense expense, int index) {
        expenseList.set(index, expense);
        currentExpenses = calculateExpenses();
        }


    public int calculateExpenses() {
        int result = 0;
        for (Expense expense : expenseList) {
            result += expense.getCost();
        }
        return result;
    }

    public int getCurrentExpenses() {
        return currentExpenses;
    }

    public void setCurrentExpenses(int currentExpenses) {
        this.currentExpenses = currentExpenses;
    }

    public int getExpenseCount() {
        return expenseList.size();
    }

    public Expense getExpenseAtIndex(int index) {
        return expenseList.get(index);
    }

    public ArrayList<Expense> getExpenseList() {
        return expenseList;
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
}
