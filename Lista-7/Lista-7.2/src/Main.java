public class Main {
    public static void main(String[] args) {

       try(Leitor l = new Leitor("./src/Nome.txt");
           Leitor l2 = new Leitor("./src/Sobrenome.txt")
       ){
           System.out.print(l.readLine() + " ");
           System.out.println(l2.readLine());
       }
        catch(Exception e){
           System.out.println("Houve um erro ao ler o arquivo");
       }

    }
}
