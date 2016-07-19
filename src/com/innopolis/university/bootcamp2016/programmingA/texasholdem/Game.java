package com.innopolis.university.bootcamp2016.programmingA.texasholdem;


import java.lang.reflect.Method;
import java.util.*;
import java.util.function.Predicate;

import static com.innopolis.university.bootcamp2016.programmingA.texasholdem.Game.GameStage.*;

public class Game {
    private final int blind;
    private Deck deck;
    private LinkedList<Player> players;
    private LinkedList<Player> currPlayers;
    private ArrayList<Card> tableCards;
    private int buttonId;
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
        buttonId = -1;
    }

    public void initializeGame() {
        if (buttonId == players.size() - 1) {
            buttonId = 0;
        } else
            buttonId++;
        Player button = players.get(buttonId);
        deck = new Deck();
        deck.shuffleDeck();
        call = this.blind;
        bank = 0;
        players.removeIf(player -> {
            int index = players.indexOf(player);
            if (index > -1) {
                if (buttonId == index) {
                    return true;
                }
                if (Utils.nextId(players, buttonId) == index) {
                    return player.getMoney() >= blind / 2;
                }
                if (Utils.nextId(players, buttonId + 1) == index) {
                    return player.getMoney() >= blind;
                }
                return player.getMoney() >= call;
            }
            return player.getMoney() > 10;
        });
        buttonId = players.indexOf(button);
        currPlayers = new LinkedList<>(players);
        for (int i = 0; i < buttonId; i++)
            Utils.passTurn(currPlayers);
        tableCards = new ArrayList<>();
        currStage = GameStage.Preflop;
    }

    public GameStage runNextStage() {
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
        Utils.passTurn(currPlayers);
        currPlayers.getFirst().setMoney(currPlayers.getFirst().getMoney() - blind / 2);
        bank += blind / 2;
        Utils.passTurn(currPlayers);
        currPlayers.getFirst().setMoney(currPlayers.getFirst().getMoney() - blind);
        bank += blind;
        for (Player player : currPlayers) {
            player.setCards(new Card[]{deck.pullCard(), deck.pullCard()});
        }
        for (Player player : currPlayers)
            if (player != null)
                processDecision(player);
        currStage = Flop;
    }

    public void flop() {
        for (Player player : currPlayers)
            if (player != null)
                processDecision(player);
        currStage = Turn;
    }

    public void turn() {
        currStage = River;
    }

    public void river() {
        currStage = END;
    }

    public void processDecision(Player player){
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

    public int getButtonId() {
        return buttonId;
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
