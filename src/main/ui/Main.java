package ui;

import ui.tools.BudgetTool;

import java.io.FileNotFoundException;


public class Main {

    public static void main(String[] args) {
        try {
            new App(); //GUI
//            new BudgetTool(); //Console
        } catch (FileNotFoundException e) {
            System.out.println("Application cannot be started: no file found");
        } catch (InterruptedException e) {
            System.out.println("Error encounted during startup");
        }

    }

}

