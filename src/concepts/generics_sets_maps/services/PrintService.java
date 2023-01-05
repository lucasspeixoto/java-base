package concepts.generics_sets_maps.services;

import java.util.ArrayList;
import java.util.List;

public class PrintService<T> {

    List<T> items = new ArrayList<>();

    public void addValue(T value) {
        this.items.add(value);
    }

    public void print() {
        System.out.print("[");
        if(!this.items.isEmpty()) {
            System.out.print(this.items.get(0));
        }
        for (int i = 1; i < this.items.size(); i ++) {
            System.out.print(", " + this.items.get(i));
        }
        System.out.println("]");
    }

    public T first() {
        if (this.items.isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        return this.items.get(0);
    }
}
