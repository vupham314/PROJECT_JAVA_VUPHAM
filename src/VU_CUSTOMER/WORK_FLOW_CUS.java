package VU_CUSTOMER;

import VU_APP.Searching;
import VU_APP.Sort;
import VU_INFORMATION.Address;
import VU_INFORMATION.FullName;
import VU_INFORMATION.Input;
import VU_INFORMATION.Profile;
import VU_MAIN.Main;
import VU_SUPPLIER.Item;
import VU_SUPPLIER.Oder;
import VU_SUPPLIER.Shop;

import java.util.ArrayList;

public abstract class WORK_FLOW_CUS {

    public static void menuCus(Customer cus){
        System.out.println("""
                1: search item
                2: search shop
                3: watch trendy items
                4: watch cart
                5: watch purchase
                6: profile
                7: log out
                """);
        switch ( (int) Input.inputCheckNumber(0, 7, "your choice")){
            case 1 ->{
                ArrayList<Item> items = searchItems();
                int count = 0;
                for (Item item : items) {
                    System.out.println();
                    System.out.println("--- " + count + " ---");
                    showInforItem(item);
                    count++;
                }
                whenCount(count, cus, items);

            }
            case 2 ->{
                System.out.println();
                System.out.print("+ key word: ");
                ArrayList<Shop> shops = Searching.searchShop(Main.scn.nextLine());
                int count = 0;
                for (Shop shop: shops) {
                    System.out.println();
                    System.out.println("--- " + count + " ---");
                    System.out.println(shop);
                    count++;
                }
                ////
            }
            case 3 ->{
                System.out.println();
                System.out.println("-- trendy items --");
                ArrayList<Item> items = Sort.sortItemBySold(Main.items);
                int i = 0;
                for (; i < 3; i++) {
                    System.out.println("--- " + i + " ---");
                    showInforItem(items.get(i));
                }
                whenCount(i, cus, items);
            }
            case 4 ->{
                System.out.println();
                System.out.println("-- cart --");
                cus.showCart();
                System.out.println("""
                        1: delete Item
                        2: buy item
                        3: exit
                        """);

                switch ((int) Input.inputCheckNumber(0, 3, "your choice")){
                    case 1->{
                        System.out.println();
                        int index = (int) Input.inputCheckNumber(0, cus.getCart().size()-1, "enter the index");
                        cus.getCart().remove(index);
                        System.out.println("***remove successfully");
                    }
                    case 2->{

                    }
                    case 3->{
                        System.out.println("bye bye");
                    }
                }

            }
            case 5 ->{
                cus.sortPurChase();
                cus.showPurchase();
            }
            case 6 ->{
                case6(cus);
            }
            case 7 ->{
                Main.menu();
                return;
            }
        }
        menuCus(cus);
    }


    public static void case6(Customer cus){
        System.out.println(cus);
        System.out.println("""
                        1: change address
                        2: change profile
                        3: change name
                        4: exit
                        """);
        switch ((int) Input.inputCheckNumber(0, 4, "your choice")){
            case 1->{
                System.out.println();
                System.out.println("-- change address --");
                Address newAddress = Input.createAddress();
                cus.getInformation().setAddress(newAddress);
            }
            case 2->{
                System.out.println();
                System.out.println("-- change profile --");
                Profile hm = Input.createProfile();
                cus.getInformation().setProfile(hm);
            }
            case 3->{
                System.out.println();
                System.out.println("-- changer name --");
                FullName newName = Input.createFullName();
                cus.getInformation().getProfile().setFullName(newName);
            }
            case 4->{
                return;
            }
        }

    }

     public static ArrayList<Item> searchItems(){
         System.out.print("+ key word: ");
         String keyword = Main.scn.nextLine();
         return Searching.searchItem(keyword, Sort.sortItemBySold(Main.items)) ;
     }

     public static void showInforItem(Item item){
        System.out.println(
                "+ name : " + item.getNameItem() + "\n" +
                "+ brand : " + item.getBrand() + "\n" +
                "+ price : " + item.getPrice() + "\n" +
                "+ rating : " + item.getRating() + "\n" +
                "+ shop: " + item.getShop().getNameShop()
        );
    }

//    public static void whenCount(Customer cus, ArrayList<Shop> shops){
//        System.out.println("""
//                1: choice an shop
//                2: go back
//                """);
//
//        switch ((int) Input.inputCheckNumber(1, 2, "your choice")){
//            case 1 -> {
//                // choice an item
//                // show infor
//                // mua hang
//                // go back home page
//                System.out.println();
//                int index = (int) Input.inputCheckNumber(0, count, "enter the index");
//                Item item = items.get(index);
//                whenChoiceItem(cus, item);
//            }
//            case 2 -> {
//                menuCus(cus);
//            }
//        }
//    }

