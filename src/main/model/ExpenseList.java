package model;

import java.util.ArrayList;
import java.util.List;

//May change from ArrayList to TreeSet for easier sorting

public class ExpenseList {

    private ArrayList<Expense> expenseList;

    public ExpenseList() {
        expenseList = new ArrayList<>();
    }

    public void addExpense(Expense expense) {
        expenseList.add(expense);
    }

    public void removeExpense(Expense expense) {
        expenseList.remove(expense);
    }

    public void editExpense(Expense expense) {
        //Get expense that user wants to change
        //Create reference to that expense object
        //Print out current data on the selected Expense
        //Prompt user to edit any fields
        //Confirm changes and print updated Expense
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
