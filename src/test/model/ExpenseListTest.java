package model;

import org.junit.jupiter.api.BeforeEach;

public class ExpenseListTest {

    private ExpenseList expenseList;
    private Expense e1;

    @BeforeEach
    private void setup(){
        expenseList = new ExpenseList();
        e1 = new Expense(1,
                "safeway",
                "Test comments",
                "Food",
                "February 17",
                true);
    }

//    @Test
//    public void testRemoveExpense(){
//        expenseList.removeExpense(e1);
//    }

//    @Test
//    public void testEditExpense() {
//        expenseList.editExpense();
//    }

}
