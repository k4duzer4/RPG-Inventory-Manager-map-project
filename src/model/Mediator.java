package model;

import factory.GameFactory;
import factory.ItemFlyweightFactory;

public class Mediator {
    public void exchangeItem(Player from, Player to, String itemName, int quantity) {
        Item item = from.getInventory().getItem(itemName);
        if (item != null && item.getQuantity() >= quantity) {
            from.getInventory().removeItem(itemName, quantity);
            Item transferItem = ItemFlyweightFactory.getItem(item.getType(), item.getName(), quantity, item.getRarity(), item.getType());
            to.getInventory().addItem(transferItem);
            System.out.println("Troca concluída: " + item.getName() + " x" + quantity + " de " + from.getName() + " para " + to.getName());
        } else {
            System.out.println(from.getName() + " não possui " + itemName + " suficiente para a troca.");
        }
    }
}
