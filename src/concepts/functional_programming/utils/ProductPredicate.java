package concepts.functional_programming.utils;

import concepts.functional_programming.entities.Product;

import java.util.function.Predicate;

public class ProductPredicate implements Predicate<Product> {
    @Override
    public boolean test(Product product) {
        return product.getPrice() >= 100.00;
    }
}
