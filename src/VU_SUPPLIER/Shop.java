package VU_SUPPLIER;

import VU_APP.Sort;

import java.util.ArrayList;

public class Shop {
    private Supplier sup;
    private String nameShop;
    private String phone;
    private String email;

    private final ArrayList<Item> itemList = new ArrayList<>();

    public ArrayList<Oder> getOders() {
        return oders;
    }

    private final ArrayList<Oder> oders = new ArrayList<>();

    public Shop(String nameShop, String phone, String email) {
        this.nameShop = nameShop;
        this.phone = phone;
        this.email = email;
    }



    public Item getHotItem(){
        return Sort.sortItemBySold(this.itemList).get(0);
    }

    public double getRating(){
        double rating = 0;
        for (Item item : itemList) {
            rating += item.getRating();
        }
        return rating/itemList.size();
    }

    public void showOder(){
        int count = 0;
        for (Oder oder : oders) {
            System.out.println("-- " + count + " --");
            System.out.println(oder);
            count ++;
        }
    }

    @Override
    public String toString() {
        return "Shop{" +
                "    nameShop='" + nameShop + '\'' + "\n" +
                "    phone='" + phone + '\'' + "\n" +
                "    email='" + email + '\'' + "\n" +
                '}';
    }

    public ArrayList<Item> getItemList() {
        return itemList;
    }

    public Supplier getSup() {
        return sup;
    }

    public void setSup(Supplier sup) {
        this.sup = sup;
    }

    public String getNameShop() {
        return nameShop;
    }

    public void setNameShop(String nameShop) {
        this.nameShop = nameShop;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
