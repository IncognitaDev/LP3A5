import java.time.Year;
import java.time.YearMonth;

public class Expense {
    float value = 0f;
    YearMonth date;
    String description;
    ExpenseType type;
    Person owner;

    public Expense(float value, String description, ExpenseType type, Person p1) {
        this.value = value;
        this.description = description;
        this.type = type;
        this.owner = p1;
        this.date = YearMonth.now();
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

    public YearMonth getDate() {
        return date;
    }

    public void setDate(YearMonth date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "value=" + value +
                ", endDate=" + date +
                ", description='" + description + '\'' +
                ", type=" + type +
                ", owner=" + owner.getName() +
                '}';
    }
}
