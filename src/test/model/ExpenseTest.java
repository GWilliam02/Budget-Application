package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ExpenseTest {

    @Test
    public void testConstructor() {
        Expense e1 = new Food(999,
                "Save On Foods",
                "Groceries",
                "Food",
                "January 5",
                false);

        assertEquals(999, e1.getCost());
        assertEquals("Save On Foods", e1.getName());
        assertEquals("Groceries", e1.getComments());
        assertEquals("Food", e1.getPurchaseType());
        assertEquals("January 5", e1.getPurchaseDate());
        assertFalse(e1.getRecurring());
    }
}
