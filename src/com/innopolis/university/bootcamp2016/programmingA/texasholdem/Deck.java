package com.innopolis.university.bootcamp2016.programmingA.texasholdem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by User on 17.07.2016.
 */
public class Deck {
    private ArrayList<Card> cards;
    private Random random;

    public Deck() {
        for(enum rank : Card.CardRankEnum){
            for(enum suit : Card.CardSuitEnum){
                cards.add(new Card(suit,rank));
            }
        }
    }

    private void createDeck() {

    }

    public Card pop() {
        return cards.get(cards.size()-1);
    }
}
