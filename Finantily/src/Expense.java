import java.time.LocalDate;
import java.util.Date;

public class Expense {
    float value = 0f;
    LocalDate initialDate ;
    LocalDate endDate;
    String description;
    ExpenseType type;
    Person owner;
    int instalmentsNumber;
    boolean isFixedExpense;

    public Expense(float value, String description, ExpenseType type) {
        this.value = value;
        this.description = description;
        this.type = type;
        this.initialDate = LocalDate.now();
    }

    public Expense(float value, String description, ExpenseType type, boolean isFixedExpense) {
        this.value = value;
        this.description = description;
        this.type = type;
        this.isFixedExpense = isFixedExpense;
        if(isFixedExpense) {
            initialDate = LocalDate.now();
        }
    }

    public Expense(float value, LocalDate initialDate, String description, ExpenseType type, int instalmentsNumber, boolean isFixedExpense) {
        this.value = value;
        this.description = description;
        this.type = type;
        this.instalmentsNumber = instalmentsNumber;
        this.isFixedExpense = isFixedExpense;
        this.initialDate = initialDate;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ExpenseType getType() {
        return type;
    }

    public void setType(ExpenseType type) {
        this.type = type;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public boolean isFixedExpense() {
        return isFixedExpense;
    }

    public void setFixedExpense(boolean fixedExpense) {
        isFixedExpense = fixedExpense;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "value=" + value +
                ", initialDate=" + initialDate +
                ", endDate=" + endDate +
                ", description='" + description + '\'' +
                ", type=" + type +
                ", owner=" + owner +
                ", instalmentsNumber=" + instalmentsNumber +
                ", isFixedExpense=" + isFixedExpense +
                '}';
    }
}
