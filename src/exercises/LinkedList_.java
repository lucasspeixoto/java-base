package exercises;

//? https://www.devmedia.com.br/diferenca-entre-arraylist-vector-e-linkedlist-em-java/29162

/**
 * LinkedList
 *
 * Este tipo de lista implementa uma “double linked list”, ou seja,
 * uma lista duplamente “linkada”. A sua principal diferença entre o
 * ArrayList é na performance entre os métodos add, remove, get e set.
 *
 * Este tipo de lista possui melhor performance nos métodos add e remove,
 * do que os métodos add e remove do ArrayList, em compensação seus métodos
 * get e set possuem uma performance pior do que os do ArrayList.
 * Vamos abaixo fazer uma comparação entre a complexidade apresentada
 * de cada método do ArrayList e o da LinkedList.
 *
 * get(int index): LinkedList possui O(n) e ArrayList possui O(1)
 * add(E element): LinkedList possui O(1) e ArrayList possui O(n) no pior caso,
 * visto que o array será redimensionado e copiado para um novo array.
 * add(int index, E element): LinkedList possui O(n) e ArrayList possui O(n)
 * no pior caso remove(int index): LinkedList possui O(n) e ArrayList possui
 * O(n-index), se remover o último elemento então fica O(1)
 * Perceba então que a principal diferença está na performance,
 * e uma análise minuciosa deve ser feita em casos onde a performance é
 * algo crítica e todos o pontos devem ser considerados.
 *
 * Como falamos muito da diferença de performance entre LinkedList e ArrayList,
 * nada melhor do que mostrar na prática qual é mais rápida em que ocasiões,
 * então veja a listagem abaixo.
 *
 * Listagem 4: Comparação de Performance entre LinkedList e ArrayList
 *
 */

public class LinkedList_ {
}
