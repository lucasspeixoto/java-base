package concepts.poo;

/*
  Quando falamos que o balance tem o modificador
  protected, estamos dizendo que ela não é publico,
  podendo ser acessado por qualquer instância, e nem
  privado, limitado o acesso àpenas a classe Account.
  Ele pode ser acessado pelas classes que herdam Account
  como BusinessAccount
 */

import concepts.poo.entities.Account;
import concepts.poo.entities.BusinessAccount;
import concepts.poo.entities.SavingsAccount;

/**
 * Upcasting
 * -> Casting da subclasse para a superclasse
 * -> Uso comum: Polimorfismo
 * <p>
 * Downcasting
 * -> Casting da superclasse para a subclasse
 * -> Palavra instanceof
 * -> Uso comum: Métodos que recebem parâmetros genéricos (ex: Equals)
 */

/**
 * Palavra Chave: final
 *  Em classes evita que a classe seja herdada
 *  Em métodos evita que o método seja sobreposto
 *  O uso do final gera uma maior performance na execução
 *  dos métodos e classes, a análise é mais rápida
 */

/**
 * Classes abstratas
 * São classes que não podem ser instanciadas
 * É uma forma de garantir herança total: somente subclasses
 * não abstratas podem ser instanciadas, mas nunca a
 * superclasse abstrata
 */
public class Poo {

    public static void main(String[] args) {

        

    }

    private static void castings() {
        Account account = new Account(1001, "Lucas Peixoto", 0.0);
        BusinessAccount businessAccount = new BusinessAccount(
                1002,
                "Liana Fernandes",
                0.0,
                500.0);

        //! UpCasting
        Account account1 = businessAccount;
        Account account2 = new BusinessAccount(1003, "Bob", 0.0, 200.0);
        Account account3 = new SavingsAccount(1004, "Anna", 0.0, 0.01);

        //! DownCasting
        /**
         * BusinessAccount account4 = account2;
         * Um objeto da subclasse BusinessAccount não pode
         * ser atribuido de um objeto da superclasse Account,
         * é necessário um casting
         */
        BusinessAccount account4 = (BusinessAccount)account2; //
        account4.loan(100.0);

        //! Esta conversão abaixo não pode ser realizada pois account3 foi instanciada como SavingsAccount ao invés de BusinessAccount.Este erro só ocorre em tempo de execução.
        //BusinessAccount account5 = (BusinessAccount)account3;
        if (account3 instanceof BusinessAccount) {
            BusinessAccount account5 = (BusinessAccount)account3;
            account5.loan(100.0);
        }
    }
}
