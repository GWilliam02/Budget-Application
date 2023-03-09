package model;

public class Budget {

    private Wallet wallet;
    private ExpenseList expenseList;

    public Budget() {
        wallet = new Wallet();
        expenseList = new ExpenseList();
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
