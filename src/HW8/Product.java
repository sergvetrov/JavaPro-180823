package HW8;

import java.time.Instant;
import java.util.Date;

public class Product{

    private final String type;
    private double price;
    private boolean haveDiscount;
    private final Date added;

    public Product(String type, int price, boolean haveDiscount) {
        this.type = type;
        this.price = price;
        this.haveDiscount = haveDiscount;
        this.added = Date.from(Instant.now());
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isHaveDiscount() {
        return haveDiscount;
    }

    public void setHaveDiscount(boolean haveDiscount) {
        this.haveDiscount = haveDiscount;
    }

    public Date getAdded() {
        return added;
    }
}
