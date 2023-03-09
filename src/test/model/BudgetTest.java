package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BudgetTest {

    private Budget budgetApp;
    private int monthlyBudget;
    private ExpenseList expenseList;
    private Wallet wallet;

    @BeforeEach
    void setUp() {
        monthlyBudget = 1000;
        expenseList = new ExpenseList();
        wallet = new Wallet();
        budgetApp = new Budget();
        budgetApp.setMonthlyBudget(monthlyBudget);
        budgetApp.setExpenseList(expenseList);
        budgetApp.setWallet(wallet);
    }

    @Test
    void toJson() {
        assertEquals(budgetApp.toJson().toString(), "{\"expensesList\":{\"currentExpenses\":0," +
                "\"expensesList\":[]},\"wallet\":{\"cards\":[],\"bankBalance\":0,\"cash\":0},\"monthlyBudget\":1000}");
    }

    @Test
    void getMonthlyBudget() {
        assertEquals(1000, budgetApp.getMonthlyBudget());
    }

    @Test
    void getExpenseList() {
        assertEquals(expenseList, budgetApp.getExpenseList());
    }


    @Test
    void getWallet() {
        assertEquals(wallet, budgetApp.getWallet());
    }

}