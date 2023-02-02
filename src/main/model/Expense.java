package model;

import java.util.Date;

public class Expense {

    private float cost;
    private String name;
    private String comments;
    private String purchaseType;
    private Date purchaseDate;

    public Expense(float cost, String name, String comments, String purchaseType, Date purchaseDate) {
        this.cost = cost;
        this.name = name;
        this.comments = comments;
        this.purchaseType = purchaseType;
        this.purchaseDate = purchaseDate;
    }

    //Getters and Setters

    public double getCost() {
        return cost;
    }

    public void setCost(float cost) {
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

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
}
