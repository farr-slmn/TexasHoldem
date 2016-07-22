package com.innopolis.university.bootcamp2016.programmingA.texasholdem;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static com.innopolis.university.bootcamp2016.programmingA.texasholdem.Player.Decision.*;

public class Player {
    private String name;
    private ArrayList<Card> cards = new ArrayList<Card>(2);
    private Card higestCard = null;
    private ArrayList<Card> rankedList = null;
    private CombinationRank maximalComboRank = null;
    private long money;
    protected long raise;

    public enum Decision {
        CALL, RAISE, CHECK, FOLD
    }

    public Player(String name, long money) {
        this.name = name;
        this.money = money;
    }

    public Player(String name) {
        this.name = name;
        money = 1000000;
    }

    public Player() {
        name = "Default";
        money = 1000000;
    }

    public ArrayList<Card> getRankedList() {
        return rankedList;
    }

    public void setRankedList(ArrayList<Card> rankedList) {
        this.rankedList = rankedList;
    }

    public void setRankedList() {
        //отсортировать свой массив карт
        //и забить в аррайлист
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(Card... cards) {
        this.cards = new ArrayList<>(Arrays.asList(cards));
    }

    public Card getHighestCard() {
        return higestCard;
    }

    public void setHigestCard(Card higestCard) {
        this.higestCard = higestCard;
    }


    public CombinationRank getMaxCombo() {
        return maximalComboRank;
    }

    public void setMaxCombo(CombinationRank maxCombo) {
        this.maximalComboRank = maxCombo;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public long takeMoney(long sum) {
        if (sum > money)
            sum = money;
        money -= sum;
        return sum;
    }

    public void giveMoney(long sum) {
        money += sum;
    }

    public Decision makeDecision(Game game) {
        Scanner sc = new Scanner(System.in);
        Decision d;

        //OUTPUT START
        System.out.println();
        if(!cards.isEmpty())
            System.out.println("Your cards: "+Arrays.toString(cards.toArray()));
        if(!game.tableCards.isEmpty())
            System.out.println("Table cards: "+Arrays.toString(game.tableCards.toArray()));
        System.out.println(name + " choose your action:         [Bank: "+money+"]");
        //OUTPUT END

        ArrayList<Decision> decisions = new ArrayList<>(Arrays.asList(Decision.values()));
        if (game.currStage.equals(Game.GameStage.Preflop)) {
            decisions.remove(CHECK);
        }
        if (money == 0)
            decisions.remove(CALL);
        if (money <= game.call) {
            decisions.remove(RAISE);
        }

        //OUTPUT START
        for (int i = 0; i < decisions.size(); i++) {
            System.out.println(i + 1 + ") " + decisions.get(i));
        }
        //OUTPUT END

        while(true)
        try {
            d = decisions.get(Integer.parseInt(sc.nextLine()) - 1);
            break;
        }catch (NumberFormatException e){
            continue;
        }
        if (RAISE.equals(d)) {
            raise = Long.parseLong(sc.nextLine());
            if (raise <= game.call)
                raise = game.call + 1;
            if (raise > money)
                raise = money;
        }
        return d;
    }

    public long getRaise() {
        return raise;
    }

    @Override
    public String toString() {
        return name;
    }
}