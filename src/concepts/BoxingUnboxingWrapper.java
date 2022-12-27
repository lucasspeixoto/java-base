package concepts;


/**
 * Boxing: Processo de conversão de um objeto tipo valor para
 * um objeto tipo referência
 * <p>
 * Unboxing: Processo de conversão de um objeto referência para
 * um objeto valor compativel
 * <p>
 * Wrapper Classes: São classes equivalentes aos tipos primitivos.
 * Uso comum: Campos de entidades em sistemas de informação
 * <p>
 * public class Product {
 * public String name;
 * public Double price; //Double = Wrapper classe do double
 * public Integer quantity; //Integer = Wrapper classe do int
 * }
 * Os wrapper, ao contrário dos tipos primitivos, aceitam valor null
 * e usufruem dos recursos de Orientação a objetos
 */
public class BoxingUnboxingWrapper {

    public static void main(String[] args) {
        boxingAndUnboxing();
    }

    private static void boxingAndUnboxing() {
        // Boxing
        int x = 20;
        Object obj = x;
        System.out.println(obj);

        // Unboxing
        int y = (int) obj;
        System.out.println(y);
    }

}
