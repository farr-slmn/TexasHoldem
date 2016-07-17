package com.innopolis.university.bootcamp2016.programmingA.texasholdem;


import java.util.LinkedList;

public class Game {
    Deck deck;
    LinkedList<Player> players;
    Player currPlayer;
    int bank;

    public Game(int bank, Player ... players){
        this.players = new LinkedList<Player>();
        if(players.length != 4){
            throw new IllegalArgumentException("Player amount not equal to 4");
        }
        for(Player p : players){
            this.players.add(p);
        }

        this.bank = bank;
    }

    boolean newGame(){
        return true;
    }

}
