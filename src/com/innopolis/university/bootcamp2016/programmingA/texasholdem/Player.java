package com.innopolis.university.bootcamp2016.programmingA.texasholdem;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Player{
    private String name;
    private Card[] cards = new Card[2];
    private Card higestCard = null;
    private ArrayList<Card> rankedList = null;
    private CombinationRank maximalComboRank = null;
    private long money;

    enum Decision{
        CALL, RAISE, FOLD;
    }

    public Player(String name){
        this.name = name;
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

    public Card[] getCards()
    {
        return cards;
    }

    public void setCards(Card[] cards)
    {
        this.cards = cards;
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

    public Decision makeDecision(Game game) {
        return Decision.values()[new Random().nextInt(Decision.values().length)];
    }

    @Override
    public String toString() {
        return name;
    }
}