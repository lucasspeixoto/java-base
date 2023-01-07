package concepts.generics_sets_maps;

import concepts.generics_sets_maps.entities.Client;
import concepts.generics_sets_maps.entities.Product;
import concepts.generics_sets_maps.entities.UserLog;
import concepts.generics_sets_maps.interfaces.Circle;
import concepts.generics_sets_maps.interfaces.Rectangle;
import concepts.generics_sets_maps.interfaces.Shape;
import concepts.generics_sets_maps.services.CalculationService;
import concepts.generics_sets_maps.services.PrintService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
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

/**
 * Set<T>
 * Representa um conjunto de elementos (similar ao da Álgebra)
 * - Não admite repetições
 * - Elementos Não possuem posição
 * - Acesso, inserção e remoção de elementos são rápidas
 * - Principais implementações:
 * -> HasSet: Não mantem a ordem de inserção
 * -> TreeSet
 * -> LinkedHasSet: Mantem a ordem de inserção
 */

/**
 * Map<K,V>
 *     É uma coleção de pares chave / valor
 *      -> Não admite repetições do objeto chave
 *      -> Os elementos são indexados pelo objeto chave (não possuem posição)
 *      -> Acesso, inserção e remoção de elementos são rápidos
 *     Uso comum: Cookies, localStorage, qualquer modelo chave-valor
 *     Principais implementações
 *      -> HashMap: Mais rápido (operações O(1) em tabela hash) e não ordenado
 *      -> TreeMap: Mais lento (operações O(log(n)) em árvore rubro-negra) e ordenado pelo
 *          compareTo do objeto (ou Comparator)
 *      -> LinkedHashMap: Velocidade intermediária e elementos na ordem em que são adicionados
 *
 */


public class Program {

    public static void main(String[] args) {

        Map<String, String> cookies = new TreeMap<>();

        cookies.put("username", "Lucas");
        cookies.put("email", "lspeixotodev@gmail.com");
        cookies.put("phone", "19982621117");

        cookies.remove("email");

        for (String key: cookies.keySet()) {
            System.out.println(key + ": " + cookies.get(key));
        }

    }

    private static void studentsExecise() {
        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);

        Set<Integer> studentsFromA = new TreeSet<>();
        Set<Integer> studentsFromB = new TreeSet<>();
        Set<Integer> studentsFromC = new TreeSet<>();

        System.out.print("Quantos alunos no Curso A: ");
        int numberOfStudentsInACourse = sc.nextInt();
        for (int i = 1; i <= numberOfStudentsInACourse; i++) {
            System.out.print("Número do Aluno: ");
            int studentNumber = sc.nextInt();
            studentsFromA.add(studentNumber);
        }

        System.out.print("Quantos alunos no Curso B: ");
        int numberOfStudentsInBCourse = sc.nextInt();
        for (int i = 1; i <= numberOfStudentsInBCourse; i++) {
            System.out.print("Número do Aluno: ");
            int studentNumber = sc.nextInt();
            studentsFromB.add(studentNumber);
        }

        System.out.print("Quantos alunos no Curso C: ");
        int numberOfStudentsInCCourse = sc.nextInt();
        for (int i = 1; i <= numberOfStudentsInCCourse; i++) {
            System.out.print("Número do Aluno: ");
            int studentNumber = sc.nextInt();
            studentsFromB.add(studentNumber);
        }

        Set<Integer> studentsFromACopy = new HashSet<>(studentsFromA);

        studentsFromACopy.addAll(studentsFromB);
        studentsFromACopy.addAll(studentsFromC);

        System.out.println(studentsFromACopy);
        System.out.println("Total de Alunos: " + studentsFromACopy.size());

        sc.close();
    }

    private static void usersExercise() {
        Locale.setDefault(Locale.US);

        Set<UserLog> usersLogs = new HashSet<>();
        String path = "C:\\temp\\in.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            while (line != null) {
                String[] splitedLine = line.split(" ");
                String userName = splitedLine[0];
                Date loginDate = Date.from(Instant.parse(splitedLine[1]));
                usersLogs.add(new UserLog(userName, loginDate));
                line = br.readLine();
            }

            System.out.println("Total users: " + usersLogs.size());

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void treeSetOrdernation() {
        Set<Product> set = new TreeSet<>();
        set.add(new Product("TV", 1400.00));
        set.add(new Product("Notebook", 5700.00));
        set.add(new Product("Tablet", 4200.00));

        for (Product p : set) {
            System.out.println(p);
        }
    }

    private static void setMethods() {
        Set<Integer> a = new TreeSet<>(Arrays.asList(0, 2, 4, 5, 6, 8, 10));
        Set<Integer> b = new TreeSet<>(Arrays.asList(5, 6, 7, 8, 9, 10));

        //union
        Set<Integer> c = new TreeSet<>(a);
        c.addAll(b);
        System.out.println(c);

        //intersection
        Set<Integer> d = new TreeSet<>(a);
        d.retainAll(b);
        System.out.println(d);

        //difference
        Set<Integer> e = new TreeSet<>(a);

        e.removeAll(b);
        System.out.println(e);
    }

    private static void setBasics() {
        Set<String> set = new LinkedHashSet<>();
        set.add("Tv");
        set.add("Notebook");
        set.add("Tablet");

        set.removeIf(product -> product.length() >= 3);

        for (String p : set) {
            System.out.println(p);
        }
    }

    private static void hasCodeAndEquals() {
        /**
         * hasCode e equals: Operações da classe Object
         * utilizadas para comparar se um objeto é igual a outro.
         *
         * equals: lento e resposta 100%
         * hasCode: rápido, porém resposta positiva não é 100%
         *
         *  Se dois objetos possuem diferentes hasCode, com certeza
         *  eles são diferentes, se possuem o mesmo hasCode, são iguas
         *  porem pode haver colisão
         */
        Client c1 = new Client("Lucas", "lspeixotodev@gmail.com");
        Client c2 = new Client("Liana", "lianacgf@gmail.com");

        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());
        System.out.println(c1.equals(c2));
    }

    private static void exemploCuringaDelimitados() {
        List<Integer> myInts = Arrays.asList(1, 2, 3, 4);
        List<Double> myDoubles = Arrays.asList(3.14, 6.28);
        List<Object> myObjs = new ArrayList<Object>();

        copy(myInts, myObjs);
        printList(myObjs);
        copy(myDoubles, myObjs);
        printList(myObjs);
    }

    private static void copy(List<? extends Number> source, List<? super Number> destiny) {
        destiny.addAll(source);
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
