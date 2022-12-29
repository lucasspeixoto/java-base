package exercises;

//? https://www.devmedia.com.br/diferenca-entre-arraylist-vector-e-linkedlist-em-java/29162

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * ArrayList
 * Vamos começar pela mais conhecida e usada, ArrayList.
 * Este tipo de lista é implementado como um Array que é dimensionado
 * dinamicamente, ou seja, sempre que é necessário o seu tamanho aumenta
 * em 50% do tamanho da lista, significa que se você tiver uma lista de
 * tamanho igual a 10 e ela “encher”, seu tamanho aumentará para 15
 * automaticamente.
 * <p>
 * Além disso a ArrayList permite que elementos sejam acessados diretamente
 * pelos métodos get() e set(), e adicionados através de add() e remove().
 * <p>
 * O que você vai perceber no código acima é que o ArrayList não remove os elementos duplicados, e ainda podemos acessar qualquer elemento diretamente através do seu index, mas tudo tem um custo e veremos mais adiante.
 * <p>
 * O
 * s ArrayList começam com um tamanho fixo, que vai aumentando conforme
 * necessário, mas o custo deste aumento é alto, pois é feita uma cópia do
 * array atual para um novo array com um novo tamanho, então imagine um array
 * com 10mil elementos que será copiado para um novo array para criação de mais
 * 5 mil elementos ? De fato é um alto custo. Então é altamente aconselhável que
 * você já inicie seu Array com uma quantidade de elementos que atenda ao seu
 * objetivo atual, sem a necessidade de criação dinâmica de novos espaços,
 * ou seja, se você saber que terá que armazenar de 300 a 400 objetos em
 * um Array, defina 500, pois é melhor sobrar espaço do que utilizar recurso
 * do processador sem necessidade.
 * <p>
 * Há ainda mais um ponto muito importante sobre ArrayList: Estes não são
 * sincronizados, consequentemente não são thread-safe, ou seja,
 * se sua aplicação precisa trabalhar com thread-safe em determinado
 * ponto onde uma Lista é necessária, então descarte ArrayList, a não
 * ser que você faça isso explicitamente, que obviamente não é o correto,
 * veremos mais a diante uma Lista que é sincronizada.
 */


public class ArrayList_ {
    public static void main(String[] args) {

        //https://www.w3resource.com/java-exercises/collection/index.php#arraylist

        List<Integer> numbersList = new ArrayList<Integer>();

        numbersList.add(2);
        numbersList.add(7);
        numbersList.add(3);
        numbersList.add(8);
        numbersList.add(4);
        numbersList.add(1);
        numbersList.add(9);
        numbersList.add(5);

        System.out.print(numbersList.stream().sorted().toList().toString());


    }

    private static void exercise7() {
        List<String> colors = new ArrayList<String>();

        colors.add("Green");
        colors.add("Orange");
        colors.add("White");
        colors.add("Blue");
        colors.add("Red");
        colors.add("Yellow");

        boolean containsRed = colors.contains("Red");

        String text = containsRed ? "Contains Red": "Not Contains Red";

        System.out.println(text);
    }

    private static void exercise5() {
        List<String> colors = new ArrayList<String>();

        colors.add("Green");
        colors.add("Orange");
        colors.add("White");
        colors.add("Blue");
        colors.add("Red");
        colors.add("Yellow");

        colors.set(0, "Black");

        System.out.println(colors);
    }

    private static void exercise4() {
        List<String> colors = new ArrayList<String>();

        colors.add("Green");
        colors.add("Orange");
        colors.add("White");
        colors.add("Blue");
        colors.add("Red");
        colors.add("Yellow");

        System.out.println(colors.get(3));
    }

    private static void exercise3() {
        List<Integer> numbersList = new ArrayList<Integer>();

        numbersList.add(0);
        numbersList.add(1);
        numbersList.add(2);
        numbersList.add(3);
        numbersList.add(4);

        System.out.println(numbersList);

        numbersList.add(0, -1);

        System.out.println(numbersList);
    }

    private static void exercise2() {
        List<String> colors = new ArrayList<String>();

        colors.add("Green");
        colors.add("Orange");
        colors.add("White");
        colors.add("Blue");

        for (String color : colors) {
            System.out.println("Color: " + color);
        }
    }

    private static void exercise1() {
        List<String> colors = new ArrayList<String>();

        colors.add("Green");
        colors.add("Orange");
        colors.add("White");

        System.out.println(colors);
    }
}
