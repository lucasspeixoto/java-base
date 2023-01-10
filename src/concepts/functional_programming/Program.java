package concepts.functional_programming;

import concepts.functional_programming.entities.Employee;
import concepts.functional_programming.entities.Product;
import concepts.functional_programming.services.ProductService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Expressões Lambda: Funções anônimas de primeira classe
 * <p>
 * <p>
 * Paradigma Funcional
 * Baseado no formalismo matemático Cálculo Lambda (Church 1930)
 * -> Forte transparência funcional: Uma função possui transparência referencial
 * se seu resultado for sempre o mesmopara os mesmos dados de entrada.
 * Benefícios: simplicidade e previsibilidade
 * -> Comum a existência de objetos imutáveis
 * -> Funções são objetos de primeira ordem: Isso significa que funções
 * podem, por exemplo, serem passadas como parâmetros de métodos,
 * bem como retornadas como resultado de métodos.
 * -> Código conciso: Interger sum = list.stream().reduce(0. Integer::sum);
 * -> Comum a tipagem dinâmica e inferência de tipos
 */

/**
 * Stream
 * É uma sequência de elementos advinda de uma fonte de dados
 * (Ex: Coleção, Array, função de iteração, recurso de E/S) que
 * oferece suporte a operações agredagas.
 * <p>
 * * Stream é uma solução para processar sequências de dados
 * de forma:
 * • Declarativa (iteração interna: escondida do programador)
 * • Paralle-friendly (imutável -> thread safe)
 * • Sem efeitos colaterais
 * • Sob demanda (lazy evaluation)
 * * Acesso sequencial (não há índices)
 * * Single-use: só pode ser usada uma vez
 * * Pipeline: Operações em streams retornam novas streams. Então
 * *  é possível criar uma cadeia de operações (fluxo de processamento)
 * * Operação intermediária:
 * • Produz uma nova streams (encadeamento)
 * • Só executa quando uma operação terminal é invocada (lazy evaluation)
 * • Exemplos: filter, map, flatmap, peek, distinct, sorted, skip limit (short-circuit)
 * Operações short-circuit cortam a stream quando a condição é satisfeita
 * * Operação terminal:
 * • Produz um objeto não-stream (coleção ou outro)
 * • Determina o fim do processamento da stream
 * • Exemplos: forEach, forEachOrdered, toArray, reduce, collect, min, count, etc...
 */

public class Program {

    public static void main(String[] args) {

        streamsExercise2();

    }

    private static void streamsExercise2() {
        Locale.setDefault(Locale.US);

        List<Employee> employees = new ArrayList<>();
        String path = "C:\\temp\\in.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            while (line != null) {
                String[] splitedLine = line.split(",");

                String employeeName = splitedLine[0];
                String employeeEmail = splitedLine[1];
                Double employeeSalary = Double.parseDouble(splitedLine[2]);

                employees.add(new Employee(employeeName, employeeEmail, employeeSalary));

                line = br.readLine();
            }

            Comparator<String> comparatorStrings = (first, second) -> first.toUpperCase().compareTo(second.toUpperCase());

            List<String> emailsForEmployeesWithSalaryBiggerThenAverage = employees.stream()
                    .filter(employee -> employee.getSalary() >= 2000.00)
                    .map(Employee::getEmail)
                    .sorted(comparatorStrings)
                    .toList();

            System.out.println("Email of people whose salary is more than 2000.00: ");
            emailsForEmployeesWithSalaryBiggerThenAverage.forEach(System.out::println);
            Double sumOfPeopleWhoseNameStartsWithM = employees.stream()
                    .filter(employee -> employee.getName().charAt(0) == 'M')
                    .map(Employee::getSalary)
                    .reduce(0.0, Double::sum);

            System.out.println("Sum of salary of people whose name starts with 'M': " + sumOfPeopleWhoseNameStartsWithM);


        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void streamsExercise1() {
        Locale.setDefault(Locale.US);

        List<Product> products = new ArrayList<>();
        String path = "C:\\temp\\in.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            while (line != null) {
                String[] splitedLine = line.split(",");
                String productName = splitedLine[0];
                Double productPrice = Double.parseDouble(splitedLine[1]);

                products.add(new Product(productName, productPrice));

                line = br.readLine();
            }

            double average = products.stream()
                    .map(Product::getPrice)
                    .reduce(0.0, Double::sum) / products.size();

            System.out.println("Average price: " + String.format("%.2f", average));

            Comparator<String> stringComparator = (first, second) -> first.toUpperCase().compareTo(second.toUpperCase());

            List<String> productsWithPriceLowerThanAverage = products.stream()
                    .filter(product -> product.getPrice() < average)
                    .map(Product::getName)
                    .sorted(stringComparator.reversed())
                    .toList();

            productsWithPriceLowerThanAverage.forEach(System.out::println);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void pipeline() {
        List<Integer> list = Arrays.asList(3, 4, 5, 10, 7);

        Stream<Integer> stream1 = list.stream().map(item -> item * 10);
        System.out.println(Arrays.toString(stream1.toArray()));

        int sum = list.stream().reduce(0, Integer::sum);
        System.out.println(sum);

        List<Integer> newList = list.stream()
                .filter(x -> x % 2 == 0)
                .map(x -> x * 10).toList();

        System.out.println(newList);
    }

