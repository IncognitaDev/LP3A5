import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestePessoa {
    public static void main(String[] args) {

        List<Pessoa> listPessoas = Arrays.asList(new Pessoa("Eduardo", 29),
                new Pessoa("Luiz", 32),
                new Pessoa("Bruna", 26));

        Collections.sort(listPessoas, new Comparator<Pessoa>() {
            @Override
            public int compare(Pessoa o1, Pessoa o2) {
                return o1.getNome().compareTo(o2.getNome());
            }
        });

        listPessoas.forEach(p -> System.out.println(p.getNome()));

        List<Pessoa> listPessoas2 = Arrays.asList(new Pessoa("Eduardo", 29),
                new Pessoa("Luiz", 32),
                new Pessoa("Bruna", 26));

        Collections.sort(listPessoas2, (Pessoa o1, Pessoa o2)
                -> o1.getNome().compareTo(o2.getNome())
        );

        listPessoas2.forEach(p -> System.out.println(p.getNome()));

    }
}
