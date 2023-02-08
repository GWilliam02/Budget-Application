package model;

import java.util.ArrayList;

//May change from ArrayList to TreeSet for easier sorting

public class ExpenseList {

    private ArrayList<Expense> expenseList;
    private Integer currentExpenses;

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

    public void editExpense(Expense expense) {
        //Get expense that user wants to change
        //Create reference to that expense object
        //Print out current data on the selected Expense
        //Prompt user to edit any fields
        //Confirm changes and print updated Expense
    }

    public double calculateExpenses() {
        double result = 0;
        for (Expense expense: expenseList) {
            result += expense.getCost();
        }
        return result;
    }


    public ArrayList<Expense> sortByDecreasingPrice() {
        return expenseList; /*Stub*/
    }

    public ArrayList<Expense> sortByAscendingPrice() {
        return expenseList; /*Stub*/
    }

    public ArrayList<Expense> sortByPurchaseType() {
        return expenseList; /*Stub*/
    }

    public ArrayList<Expense> sortByLatestPurchase() {
        return expenseList; /*Stub*/
    }



}
