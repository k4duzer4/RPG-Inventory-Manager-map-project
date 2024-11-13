package model;

import factory.GameFactory;

public class Mediator {
    public void exchangeItem(Player from, Player to, Item item, int quantity) {
        if (from.getInventory().hasItem(item.getName())) {
            from.getInventory().removeItem(item.getName(), quantity);
            Item transferItem = GameFactory.createItem(item.getType(), item.getName(), quantity, item.getRarity(), item.getType());
            to.getInventory().addItem(transferItem);
            System.out.println("Troca concluída: " + item.getName() + " x" + quantity + " de " + from.getName() + " para " + to.getName());
        } else {
            System.out.println(from.getName() + " não tem " + item.getName() + " suficiente no inventário.");
        }
    }
}
