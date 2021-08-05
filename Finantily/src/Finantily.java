import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Finantily {
    static ArrayList<Expense> expenses = new ArrayList<>();
    static ArrayList<Person> persons = new ArrayList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Person p1 = new Person("Luis Sousa");
        Income r1 = new Income(3500f,p1,true);
        p1.setIncome(r1);
        persons.add(p1);

        addPerson(in);
        addIncome(in);
        addExpanse(in);

        Person p2 = new Person("Thaina");
        Income r2 = new Income(1000f, p2, true);
        p2.setIncome(r2);
        persons.add(p2);

        Expense e1 = new Expense(150,"Internet",ExpenseType.Services, true);
        Expense e2 = new Expense(700, LocalDate.of(2021,Calendar.AUGUST,8), "guarda roupa", ExpenseType.House, 5, true);

        expenses.add(e1);
        expenses.add(e2);

        expenses.stream().filter(
                expense ->
                expense.initialDate.getMonthValue() == Calendar.AUGUST ||
                        expense.endDate.getMonthValue() == Calendar.AUGUST
                )
                .forEach(n ->  System.out.println(n.toString()));

        persons.forEach(n -> System.out.println(n.getName()));
    }

    public static void addPerson(Scanner in) {
        System.out.println("Digite o nome da pessoa");
        String name =  in.next();
        Person p1 = new Person(name);
        System.out.println("Deseja addicionar uma renda para: "+ p1.getName());
        addIncome(in, p1);
    }

    public static void addExpanse(Scanner in){
        System.out.println("digite o valor da despesa");
        float value =  in.nextFloat();
        System.out.println("digite a descrição da despesa");
        String description = in.nextLine();
        System.out.println("selecione o tipo da despesa");

        System.out.println("é uma despesa recorente (y/n)");

        String recorencyAnwser = in.next();
        boolean recorency = recorencyAnwser.equals("Y") || recorencyAnwser.equals("y");

        Expense e1 = new Expense(value,description,ExpenseType.Services, recorency);
    }

    public static void addIncome(Scanner in,Person p){
        System.out.println("digite o valor");
        float value = in.nextFloat();
        System.out.println("é uma renda fixa? (y/n)");
        String recurrenceAnswer = in.next();

        boolean recurrence = recurrenceAnswer.equals("Y") || recurrenceAnswer.equals("y");

        Income r1 = new Income(value,p,recurrence);
    }

    public void ListIncomes(Scanner in){

    }
}
