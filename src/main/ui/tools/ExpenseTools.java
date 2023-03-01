package ui.tools;

import model.Expense;

//UI Tools for Expense
public class ExpenseTools {

    public ExpenseTools() {}

    public void printExpense(Expense expense) {
        System.out.println("1. Cost: " + expense.getCost());
        System.out.println("2. Name: " + expense.getName());
        System.out.println("3. Comments: " + expense.getComments());
        System.out.println("4. Purchase Type: " + expense.getPurchaseType());
        System.out.println("5. Purchase Date: " + expense.getPurchaseDate());
        System.out.println("6. Recurring: " + expense.getRecurring());
    }
}
