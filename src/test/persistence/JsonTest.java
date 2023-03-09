package persistence;

import model.CreditCard;
import model.Expense;

import static org.junit.jupiter.api.Assertions.*;

public class JsonTest {
    protected void checkCard(String name, int balance, int limit, CreditCard creditCard) {
        assertEquals(name, creditCard.getName());
        assertEquals(balance, creditCard.getBalance());
        assertEquals(limit, creditCard.getLimit());
    }

    protected void checkExpense(int cost,
                                String name,
                                String comments,
                                String purchaseType,
                                String purchaseDate,
                                Boolean recurring,
                                Expense expense) {
        assertEquals(cost, expense.getCost());
        assertEquals(name, expense.getName());
        assertEquals(comments, expense.getComments());
        assertEquals(purchaseType, expense.getPurchaseType());
        assertEquals(purchaseDate, expense.getPurchaseDate());
        assertEquals(recurring, expense.getRecurring());

    }
}
