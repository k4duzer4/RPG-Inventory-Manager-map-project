import factory.GameFactory;
import factory.ItemFlyweightFactory;
import model.*;

public class Main {
    public static void main(String[] args) {
        // Criando jogadores
        Player player1 = GameFactory.createPlayer("Carlos");
        Player player2 = GameFactory.createPlayer("Lucia");

        // Criando itens
        Item sword = ItemFlyweightFactory.getItem("weapon", "Espada", 1, "Comum", "weapon");
        Item armor = ItemFlyweightFactory.getItem("armor", "Armadura", 1, "Rara", "Defesa");
        Item potion = ItemFlyweightFactory.getItem("potion", "Poção de Cura", 3, "Comum", "Cura");

        // Adicionando itens aos inventários
        player1.getInventory().addItem(sword);
        player1.getInventory().addItem(armor);
        player2.getInventory().addItem(potion);

        // Exibindo inventários
        System.out.println("Inventário de " + player1.getName() + ":");
        player1.getInventory().listItems();
        System.out.println("Inventário de " + player2.getName() + ":");
        player2.getInventory().listItems();

        // Usando itens
        sword.use();
        armor.use();
        potion.use();

        // Realizando uma troca de itens
        Mediator mediator = new Mediator();
        mediator.exchangeItem(player1, player2, sword, 1);

        // Exibindo inventários após troca
        System.out.println("Inventário de " + player1.getName() + " após troca:");
        player1.getInventory().listItems();
        System.out.println("Inventário de " + player2.getName() + " após troca:");
        player2.getInventory().listItems();
    }
}
