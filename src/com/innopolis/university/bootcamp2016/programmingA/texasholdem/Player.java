package com.innopolis.university.bootcamp2016.programmingA.texasholdem;



import java.util.ArrayList;

/**
 * Created by mer_e on 17.07.2016.
 */
public class Player {
    private Card[] cards = new Card[2];
    private Card higestCard = null;
    private ArrayList<Card> rankedList = null;
    private CombinationRank maximalComboRank = null;
    private long money;




    public ArrayList<Card> getRankingList()
    {
        return rankedList;
    }

    public void setRankingList(ArrayList<Card> rankingList)
    {
        this.rankedList = rankingList;
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

    public ArrayList<Card> getRankedList()
    {
        return  rankedList;
    }

    public void setRankedList()
    {
       //отсортировать свой массив карт
        //и забить в аррайлист
    }

    public void setMaxCombo(CombinationRank maxCombo)
    {
        this.maximalComboRank = maxCombo;
    }

    public CombinationRank getMaxCombo()
    {
       return maximalComboRank;
    }

    public void setMoney(long money)
    {
        this.money = money;
    }

    public long getMoney()
    {
        return money;
    }

}