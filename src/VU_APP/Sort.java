package VU_APP;

import VU_SUPPLIER.Item;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Comparator;

import static VU_MAIN.Main.*;

public class Sort {
    public static ArrayList<Item> sortItemBySold(@NotNull ArrayList<Item> list){
        list.sort(new Comparator<Item>() {
            @Override
            public int compare(Item A, Item B) {
                return Integer.compare(A.getAmount(), B.getAmount());
            }
        });
        return list;
    }

}
