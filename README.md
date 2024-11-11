#RPG Inventory Manager

## Descrição
**EpicLoot-RPG-Inventory-Manager-map-project** é um sistema de gerenciamento de inventário para RPGs de mesa que utiliza padrões de design como **Factory**, **Flyweight** e **Mediator** para otimizar a criação, uso e troca de itens entre jogadores. O sistema permite o gerenciamento de itens como armas, poções, armaduras e objetos, além de possibilitar interações entre jogadores por meio de trocas.

## Objetivo
Este projeto tem como objetivo implementar um sistema eficiente e modular de inventário para jogos de RPG, proporcionando uma melhor gestão de recursos e itens durante a partida. O projeto utiliza técnicas de design de software para garantir que o código seja flexível, reutilizável e fácil de expandir.

## Tecnologias Utilizadas
- **Java**: Linguagem de programação principal.
- **Padrões de Design**:
  - **Factory**: Para criação de itens e jogadores.
  - **Flyweight**: Para economizar memória ao reutilizar objetos comuns (itens repetidos).
  - **Mediator**: Para gerenciar as trocas de itens entre jogadores.
- **Logger**: Para registrar as ações dos jogadores e eventos importantes do jogo.

## Estrutura do Projeto
O projeto é dividido em várias classes, cada uma com uma responsabilidade específica. A estrutura básica do projeto inclui:

- **Item.java**: Interface para os itens do jogo.
- **Weapon.java, Potion.java, Armor.java, ObjectItem.java**: Classes que representam diferentes tipos de itens.
- **Inventory.java**: Gerencia o inventário dos jogadores.
- **Player.java**: Representa um jogador no jogo.
- **Mediator.java**: Coordena as trocas de itens entre jogadores.
- **GameFactory.java**: Fábrica para criar itens e jogadores.
- **ItemFlyweightFactory.java**: Fábrica que utiliza o padrão Flyweight para economizar memória.
- **Logger.java**: Registra ações importantes no jogo.

## Como Usar
1. Clone o repositório:
   ```bash
   git clone https://github.com/usuario/EpicLoot-RPG-Inventory-Manager-map-project.git
   ```

2. Compile e execute o código:
   ```bash
   javac *.java
   java Main
   ```

3. Interaja com o sistema de inventário e explore as funcionalidades de criação de itens e trocas entre jogadores.

## Objetivo Acadêmico
Este projeto foi desenvolvido para a obtenção de nota na cadeira de **Métodos Avançados de Programação** da **Universidade Estadual da Paraíba** (UEPB). Ele busca aplicar conceitos avançados de programação e padrões de design em um contexto prático.

## Licença
Este projeto está licenciado sob a [MIT License](LICENSE).
