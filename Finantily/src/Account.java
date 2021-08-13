import java.util.ArrayList;

public class Account {

    float value;
    AccountTypes type;
    Person owner;
    ArrayList<Income> incomes =  new ArrayList<>();;
    ArrayList<Expense> expenses = new ArrayList<>();;

    public Account(float value, Person owner, AccountTypes type) {
        this.value = value;
        this.type = type;
        this.owner = owner;
    }

    public void addIncome(Income income) {
            this.value += income.value;
            incomes.add(income);
    }

    public void addExpense(Expense expense) throws SaldoException {
        if(expense.value <= this.value){
            this.value -= expense.value;
            expenses.add(expense);
        }else {
            throw new SaldoException("Saldo insuficiente");
        }
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public AccountTypes getType() {
        return type;
    }

    public void setType(AccountTypes type) {
        this.type = type;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public ArrayList<Income> getIncomes() {
        return incomes;
    }

    @Override
    public String toString() {
        return "Account{" +
                "value=" + value +
                ", type=" + type +
                ", owner=" + owner.getName() +
                ", incomes=" + incomes.size() +
                ", expenses=" + expenses.size() +
                '}';
    }
}
