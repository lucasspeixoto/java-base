package concepts.functional_programming.services;

import concepts.functional_programming.entities.Product;

import java.util.List;
import java.util.function.Predicate;

public class ProductService {

    public double filteredSum(
            List<Product> productList,
            Predicate<Product> criteria) {

        double tProductsTotalPrice = 0.0;

        for (Product product : productList) {
            if (criteria.test(product)) {
                tProductsTotalPrice += product.getPrice();
            }
        }

        return tProductsTotalPrice;
    }
}
