package model;

import java.util.List;
import java.util.ArrayList;

public class Player {
    private String name;
    private Inventory inventory;
    private List<String> actionLog;

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
        this.actionLog = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void addLog(String action) {
        actionLog.add(action);
    }

    public void showLogs() {
        System.out.println("Action log for " + name + ":");
        actionLog.forEach(System.out::println);
    }
}
