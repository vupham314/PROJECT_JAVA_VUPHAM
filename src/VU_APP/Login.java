package VU_APP;

import VU_CUSTOMER.Customer;
import VU_INFORMATION.Account;
import VU_SUPPLIER.Supplier;
import static VU_MAIN.Main.*;

import java.util.Map;

public class Login {

    public static Customer loginCus(){
        System.out.print("+ account name: ");
        String nameLog = scn.nextLine();

        System.out.print("+ password: ");
        String pass = scn.nextLine();

        try{
            for (Customer cus : cusAccountList) {
                if(cus.getNameLog().equals(nameLog) && cus.getPassword().equals(pass)){
                    return cus;
                }
            }
            throw new Exception("***Incorrect username or password");
        } catch (Exception e) {
            System.out.println(e.toString());
            return loginCus();
        }
    }

    public static Supplier loginSup(){
        System.out.println("-- LOGIN --");

        System.out.print("+ account name: ");
        String nameLog = scn.nextLine();

        System.out.print("+ password: ");
        String pass = scn.nextLine();

        try{
            for (Supplier sup : supAccountList) {
                if(sup.getNameLog().equals(nameLog) && sup.getPassword().equals(pass)){
                    return sup;
                }
            }
            throw new Exception("***Incorrect username or password");
        } catch (Exception e) {
            System.out.println(e.toString());
            return loginSup();
        }
    }

    public static Account login(int role){
        System.out.print("+ account name: ");
        String nameLog = scn.nextLine();

        System.out.print("+ password: ");
        String pass = scn.nextLine();

        try{
            for (Map.Entry<String, Account> entry : accountList.entrySet()) {
                if(entry.getKey().equals(nameLog) && entry.getValue().getPassword().equals(pass)){
                    return entry.getValue();
                }
            }
            throw new Exception("***Incorrect username or password");
        } catch (Exception e) {
            System.out.println(e.toString());
            return login(role);
        }
    }

}
