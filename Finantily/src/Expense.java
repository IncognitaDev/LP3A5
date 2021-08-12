import java.time.LocalDate;
import java.util.Date;

public class Expense {
    float value = 0f;
    LocalDate endDate;
    String description;
    ExpenseType type;
    Person owner;
    int instalmentsNumber;

    public Expense(float value, String description, ExpenseType type) {
        this.value = value;
        this.description = description;
        this.type = type;
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

    @Override
    public String toString() {
        return "Expense{" +
                "value=" + value +
                ", endDate=" + endDate +
                ", description='" + description + '\'' +
                ", type=" + type +
                ", owner=" + owner +
                ", instalmentsNumber=" + instalmentsNumber +
                '}';
    }
}
