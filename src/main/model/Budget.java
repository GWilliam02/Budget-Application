package model;

public class Budget {

    private float budget;
    private float currentExpenses;

    private ExpenseList expenseList;

    //Initialization of Budget with 0 currentExpense and empty ExpenseList
    public Budget(float budget) {
        this.budget = budget;
        currentExpenses = 0;
        expenseList = new ExpenseList();
    }

    public void calculateExpenses(ExpenseList expenseList) {
        //Iterates over each Expense in ExpenseList
        // Calculate the sum of each expense

    }




    public float getBudget() {
        return budget;
    }

    public void setBudget(float budget) {
        this.budget = budget;
    }

    public float getCurrentExpenses() {
        return currentExpenses;
    }

    public void setCurrentExpenses(float currentExpenses) {
        this.currentExpenses = currentExpenses;
    }
}
