package com.innopolis.university.bootcamp2016.programmingA.texasholdem;

/**
 * Created by User on 17.07.2016.
 */
public class Card {

    public enum CardRankEnum {
        CARD_2,
        CARD_3,
        CARD_4,
        CARD_5,
        CARD_6,
        CARD_7,
        CARD_8,
        CARD_9,
        CARD_10,
        JACK,
        QUEEN,
        KING,
        ACE
    }

    public enum CardSuitEnum {
        CLUBS,
        DIAMONDS,
        HEARTS,
        SPADES
    }

    private CardSuitEnum suit;
    private CardRankEnum rank;

    public Card(){

    }

    public Card(CardSuitEnum suit, CardRankEnum rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public CardSuitEnum getSuit() {
        return suit;
    }

    public CardRankEnum getRank() {
        return rank;
    }

}
