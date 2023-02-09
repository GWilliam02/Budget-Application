package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ExpenseListTest {

    private ExpenseList elist;
    private Expense e1;

    @BeforeEach
    private void setup(){
        elist = new ExpenseList();
        e1 = new Expense(1,
                "safeway",
                "Test comments",
                "Food",
                "February 17",
                true);
    }

    @Test
    public void addExpense(){

    }


}
