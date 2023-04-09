# Budgeting App

## Introduction
### Functionality
This application seeks to allow users to calculate their monthly expenditure by 
recording their daily expenses.  For each expense, users will be able to state 
the date of purchase, the category it falls under, and whether it is an abnormal
purchase or not. Each of the expenses will be displayed in a list with features 
to sort the list according to categories or price. Each recorded expense can be 
edited or deleted, and users can set up recurring expenses. There will also be a 
balance indicating how much money the user has left in their 
pre-set budget, after subtracting all expenses. Users can also create a savings goal
where they contribute a set amount of money each month towards that goal.

### Targeted Users
The application is designed for university students or people that need to manage their
spending habits.

### Personal Significance
I have a tendency to overspend when I don't keep track of my expenses. But after trying multiple 
budgeting methods to no avail, I decided to create my own application to keep track of my own expenses, with
features that I feel are important for planning future budgeting plans.

## User Stories

### Phase 0: ###

As a user, I want to be able to:
- **set** my monthly budget
- **add** an expense to my list of expenses

- **view** every purchase in my list of expenses

- **view** the details of an expense.

- **edit** the details of an expense.

- **remove** an expense.

### Phase 2: ###

As a user, I want to be able to:
- **save** my list of expenses to file by selecting that option in the main directory
- **load** my list of expenses from file if I want whenever I start the application.

### Phase 3: ###

As a user, I want to be able to:
- **add** multiple expenses to a list of expenses
- **save** or **load** the state of an application

#### Instructions for Grader ####
- You can generate the first required action related to adding Xs to a Y by navigating to Expenses,
and clicking "Add Expense". A new window will pop up, prompting you to enter the details for a new expense.
Keep in mind that "cost" should be an integer.
- You can generate the second required action related to adding Xs to a Y by selecting delete beside an already present
expense, in the "Expenses" page.
- You can locate my visual component by going to the "Main" page, the component should be a progress bar indicating
your remaining budget for the month.
- You can save the state of my application by going to the "Main" page, and clicking "Save Budget".
- You can reload the state of my application by either clicking "okay" when the program asks you when the application
starts, or by going to the "Main" page, and clicking "Load Budget".

### Phase 4: ###

#### Task 2: Sample of events ####
Thu Apr 06 09:39:00 PDT 2023\
Event log cleared.\
Thu Apr 06 09:39:00 PDT 2023\
Existing budget app loaded from file.\
Thu Apr 06 09:39:10 PDT 2023\
120000 set as monthly budget\
Thu Apr 06 09:39:55 PDT 2023\
New expense has been added: Costco\
Thu Apr 06 09:40:06 PDT 2023\
The following expense has been deleted: save-on-foods\
Thu Apr 06 09:40:30 PDT 2023\
The following expense has been edited: Bestbuy\
Thu Apr 06 09:40:37 PDT 2023\
Application Saved as JSON Object

#### Task 3: Reflection on UML Class Diagram ####

During development, there appears to be a substantial amount of coupling between various classes and the ExpenseList
class. Most classes that had a dependency on ExpenseList were tightly coupled and changing the ExpenseList class 
required changes in others. To fix this, implementations were done in the class that depended on ExpenseList, which led
to repetitiveness in the code. It was also challenging to keep track of the pointers to ExpenseList in each class,
as there were occasions where a new class was created when a pointer to an existing object was meant to be duplicated.
To fix this, the Singleton method could be used as only one instance of ExpenseList should be present in the 
application. To make it easier to add new functionality in the future, the methods in several classes could be
abstracted. For example, a function could be dedicated to adding a "delete" or "edit" button to a JPanel could be
produced, instead of writing it in the method that builds the parent component.

For the GUI component, it may be more efficient to re-render the whole window from the 
App class, which is the parent container that contains the ExpenseListGUI and MainPageGUI. Doing so would allow both
pages to be updated with information when something is changed in one page. (Which is not a feature
as of now). This would also decrease coupling as the MainPageGUI would not require an instance
of ExpenseList since the desired information could be passed into the MainPageGUI class directly upon
updating the App class.



References:
- JsonSerializationDemo