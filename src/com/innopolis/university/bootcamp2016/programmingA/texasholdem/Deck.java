package com.innopolis.university.bootcamp2016.programmingA.texasholdem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Stack;

/**
 * Created by User on 17.07.2016.
 */
public class Deck {
    public ArrayList<Card> cards;
    public Stack<Card> deckStack;

    public Deck()
    {
        cards = new ArrayList<>();
        deckStack = new Stack<>();

        for(Card.CardRankEnum rank : Card.CardRankEnum.values()) {
            for (Card.CardSuitEnum suit : Card.CardSuitEnum.values()) {
                cards.add(new Card(suit, rank));
            }
        }
    }

    public void shuffleDeck()
    {
        long seed = System.nanoTime();
        Collections.shuffle(cards, new Random(seed));
        for(Card c : cards)
        {
            deckStack.add(c);
        }
    }

    public Card pullCard()
    {
        return deckStack.pop();
    }

    public ArrayList<Card> getCards()
    {
        return cards;
    }
}
