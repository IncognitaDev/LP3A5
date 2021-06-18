public class FunctionalTest {

    public static void main(String[] args) {
       InterfaceFuncional funcional = () -> System.out.println("teste");
       funcional.show();
    }
}
