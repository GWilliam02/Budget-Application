package model;

import java.util.Scanner;

public class Budget {

    private int budget;
    private ExpenseList expenseList;
    private Scanner scanner;

    //Initialization of Budget and empty ExpenseList
    public Budget() {
        scanner = new Scanner(System.in);
        expenseList = new ExpenseList();
        this.budget = budget;
        initializeApp();
    }

    private void initializeApp() {
        setUpBudget();
        mainDirectory();
    }


    private void mainDirectory() {
        
    }



    private void setUpBudget(){
        System.out.println("Please entire your budget for this month (In Cents)");
        budget = Integer.parseInt(scanner.nextLine());
        System.out.println("You have set your budget to: " + budget + " Cents");
    }






    public static void main(String[] args) {
        new Budget();
    }

}
