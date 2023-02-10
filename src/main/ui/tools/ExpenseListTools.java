package ui.tools;

import model.Expense;
import model.ExpenseList;

import java.util.ArrayList;
import java.util.Scanner;

public class ExpenseListTools {

    private Scanner scanner;
    private ExpenseTools expenseTools;
    private ExpenseList expenseList;


    public ExpenseListTools() {
        scanner = new Scanner(System.in);
        expenseTools = new ExpenseTools();
        expenseList = new ExpenseList();
    }

    public int getCurrentExpenses(){
        return expenseList.getCurrentExpenses();
    }

    public int selectExpenseUI() {
        printExpensesUI();
        System.out.println("Please select an expense");
        return scanner.nextInt();
    }

    public void printExpensesUI() {
        ArrayList<Expense> expenses = expenseList.getExpenseList();
        int index = 1;
        if (expenses.size() == 0) {
            System.out.println("No expenses");
        } else {
            for (Expense expense : expenses) {
                System.out.println(
                        index + "."
                                + " Name: " + expense.getName()
                                + ", Cost: " + expense.getCost()
                                + ", Purchase Type: " + expense.getPurchaseType()
                                + ", Purchase Date: " + expense.getRecurring()
                                + ", Recurring: " + expense.getRecurring());
                index++;
            }
        }
    }

    public void addNewExpenseUI(){
        int cost;
        String name, comments, purchaseType, purchaseDate;
        boolean recurring;

        System.out.println("Add new expense!");

        System.out.println("Cost:");
        cost = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Name:");
        name = scanner.nextLine();

        System.out.println("Comments:");
        comments = scanner.nextLine();

        System.out.println("Purchase Type:");
        purchaseType = scanner.nextLine();

        System.out.println("Purchase Date:");
        purchaseDate = scanner.nextLine();

        System.out.println("Recurring? (true or false)");
        recurring = scanner.nextBoolean();

        expenseList.addExpense(new Expense(cost, name, comments, purchaseType, purchaseDate, recurring));
        System.out.println("Successfully added new expense!");
    }

    public void removeExpenseUI() {
        int index = selectExpenseUI();
        Expense expense = expenseList.getExpenseAtIndex(index - 1);
        expenseList.removeExpense(expense);
    }

    public void editExpenseUI() {
        int index = selectExpenseUI();
        Expense expense = expenseList.getExpenseAtIndex(index-1);

        int nextOperation;
        boolean save = false;

        while (!save) {
            System.out.println();
            System.out.println("Details for Expense " + index);
            expenseTools.printExpense(expense);
            System.out.println("What would you like to edit? (1-6)");
            System.out.println("Enter 7 to save changes");
            nextOperation = scanner.nextInt();
            switch (nextOperation) {
                case 1: {
                    System.out.println("Edit cost (Cents)");
                    expense.setCost(scanner.nextInt());
                    break;
                }
                case 2: {
                    System.out.println("Edit Name");
                    expense.setName(scanner.next());
                    break;
                }
                case 3: {
                    System.out.println("Edit Comments");
                    expense.setComments(scanner.next());
                    break;
                }
                case 4: {
                    System.out.println("Edit Purchase Type");
                    expense.setPurchaseType(scanner.next());
                    break;
                }
                case 5: {
                    System.out.println("Edit Purchase Date");
                    expense.setPurchaseDate(scanner.next());
                    break;
                }
                case 6: {
                    System.out.println("Recurring?");
                    expense.setRecurring(scanner.nextBoolean());
                    break;
                }
                case 7: {
                    System.out.println("Changes Saved!");
                    save = true;
                    break;
                }
            }
        }
        expenseList.editExpense(expense, index-1);
    }
}