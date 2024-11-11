package model;

public class Mediator {
    public void exchangeItem(Player from, Player to, Item item, int quantity) {
        if (from.getInventory().hasItem(item.getName())) {
            from.getInventory().removeItem(item.getName(), quantity);
            Item transferItem = new Item(item.getName(), quantity, item.getRarity(), item.getType());
            to.getInventory().addItem(transferItem);
            System.out.println("Troca concluida: " + item.getName() + " x" + " de " + from.getName() + " para " + to.getName());
        } else {
            System.out.println(from.getName() + " não existe mais " + item.getName() + " no inventario" );
        }
    }
}
