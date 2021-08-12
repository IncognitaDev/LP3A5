import java.time.YearMonth;

public class Income {

    float value;
    YearMonth reference;
    Person owner;
    boolean active;

    public Income(float value, Person owner) {
        this.value = value;
        this.owner = owner;
    }

    public Income(float value, YearMonth reference, Person owner) {
        this.value = value;
        this.reference = reference;
        this.owner = owner;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public YearMonth getReference() {
        return reference;
    }

    public void setReference(YearMonth reference) {
        this.reference = reference;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
