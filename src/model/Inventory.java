package model;

public class Inventory {
   package model;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<String, Item> items = new HashMap<>();

    public void addItem(Item item) {
        items.merge(item.getName(), item, (existingItem, newItem) -> {
            existingItem.setQuantity(existingItem.getQuantity() + newItem.getQuantity());
            return existingItem;
        });
    }

    public void removeItem(String itemName, int quantity) {
        Item item = items.get(itemName);
        if (item != null && item.getQuantity() >= quantity) {
            item.setQuantity(item.getQuantity() - quantity);
            if (item.getQuantity() == 0) {
                items.remove(itemName);
            }
        } else {
            System.out.println("Item not available in sufficient quantity.");
        }
    }

    public void listItems() {
        for (Item item : items.values()) {
            System.out.println("Item: " + item.getName() + ", Quantity: " + item.getQuantity() +
                    ", Rarity: " + item.getRarity() + ", Type: " + item.getType());
        }
    }

    public boolean hasItem(String itemName) {
        return items.containsKey(itemName);
    }
}