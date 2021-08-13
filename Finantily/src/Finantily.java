import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Scanner;

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
                Person p1 = getPerson();
                Account account = getAccount(p1);
                addIncome(account);
                break;
            case 4:
                persons.stream().forEach(person -> System.out.println(person.toString()));
                break;
            case 5:
                Person p2 = getPerson();
                addAccount(p2);
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

    private static Person getPerson(){
        System.out.println("selecione a pessoa");
        persons.stream()
                .forEach(person -> System.out.println(persons.indexOf(person)+ " - " + person.getName()));
        int personId = in.nextInt();
        return persons.get(personId);
    }

    private static Account getAccount(Person p1){
        System.out.println("Selecione a conta");
        p1
                .getAccounts()
                .stream()
                .forEach(account -> System.out.println(accounts.indexOf(account)+ " - " + account.getType()));
        int accountId = in.nextInt();

       return accounts.get(accountId);
    }

    private static YearMonth getDate() {
        System.out.println("Digite a data. ex: 08/2021");
        String value = in.next();

        if (value.matches("[0-9]{2}/[0-9]{4}")) {
            String[] date = value.split("/");
            return YearMonth.of(Integer.parseInt(date[1]), Integer.parseInt(date[0]));
        }

        System.out.println("Formato invalido");
        return getDate();
    }

    private static void renderMenu() {
        System.out.println("--------- Finantily ------------");
        System.out.println("O que deseja fazer? ");
        System.out.println("1 - Adicionar uma pessoa");
        if (!persons.isEmpty()) {
            System.out.println("4 - Listar todas as pessoas");
            System.out.println("5 - Adicionar uma conta");
        }
        if (!accounts.isEmpty()) {
            System.out.println("2 - Adicionar uma despesa");
            System.out.println("3 - Adicionar uma renda");
        }
        if (!expenses.isEmpty()) {
            System.out.println("6 - Listar todas despesas do mes atual");
            System.out.println("7 - Listar despesas por Mes/Ano");
        }
        if (!incomes.isEmpty()) {
            System.out.println("8 - Listar todas rendas do mes atual");
            System.out.println("9 - Listar rendas por Mes/Ano");
        }

        System.out.println("0 - sair");
    }

    public static void addPerson(Scanner in) {
        System.out.println("Digite o nome da pessoa");
        String name = in.next();

        Person p1 = new Person(name);
        persons.add(p1);

        System.out.println("Deseja addicionar uma conta para: " + p1.getName() + " (y/n)");
        String opt = in.next();

        if (opt.equals("Y") || opt.equals("y")) addAccount(p1);
    }

    public static void addExpanse(Scanner in) {
        Person p1 = getPerson();
        Account account = getAccount(p1);

        System.out.println("digite o valor da despesa");
        float value = in.nextFloat();

        System.out.println("digite a descrição da despesa");
        in.nextLine();
        String description = in.nextLine();

        System.out.println("selecione o tipo da despesa");
        System.out.println("1 - Serviço ");
        System.out.println("2 - Casa ");
        System.out.println("3 - Transporte ");
        System.out.println("4 - Alimentação ");
        int opt = in.nextInt();

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
        Expense e1 = new Expense(value, description, eType, p1);

        try {
            account.addExpense(e1);
        } catch (SaldoException e){
            System.out.println(e.getMessage());
        }

        expenses.add(e1);
    }

    public static void addIncome(Account ac) {
        System.out.println("digite o valor");
        float value = in.nextFloat();

        Income r1 =  new Income(value, ac.owner);

        incomes.add(r1);
        ac.addIncome(r1);
    }

    public static void listExpenses(Scanner in) {
        YearMonth now = YearMonth.now();
        expenses.stream()
                .filter(expense ->
                     expense.date.getMonthValue() == now.getMonthValue() && expense.date.getYear() == now.getYear()
                ).forEach(expense -> System.out.println(expense.toString()));

//        expenses.stream()
//                .map(Expense::getValue)
//                .reduce(Float::sum)
//                .ifPresent(sum -> System.out.println("Total: " + sum));
    }

    public static void listExpenses(Scanner in, YearMonth ym) {
        expenses.stream()
                .filter(expense ->
                            expense.getDate().getMonthValue() == ym.getMonthValue() && expense.getDate().getYear() == ym.getYear()

                )
                .forEach(expense -> System.out.println(expense.toString()));
    }

    public static void listIncomes(Scanner in) {
        incomes.stream().forEach(System.out::println);
    }

    public static void listIncomes(Scanner in, YearMonth ym) {
        incomes.stream()
                .filter(income ->
                        income.date.getMonthValue() == ym.getMonthValue() && income.date.getYear() == ym.getYear()
                ).forEach(income -> System.out.println(income.toString()));
    }

    public static void addAccount(Person p1){
        System.out.println("qual o tipo de conta?");
        System.out.println("1 - Poupança");
        System.out.println("2 - Corrente");
        System.out.println("3 - Dinheiro");
        int opt = in.nextInt();

        AccountTypes accountType;
        switch (opt) {
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

        Account ac = new Account(value, p1, accountType);
        accounts.add(ac);
        p1.addAccount(ac);

    }

}
