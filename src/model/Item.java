package model;

public interface Item {
    void use();
    String getName();
    int getQuantity();
    void setQuantity(int quantity);
    String getRarity();
    String getType();
}