    public static void whenCount(int count, Customer cus, ArrayList<Item> items){
        System.out.println("""
                1: choice an item
                2: go back
                """);

        switch ((int) Input.inputCheckNumber(1, 2, "your choice")){
            case 1 -> {
                // choice an item
                // show infor
                // mua hang
                // go back home page
                System.out.println();
                int index = (int) Input.inputCheckNumber(0, count, "enter the index");
                Item item = items.get(index);
                whenChoiceItem(cus, item);
            }
            case 2 -> {
                menuCus(cus);
            }
        }
    }
    public static void whenChoiceItem(Customer cus, Item item){
        System.out.println();
        System.out.println("""
                1: buy the item
                2: add to cart
                3: go back to home page
                """);
        switch ((int) Input.inputCheckNumber(1, 3, "your choice")){
            case 1 -> {
                buyItem(cus, item);
            }
            case 2 -> {
                int amount = (int) Input.inputCheckNumber(0, item.getAmount(), "how much you want");
                cus.addToCart(new ItemInCart(item, item.getShop(), amount));
                System.out.println("*** add to cart successfully");
            }
            case 3 ->{

            }
        }
        menuCus(cus);
    }

    public static void buyItem(Customer cus, Item item) {
        System.out.println();
        int amount = (int) Input.inputCheckNumber(0, item.getAmount(), "how much you want");
        System.out.println();
        System.out.println("-- information oder --");
        System.out.println(
                "+ name : " + item.getNameItem() + "\n" +
                "+ size : " + item.getSize() + "\n" +
                "+ brand : " + item.getBrand() + "\n" +
                "+ price : " + item.getPrice() + "\n" +
                "+ amount : " + amount + "\n" +
                "+ shop: " + item.getShop().getNameShop() + "\n\n" +
                "-- your information --" + "\n" +
                "+ address: " + cus.getInformation().getAddress() + "\n" +
                "+ pay: " + amount * item.getPrice()
        );
        askForConfirm(item, cus, amount);
    }

