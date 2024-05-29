# Battleship Game

## Requirements
- JDK 8
- [Maven 3.6.x](https://maven.apache.org/download.cgi)
- [Docker](https://www.docker.com/products/docker-desktop) - Execute `docker run hello-world` to ensure docker is able to pull and run images

## Problem statement
Our aim is to write a Java program that will play the popular game of [Battleship](https://en.wikipedia.org/wiki/Battleship_%28game%29) against the computer.

The game is played on two fields, each 10 X 10 squares. The columns are labeled A-J, and
the rows are labeled 1-10. Each player's fleet of ships consists of one aircraft carrier, one
battleship, one destroyer, one submarine and one cruiser.

![Game in progress image](https://upload.wikimedia.org/wikipedia/commons/thumb/6/65/Battleship_game_board.svg/800px-Battleship_game_board.svg.png "A map of one player's ships from a game in progress")

The size and shape of each ship is as follows:
- Destroyer (2 squares)
- Submarine (3 squares)
- Cruiser (3 squares)
- Battleship (4 squares)
- Aircraft Carrier (5 squares)

Before the game starts, each player secretly places their ships anywhere on their own playing field. Ships cannot overlap one another, but may be placed either vertically or horizontally. The players don't know where the opponent's ships have been allocated.
The first turn is determined by some random means (throwing a die). Players take turns to try to guess the location of the other's ships by naming a square (e.g. F7). The opponent declares the square to be a hit or a miss, depending on whether there is a ship occupying that square. When all the squares occupied by a particular ship have been guessed, the player must announce that that particular ship is sunk. A player keeps track of the hits and misses on a copy of the opponent's field.
The first player to sink all the other's ships is the winner.



## Live test (part 1) instructions
In this exercise we are going to work on modeling the Battleship game. The goal is not to obtain a detailed implementation, but to identify responsibilities and assign them.
This means to propose classes (or interfaces) and identify attributes and methods inside them, applying SOLID principles and proposing what makes sense for you.
In this sense we strongly recommend not to get lost on low level details but to work at a high level.

The Battleship game that we are looking for is defined by these requirements:
- This is a two player game.
- Each player has its own field, which is a 10x10 cells grid.
- There exist the following vessel types with its length:
    - Destroyer (2)
    - Submarine (3)
    - Cruiser (3)
    - Battleship (4)
    - Aircraft carrier (5)
- Each vessel has a certain amount of health points equal to its length.
- Each player starts the game with one vessel of each type.

### Deployment phase
- The first phase of the game is the deployment phase, where each player choose where to place each of their vessels.
- Each player must deploy all their vessels in the board.
    - They must be placed horizontally or vertically in the field.
    - They must fit into the field.
    - They can not overlap with other vessels.
### Battle phase
- Once the deployment phase is finished, the battle phase starts.
- The battle develops by turns.
- On each turn, the player selects a cell (by its coordinates) of the opponent’s field and fires against it.
- If that cell on the opponent’s field is occupied by some vessel, that vessel receives an impact.
    - Game must inform about the impact.
    - If the vessel’s health points reach 0, game inform that the vessel has been sunk. If not, game inform that the vessel has been touched.
- If that cell in the opponent’s field is not occupied by any vessel, game inform ‘water’.
- When any cell (occupied by a vessel or not) is hit, it remains in that state for the rest of the game.
- When all vessels of a player has been sunk, game is finished.

We provide a complete api contract that should orientate you on how the users interact with the application.

We provide as well some code in the service module that you can check to have some ideas.
You can use all this code as a starting point, adapt to it and propose the design for the rest. But you can as well criticize any provided code and propose a different approach
or make any modifications in order to adapt it to your solution. It is up to you to evaluate the pros and cons.

We recommend you to talk to us. We want to know how do you think.


## Build

```
mvn clean package
```

## Docker network creation

```
docker network create battleship_net
```

## Run

```
docker-compose up --build
```

## Postman
[Postman project](docs/postman)
