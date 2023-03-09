package persistence;

import model.*;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonWriterTest extends JsonTest {
    @Test
    public void testWriterUnknownFile() {
        try {
            JsonWriter jsonWriter = new JsonWriter("./data/my\0illegal:fileName.json");
            jsonWriter.open();
            fail("IOException error expected");
        } catch (IOException e) {
            // Test passes
        }
    }

    @Test
    public void testReaderEmptyBudget() {
        try {
            Budget budgetApp = new Budget();
            JsonWriter jsonWriter = new JsonWriter("./data/testWriterEmptyBudget.json");
            jsonWriter.open();
            jsonWriter.write(budgetApp);
            jsonWriter.close();

            JsonReader jsonReader = new JsonReader("./data/testWriterEmptyBudget.json");
            Budget budget = jsonReader.readBudget();
            assertEquals(0, budget.getMonthlyBudget());

            assertEquals(0, budget.getExpenseList().getCurrentExpenses());
            assertEquals(0, budget.getExpenseList().getExpenseCount());

            assertEquals(0, budget.getWallet().getBankBalance());
            assertEquals(0, budget.getWallet().getCash());
            assertEquals(0, budget.getWallet().getCards().size());

        } catch (IOException e) {
            fail("Caught unexpected IOException Error");
        }

    }

    @Test
    public void testReaderNormalBudget() {
        try {
            Budget budget = buildBudget();

            JsonWriter jsonWriter = new JsonWriter("./data/testWriterNormalBudget.json");
            jsonWriter.open();
            jsonWriter.write(budget);
            jsonWriter.close();

            JsonReader jsonReader = new JsonReader("./data/testWriterNormalBudget.json");
            Budget newBudget = jsonReader.readBudget();
            testNewBudget(newBudget);

        } catch (IOException e) {
            fail("Caught unexpected IOException Error");
        }
    }

    private void testNewBudget(Budget newBudget) {
        assertEquals(25000, newBudget.getMonthlyBudget());

        testNewBudgetExpenseList(newBudget.getExpenseList());
        testNewBudgetWallet(newBudget.getWallet());

    }

    private void testNewBudgetExpenseList(ExpenseList newExpenseList) {
        Expense exp1 = newExpenseList.getExpenseAtIndex(0);
        Expense exp2 = newExpenseList.getExpenseAtIndex(1);
        assertEquals(6000, newExpenseList.getCurrentExpenses());
        assertEquals(2, newExpenseList.getExpenseCount());
        checkExpense(1000,
                "Save On Foods",
                "Groceries",
                "Food",
                "January 5",
                false,
                exp1);
        checkExpense(5000,
                "UBC",
                "Books",
                "Education",
                "January 19",
                true,
                exp2);
    }

    private void testNewBudgetWallet(Wallet newBudgetWallet) {
        CreditCard cc1 = newBudgetWallet.getCards().get(0);
        CreditCard cc2 = newBudgetWallet.getCards().get(1);
        assertEquals(90000, newBudgetWallet.getBankBalance());
        assertEquals(2500, newBudgetWallet.getCash());
        assertEquals(2, newBudgetWallet.getCards().size());
        checkCard("RBC Visa", 200, 5000, cc1);
        checkCard("TD Mastercard", 2200, 7500, cc2);
    }

    private Budget buildBudget() {
        Budget budget = new Budget();
        budget.setMonthlyBudget(25000);

        ExpenseList expenseList = new ExpenseList();
        expenseList.addExpense(new Expense(1000,
                "Save On Foods",
                "Groceries",
                "Food",
                "January 5",
                false));
        expenseList.addExpense(new Expense(5000,
                "UBC",
                "Books",
                "Education",
                "January 19",
                true));

        Wallet wallet = new Wallet();
        wallet.setCash(2500);
        wallet.setBankBalance(90000);
        wallet.addCreditCard(new CreditCard("RBC Visa", 200, 5000));
        wallet.addCreditCard(new CreditCard("TD Mastercard", 2200, 7500));

        budget.setExpenseList(expenseList);
        budget.setWallet(wallet);

        return budget;
    }

}
