import java.util.ArrayList;

public class Person {
    String name;
    Income income;
    ArrayList<Account> accounts = new ArrayList<>();

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

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", income=" + income +
                ", accounts= [" + accounts.stream().toString() +
                "]}";
    }
}


