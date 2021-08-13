import org.jetbrains.annotations.NotNull;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
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
                listAll(persons);
                break;
            case 5:
                Person p2 = getPerson();
                addAccount(p2);
                break;
            case 6:
                listAll(expenses);
                break;
            case 7:
                listByActualMonth(expenses);
                break;
            case 8:
                listAll(incomes);
                break;
            case 9:
                listByActualMonth(incomes);
                break;
            case 10:
                listAll(accounts);
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
            System.out.println("10 - Listar contas");
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


        try {
            Expense e1 = new Expense(value, description, eType, p1);
            account.addExpense(e1);
            expenses.add(e1);
        } catch (SaldoException e){
            System.out.println(e.getMessage());
        }
        catch (Exception e){
            System.out.println("erro ao criar a despesa");
        }
    }

    public static void addIncome(Account ac) {
        System.out.println("digite o valor");
        float value = in.nextFloat();

        Income r1 =  new Income(value, ac.owner);

        incomes.add(r1);
        ac.addIncome(r1);
    }

    public static void listExpenses(Scanner in) {
        expenses.stream()
                .map(Expense::getValue)
                .reduce(Float::sum)
                .ifPresent(sum -> System.out.println("Total: " + sum));
    }

    private static void listAll(ArrayList<?> list){
        if(list != null){
            list.stream().forEach(item -> item.toString());
        }
    }

    private static void listByActualMonth(ArrayList<?> list ) {
        YearMonth ym = getDate();
        list.stream()
                .filter(item -> item.getClass().getName().equals("Income") || item.getClass().getName().equals("Expanse"))
                .filter(item -> {
                    Dated obj = (Dated) item;
                    return obj.date.getMonthValue() == ym.getMonthValue() && obj.date.getYear() == ym.getYear();
                }).forEach(item  -> System.out.println(item.toString()));
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
