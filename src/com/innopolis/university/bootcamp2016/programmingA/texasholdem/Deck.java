package com.innopolis.university.bootcamp2016.programmingA.texasholdem;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
    private ArrayList<Card> cards;
    private Random random;

    public Deck() {
        cards = new ArrayList<>();
        for(Card.CardRankEnum rank : Card.CardRankEnum.values()){
            for(Card.CardSuitEnum suit : Card.CardSuitEnum.values()){
                cards.add(new Card(suit,rank));
            }
        }
    }

    private void shuffle() {

    }

    public Card pop() {
        return cards.get(cards.size()-1);
    }
}
