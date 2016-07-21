package com.innopolis.university.bootcamp2016.programmingA.texasholdem;

import java.util.*;

import static com.innopolis.university.bootcamp2016.programmingA.texasholdem.Game.GameStage.*;
import static com.innopolis.university.bootcamp2016.programmingA.texasholdem.CombinationRank.*;

public class Game {
    final int blind;
    Deck deck;
    LinkedList<Player> players;
    LinkedList<Player> currPlayers;
    Iterator<Player> currPlayersIterator;
    ArrayList<Card> tableCards;
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
            if (index > -1) {
                if (buttonId == index) {
                    return false;
                }
                if (Utils.nextId(players, buttonId) == index) {
                    return player.getMoney() < blind / 2;
                }
                if (Utils.nextId(players, buttonId + 1) == index) {
                    return player.getMoney() < blind;
                }
                return player.getMoney() < call;
            }
            return player.getMoney() < blind;
        });
        if (players.size() < 2)
            throw new IllegalStateException();
        buttonId = players.indexOf(button);
        currPlayers = new LinkedList<>(players);
        for (int i = 0; i < buttonId; i++) {
            currPlayers.add(currPlayers.removeFirst());
        }
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
        currPlayers.add(currPlayers.removeFirst());
        currPlayers.getFirst().setMoney(currPlayers.getFirst().getMoney() - blind / 2);
        bank += blind / 2;
        currPlayers.add(currPlayers.removeFirst());
        currPlayers.getFirst().setMoney(currPlayers.getFirst().getMoney() - blind);
        bank += blind;
        for (Player player : currPlayers) {
            player.setCards(new Card[]{deck.pullCard(), deck.pullCard()});
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
                System.out.println(player + " FOLDS");
                currPlayersIterator.remove();
                break;
            case CALL:
                System.out.println(player + " CALLS");
                break;
            case RAISE:
                System.out.println(player + " RAISES");
                break;
            case CHECK:
                System.out.println(player + " CHECKS");
                break;
            default:
                System.out.println("DUNNO WHAT DOES " + player);
        }
    }

    public boolean doWinner() {
        HashMap<Player, Combinations> plComb = new HashMap<>();
        for (Player p : currPlayers) {
            plComb.put(p, new CombinationRank(new ArrayList<Card>(Arrays.asList(p.getCards())), tableCards).bestCombination());
        }
        for(Player ah : currPlayers){
            System.out.print(ah.toString()+" : "+Arrays.toString(ah.getCards())+" , ");
            System.out.println(tableCards.toString());
        }
        ArrayList<Map.Entry<Player, Combinations>> sortedList = new ArrayList<>(plComb.entrySet());
        Combinations topComb = Collections.max(plComb.entrySet(), (o1, o2) -> o1.getValue().compareTo(o2.getValue())).getValue();
        lastWinners = new ArrayList<>();
        for (Map.Entry<Player, Combinations> entry : plComb.entrySet()) {
            if (topComb.equals(entry.getValue())) {
                lastWinners.add(entry.getKey());
            }
        }
        System.out.println(topComb);
        if (lastWinners.size() == 1)
            System.out.println(lastWinners.get(0).toString() + " is a winner!");
        else {
            System.out.print(lastWinners.get(0).toString() + " [" + plComb.get(lastWinners.get(0)) + "]");
            for (int i = 1; i < lastWinners.size(); i++) {
                System.out.print(", " + lastWinners.get(i).toString() + " [" + plComb.get(lastWinners.get(i)) + "]");
            }
            System.out.println(" are winners!");
        }
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
