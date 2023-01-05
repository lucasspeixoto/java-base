package concepts.generics_sets_maps;

import concepts.generics_sets_maps.entities.Product;
import concepts.generics_sets_maps.interfaces.Circle;
import concepts.generics_sets_maps.interfaces.Rectangle;
import concepts.generics_sets_maps.interfaces.Shape;
import concepts.generics_sets_maps.services.CalculationService;
import concepts.generics_sets_maps.services.PrintService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Generics
 * Permitem que classes, interfaces e métodos possam
 * ser parametrizados por tipo. Seus benefícios são:
 * -> Reuso
 * -> Type Safety
 * -> Performance
 * <p>
 * Em alguns casos podem reutilizar metodos de serviços
 * com um tipo Object, porem ele vai exigir casting de
 * tipos em determinadas situações, diferente do Generics
 */


public class Program {

    public static void main(String[] args) {

        List<Integer> myInts = Arrays.asList(1, 2, 3, 4);
        List<Double> myDoubles = Arrays.asList(3.14, 6.28);
        List<Object> myObjs = new ArrayList<Object>();

        copy(myInts, myObjs);
        printList(myObjs);
        copy(myDoubles, myObjs);
        printList(myObjs);

    }

    private static void copy(List<? extends Number> source, List<? super Number> destiny) {
        for (Number number : source) {
            destiny.add(number);
        }
    }


    private static void principioGetPutContravariancia() {
        //! Contravariância: get não permitido e put permitido
        List<Object> myObjs = new ArrayList<>();
        myObjs.add("Lucas");
        myObjs.add("Liana");

        /**
         * List<? super Number> myNums
         * myNums pode ser um Number ou qualquer super tipo
         * de Number, no caso o Object (único acima do Number)
         */
        List<? super Number> myNums = myObjs;

        myNums.add(10);
        myNums.add(3.14);

        //Number x = myNums.get(0);
    }

    private static void principioGetPutCovariancia() {
        /**
         * Principio get/put
         *
         */
        //! Covariância: get permitido e put não permitido

        List<Integer> intList = new ArrayList<Integer>();
        intList.add(10);
        intList.add(5);

        /**
         * List<? extends Number> list
         * list pode ser qualquer subtipo de Number,
         * Integer, Double, Byte, etc...
         */
        List<? extends Number> list = intList;

        Number x = list.get(0); //get permitido

        //list.add(20); //put não permitido
    }

    private static void usoDeTiposCuringa2() {
        Locale.setDefault(Locale.US);

        List<Shape> myShapes = new ArrayList<>();
        myShapes.add(new Rectangle(3.0, 4.0));
        myShapes.add(new Circle(2.0));

        List<Circle> myCircles = new ArrayList<>();
        myCircles.add(new Circle(2.0));
        myCircles.add(new Circle(3.0));
        myCircles.add(new Circle(4.0));

        System.out.println(
                "Total area: "
                        +
                        String.format("%.2f", totalArea(myShapes))
                        +
                        "cm2"
        );

        System.out.println(
                "Total area: "
                        +
                        String.format("%.2f", totalArea(myCircles))
                        +
                        "cm2"
        );
    }

    /**
     * List<? extends Shape> listOfShapes: listOfShapes pode ser
     * do tipos shape ou de qualquer subtipo de Shape, ou seja, podemos
     * chamar totalArea para tipos Circle: totalArea(myCircles)
     */
    private static double totalArea(List<? extends Shape> listOfShapes) {
        double totalArea = 0.0;
        for (Shape shape : listOfShapes) {
            totalArea += shape.area();
        }

        return totalArea;
    }

    private static void usoDeTiposCuringa1() {
        List<Integer> myInts = Arrays.asList(5, 2, 10);
        List<String> names = Arrays.asList("Lucas", "Liana");
        printList(myInts);
        printList(names);
    }

    // List<Object> não funcionaria pois não é possível
    // realizar o upercastinh de List<Integer> para List<Object>
    public static void printList(List<?> list) {
        //list.add(3); //Não é possível adicionar items em listas de tipo curinga
        for (Object obj : list) {
            System.out.print(obj + " ");
        }
        System.out.println();
    }

    private static void tiposCuringa() {
        // List<Object> não é o supertipo de qualquer tipo de lista:
        List<Object> myObjs1 = new ArrayList<Object>();
        List<Integer> myNumbers1 = new ArrayList<Integer>();
        //myObjs1 = myNumbers1; // erro de compilação

        //O supertipo de qualquer tipo de lista é List<?>. Este é um tipo curinga:
        List<?> myObjs2 = new ArrayList<Object>();
        List<Integer> myNumbers2 = new ArrayList<Integer>();
        myObjs2 = myNumbers2;
    }

    private static void genericDelimited() {
        Locale.setDefault(Locale.US);

        List<Product> list = new ArrayList<>();
        String path = "C:\\temp\\in.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            while (line != null) {
                String[] splitedLine = line.split(",");
                String productName = splitedLine[0];
                Double productValue = Double.parseDouble(splitedLine[1]);
                list.add(new Product(productName, productValue));
                line = br.readLine();
            }

            Product x = CalculationService.max(list);
            System.out.println("Max expensive product: " + x);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void genericsBasic() {
        Scanner sc = new Scanner(System.in);

        PrintService<Integer> printService = new PrintService<>();

        System.out.print("How Many values: ");
        int numberOfValues = sc.nextInt();

        for (int i = 0; i < numberOfValues; i++) {
            Integer value = sc.nextInt();
            printService.addValue(value);
        }

        printService.print();

        System.out.println("First: " + printService.first());

        sc.close();
    }
}
