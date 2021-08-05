import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Reflection {

    public void getClassName(Object obj){
        System.out.println(obj.getClass().getName());
    }

    public Object getNewInstance(Object obj) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class<?> c = Class.forName(getClassLocation(obj));
        return c.newInstance();
    }

    public void getMethods(Object obj){
        Method[] methods = obj.getClass().getDeclaredMethods();
        Arrays.stream(methods).forEach(n -> {
            System.out.print(n.getName()+": ");
            System.out.println(n.getReturnType());
        });
    }

    public String getClassLocation(Object obj){
        String a = obj.getClass().getCanonicalName();
        System.out.println("canonical: " +a);
        return a;
    }

    public void getClassType(Object obj){
        System.out.println("class type: " +obj.getClass().getComponentType());
    }

    public void getClassAttributes(Object obj){
       Field[] attributes = obj.getClass().getDeclaredFields();

        for (Field n : attributes) {
            System.out.print(n.getName() + " :");
            System.out.println(n.getType());
        }
    }

    public void showAttributesAndValues(Object obj){
        Field[] attributes = obj.getClass().getDeclaredFields();

        for (Field n : attributes) {
            n.setAccessible(true);
            System.out.print(n.getName() + " :");
            try {
                System.out.println(n.get(obj));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public void setAttribute(Object obj, String fieldName, String fieldValue){
        try {
           Field f =  obj.getClass().getDeclaredField(fieldName);
           f.setAccessible(true);
           f.set(obj, fieldValue);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
