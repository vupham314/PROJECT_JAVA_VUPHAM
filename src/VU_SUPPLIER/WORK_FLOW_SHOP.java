package VU_SUPPLIER;

import VU_APP.Login;
import VU_APP.Register;
import VU_APP.Sort;
import VU_CUSTOMER.Customer;
import VU_CUSTOMER.ItemInPurchase;
import VU_INFORMATION.Input;
import VU_MAIN.Main;

public abstract class WORK_FLOW_SHOP {

    public static void menuShop(Shop shop){
        System.out.println("""
                1: watch oder
                2: watch items
                3: watch hottest item
                4: add item
                5: log out
                """);
//hfaskdfhksadfds
        switch ((int) Input.inputCheckNumber(0, 10, "your choice")){
            case 1 -> {
                watchOders(shop);
            }
            case 2 -> {
                System.out.println("--- list items ---");
                for (Item item: shop.getItemList()) {
                    System.out.println();
                    System.out.println(item);
                    System.out.println(item.getRating());
                }
            }
            case 3 -> {
                System.out.println("--- hottest item ---");
                Item hottestItem = Sort.sortItemBySold(shop.getItemList()).get(0);
                System.out.println(hottestItem);
                System.out.println(hottestItem.getRating());
            }
            case 4 -> {
                System.out.println("--- add item ---");
                System.out.println();
                int many = (int) Input.inputCheckNumber(0, 10000, "how many item");
                for (int i = 0; i < many; i++) {
                    System.out.println("-- " + i + " --");
                    Item item = Input.createItem(shop);
                    shop.getItemList().add(item);
                    Main.items.add(item);
                    System.out.println();
                }
            }
            case 5 -> {
                Main.menu();
                return;
            }
        }
        menuShop(shop);

    }

    public static void watchOders(Shop shop){
        System.out.println("-- ODERS --");
        System.out.println();
        shop.showOder();
        System.out.println("""
                        1: confirm the oder
                        2: exit
                        """);
        switch ((int) Input.inputCheckNumber(0, 10, "your choice")){
            case 1 -> {
                Customer cus = shop.getOders().get((int) Input.inputCheckNumber(0, shop.getItemList().size() - 1,
                        "input the " +
                                "index")).getCus();
                for (ItemInPurchase item : cus.getPurchase()) {
                    if(item.getShop() == shop){
                        item.setStatusTransport(2);
                        item.getItem().setSold(item.getAmount());
                    }
                }
            }
            case 2 -> {
                menuShop(shop);
            }
        }
    }

//        public static void main(String[] args) {
//        Register.createAccount(1);
//        menuShop( ((Supplier) (Login.login(2))).getShop());
//    }

}
