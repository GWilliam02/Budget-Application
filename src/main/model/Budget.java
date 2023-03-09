package model;

import org.json.JSONObject;

//Budget represents the state of the whole app and includes each component.
public class Budget{

    private Wallet wallet;
    private ExpenseList expenseList;

    public Budget() {
        wallet = new Wallet();
        expenseList = new ExpenseList();
    }

    //EFFECTS; returns this as JSON object
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("wallet", wallet);
        json.put("expenseList", expenseList);
        return json;
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
