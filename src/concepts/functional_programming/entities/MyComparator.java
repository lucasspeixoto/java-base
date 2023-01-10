package concepts.functional_programming.entities;

import java.util.Comparator;

public class MyComparator implements Comparator<Product> {

    @Override
    public int compare(Product firstProduct, Product secondProduct) {
        return firstProduct.getName().toUpperCase().compareTo(secondProduct.getName().toUpperCase());
    }
}
