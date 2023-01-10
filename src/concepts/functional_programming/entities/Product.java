package concepts.functional_programming.entities;

import java.util.Objects;

public class Product {

    private String name;
    private Double price;

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    // Trabalha com a instancia passada por argumento
    public static boolean staticProductPredicate(Product product) {
        return product.getPrice() >= 100.00;
    }

    public static void staticPriceUpdateConsumer(Product product) {
        Double newPrice = product.getPrice() * 1.10;
        product.setPrice(newPrice);
    }

    public static String staticUpperCaseNameFunction(Product product) {
        return product.getName().toUpperCase();
    }
    public String nonStaticUpperCaseNameFunction() {
        return this.name.toUpperCase();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    // Trabalha com a instancia da classe
    public boolean nonStaticProductPredicate() {
        return this.price >= 100.00;
    }

    public void nonStaticPriceUpdateConsumer() {
        Double newPrice = this.price * 1.10;
        this.setPrice(newPrice);
    }

    @Override
    public String toString() {
        return "Nome: " + this.name + " | " + "Preço: " + String.format("%.2f", this.price);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof concepts.generics_sets_maps.entities.Product product)) return false;
        return getName().equals(product.getName()) && getPrice().equals(product.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPrice());
    }
}
