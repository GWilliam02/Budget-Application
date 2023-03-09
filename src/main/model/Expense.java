package model;

import org.json.JSONObject;

public class Expense {

    protected Integer cost;
    protected String name;
    protected String comments;
    protected String purchaseType;
    protected String purchaseDate;
    protected Boolean recurring;


    public Expense(Integer cost,
                   String name,
                   String comments,
                   String purchaseType,
                   String purchaseDate,
                   Boolean recurring) {

        this.cost = cost;
        this.name = name;
        this.comments = comments;
        this.purchaseType = purchaseType;
        this.purchaseDate = purchaseDate;
        this.recurring = recurring;
    }

    //EFFECTS: Converts expense object to JSON
    public JSONObject toJson() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("cost", cost);
        jsonObject.put("name", name);
        jsonObject.put("comments", comments);
        jsonObject.put("purchaseType", purchaseType);
        jsonObject.put("purchaseDate", purchaseDate);
        jsonObject.put("recurring", recurring);
        return jsonObject;
    }


    //Getters and Setters

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getPurchaseType() {
        return purchaseType;
    }

    public void setPurchaseType(String purchaseType) {
        this.purchaseType = purchaseType;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Boolean getRecurring() {
        return recurring;
    }

    public void setRecurring(Boolean recurring) {
        this.recurring = recurring;
    }
}
