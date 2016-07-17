package com.innopolis.university.bootcamp2016.programmingA.texasholdem;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Game {
    Deck deck;
    LinkedList<Player> players;
    LinkedList<Player> currPlayers;
    Player currPlayer;
    Player button;
    ArrayList<Card> tableCards;
    final int blind;
    int call;
    int bank;

    public Game(int blind, Player ... players){
        this.blind = blind;
        call = this.blind;
        this.players = new LinkedList<>();
        if(players.length != 4){
            throw new IllegalArgumentException("Player amount not equal to 4");
        }
        for(Player p : players){
            this.players.add(p);
        }
        button = this.players.getFirst();
        currPlayer = button;
        tableCards = new ArrayList<Card>();
    }



    boolean startGame(){
        currPlayer.setMoney(currPlayer.getMoney() - blind/2);
        nextTurn();
        currPlayer.setMoney(currPlayer.getMoney() - blind);
        for(Player player: currPlayers){
            deck.pop();
            deck.pop();
        }
        //
        return true;
    }

    private void nextTurn() {
        currPlayer
    }

}
