package com.innopolis.university.bootcamp2016.programmingA.texasholdem;


import java.util.*;

import static com.innopolis.university.bootcamp2016.programmingA.texasholdem.Game.GameStage.*;
import static com.innopolis.university.bootcamp2016.programmingA.texasholdem.CombinationRank.*;

public class Game {
    final int blind;
    public Deck deck;
    public LinkedList<Player> players;
    public LinkedList<Player> currPlayers;
    public Iterator<Player> currPlayersIterator;
    public ArrayList<Card> tableCards;
    int buttonId;
    int call;
    int bank;
    ArrayList<Player> lastWinners;
    GameStage currStage;

    public enum GameStage {
        START, Preflop, Flop, Turn, River, END
    }

    public Game(int blind, Player... players) {
        this.blind = blind;
        if (players.length < 2) {
            throw new IllegalArgumentException("Player amount is less than 2");
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
            if (player.getMoney() == 0) {
                if (buttonId == index) {
                    buttonId = Utils.nextId(players, buttonId);
                }
                return true;
            }
            if (buttonId == index) {
                return false;
            }
            if (Utils.nextId(players, buttonId) == index) {
                return player.getMoney() < blind / 2;
            }
            if (Utils.nextId(players, buttonId + 1) == index) {
                return player.getMoney() < blind;
            }
            return player.getMoney() < blind;

        });
        if (players.size() < 2) {
            currStage = GameStage.END;
            return;
        }
        buttonId = players.indexOf(button);
        currPlayers = new LinkedList<>(players);
        for (int i = 0; i < buttonId; i++) {
            currPlayers.add(currPlayers.removeFirst());
        }

