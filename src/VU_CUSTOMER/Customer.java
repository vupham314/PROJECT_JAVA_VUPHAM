package VU_CUSTOMER;

import VU_INFORMATION.Account;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Customer extends Account{

    // mặt hàng trong đơn mua
    private final ArrayList<ItemInPurchase> purchase = new ArrayList<>();

    // mặt hàng trong giỏ hàng
    private final ArrayList<ItemInCart> cart = new ArrayList<>();

    public ArrayList<ItemInPurchase> getPurchase() {
        return purchase;
    }

    public void showPurchase(){
        int count = 0;
        for (ItemInPurchase item: purchase) {
            System.out.println("-- " + count + " --");
            System.out.println(item);
            System.out.println();
        }
    }

    public void showCart(){
        int count = 0;
        for (ItemInCart item: cart) {
            System.out.println("-- " + count + " --");
            System.out.println(item);
            System.out.println();
        }
    }

    public void sortPurChase(){
        Collections.sort(purchase, new Comparator<ItemInPurchase>() {
            @Override
            public int compare(ItemInPurchase sv1, ItemInPurchase sv2) {
                if (sv1.getStatusTransport().compareTo(sv2.getStatusTransport()) < 0) {
                    return 1;
                } else {
                    if (sv1.getStatusTransport().compareTo(sv2.getStatusTransport()) == 0) {
                        return 0;
                    } else {
                        return -1;
                    }
                }
            }
        });
    }

    @Override
    public String toString() {
        return  super.toString();
    }

    public void addToPurchase(ItemInPurchase item){
        purchase.add(item);
    }

    public void addToCart(ItemInCart item){
        cart.add(item);
    }

    public ArrayList<ItemInCart> getCart() {
        return cart;
    }

    public Customer(String nameLog, String password, String email) {
        super(nameLog, password, email);
    }

}