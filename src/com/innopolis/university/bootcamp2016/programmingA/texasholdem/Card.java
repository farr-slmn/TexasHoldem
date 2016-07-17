package com.innopolis.university.bootcamp2016.programmingA.texasholdem;

/**
 * Created by User on 17.07.2016.
 */
public class Card {

    public enum CardRankEnum {
        CARD_2(2),
        CARD_3(3),
        CARD_4(4),
        CARD_5(5),
        CARD_6(6),
        CARD_7(7),
        CARD_8(8),
        CARD_9(9),
        CARD_10(10),
        JACK(11),
        QUEEN(12),
        KING(13),
        ACE(14);

        final int rank;
        CardRankEnum(int p) {
            rank = p;
        }
    }

    public enum CardSuitEnum {
        CLUBS,
        DIAMONDS,
        HEARTS,
        SPADES;
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
