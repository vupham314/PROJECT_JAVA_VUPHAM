package VU_CUSTOMER;

import VU_SUPPLIER.Item;
import VU_SUPPLIER.Shop;

import java.util.Arrays;

public class ItemInPurchase {

    private final Item item;
    private final Shop shop;
    private final int amount;
    private String statusTransport;
    private String statusPayment;

    private final String[] Transport = {
            "waiting for confirmation",
            "waiting for the goods",
            "delivery",
            "delivered",
            "cancelled",
            "returns"
    };

    private final String[] Payment = {
            "unpaid",
            "paid"};


    public ItemInPurchase(Item item, Shop shop, int amount, int statusTransport, int statusPayment) {
        this.item = item;
        this.shop = shop;
        this.amount = amount;
        this.statusTransport = this.Transport[statusTransport - 1];
        this.statusPayment = this.Payment[statusPayment - 1];
    }

    @Override
    public String toString() {
        return "ItemInPurchase{" +
                "     item=" + item + "\n" +
                "     shop=" + shop + "\n" +
                "     amount=" + amount + "\n" +
                "     statusTransport='" + statusTransport + '\'' + "\n" +
                "     statusPayment='" + statusPayment + '\'' + "\n" +
                "     Transport=" + Arrays.toString(Transport) + "\n" +
                "     Payment=" + Arrays.toString(Payment) + "\n" +
                '}';
    }

    public Item getItem() {
        return item;
    }

    public Shop getShop() {
        return shop;
    }

    public int getAmount() {
        return amount;
    }

    public String getStatusTransport() {
        return statusTransport;
    }

    public void setStatusTransport(int statusTransport) {
        this.statusTransport = Transport[statusTransport-1];
    }

    public String getStatusPayment() {
        return statusPayment;
    }

    public void setStatusPayment(String statusPayment) {
        this.statusPayment = statusPayment;
    }
}
