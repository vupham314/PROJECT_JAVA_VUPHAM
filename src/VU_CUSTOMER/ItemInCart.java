package VU_CUSTOMER;

import VU_SUPPLIER.Item;
import VU_SUPPLIER.Shop;

public class ItemInCart {
    private final Item item;
    private final Shop shop;
    private int amount;

    public ItemInCart(Item item, Shop shop, int amount) {
        this.item = item;
        this.shop = shop;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "ItemInCart{" + "\n" +
                "     item=" + item.getNameItem() +"\n" +
                "     shop=" + shop.getNameShop() +"\n" +
                "     amount=" + amount +"\n" +
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

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
