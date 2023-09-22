package HW7.cofee.order;

import java.util.*;

public class CoffeeOrderBoard {

    private int orderingNumber = 1;
    Queue<Order> orders = new PriorityQueue<>();

    public void add(Order order) {
        order.setId(orderingNumber++);
        orders.add(order);
    }

    public Order deliver() {
        return orders.remove();
    }

    public Order deliver(int orderingNumber) {
        LinkedList<Order> ordersList = new LinkedList<>(orders);
        for (Order order : ordersList) {
            if (order.getId() == orderingNumber) {
                orders.remove(order);
                return order;
            }
        }
        return null;
    }

    public void draw() {
        LinkedList<Order> orderList = new LinkedList<>(orders);
        for (Order order : orderList) {
            System.out.println("Num: " + order.getId() + " | Client: " + order.getClientName());
        }
    }
}
