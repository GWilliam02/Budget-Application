package model;

import java.time.LocalDateTime;

public class FoodExpense extends Expense{
    public FoodExpense(Integer cost,
                       String name,
                       String comments,
                       String purchaseType,
                       LocalDateTime purchaseDate,
                       Boolean recurring) {
        super(999,
                "Save On Foods",
                "Groceries",
                "Food",
                "January 6",
                false);
    }

    public void splitBill() {
        System.out.println(cost);
    }
}
