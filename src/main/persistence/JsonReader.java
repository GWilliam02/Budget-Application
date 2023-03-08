package persistence;


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
    }

    //EFFECTS: reads and returns wallet form file
    //throws IO exception for reading errors
    public Wallet readWallet() throws IOException {
        String jsonData = readFile(source);
    }

    //EFFECTS: reads and return file as string.
    private String readFile(String source) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(stringBuilder::append);
        }
        return stringBuilder.toString();
    }


    private ExpenseList parseExpenseList(JSONObject jsonObject) {
        ExpenseList expenseList = new ExpenseList();
        JSONObject expenseListJson = jsonObject.getJSONObject("expenseList");

        int currentExpense = expenseListJson.getInt("currentExpense");
        JSONArray expenseArray = expenseListJson.getJSONArray("expenseList");

        return expenseList;
    }

    private Wallet parseWallet(JSONObject jsonObject) {
    }


}
