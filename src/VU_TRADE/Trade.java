package VU_TRADE;

import VU_CUSTOMER.Customer;
import VU_CUSTOMER.ItemInPurchase;
import VU_SUPPLIER.Item;
import VU_SUPPLIER.Shop;
import VU_SUPPLIER.Supplier;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Trade {
    private static int stt  = 0;
    private final int id;
    private final Item itemTraded;
    private final Shop shop;
    private final Customer cus;
    private final LocalDateTime time;

    public Trade(Item itemTraded, Shop shop, Customer cus) {
        this.id = stt;
        stt++;
        this.itemTraded = itemTraded;
        this.shop = shop;
        this.cus = cus;
        this.time = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public Item getItemTraded() {
        return itemTraded;
    }

    public Shop getShop() {
        return shop;
    }

    public Customer getCus() {
        return cus;
    }

    public LocalDateTime getTime() {
        return time;
    }
}
