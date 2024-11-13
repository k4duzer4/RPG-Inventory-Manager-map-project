import model.*;
import factory.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Player player1 = null, player2 = null;

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Criar Jogador");
            System.out.println("2. Ver Inventários");
            System.out.println("3. Criar Itens");
            System.out.println("4. Trocar Itens");
            System.out.println("5. Usar Itens");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consumir a quebra de linha

            switch (choice) {
                case 1:
                    if (player1 == null) {
                        System.out.print("Digite o nome do Jogador 1: ");
                        String name1 = scanner.nextLine();
                        player1 = GameFactory.createPlayer(name1);
                        System.out.println("Jogador 1 criado: " + name1);
                    } else if (player2 == null) {
                        System.out.print("Digite o nome do Jogador 2: ");
                        String name2 = scanner.nextLine();
                        player2 = GameFactory.createPlayer(name2);
                        System.out.println("Jogador 2 criado: " + name2);
                    } else {
                        System.out.println("Os dois jogadores já foram criados!");
                    }
                    break;
                case 2:
                    if (player1 != null) {
                        System.out.println("Inventário de " + player1.getName() + ":");
                        player1.getInventory().listItems();
                    }
                    if (player2 != null) {
                        System.out.println("Inventário de " + player2.getName() + ":");
                        player2.getInventory().listItems();
                    }
                    break;
                case 3:
                    if (player1 == null || player2 == null) {
                        System.out.println("Crie os jogadores primeiro!");
                        break;
                    }
                    System.out.println("Escolha um item para criar:");
                    System.out.println("1. Espada");
                    System.out.println("2. Escudo");
                    System.out.println("3. Poção de Cura");
                    System.out.print("Escolha um número: ");
                    int itemChoice = scanner.nextInt();
                    scanner.nextLine();  // Consumir a quebra de linha

                    Item item = null;
                    switch (itemChoice) {
                        case 1:
                            item = ItemFlyweightFactory.getItem("weapon", "Espada", 1, "Comum", "weapon");
                            break;
                        case 2:
                            item = ItemFlyweightFactory.getItem("armor", "Escudo", 1, "Raro", "armor");
                            break;
                        case 3:
                            item = ItemFlyweightFactory.getItem("potion", "Poção de Cura", 1, "Comum", "potion");
                            break;
                        default:
                            System.out.println("Opção inválida!");
                            continue;
                    }

                    System.out.println("Escolha para quem adicionar o item:");
                    System.out.println("1. " + player1.getName());
                    System.out.println("2. " + player2.getName());
                    int addChoice = scanner.nextInt();
                    scanner.nextLine();  // Consumir a quebra de linha

                    if (addChoice == 1) {
                        player1.getInventory().addItem(item);
                        System.out.println("Item adicionado ao inventário de " + player1.getName());
                    } else if (addChoice == 2) {
                        player2.getInventory().addItem(item);
                        System.out.println("Item adicionado ao inventário de " + player2.getName());
                    } else {
                        System.out.println("Opção inválida!");
                    }
                    break;
                case 4:
                    if (player1 == null || player2 == null) {
                        System.out.println("Crie os jogadores primeiro!");
                        break;
                    }
                    System.out.println("Escolha o item a ser trocado entre jogadores:");
                    System.out.println("1. " + player1.getName());
                    System.out.println("2. " + player2.getName());
                    int fromChoice = scanner.nextInt();
                    scanner.nextLine();  // Consumir a quebra de linha

                    Player fromPlayer = fromChoice == 1 ? player1 : player2;
                    Player toPlayer = fromChoice == 1 ? player2 : player1;

                    System.out.println("Escolha o item para trocar:");
                    fromPlayer.getInventory().listItems();
                    System.out.print("Digite o nome do item a trocar: ");
                    String itemName = scanner.nextLine();
                    System.out.print("Digite a quantidade: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine();  // Consumir a quebra de linha

                    Item itemToTrade = fromPlayer.getInventory().hasItem(itemName) ? new ObjectItem(itemName, quantity, "Comum", "object") : null;

                    if (itemToTrade != null) {
                        Mediator mediator = new Mediator();
                        mediator.exchangeItem(fromPlayer, toPlayer, itemToTrade, quantity);
                    } else {
                        System.out.println("Item não encontrado!");
                    }
                    break;
                case 5:
                    if (player1 == null || player2 == null) {
                        System.out.println("Crie os jogadores primeiro!");
                        break;
                    }
                    System.out.println("Escolha o item para usar:");
                    System.out.println("1. " + player1.getName());
                    System.out.println("2. " + player2.getName());
                    int useChoice = scanner.nextInt();
                    scanner.nextLine();  // Consumir a quebra de linha

                    Player usePlayer = useChoice == 1 ? player1 : player2;

                    System.out.println("Escolha o item para usar:");
                    usePlayer.getInventory().listItems();
                    System.out.print("Digite o nome do item a usar: ");
                    String itemNameToUse = scanner.nextLine();

                    Item itemToUse = usePlayer.getInventory().hasItem(itemNameToUse) ? new ObjectItem(itemNameToUse, 1, "Comum", "object") : null;

                    if (itemToUse != null) {
                        itemToUse.use();
                    } else {
                        System.out.println("Item não encontrado!");
                    }
                    break;
                case 6:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
