package com.innopolis.university.bootcamp2016.programmingA.texasholdem;

public class Main {
    public static void main(String[] args) {
        Game game = new Game(50000, new Player("Tamara"), new Player("John"), new Player("Albert"), new Player("Zak"));
        game.startGame();
    }
}
