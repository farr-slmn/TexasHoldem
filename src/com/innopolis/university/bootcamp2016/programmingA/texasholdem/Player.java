package com.innopolis.university.bootcamp2016.programmingA.texasholdem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static com.innopolis.university.bootcamp2016.programmingA.texasholdem.Player.Decision.RAISE;

public class Player{
    private String name;
    private ArrayList<Card> cards = new ArrayList<Card>(2);
    private Card higestCard = null;
    private ArrayList<Card> rankedList = null;
    private CombinationRank maximalComboRank = null;
    private long money;
    private long raise;

    public enum Decision
    {
        CALL, RAISE(), CHECK, FOLD;
        int raise;

        public void setRaise(int raise) {
            this.raise = raise;
        }
    }

    public Player(String name, long money)
    {
        this.name = name;
        this.money = money;
    }

    public Player(String name){
        this.name = name;
        money = 1000000;
    }

    public Player(){
        name = "Default";
        money = 1000000;
    }

    public ArrayList<Card> getRankedList()
    {
        return rankedList;
    }

    public void setRankedList(ArrayList<Card> rankedList)
    {
        this.rankedList = rankedList;
    }

    public void setRankedList()
    {
        //отсортировать свой массив карт
        //и забить в аррайлист
    }

    public ArrayList<Card> getCards()
    {
        return cards;
    }

    public void setCards(Card ... cards)
    {
        this.cards = new ArrayList<>(Arrays.asList(cards));
    }

    public Card getHighestCard()
    {
        return higestCard;
    }

    public void setHigestCard(Card higestCard)
    {
        this.higestCard=higestCard;
    }



    public CombinationRank getMaxCombo()
    {
       return maximalComboRank;
    }

    public void setMaxCombo(CombinationRank maxCombo)
    {
        this.maximalComboRank = maxCombo;
    }

    public long getMoney()
    {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public Decision makeDecision(Game game)
    {
        System.out.println(name+" choose your action: ");
        Scanner sc = new Scanner(System.in);
        int action = Integer.parseInt(sc.nextLine());
        if(action==1) {
            return Decision.CALL;
        }
        else if(action==2)
        {
            return  Decision.FOLD;
        }
        else
        {
            Decision d = Decision.RAISE;
            d.setRaise(200);
            RAISE.setRaise(200);
            return RAISE;
        }

    }

    @Override
    public String toString() {
        return name;
    }
}