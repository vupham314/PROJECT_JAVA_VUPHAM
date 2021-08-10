package VU_INFORMATION;

import VU_MAIN.Main;
import VU_SUPPLIER.Item;
import VU_SUPPLIER.Shop;
import VU_SUPPLIER.Supplier;

import java.time.LocalDate;

import static VU_APP.Register.inputEmail;
import static VU_MAIN.Main.scn;


public abstract class Input {

    public static Address createAddress(){
        System.out.println();
        System.out.println("- Address -");
        System.out.println();
        System.out.print("+ city: ");
        String city = scn.nextLine();

        System.out.print("+ district: ");
        String district = scn.nextLine();

        System.out.print("+ ward: ");
        String ward = scn.nextLine();

        System.out.print("+ detailed address: ");
        String detailed = scn.nextLine();

        return new Address(city, district, ward, detailed);
    }

    public static FullName createFullName(){
        System.out.println();
        System.out.println("- full name -");
        System.out.println();
        System.out.print("first name: ");
        String firstName = scn.nextLine();

        System.out.print("surname: ");
        String surname = scn.nextLine();

        return new FullName(firstName, surname);
    }

    public static LocalDate createDate(){
        System.out.println();
        System.out.println("-- day of birth --");
        LocalDate dob;

        try{
            System.out.print("+ year: ");
            int year = Integer.parseInt(scn.nextLine());

            System.out.print("+ month: ");
            int month = Integer.parseInt(scn.nextLine());

            System.out.print("+ day: ");
            int day = Integer.parseInt(scn.nextLine());

            dob = LocalDate.of(year, month, day);
            if (dob.isAfter(LocalDate.now())){
                throw new Exception("***the day is invalid, please try again");
            }
        } catch (Exception e){
            System.out.println(e.toString());
            return createDate();
        }
        return dob;
    }

    public static double inputCheckNumber(double x, double y, String text){
        System.out.println();
        System.out.print("+ " + text + ": ");
        double mark;
        try{
            mark = Double.parseDouble(scn.nextLine());
            if(mark < x || mark > y){
                throw new Exception("***invalid value, valid value must be between " + x +" and " + y);
            }
        } catch (Exception e){
            System.out.println(e.toString());
            return inputCheckNumber(x, y, text);
        }
        return mark;
    }

    public static Profile createProfile(){
        System.out.println();
        System.out.println("-- profile --");
        FullName fullName = createFullName();

        int gender = (int) inputCheckNumber(1, 3, "gender(1: male, 2: female, 3: LGBT)");

        System.out.print("+ phone: ");
        String phone = scn.nextLine();

        String email = inputEmail();

        LocalDate dob = createDate();

        return new Profile(fullName, gender, phone, email, dob);
    }

    public static Information createInformation(){
        System.out.println();
        System.out.println("-- information --");
        return new Information(createProfile(), createAddress());
    }

    public static Item createItem(Shop shop){
        System.out.println();
        System.out.println("- Item -");
        System.out.println();
        try {
            System.out.print("+ name item: ");
            String nameItem = scn.nextLine();

            System.out.print("+ size: ");
            String size = scn.nextLine();

            System.out.print("+ brand: ");
            String brand = scn.nextLine();

            System.out.print("+ price: ");
            int price = Integer.parseInt(scn.nextLine());

            System.out.print("+ amount: ");
            int amount = Integer.parseInt(scn.nextLine());

            return new Item(shop,nameItem, size, brand, price, amount);
        } catch (Exception e){
            System.out.println(e.toString());
            return createItem(shop);
        }

    }

    public static Shop createShop(){
        System.out.println();
        System.out.println("-- Shop --");
        System.out.print("+ name shop: ");
        String name = scn.nextLine();

        System.out.print("+ phone: ");
        String phone = scn.nextLine();

        System.out.print("+ email: ");
        String email = scn.nextLine();

        return new Shop(name, phone, email);
    }

}
