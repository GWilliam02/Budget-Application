package persistence;


import model.CreditCard;
import model.Expense;
import model.ExpenseList;
import model.Wallet;
import org.json.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

// A reader that reads budget data stored as JSON data from a given file
public class JsonReader {

    private String source;

    //EFFECTS: constructs reader with file source set.
    public JsonReader(String source) {
        this.source = source;
    }

    //EFFECTS: reads and return expense list from file
    //throws IO exception for reading errors
    public ExpenseList readExpenseList() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseExpenseList(jsonObject);
    }

    //EFFECTS: reads and returns wallet form file
    //throws IO exception for reading errors
    public Wallet readWallet() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseWallet(jsonObject);
    }

    //EFFECTS: reads and return file as string.
    private String readFile(String source) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(stringBuilder::append);
        }
        return stringBuilder.toString();
    }

    //EFFECTS: parses expense list from JSON object and returns it.
    private ExpenseList parseExpenseList(JSONObject jsonObject) {
        ExpenseList expenseList = new ExpenseList();
        JSONObject expenseListJson = jsonObject.getJSONObject("expenseList");

        int currentExpense = expenseListJson.getInt("currentExpense");
        JSONArray expenseArray = expenseListJson.getJSONArray("expensesList");

        for (Object json : expenseArray) {
            JSONObject nextExpense = (JSONObject) json;
            addExpense(expenseList, nextExpense);
        }

        if (currentExpense != expenseList.getCurrentExpenses()) {
            System.out.println("Error while parsing expense list data. ");
            expenseList.setCurrentExpenses(currentExpense);
        }

        return expenseList;
    }

    //EFFECTS: parses wallet from JSON object and returns it.
    private Wallet parseWallet(JSONObject jsonObject) {
        Wallet wallet = new Wallet();
        JSONObject walletJson = jsonObject.getJSONObject("wallet");

        int cash = walletJson.getInt("cash");
        int bankBalance = walletJson.getInt("bankBalance");
        JSONArray creditCardArray = walletJson.getJSONArray("cards");

        for (Object json : creditCardArray) {
            JSONObject nextCard = (JSONObject) json;
            addCreditCard(wallet, nextCard);
        }

        wallet.setBankBalance(bankBalance);
        wallet.setCash(cash);

        return wallet;
    }

    //MODIFIES: expenseList
    //EFFECTS: parses expense from JSON object and adds it to expenseList
    private void addExpense(ExpenseList expenseList, JSONObject nextExpense) {
        Expense newExpense = new Expense(
                nextExpense.getInt("cost"),
                nextExpense.getString("name"),
                nextExpense.getString("comments"),
                nextExpense.getString("purchaseType"),
                nextExpense.getString("purchaseDate"),
                nextExpense.getBoolean("recurring"));

        expenseList.addExpense(newExpense);
    }

    //MODIFIES: wallet
    //EFFECTS: parses credit Card from JSON object and adds it to wallet
    private void addCreditCard(Wallet wallet, JSONObject nextCard) {
        CreditCard newCreditCard = new CreditCard(
                nextCard.getString("name"),
                nextCard.getInt("balance"),
                nextCard.getInt("limit"));

        wallet.addCreditCard(newCreditCard);
    }

}
