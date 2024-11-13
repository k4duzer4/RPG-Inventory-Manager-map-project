package model;


public class Armor implements Item {
    private String name;
    private int quantity;
    private String rarity;
    private String type;

    public Armor(String name, int quantity, String rarity, String type) {
        this.name = name;
        this.quantity = quantity;
        this.rarity = rarity;
        this.type = type;
    }

    @Override
    public void use() {
        System.out.println("Usando escudo para defesa.");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String getRarity() {
        return rarity;
    }

    @Override
    public String getType() {
        return type;
    }
}
