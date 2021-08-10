package VU_SUPPLIER;

import VU_CUSTOMER.Customer;
import VU_CUSTOMER.ItemInPurchase;

import java.time.LocalDateTime;

public class Oder {
    private static int stt  = 0;
    private final int id;
    private final Item item;
    private final int amount;
    private final double interest;
    private final Customer cus;
    private final LocalDateTime time;

    public Oder(Item item, int amount, Customer cus) {
        this.id = stt;
        stt ++;
        this.item = item;
        this.amount = amount;
        this.cus = cus;
        this.time = LocalDateTime.now();
        this.interest = this.amount * item.getPrice();
    }

    @Override
    public String toString() {
        return "Oder{" + "\n" +
                "     id=" + id + "\n" +
                "     item=" + item.getNameItem() + "\n" +
                "     amount=" + amount + "\n" +
                "     interest=" + interest + "\n" +
                "     cus=" + cus + "\n" +
                "     time=" + time + "\n" +
                '}';
    }

    public int getId() {
        return id;
    }

    public Item getItem() {
        return item;
    }

    public int getAmount() {
        return amount;
    }

    public double getInterest() {
        return interest;
    }

    public Customer getCus() {
        return cus;
    }

    public LocalDateTime getTime() {
        return time;
    }
}
