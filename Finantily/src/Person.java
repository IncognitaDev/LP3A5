import java.util.ArrayList;

public class Person {

    String name;
    Income income;
    ArrayList<Expense> expenses;

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, Income income) {
        this.name = name;
        this.income = income;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Income getIncome() {
        return income;
    }

    public void setIncome(Income income) {
        this.income = income;
    }

    public ArrayList<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(ArrayList<Expense> expenses) {
        this.expenses = expenses;
    }
}


