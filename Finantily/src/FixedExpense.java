import java.time.LocalDate;

public class FixedExpense extends Expense{
    LocalDate initialDate;
    LocalDate endDate;

    public FixedExpense(float value, String description, ExpenseType type) {
        super(value, description, type);
    }

    public FixedExpense(float value, String description, ExpenseType type, LocalDate initialDate) {
        super(value, description, type);
        this.initialDate = initialDate;
    }

    public FixedExpense(float value, String description, ExpenseType type, LocalDate initialDate, LocalDate endDate) {
        super(value, description, type);
        this.initialDate = initialDate;
        this.endDate = endDate;
    }

    public LocalDate getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(LocalDate initialDate) {
        this.initialDate = initialDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
