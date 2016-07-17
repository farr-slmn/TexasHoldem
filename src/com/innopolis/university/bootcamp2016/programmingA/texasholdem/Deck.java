package com.innopolis.university.bootcamp2016.programmingA.texasholdem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Stack;

/**
 * Created by User on 17.07.2016.
 */
public class Deck {
    private ArrayList<Card> cards;
    private Stack<Card> deckStack;

    public Deck()
    {
        for(Card.CardRankEnum rank : Card.CardRankEnum.values()){
            for(Card.CardSuitEnum suit : Card.CardSuitEnum.values()){
                cards.add(new Card(suit,rank));
            }
        }

        shuffleDeck();

        for(Card c : cards)
        {
            deckStack.add(c);
        }

    }

    private void shuffleDeck()
    {
        long seed = System.nanoTime();
        Collections.shuffle(cards, new Random(seed));
    }

    public Card pullCard()
    {
        return deckStack.pop();
    }
}
