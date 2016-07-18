package com.innopolis.university.bootcamp2016.programmingA.texasholdem;


import java.lang.reflect.Method;
import java.util.*;

import static com.innopolis.university.bootcamp2016.programmingA.texasholdem.Game.GameStage.*;

public class Game {
    private final int blind;
    private Deck deck;
    private LinkedList<Player> players;
    private LinkedList<Player> currPlayers;
    private Player button;
    private ArrayList<Card> tableCards;
    private int call;
    private int bank;
    GameStage currStage;

    enum GameStage{
        Preflop, Flop, Turn, River, END;
    }

    public Game(int blind, Player ... players){
        this.blind = blind;
        if(players.length != 4){
            throw new IllegalArgumentException("Player amount not equal to 4");
        }
        this.players = new LinkedList<>();
        for(Player p : players)
            this.players.add(p);
    }

    public void initializeGame(){
        deck = new Deck();
        deck.shuffleDeck();
        call = this.blind;
        currPlayers = new LinkedList<>(this.players);
        button = this.players.getFirst();
        tableCards = new ArrayList<>();
        currStage = GameStage.Preflop;
    }

    public GameStage doStage(){
        switch (currStage){
            case Preflop:
                preflop();
                currStage = Flop;
                break;
            case Flop:
                flop();
                currStage = Turn;
                break;
            case Turn:
                turn();
                currStage = River;
                break;
            case River:
                river();
                currStage = END;
                break;
            default:
                break;
        }
        return currStage;
    }

    public void preflop(){
        for(Player player: currPlayers){
            player.setCards(new Card[]{deck.pullCard(), deck.pullCard()});
        }
    }

    public void flop(){
        for(Player player : currPlayers)
        switch (player.makeDecision(this)){
            case FOLD:
                System.out.println(player+" FOLDS");
                break;
            case CALL:
                System.out.println(player+" CALLS");
                break;
            case RAISE:
                System.out.println(player+" RAISES");
                break;
            default:
                System.out.println("DUNNO WHAT DOES "+player);
        }
    }

    public void turn(){

    }

    public void river(){

    }

    public ArrayList<Card> getTableCards() {
        return tableCards;
    }

    public LinkedList<Player> getCurrPlayers() {
        return currPlayers;
    }

    public LinkedList<Player> getPlayers() {
        return players;
    }

    public Player getCurrPlayer() {
        return currPlayers.getFirst();
    }

    public Player getButton() {
        return button;
    }

    public int getCall() {
        return call;
    }

    public int getBank() {
        return bank;
    }

    public int getBlind() {
        return blind;
    }

}
