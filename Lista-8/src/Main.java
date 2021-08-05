import com.documents.NotaFiscal;

public class Main {

    public static void main(String[] args) {
        NotaFiscal n = new NotaFiscal();
        Reflection r = new Reflection();

        r.getClassAttributes(n);
        r.getClassLocation(n);
        r.getClassType(n);
        r.getMethods(n);
        r.getClassName(n);
        r.setAttribute(n, "codigo", "1");

        try {
           Object c = r.getNewInstance(n);
           r.setAttribute(c, "codigo", "1");
           r.setAttribute(c, "comprador", "Luis Sousa");
           r.setAttribute(c, "nomeFantasia", "Mega Pcs");
           r.setAttribute(c, "cnpj", "28.077.557/0001-40");
           r.showAttributesAndValues(c);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
