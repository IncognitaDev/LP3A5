import java.time.YearMonth;

public class Income implements Dated{

    float value;
    YearMonth date;
    Person owner;

    public Income(float value, Person owner) {
        this.value = value;
        this.owner = owner;
        this.date = YearMonth.now();
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public YearMonth getReference() {
        return date;
    }

    public void setReference(YearMonth reference) {
        this.date = reference;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Income{" +
                "value=" + value +
                ", date=" + date +
                ", owner=" + owner.getName() +
                '}';
    }
}
