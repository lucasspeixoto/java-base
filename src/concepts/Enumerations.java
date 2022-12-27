package concepts;

import concepts.entities.Order;
import concepts.entities.OrderStatus;

import java.util.Date;

public class Enumerations {

    public static void main(String[] args) {

        Order order = new Order(1080, new Date(), OrderStatus.PENDING_PAYMENT);

        System.out.println(order);

        OrderStatus os1 = OrderStatus.DELIVERED;

        OrderStatus os2 = OrderStatus.valueOf("DELIVERED");

        System.out.println(os1);

        System.out.println(os2);
    }
}
