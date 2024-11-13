package factory;

import model.*;

import java.util.HashMap;
import java.util.Map;

public class ItemFlyweightFactory {
    private static final Map<String, Item> commonItems = new HashMap<>();

    public static Item getItem(String type, String name, int quantity, String rarity, String itemType) {
        String key = type + "-" + name + "-" + rarity + "-" + itemType;
        Item item = commonItems.get(key);
        if (item == null) {
            item = GameFactory.createItem(type, name, quantity, rarity, itemType);
            commonItems.put(key, item);
            System.out.println("Item criado: " + name);
        } else {
            System.out.println("Reutilizando item: " + name);
        }
        return item;
    }

    public static void clearItems() {
        commonItems.clear();
    }
}