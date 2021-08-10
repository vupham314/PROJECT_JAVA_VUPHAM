package VU_APP;

import VU_CUSTOMER.Customer;
import VU_INFORMATION.Account;
import VU_INFORMATION.Information;
import VU_INFORMATION.Input;
import VU_MAIN.Main;
import VU_SUPPLIER.Shop;
import VU_SUPPLIER.Supplier;

public class Register
{
    public static void registerCus(){

    }

    public static String createNameLog(){
        System.out.print("+ account name: ");
        String nameLog;

        try {
            nameLog = Main.scn.nextLine();
            final String username_regex = "^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){6,30}[a-zA-Z0-9]$";
            if(!nameLog.matches(username_regex)){
                throw new Exception("Invalid character,username length must be greater than 6, containing only " +
                        "characters from a-z, A-Z, or \"_\" and \".\"");
            }

            if(Main.accountList.containsKey(nameLog)){
                throw new Exception("***Account already exists, please try again");
            }
        }catch (Exception e) {
            System.out.println(e.toString());
            return createNameLog();
        }
        return nameLog;
    }

    public static String createPassword(){
        System.out.print("+ password: ");
        String password = Main.scn.nextLine();

        try {
            final String password_regex = "^.*(?=.{6,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$";
            if(!password.matches(password_regex)){
                throw new Exception("***password");
            }
        } catch (Exception e){
            System.out.println(e.toString());
            return createPassword();
        }
        return password;
    }

    public static String inputEmail(){
        System.out.print("+ email: ");
        String email = Main.scn.nextLine();

        try{
//            final String email_regex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\\\.[A-Za-z0-9-]+)*(\\\\.[A-Za-z]{2,})$";
//            if(!email.equals(email_regex)){
//                throw new Exception("***email");
//            }
        } catch (Exception e){
            System.out.println(e.toString());
            return inputEmail();
        }
        return email;
    }
    //"\\b[A-Z0-9._%-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b"
    public static void createAccount(int role){
        System.out.println("-- REGISTER --");

        String nameLog = createNameLog();

        String pass = createPassword();

        String email = inputEmail();

        if(role == 1){
            Customer cus = new Customer(nameLog, pass, email);
            Main.accountList.put(cus.getNameLog(), cus);
            Main.cusAccountList.add(cus);
            cus.setInformation(Input.createInformation());
        } else {
            Shop shop = Input.createShop();
            Main.shops.add(shop);
            Supplier sup = new Supplier(shop, nameLog, pass, email);
            sup.setInformation(Input.createInformation());
            Main.accountList.put(sup.getNameLog(), sup);
            Main.supAccountList.add(sup);
        }

    }
}
