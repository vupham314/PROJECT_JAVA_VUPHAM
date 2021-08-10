package VU_SUPPLIER;

import VU_INFORMATION.Account;

public class Supplier extends Account {
    private Shop shop;
    public Supplier(Shop shop, String nameLog, String password, String email) {
        super(nameLog, password, email);
        this.shop = shop;
    }

    public Shop getShop() {
        return shop;
    }
}
