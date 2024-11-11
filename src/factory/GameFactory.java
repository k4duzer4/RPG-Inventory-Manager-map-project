package factory;

import model.*;

public class GameFactory {
    public static Item createItem(String type, String name, int quantity, String rarity, String itemType) {
        switch (type.toLowerCase()) {
            case "weapon":
                return new Weapon(name, quantity, rarity, itemType);
            case "potion":
                return new Potion(name, quantity, rarity, itemType);
            case "armor":
                return new Armor(name, quantity, rarity, itemType);
            case "object":
                return new ObjectItem(name, quantity, rarity, itemType);
            default:
                throw new IllegalArgumentException("Tipo de item desconhecido: " + type);
        }
    }

    public static Player createPlayer(String name) {
        return new Player(name);
    }
}