    private static void streams() {
        List<Integer> list = Arrays.asList(3, 4, 5, 10, 7);

        Stream<Integer> stream1 = list.stream().map(item -> item * 10);

        System.out.println(Arrays.toString(stream1.toArray()));

        Stream<String> stream2 = Stream.of("Lucas", "Liana", "Cecícia");
        System.out.println(Arrays.toString(stream2.toArray()));

        Stream<Integer> stream3 = Stream.iterate(0, x -> x + 2);
        System.out.println(Arrays.toString(stream3.limit(10).toArray()));

        Stream<Long> stream4 = Stream.iterate(
                        new Long[]{0L, 1L},
                        p -> new Long[]{p[1], p[0] + p[1]})
                .map(p -> p[0]);

        System.out.println(Arrays.toString(stream4.limit(10).toArray()));
    }

    private static void functionWithLambdaFunctionAsParameter() {
        Locale.setDefault(Locale.US);

        List<Product> products = new ArrayList<>();

        products.add(new Product("TV", 1400.00));
        products.add(new Product("Mouse", 50.00));
        products.add(new Product("Monitor", 800.00));
        products.add(new Product("Tablet", 4500.00));
        products.add(new Product("Hd Case", 90.89));

        ProductService productService = new ProductService();

        System.out.println(productService.filteredSum(
                products,
                product -> product.getName().charAt(0) == 'M'));
    }

    private static void interfaceFunction() {
        Locale.setDefault(Locale.US);

        List<Product> products = new ArrayList<>();

        products.add(new Product("TV", 1400.00));
        products.add(new Product("Mouse", 50.00));
        products.add(new Product("Tablet", 4500.00));
        products.add(new Product("Hd Case", 90.89));

        /**
         List<String> names = products.stream()
         .map(new UpperCaseNameFunction())
         .toList(); //Implementação da interface
         */

        /**
         List<String> names = products.stream()
         .map(Product::staticUpperCaseNameFunction)
         .toList(); //Reference method com método estático
         */

        /**
         List<String> names = products.stream()
         .map(Product::nonStaticUpperCaseNameFunction)
         .toList(); ////Reference method com método não estático
         */
        /**
         Function<Product, String> funct = product -> product.getName().toUpperCase();
         List<String> names = products.stream()
         .map(funct)
         .toList(); //Expressão lambda declarada
         */

        Stream<Product> namesStream = products.stream();

        List<String> names = namesStream
                .map(product -> product.getName().toUpperCase())
                .toList(); //Expressão lambda inline

        names.forEach(System.out::println);
    }

    private static void interfaceConsumer() {
        Locale.setDefault(Locale.US);

        List<Product> products = new ArrayList<>();

        products.add(new Product("TV", 1400.00));
        products.add(new Product("Mouse", 50.00));
        products.add(new Product("Tablet", 4500.00));
        products.add(new Product("Hd Case", 90.89));

        //products.forEach(new PriceUpdateConsumer()); //Implementação da interface
        //products.forEach(Product::staticPriceUpdateConsumer); //Reference method com método estático
        //products.forEach(Product::nonStaticPriceUpdateConsumer); //Reference method com método não estático
        Consumer<Product> consP = product -> product.setPrice(product.getPrice() * 1.10);
        //products.forEach(consP); //Expressão lambda declarada
        products.forEach(product -> product.setPrice(product.getPrice() * 1.10)); //Expressão lambda inline
        products.forEach(System.out::println);
    }

    private static void interfacePredicate() {
        List<Product> products = new ArrayList<>();

        products.add(new Product("TV", 1400.00));
        products.add(new Product("Mouse", 50.00));
        products.add(new Product("Tablet", 4500.00));
        products.add(new Product("Hd Case", 90.89));


        //products.removeIf(new ProductPredicate());
        //products.removeIf(Product::staticProductPredicate); //Reference method com método estático
        //products.removeIf(Product::nonStaticProductPredicate); //Reference method com método não estático

        Predicate<Product> prodP = product -> product.getPrice() >= 100;
        //products.removeIf(prodP); //Expressão lambda declarada
        //products.removeIf(product -> product.getPrice() >= 100.00); // Expressão lambda inline
        for (Product product : products) {
            System.out.println(product);
        }
    }

    private static void interfaceFuncional() {
        List<Product> products = new ArrayList<>();

        products.add(new Product("TV", 1400.00));
        products.add(new Product("Agasalho", 400.00));
        products.add(new Product("Tablet", 4500.00));
        products.add(new Product("Notebook", 5700.00));

        /**
         *  O método comparator é uma interfaca funcional, ou seja,
         *  uma interface que possui um único método abstrato. Suas
         * implementações serão tratadas como expressões lambda.
         * Exemplo de interfaces funcionais: Predicate, Function e Consumer
         *  Comparator<Product> comparator = new Comparator<Product>() {
         *             @Override
         *             public int compare(Product firstProduct, Product secondProduct) {
         *                 return firstProduct.getName().toUpperCase().compareTo(secondProduct.getName().toUpperCase());
         *             }
         *         };
         */

        //products.sort(new MyComparator());
        //Comparator<Product> comparator = (firstProduct, secondProduct) -> firstProduct.getName().toUpperCase().compareTo(secondProduct.getName().toUpperCase());


        products.sort((firstProduct, secondProduct) -> firstProduct.getName().toUpperCase().compareTo(secondProduct.getName().toUpperCase()));

        for (Product product : products) {
            System.out.println(product);
        }
    }
}
