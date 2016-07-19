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

    public enum GameStage {
        START, Preflop, Flop, Turn, River, END;
    }

    public Game(int blind, Player... players) {
        this.blind = blind;
        if (players.length != 4) {
            throw new IllegalArgumentException("Player amount not equal to 4");
        }
        this.players = new LinkedList<>();
        for (Player p : players)
            this.players.add(p);
        currStage = GameStage.START;
    }

    public void initializeGame() {
        deck = new Deck();
        deck.shuffleDeck();
        call = this.blind;
        currPlayers = new LinkedList<>(this.players);
        button = this.players.getFirst();
        tableCards = new ArrayList<>();
        currStage = GameStage.Preflop;
    }

    public GameStage doStage() {
        switch (currStage) {
            case START:
                initializeGame();
                break;
            case Preflop:
                preflop();
                break;
            case Flop:
                flop();
                break;
            case Turn:
                turn();
                break;
            case River:
                river();
                break;
            default:
                break;
        }
        return currStage;
    }

    public void preflop() {

        for (Player player : currPlayers) {
            player.setCards(new Card[]{deck.pullCard(), deck.pullCard()});
        }
        currStage = Flop;
    }

    public void flop() {
        for (Player player : currPlayers)
            if (player != null)
                switch (player.makeDecision(this)) {
                    case FOLD:
                        System.out.println(player + " FOLDS");
                        break;
                    case CALL:
                        System.out.println(player + " CALLS");
                        break;
                    case RAISE:
                        System.out.println(player + " RAISES");
                        break;
                    default:
                        System.out.println("DUNNO WHAT DOES " + player);
                }
        currStage = Turn;
    }

    public void turn() {
        currStage = River;
    }

    public void river() {
        currStage = River;
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
