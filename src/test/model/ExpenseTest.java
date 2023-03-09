package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ExpenseTest {
    private Expense e1;

    @BeforeEach
    public void setUp() {
        e1 = new Expense(999,
                "Save On Foods",
                "Groceries",
                "Food",
                "January 5",
                false);
    }

    @Test
    public void testConstructor() {
        assertEquals(999, e1.getCost());
        assertEquals("Save On Foods", e1.getName());
        assertEquals("Groceries", e1.getComments());
        assertEquals("Food", e1.getPurchaseType());
        assertEquals("January 5", e1.getPurchaseDate());
        assertFalse(e1.getRecurring());
    }

    @Test
    public void testToJson() {
        assertEquals(e1.toJson().toString(), "{\"purchaseDate\":\"January 5\","
                + "\"cost\":999,"
                + "\"comments\":\"Groceries\","
                + "\"recurring\":false,"
                + "\"name\":\"Save On Foods\","
                + "\"purchaseType\":\"Food\"}");
    }

    @Test
    public void testSetCost() {
        e1.setCost(100);
        assertEquals(100, e1.getCost());
    }

    @Test
    public void testSetName() {
        e1.setName("New name");
        assertEquals("New name", e1.getName());
    }

    @Test
    public void testSetComments() {
        e1.setComments("Shopping");
        assertEquals("Shopping", e1.getComments());
    }

    @Test
    public void testSetPurchaseType() {
        e1.setPurchaseType("Leisure");
        assertEquals("Leisure", e1.getPurchaseType());
    }

    @Test
    public void testSetPurchaseDate() {
        e1.setPurchaseDate("February 17");
        assertEquals("February 17", e1.getPurchaseDate());
    }

    @Test
    public void testSetRecurring() {
        e1.setRecurring(true);
        assertEquals(true, e1.getRecurring());
    }
}
