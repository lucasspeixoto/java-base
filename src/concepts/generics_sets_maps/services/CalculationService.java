package concepts.generics_sets_maps.services;

import concepts.generics_sets_maps.entities.Product;

import java.util.List;

public class CalculationService {

    /**
     *
     Todas as declarações de método genérico têm uma seção de parâmetro
     de tipo delimitada por colchetes angulares (< e >) que precede o
     tipo de retorno do método, ex:

     // Método genérico PrintArray
     public static <T> void printArray(T[] inputArray){
        //Exibe elementos do Array
        for(T elemente: inputArray) {
            System.out.println("%s ", element);
        }
     }
     */

    //? Estamos assinando um contrato que diz que o método obrigatóriamente
    //? tem que implementar a interface comparable para funcionar.
    public static <T extends Comparable<? super T>> T max(List<T> list) {


        if (list.isEmpty()) {
            throw new IllegalStateException("List can't be empty");
        }

        T maxProductValue = list.get(0);

        for (T item : list) {
            if (item.compareTo(maxProductValue) > 0) {
                maxProductValue = item;
            }
        }

        return maxProductValue;
        //return Collections.max(list);
    }
}