        //OUTPUT START
        for (Player p : players)
            System.out.println(p + " [Bank: " + p.getMoney() + "]");
        System.out.println();
        //OUTPUT END

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
            case END:
                doWinner();
                break;
            default:
                break;
        }
        return currStage;
    }

    public void preflop() {
        //OUTPUT START
        System.out.println(currPlayers.getFirst() + " is a dealer");
        //OUTPUT END

        currPlayers.add(currPlayers.removeFirst());
        bank += currPlayers.getFirst().takeMoney(blind / 2);

        //OUTPUT START
        System.out.println(currPlayers.getFirst() + " put small blind " + blind / 2);
        //OUTPUT END

        currPlayers.add(currPlayers.removeFirst());
        bank += currPlayers.getFirst().takeMoney(blind);

        //OUTPUT START
        System.out.println(currPlayers.getFirst() + " put big blind " + blind);
        //OUTPUT END

        for (Player player : currPlayers) {
            player.setCards(deck.pullCard(), deck.pullCard());
        }
        currPlayers.add(currPlayers.removeFirst());
        currPlayersIterator = currPlayers.iterator();
        while (currPlayersIterator.hasNext()) {
            processDecision(currPlayersIterator.next());
            if (currPlayers.size() == 1) {
                currStage = END;
                return;
            }
        }
        currPlayersIterator = null;
        currStage = Flop;
    }

    public void flop() {
        tableCards.add(deck.pullCard());
        tableCards.add(deck.pullCard());
        tableCards.add(deck.pullCard());
        for (int i = buttonId + 1; i < (players.size() + buttonId - 1) % players.size(); i = (i + 1) % players.size())
            if (currPlayers.contains(players.get(i))) {
                while (!currPlayers.getFirst().equals(players.get(i))) {
                    currPlayers.add(currPlayers.removeFirst());
                }
            }

        currPlayers.add(currPlayers.removeFirst());
        currPlayersIterator = currPlayers.iterator();
        while (currPlayersIterator.hasNext())

        {
            processDecision(currPlayersIterator.next());
            if (currPlayers.size() == 1) {
                currStage = END;
                return;
            }
        }

        currPlayersIterator = null;
        currStage = Turn;
    }

    public void turn() {
        tableCards.add(deck.pullCard());
        currPlayersIterator = currPlayers.iterator();
        while (currPlayersIterator.hasNext()) {
            processDecision(currPlayersIterator.next());
            if (currPlayers.size() == 1) {
                currStage = END;
                return;
            }
        }
        currPlayersIterator = null;
        currStage = River;
    }

    public void river() {
        tableCards.add(deck.pullCard());
        currPlayersIterator = currPlayers.iterator();
        while (currPlayersIterator.hasNext()) {
            processDecision(currPlayersIterator.next());
            if (currPlayers.size() == 1) {
                currStage = END;
                return;
            }
        }
        currPlayersIterator = null;
        currStage = END;
    }

    public void processDecision(Player player) {
        if (currPlayersIterator == null)
            throw new NullPointerException();
        switch (player.makeDecision(this)) {
            case FOLD:
                //OUTPUT START
                System.out.println(player + " FOLDS");
                //OUTPUT END

                currPlayersIterator.remove();
                if (currPlayers.size() < 2) {
                    currStage = END;
                    return;
                }
                break;
            case CALL:
                bank += player.takeMoney(call);

                //OUTPUT START
                System.out.println(player + " CALLS " + call);
                System.out.println("Bank is " + bank);
                //OUTPUT END

                break;
            case RAISE:
                player.takeMoney(player.getRaise());
                call = (int) player.getRaise();
                bank += call;

                //OUTPUT START
                System.out.println(player + " RAISES for " + player.getRaise());
                System.out.println("Bank is " + bank);
                //OUTPUT END

                break;
            case CHECK:
                //OUTPUT START
                System.out.println(player + " CHECKS");
                //OUTPUT END

                break;
            default:
                System.out.println("DUNNO WHAT DOES " + player);
        }
    }

    public boolean doWinner() {
        if (currPlayers.size() == 1) {
            //OUTPUT START
            System.out.println(currPlayers.get(0).toString() + " is a winner!");
            //OUTPUT END
            currPlayers.get(0).giveMoney(bank);
        } else {
            HashMap<Player, Combinations> plComb = new HashMap<>();
            for (Player p : currPlayers) {
                plComb.put(p, new CombinationRank(new ArrayList<Card>(p.getCards()), tableCards).bestCombination());
            }

            //OUTPUT START
            for (Player ah : currPlayers) {
                System.out.print(ah.toString() + " : " + ah.getCards() + " , ");
                System.out.println(tableCards.toString());
            }
            //OUTPUT END

            ArrayList<Map.Entry<Player, Combinations>> sortedList = new ArrayList<>(plComb.entrySet());
            Combinations topComb = Collections.max(plComb.entrySet(), (o1, o2) -> o1.getValue().compareTo(o2.getValue())).getValue();
            lastWinners = new ArrayList<>();
            for (Map.Entry<Player, Combinations> entry : plComb.entrySet()) {
                if (topComb.equals(entry.getValue())) {
                    lastWinners.add(entry.getKey());
                }
            }

            //OUTPUT START
            System.out.println(topComb);
            System.out.print(lastWinners.get(0).toString() + " [" + plComb.get(lastWinners.get(0)) + "]");
            //OUTPUT END

            lastWinners.get(0).giveMoney(bank / lastWinners.size());
            for (int i = 1; i < lastWinners.size(); i++) {
                //OUTPUT START
                System.out.print(", " + lastWinners.get(i).toString() + " [" + plComb.get(lastWinners.get(i)) + "]");
                //OUTPUT END
                lastWinners.get(i).giveMoney(bank / lastWinners.size());
            }
            //OUTPUT START
            if (lastWinners.size() == 1)
                System.out.println(" is winner!");
            else
                System.out.println(" are winners!");
            //OUTPUT END
        }
        //OUTPUT START
        System.out.println("Winning sum is " + bank / lastWinners.size());
        //OUTPUT END
        return true;
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


}