    public static void askForConfirm(Item item, Customer cus, int amount){
        System.out.println();
        System.out.println("""
                1: confirm the oder
                2: change address
                3: cancel
                """);
        switch ((int) Input.inputCheckNumber(1, 3, "your choice")) {
            case 1 -> {
                System.out.println();
                cus.addToPurchase(new ItemInPurchase(item, item.getShop(), amount, 1, 2));
                item.getShop().getOders().add(new Oder(item, amount, cus));
                System.out.println("go go go");
            }
            case 2 -> {
                System.out.println();
                Address newAddress = Input.createAddress();
                cus.getInformation().setAddress(newAddress);
                askForConfirm(item, cus, amount);
            }
            case 3 -> {
            }
        }

    }



















//    // fun 2-----------------------------------------
//    public static ArrayList<Shop> searchShop(Customer cus){
//        System.out.print("+ key word: ");
//        String keyword = Main.scn.nextLine();
//        return Searching.searchShop(keyword);
//    }
//
//    public static void showShopAfterSearching(ArrayList<Shop> shops, Customer cus){
//        int count = 0;
//        System.out.println();
//        for (Shop shop : shops) {
//            count ++;
//            System.out.println("-- " + count + " --");
//            System.out.println(
//                    "+ name : " + shop.getNameShop() + "\n" +
//                    "+ phone : " + shop.getPhone() + "\n" +
//                    "+ rating : " + shop.getRating() + "\n" +
//                    "+ hot Item: " + shop.getHotItem().getNameItem()
//            );
//            if(count % 10 == 0 || count == shops.size() - 1){
//                if (count != shops.size() - 1) {
//                    System.out.println();
//                    System.out.print("1: show more");
//                }
//
//            }
//        }
//    }
//
//
//    // fun 1-----------------------------------
//    public static ArrayList<Item> searchItem(Customer cus){
//        System.out.print("+ key word: ");
//        String keyword = Main.scn.nextLine();
////        ArrayList<Item> itemList = Searching.searchItem(keyword, Sort.sortItemBySold(Main.items));
//        return Searching.searchItem(keyword, Main.items);
//    }
//
//    public static void showItemsAfterSearching(ArrayList<Item> items, Customer cus){
//        int count = 0;
//
//        while (count <= items.size()){
//            try{
//                count ++;
//                System.out.println();
//                System.out.println("-- " + count + " --");
//                showInforItem(items.get(count-1));
//                if(count % 10 == 0 || count == items.size() - 1){
//                    if (count != items.size() - 1) {
//                        System.out.println();
//                        System.out.print("1: show more");
//                    }
//                    System.out.println("adasdasds");
//                    whenCount(count, cus, items);
//                }
//            } catch (Exception e){
//                System.out.println("***there are no any item");
//                menuCus(cus);
//            }
//
//        }
//    }
//
//    public static void show(ArrayList<Item> items){
//        for (Item item : items) {
//            System.out.println(item);
//        }
//    }
//
//    public static void whenCount(int count, Customer cus, ArrayList<Item> items){
//        System.out.println("""
//                2: choice an item
//                3: go back
//                """);
//
//        switch ((int) Input.inputCheckNumber(1, 3, "your choice")){
//            case 1 -> {
//                // choice an item
//                // show infor
//                // mua hang
//                // go back home page
//                System.out.println();
//                int index = (int) Input.inputCheckNumber(0, count, "enter the index");
//                Item item = items.get(index - 1);
//
//            }
//            case 2 -> {
//                menuCus(cus);
//            }
//            case 3 -> {
//                return;
//            }
//        }
//    }
//
//    public static void showInforItem(Item item){
//        System.out.println(
//                "+ name : " + item.getNameItem() + "\n" +
//                "+ brand : " + item.getBrand() + "\n" +
//                "+ price : " + item.getPrice() + "\n" +
//                "+ rating : " + item.getRating() + "\n" +
//                "+ shop: " + item.getShop().getNameShop()
//        );
//    }
//
//    public static void whenChoiceItem(Customer cus, Item item){
//        System.out.println();
//        System.out.println("""
//                1: buy the item
//                2: add to cart
//                3: go back to home page
//                """);
//        switch ((int) Input.inputCheckNumber(1, 3, "your choice")){
//            case 1 -> {
//                buyItem(cus, item);
//            }
//            case 2 -> {
//                int amount = (int) Input.inputCheckNumber(0, item.getAmount(), "how much you want");
//                cus.addToCart(new ItemInCart(item, item.getShop(), amount));
//                System.out.println("*** add to cart successfully");
//            }
//            case 3 ->{
//
//            }
//        }
//        menuCus(cus);
//    }
//
//    public static void buyItem(Customer cus, Item item) {
//        System.out.println();
//        int amount = (int) Input.inputCheckNumber(0, item.getAmount(), "how much you want");
//        System.out.println();
//        System.out.println("-- information oder --");
//        System.out.println(
//                "+ name : " + item.getNameItem() + "\n" +
//                "+ size : " + item.getSize() + "\n" +
//                "+ brand : " + item.getBrand() + "\n" +
//                "+ price : " + item.getPrice() + "\n" +
//                "+ amount : " + amount + "\n" +
//                "+ shop: " + item.getShop().getNameShop() + "\n\n" +
//                "-- your information --" + "\n" +
//                "+ address: " + cus.getInformation().getAddress() + "\n" +
//                "+ pay: " + amount * item.getPrice()
//        );
//        askForConfirm(item, cus, amount);
//    }
//
//    public static void askForConfirm(Item item, Customer cus, int amount){
//        System.out.println();
//        System.out.println("""
//                1: confirm the oder
//                2: change address
//                3: cancel
//                """);
//        switch ((int) Input.inputCheckNumber(1, 3, "your choice")) {
//            case 1 -> {
//                System.out.println();
//                cus.addToPurchase(new ItemInPurchase(item, item.getShop(), amount, 1, 2));
//                item.getShop().getOders().add(new Oder(item, amount, cus));
//                System.out.println("go go go");
//            }
//            case 2 -> {
//                System.out.println();
//                Address newAddress = Input.createAddress();
//                cus.getInformation().setAddress(newAddress);
//                askForConfirm(item, cus, amount);
//            }
//            case 3 -> {
//            }
//        }
//
//    }

//    public static void main(String[] args) {
//        Register.createAccount(1);
//        menuCus( (Customer) (Login.login(1)));
//    }
}
