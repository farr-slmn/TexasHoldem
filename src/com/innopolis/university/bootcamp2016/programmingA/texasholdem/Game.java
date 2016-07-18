package com.innopolis.university.bootcamp2016.programmingA.texasholdem;


import java.util.*;

public class Game {
    private final int blind;
    private Deck deck;
    private LinkedList<Player> players;
    private LinkedList<Player> currPlayers;
    private Player button;
    private ArrayList<Card> tableCards;
    private int call;
    private int bank;

    public Game(int blind, Player ... players){
        this.blind = blind;
        deck = new Deck();
        call = this.blind;
        if(players.length != 4){
            throw new IllegalArgumentException("Player amount not equal to 4");
        }
        this.players = new LinkedList<>();
        for(Player p : players)
            this.players.add(p);
        currPlayers = new LinkedList<>(this.players);
        button = this.players.getFirst();
        tableCards = new ArrayList<>();
    }



    public boolean startGame(){
        nextTurn();
        currPlayers.getFirst().setMoney(currPlayers.getFirst().getMoney() - blind/2);
        nextTurn();
        currPlayers.getFirst().setMoney(currPlayers.getFirst().getMoney() - blind/2);
        nextTurn();
        preflop();
        for(Iterator<Player> li = currPlayers.iterator(); li.hasNext();) {
            Player tmp = li.next();
            switch (tmp.makeDecision(this)){
                case FOLD:
                    System.out.println(tmp+" FOLDS");
                    li.remove();
                    break;
                case CALL:
                    System.out.println(tmp+" CALLS");
                    break;
                case RAISE:
                    System.out.println(tmp+" RAISES");
                    break;
                default:
                    System.out.println("DUNNO WHAT DOES "+tmp);
            }
        }
        tableCards.add(deck.pop());
        tableCards.add(deck.pop());
        tableCards.add(deck.pop());
        return true;
    }

    private void nextTurn() {
        if(!currPlayers.offerLast(currPlayers.removeFirst()))
            System.err.println("could not change turn");
    }

    private void preflop(){
        for(Player player: currPlayers){
            player.setCards(new Card[]{deck.pop(), deck.pop()});
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
