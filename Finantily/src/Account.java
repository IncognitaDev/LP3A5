public class Account {

    float value;
    AccountTypes type;
    Person owner;

    public Account(float value, Person owner, AccountTypes type) {
        this.value = value;
        this.type = type;
        this.owner = owner;
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
}
