package concepts.poo.entities;

public class Account {
    private Integer number;
    private String holder;
    /**
     * Quando falamos que o balance tem o modificador
     * protected, estamos dizendo que ela não é publico,
     * podendo ser acessado por qualquer instância, e nem
     * privado, limitado o acesso àpenas a classe Account.
     * Ele pode ser acessado pelas classes que herdam Account
     * como BusinessAccount
     */
    protected Double balance;

    public Account() {
    }

    public Account(Integer number, String holder, Double balance) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getBalance() {
        return balance;
    }

    public void withdraw(double amount) {
        this.balance -= amount;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }
}
