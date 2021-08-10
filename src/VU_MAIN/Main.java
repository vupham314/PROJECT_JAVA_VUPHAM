package VU_MAIN;

import VU_APP.Login;
import VU_APP.Register;
import VU_CUSTOMER.Customer;
import VU_CUSTOMER.WORK_FLOW_CUS;
import VU_INFORMATION.Account;
import VU_INFORMATION.Input;
import VU_SUPPLIER.Item;
import VU_SUPPLIER.Shop;
import VU_SUPPLIER.Supplier;
import VU_SUPPLIER.WORK_FLOW_SHOP;
import VU_TRADE.Trade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static final Scanner scn = new Scanner(System.in);

    public static final HashMap<String, Account> accountList = new HashMap<>();
    public static final ArrayList<Customer> cusAccountList = new ArrayList<>();
    public static final ArrayList<Supplier> supAccountList = new ArrayList<>();
    public static final ArrayList<Trade> trades = new ArrayList<>();
    public static final ArrayList<Shop> shops = new ArrayList<>();
    public static final ArrayList<Item> items = new ArrayList<>();

    public static void menu(){
        System.out.println("-- ROLE --");
        System.out.println("""
                1: Customer
                2: Supplier""");
        switch ( (int) Input.inputCheckNumber(1, 2, "your role")){
            case 1 ->{
                menuAccount(1);
            }
            case 2 ->{
                menuAccount(2);
            }
        }
    }

    public static void menuAccount(int role){
        System.out.println("-- ACCOUNT --");
        System.out.println("""
                1: Login
                2: Register
                """);
        switch ((int) Input.inputCheckNumber(1, 2, "your choice")){
            case 1 -> {

                if(role == 1){
                    Account account = login(role);
                    WORK_FLOW_CUS.menuCus((Customer) account);
                } else {
                    Account account = login(role);
                    WORK_FLOW_SHOP.menuShop(((Supplier) account).getShop());
                }

            }
            case 2 -> {
                register(role);
                System.out.println("----- register successfully");
                menu();
            }
        }
    }

    public static void register(int role){
        Register.createAccount(role);
    }

    public static Account login(int role){
        if(role == 1){
            return Login.loginCus();
        } else {
            return Login.loginSup();
        }
    }
    public static void main(String[] args) {
        menu();
    }

}
