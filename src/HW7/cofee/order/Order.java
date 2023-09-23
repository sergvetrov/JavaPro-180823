package HW7.cofee.order;

public class Order implements Comparable<Order> {

    private int id;
    private final String clientName;

    public Order(String clientName) {
        this.clientName = clientName;
    }

    public int getId() {
        return id;
    }

    public String getClientName() {
        return clientName;
    }

    protected void setId(int id) {
        this.id = id;
    }

    @Override
    public int compareTo(Order o) {
        return id - o.id;
    }
}
