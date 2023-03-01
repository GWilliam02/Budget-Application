package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExpenseListTest {

    private ExpenseList expenseList;
    private Expense e1;
    private Expense e2;

    @BeforeEach
    private void setup() {
        expenseList = new ExpenseList();
        e1 = new Expense(100,
                "safeway",
                "Test comments",
                "Food",
                "February 17",
                true);

        e2 = new Expense(500,
                "costco",
                "Test comments2",
                "TV",
                "February 1",
                false);

        expenseList.addExpense(e1);
        expenseList.addExpense(e2);
    }

    @Test
    public void testAddExpense() {
        assertEquals(600, expenseList.getCurrentExpenses());
        expenseList.addExpense(e1);
        assertEquals(700, expenseList.getCurrentExpenses());
    }

    @Test
    public void testRemoveExpense() {
        expenseList.removeExpense(e1);
        assertEquals(1, expenseList.getExpenseCount());
        assertEquals(500, expenseList.getCurrentExpenses());
        assertEquals(e2, expenseList.getExpenseAtIndex(0));
    }

    @Test
    public void testEditExpense() {
        expenseList.editExpense(e1, 1);
        assertEquals(200, expenseList.getCurrentExpenses());
        assertEquals(e1, expenseList.getExpenseAtIndex(1));
    }

    @Test
    public void testSetCurrentExpenses() {
        expenseList.setCurrentExpenses(1000);
        assertEquals(1000, expenseList.getCurrentExpenses());
    }

    @Test
    public void testGetExpenseList() {
        ArrayList<Expense> expList = expenseList.getExpenseList();
        assertEquals(2, expList.size());
    }


}
