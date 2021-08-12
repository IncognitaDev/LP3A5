import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Function;

public class Finantily {
    static ArrayList<Expense> expenses = new ArrayList<>();
    static ArrayList<Person> persons = new ArrayList<>();
    static ArrayList<Income> incomes = new ArrayList<>();
    static ArrayList<Account> accounts = new ArrayList<>();
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        YearMonth ym;

        renderMenu();
        int opt = in.nextInt();

        switch (opt) {
            case 0:
                System.exit(0);
            case 1:
                addPerson(in);
                break;
            case 2:
                addExpanse(in);
                break;
            case 3:
                addIncome(in, persons.get(0));
                break;
            case 4:
                persons.stream().forEach(System.out::println);
                break;
            case 5:
                addAccount();
                break;
            case 6:
                listExpenses(in);
                break;
            case 7:
                ym = getDate();
                listExpenses(in, ym);
                break;
            case 8:
                listIncomes(in);
                break;
            case 9:
                ym = getDate();
                listIncomes(in, ym);
                break;
            default:
                System.out.println("opção não encontrada");
                break;
        }

        Finantily.main(new String[]{""});
    }

    private static YearMonth getDate() {
        System.out.println("Digite a data. ex: 08/2021");
        String value = in.next();

        if(value.matches("[0-9]{2}/[0-9]{4}")) {
            String[] date = value.split("/");
            return YearMonth.of(Integer.parseInt(date[1]),Integer.parseInt(date[0]));
        }

        System.out.println("Formato invalido");
        return getDate();
    }

    private static void renderMenu() {
        System.out.println("--------- Finantily ------------");
        System.out.println("O que deseja fazer? ");
        System.out.println("1 - Adicionar uma pessoa");
        System.out.println("2 - Adicionar uma despesa");
        System.out.println("3 - Adicionar uma renda");
        System.out.println("4 - Adicoionar uma conta");

        if(!persons.isEmpty()){
            System.out.println("5 - Listar todas as pessoas");
        }

        if(!expenses.isEmpty()){
            System.out.println("6 - Listar todas despesas ativas");
            System.out.println("7 - Listar despesas por Mes/Ano");
        }

        if(!incomes.isEmpty()){
            System.out.println("8 - Listar todas rendas ativas");
            System.out.println("9 - Listar rendas por Mes/Ano");
        }

        System.out.println("0 - sair");
    }

    public static void addPerson(Scanner in) {
        System.out.println("Digite o nome da pessoa");
        String name = in.next();

        Person p1 = new Person(name);
        persons.add(p1);

        System.out.println("Deseja addicionar uma renda para: " + p1.getName() + " (y/n)");
        String opt = in.next();

        if(opt.equals("Y") || opt.equals("y")) addIncome(in, p1);
    }

    public static void addExpanse(Scanner in) {
        System.out.println("digite o valor da despesa");
        float value = in.nextFloat();

        System.out.println("digite a descrição da despesa");
        String description = in.nextLine();

        System.out.println("selecione o tipo da despesa");
        System.out.println("1 - Serviço ");
        System.out.println("2 - Casa ");
        System.out.println("3 - Transporte ");
        System.out.println("4 - Alimentação ");
        int opt = in.nextInt();

        System.out.println("é uma despesa recorente (y/n)");
        String recurrenceAnswer = in.next();
        boolean recurrence = recurrenceAnswer.equals("Y") || recurrenceAnswer.equals("y");

        ExpenseType eType;
        switch (opt) {
            case 2:
                eType = ExpenseType.House;
            case 3:
                eType = ExpenseType.Transport;
            case 4:
                eType = ExpenseType.Alimentation;
            default:
                eType = ExpenseType.Services;
        }
        Expense e1 = recurrence ? new FixedExpense(value, description, eType) : new Expense(value, description, eType);

        expenses.add(e1);
    }

    public static void addIncome(Scanner in, Person p) {
        System.out.println("digite o valor");
        float value = in.nextFloat();

        System.out.println("é uma renda fixa? (y/n)");
        String recurrenceAnswer = in.next();

        boolean recurrence = recurrenceAnswer.equals("Y") || recurrenceAnswer.equals("y");

        Income r1 = recurrence ? new Income(value, p) : new FixedIncome(value, p);

        incomes.add(r1);
    }

    public static void listExpenses(Scanner in) {
        expenses.stream()
                .filter(expense -> {
                    YearMonth now = YearMonth.now();
                    return expense.endDate.getMonthValue() >= now.getMonthValue() && expense.endDate.getYear() >= now.getYear();
                }).forEach(System.out::println);
    }

    public static void listExpenses(Scanner in, YearMonth ym) {
        expenses.stream()
                .filter(n -> "FixedExpanse".equals(n.getClass().getName()))
                .filter(expense -> {
                            FixedExpense e1 = (FixedExpense) expense;
                            return e1.getInitialDate().getMonthValue() >= ym.getMonthValue() ||
                                    e1.getEndDate().getMonthValue() <= ym.getMonthValue();
                        }
                )
                .forEach(System.out::println);
    }


    public static void listIncomes(Scanner in){
        incomes.stream().forEach(System.out::println);
    }

    public static void listIncomes(Scanner in, YearMonth ym){
        incomes.stream().filter(income ->
                income.active
        ).forEach(System.out::println);
    }

    public static void addAccount() {
        System.out.println("qual o tipo de conta?");
        System.out.println("1 - Poupança");
        System.out.println("2 - Corrente");
        System.out.println("3 - Dinheiro");
        int opt = in.nextInt();

        AccountTypes accountType;
        switch (opt){
            case 1:
                accountType = AccountTypes.Poupança;
                break;
            case 2:
                accountType = AccountTypes.Corrente;
                break;
            default:
                accountType = AccountTypes.Dinheiro;
                break;
        }

        System.out.println("digite o valor atual");
        float value = in.nextFloat();

        Account ac = new Account(value, persons.get(0) ,accountType);
    }

    public static void list(ArrayList list, Function<Object, Boolean> comparate){
        list.stream().filter(comparate::apply).forEach(System.out::println);
    }
}
