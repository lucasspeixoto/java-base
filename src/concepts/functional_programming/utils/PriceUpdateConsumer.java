package concepts.functional_programming.utils;

import concepts.functional_programming.entities.Product;

import java.util.function.Consumer;

public class PriceUpdateConsumer implements Consumer<Product> {

    @Override
    public void accept(Product product) {
        product.setPrice(product.getPrice() * 1.10);
    }
}
