package concepts;

import java.util.ArrayList;
import java.util.List;

/**
 * Listas
 * <p>
 * Estrutura de dados:
 * -> Homogênea (dados de mesmo tipo)
 * -> Ordenada (elementos acessados por meio de posições
 * -> Inicia vazia e ocupada sob demanda
 * -> Cada elemento ocupa um nó
 * <p>
 * Tipo (interface) List . Obs: Interfaces, diferentes de classes, é um tipo que define
 * apenas a especificação das operações; interface não são instanciadas, são implementadas
 * <p>
 * Classes que implementam: ArrayList, LinkedList, etc.
 * Vantagens:
 * -> Tamanho variável
 * -> Facilidade para se realizar e deleções
 * Desvantagens:
 * -> Acesso sequencial dos elementos
 */

public class Lists {

    public static void main(String[] args) {

        List<String> names = new ArrayList<>();

        names.add("Liana");
        names.add("Lucas");
        names.add("Leandro");
        names.add("Fulano");
        names.add("Beltrano");
        names.add(0, "Ciclano");

        names.remove("Beltrano");

        System.out.println(names.size());

        for (String name : names) {
            System.out.println(name);
        }

        System.out.println(names.indexOf("Ciclano"));

        List<String> result = names.stream()
                .filter(name -> name.charAt(0) == 'L')
                .toList();

        System.out.println(result);

        String firstL = names.stream().filter(name -> name.charAt(0) == 'L')
                .findFirst()
                .orElse(null);

        System.out.println(firstL);

    }
}

