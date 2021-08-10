package VU_APP;
import VU_SUPPLIER.Item;
import VU_SUPPLIER.Shop;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import static VU_MAIN.Main.*;
import static VU_MAIN.Main.shops;

public class Searching {

    // tìm kiếm shop theo tên shop
    public static ArrayList<Shop> searchShop(@NotNull String keyWord){
        ArrayList<Shop> searchResult = new ArrayList<>();

        for (Shop shop : shops) {
            if(shop.getNameShop().toLowerCase().contains(keyWord.toLowerCase()) || keyWord.toLowerCase().contains(shop.getNameShop().toLowerCase())){
                searchResult.add(shop);
            }
        }

        return searchResult;
    }

    // ??????????
    public static int searchInShop(Item item){
        for (Shop shop : shops) {
            if (!shop.getItemList().contains(item)){
                continue;
            }
            for (Item itemCurrent : shop.getItemList()) {
                return shop.getItemList().indexOf(item);
            }
        }
        return -1;
    }

    // tìm kiếm Item theo tên item
    public static ArrayList<Item> searchItem(String keyWord, ArrayList<Item> listItem){
        ArrayList<Item> searchResult = new ArrayList<>();

        for (Item item : listItem) {
            if(item.getNameItem().toLowerCase().contains(keyWord.toLowerCase()) || keyWord.toLowerCase().contains(item.getNameItem().toLowerCase())){
                searchResult.add(item);
            }
        }
        return  searchResult;
    }

}
