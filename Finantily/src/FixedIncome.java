import java.time.LocalDate;

public class FixedIncome extends Income{
    LocalDate initialDate;
    LocalDate endDate;

    public FixedIncome(float value, Person owner) {
        super(value, owner);
    }

    public FixedIncome(float value,  Person owner, LocalDate initialDate) {
        super(value, owner);
        this.initialDate = initialDate;
    }

    public FixedIncome(float value, Person owner, LocalDate initialDate, LocalDate endDate) {
        super(value, owner);
        this.initialDate = initialDate;
        this.endDate = endDate;
    }
}
