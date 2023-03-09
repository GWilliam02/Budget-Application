package model;

import org.json.JSONArray;
import org.json.JSONObject;

//Budget represents the state of the whole app and includes each component.
public class Budget {

    private Wallet wallet;
    private ExpenseList expenseList;
    private int monthlyBudget;

    public Budget() {
        wallet = new Wallet();
        expenseList = new ExpenseList();
        monthlyBudget = 0;
    }

    //EFFECTS; returns this as JSON object
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("monthlyBudget", monthlyBudget);
        json.put("wallet", walletToJson());
        json.put("expensesList", expenseListToJson());
        return json;
    }

    //EFFECTS: returns wallet as JSON Object
    private JSONObject walletToJson() {
        JSONObject json = new JSONObject();
        json.put("cash", wallet.getCash());
        json.put("bankBalance", wallet.getBankBalance());
        json.put("cards", cardsToJson());
        return json;
    }

    //EFFECTS: returns expenseList as JSON Object
    private JSONObject expenseListToJson() {
        JSONObject json = new JSONObject();
        json.put("currentExpenses", expenseList.getCurrentExpenses());
        json.put("expensesList", expensesListToJson());
        return json;
    }

    //EFFECTS: returns expensesList as JSON Object
    private JSONArray expensesListToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Expense expense : expenseList.getExpensesList()) {
            jsonArray.put(expense.toJson());
        }

        return jsonArray;
    }

    private JSONArray cardsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (CreditCard card : wallet.getCards()) {
            jsonArray.put(card.toJson());
        }
        return jsonArray;
    }


    public int getMonthlyBudget() {
        return monthlyBudget;
    }

    public void setMonthlyBudget(int monthlyBudget) {
        this.monthlyBudget = monthlyBudget;
    }

    public ExpenseList getExpenseList() {
        return expenseList;
    }

    public void setExpenseList(ExpenseList expenseList) {
        this.expenseList = expenseList;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }
}
