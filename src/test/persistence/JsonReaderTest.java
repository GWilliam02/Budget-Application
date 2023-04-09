package persistence;

import model.Budget;
import model.CreditCard;
import model.Expense;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class JsonReaderTest extends JsonTest {

    @Test
    public void testReaderUnknownFile() {
        JsonReader jsonReader = new JsonReader("./data/unknown.json");
        try {
            Budget budget = jsonReader.readBudget();
            fail("IOException error expected");
        } catch (IOException e) {
            // Test passes
        }
    }

    @Test
    public void testReaderEmptyBudget() {
        JsonReader jsonReader = new JsonReader("./data/emptyBudget.json");
        try {
            Budget budget = jsonReader.readBudget();
            assertEquals(0, budget.getMonthlyBudget());

            assertEquals(0, budget.getExpenseList().getCurrentExpenses());
            assertEquals(0, budget.getExpenseList().getExpenseCount());

            assertEquals(0, budget.getWallet().getBankBalance());
            assertEquals(0, budget.getWallet().getCash());
            assertEquals(0, budget.getWallet().getCards().size());

        } catch (IOException e) {
            fail("Caught IOException Error");
        }

    }

    @Test
    public void testReaderNormalBudget() {
        JsonReader jsonReader = new JsonReader("./data/testBudget1.json");
        try {
            Budget budget = jsonReader.readBudget();
            assertEquals(120000, budget.getMonthlyBudget());

            Expense exp1 = budget.getExpenseList().getExpenseAtIndex(0);
            Expense exp2 = budget.getExpenseList().getExpenseAtIndex(1);
            assertEquals(6000, budget.getExpenseList().getCurrentExpenses());
            assertEquals(2, budget.getExpenseList().getExpenseCount());
            checkExpense(5500, "Bestbuy", "New computer",
                    "Shopping", "Jun 28 2021", false, exp1);
            checkExpense(500, "Costco", "Vitamins",
                    "Food", "July 4 2022", false, exp2);


            CreditCard cc1 = budget.getWallet().getCards().get(0);
            CreditCard cc2 = budget.getWallet().getCards().get(1);
            assertEquals(50000, budget.getWallet().getBankBalance());
            assertEquals(2000, budget.getWallet().getCash());
            assertEquals(2, budget.getWallet().getCards().size());
            checkCard("RBC Advantage Visa", 500, 10000, cc1);
            checkCard("AMEX Platinum", 650, 50000, cc2);

        } catch (IOException e) {
            fail("Caught IOException Error");
        }
    }
}
