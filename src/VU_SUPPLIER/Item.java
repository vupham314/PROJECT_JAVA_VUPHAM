package VU_SUPPLIER;

public class Item {
    private String nameItem;
    private String size;
    private String brand;
    private int price;
    private int amount;
    private int sold;
    private int inventory;
    private int rating;
    private int timesRating = 0;
    private Shop shop;

    public Item(Shop shop, String nameItem, String size, String brand, int price, int amount) {
        this.shop = shop;
        this.nameItem = nameItem;
        this.size = size;
        this.brand = brand;
        this.price = price;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Item{" +"\n" +
                "     nameItem='" + nameItem + '\'' + "\n" +
                "     size='" + size + '\'' + "\n" +
                "     brand='" + brand + '\'' +"\n" +
                "     price=" + price +"\n" +
                "     amount=" + amount +"\n" +
                "     sold=" + sold +"\n" +
                "     inventory=" + inventory +"\n" +
                '}';
    }

    public String getNameItem() {
        return nameItem;
    }

    public void setNameItem(String nameItem) {
        this.nameItem = nameItem;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

    public int getInventory() {
        inventory = amount - sold;
        return inventory;
    }

    public void setRating(int rating) {
        this.rating = (this.rating + rating)/2;
    }

    public int getRating() {
        this.timesRating++;
        return rating;
    }

    public int getTimesRating() {
        return timesRating;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }
}
