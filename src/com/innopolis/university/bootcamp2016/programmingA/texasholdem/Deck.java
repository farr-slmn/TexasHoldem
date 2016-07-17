package com.innopolis.university.bootcamp2016.programmingA.texasholdem;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by User on 17.07.2016.
 */
public class Deck {
    private ArrayList<Card> cards;
    private Random random;

    public Deck() {
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
