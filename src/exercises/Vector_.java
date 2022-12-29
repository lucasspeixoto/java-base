package exercises;

//? https://www.devmedia.com.br/diferenca-entre-arraylist-vector-e-linkedlist-em-java/29162

/**
 * Vector
 * Do ponto de vista da API, ou seja, da forma como é utilizado,
 * o Vector e o ArayList são muito similares, podemos arriscar até
 * em dizer: iguais. Se você não conhece a fundo o conceito de Vector
 * e ArrayList usará ambos como se fossem o mesmo, sem sentir nenhuma
 * diferença, veja na listagem 2 um exemplo disso.
 *
 * Então qual a diferença entre Vector e ArrayList ?
 *
 * Primeiramente vamos falar sobre o fato de Vector ser sincronizado e o
 * ArrayList não. Significa dizer que se você possui uma aplicação que
 * precisa ser thread-safe em determinado ponto, use Vector e você estará garantido.
 * Outro ponto importante é a alocação dinâmica do Vector, que é diferente
 * do ArrayList. Lembra que falamos que o ArrayList aumenta 50% do seu
 * tamanho quando a lista está cheia ? O Vector aumenta o dobro, ou seja,
 * se você tem uma lista de 10 elementos cheia, essa lista aumentará para 20,
 * com 10 posições vazias. Mas isso não é ruim ? Depende do que você precisar,
 * se você está precisando aumentar a quantidade de elementos com muita frequência,
 * então o ideal é usar o Vector que aumenta o dobro e você ficará com muito
 * mais espaço do que no ArrayList que precisará ficar aumentando
 * com mais frequência, diminuindo assim a performance da sua aplicação.
 */
public class Vector_ {
}
