package ui;

import ui.tools.BudgetTool;

import java.io.FileNotFoundException;


public class Main {

    public static void main(String[] args) {
        try {
            new BudgetTool();
        } catch (FileNotFoundException e) {
            System.out.println("Application cannot be started: no file found");
        }
    }

}

