package model;

public class Weapon implements Item {
        private String name;
        private int quantity;
        private String rarity;
        private String type;

        public Weapon(String name, int quantity, String rarity, String type) {
            this.name = name;
            this.quantity = quantity;
            this.rarity = rarity;
            this.type = type;
        }
    
        @Override
        public void use() {
            System.out.println("Using weapon for attack.");
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
    

