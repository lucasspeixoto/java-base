package concepts.functional_programming.utils;

import concepts.functional_programming.entities.Product;

import java.util.function.Function;

public class UpperCaseNameFunction implements Function<Product, String> {

    @Override
    public String apply(Product product) {
        return product.getName().toUpperCase();
    }
}
