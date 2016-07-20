package com.innopolis.university.bootcamp2016.programmingA.texasholdem;

import java.util.*;

public class CombinationRank {

    public ArrayList<Card> summaryCards;

    public enum Combinations {
        HIGH_CARD,
        ONE_PAIR,
        TWO_PAIR,
        THREE_OF_A_KIND,
        STRAIGHT,
        FLUSH,
        FULL_HOUSE,
        FOUR_OF_A_KIND,
        STRAIGHT_FLUSH,
        ROYAL_FLUSH
    }

    public CombinationRank(ArrayList<Card> playerCards, ArrayList<Card> tableCards) {
        summaryCards = new ArrayList<>();
        summaryCards.addAll(playerCards);
        summaryCards.addAll(tableCards);

        //Descending sort

        summaryCards.sort(new Comparator<Card>() {
            @Override
            public int compare(Card o1, Card o2) {
                if (o1.getRank().ordinal() == o2.getRank().ordinal())
                    return 0;
                else if (o1.getRank().ordinal() > o2.getRank().ordinal())
                    return -1;
                return 1;
            }
        });
    }

    public Combinations bestCombination() {

        if (isRoyalFlush(summaryCards)) {
            return Combinations.ROYAL_FLUSH;
        } else if (isStraightFlush(summaryCards)) {
            return Combinations.STRAIGHT_FLUSH;
        } else if (isFourOfKind(summaryCards)) {
            return Combinations.FOUR_OF_A_KIND;
        } else if (isFullHouse(summaryCards)) {
            return Combinations.FULL_HOUSE;
        } else if (isFlush(summaryCards)) {
            return Combinations.FLUSH;
        } else if (isStraight(summaryCards)) {
            return Combinations.STRAIGHT;
        } else if (isThreeOfKind(summaryCards)) {
            return Combinations.THREE_OF_A_KIND;
        } else if (isTwoPair(summaryCards)) {
            return Combinations.TWO_PAIR;
        } else if (isOnePair(summaryCards)) {
            return Combinations.ONE_PAIR;
        } else
            return Combinations.HIGH_CARD;
    }

    public boolean isRoyalFlush(ArrayList<Card> summaryCards) {

        boolean t = true;
        Card.CardSuitEnum suit = summaryCards.get(0).getSuit();
        for (Card card : summaryCards) {
            if (card.getSuit().compareTo(suit) != 0) {
                t = false;
            }
        }
        for (int i = 1; i < summaryCards.size(); ++i) {
            if (summaryCards.get(i).getRank().ordinal() + 1 != summaryCards.get(i - 1).getRank().ordinal()) {
                t = false;
            }
        }
        if (t && summaryCards.get(0).getRank().equals(Card.CardRankEnum.ACE) && summaryCards.get(4).getRank().equals(Card.CardRankEnum.CARD_10)) {
            return true;
        }

        return false;
    }

    public boolean isStraightFlush(ArrayList<Card> summaryCards) {

        boolean t = true;
        Card.CardSuitEnum suit = summaryCards.get(0).getSuit();
        for (Card card : summaryCards) {
            if (card.getSuit().compareTo(suit) != 0) {
                t = false;
            }
        }
        for (int i = 1; i < summaryCards.size(); ++i) {
            if (summaryCards.get(i).getRank().ordinal() + 1 != summaryCards.get(i - 1).getRank().ordinal()) {
                t = false;
            }
        }
        return t;
    }

    public boolean isFourOfKind(ArrayList<Card> summaryCards) {
        int ans = 0;
        Card.CardRankEnum rank = summaryCards.get(0).getRank();
        for (Card card : summaryCards) {
            if (card.getRank().equals(rank)) {
                ans++;
            }
        }
        if (ans >= 4) {
            return true;
        }

        rank = summaryCards.get(summaryCards.size() - 1).getRank();
        ans = 0;
        for (Card card : summaryCards) {
            if (card.getRank().equals(rank)) {
                ans++;
            }
        }
        if (ans >= 4) {
            return true;
        }

        return false;
    }

    public boolean isFullHouse(ArrayList<Card> summaryCards) {
        //нужна сортировка
        int three = 0, two = 0;
        Card.CardRankEnum rank1 = summaryCards.get(0).getRank();
        Card.CardRankEnum rank2 = summaryCards.get(summaryCards.size() - 1).getRank();
        for (Card card : summaryCards) {
            if (card.getRank().equals(rank1)) {
                three++;
            }
            if (card.getRank().equals(rank2)) {
                two++;
            }
        }
        if (three == 3 && two == 2) {
            return true;
        }
        return false;
    }

    public boolean isFlush(ArrayList<Card> summaryCards) {
        boolean t = true;
        Card.CardSuitEnum suit = summaryCards.get(0).getSuit();
        for (Card card : summaryCards) {
            if (!card.getSuit().equals(suit)) {
                t = false;
            }
        }
        if (t) {
            return true;
        }
        return false;
    }

    public boolean isStraight(ArrayList<Card> summaryCards) {
        boolean t = true;
        for (int i = 1; i < summaryCards.size(); ++i) {
            if (summaryCards.get(i).getRank().ordinal() + 1 != summaryCards.get(i - 1).getRank().ordinal()) {
                t = false;
            }
        }
        return t;
    }

    public boolean isThreeOfKind(ArrayList<Card> summaryCards) {
        int ans = 0;
        Card.CardRankEnum rank = summaryCards.get(1).getRank();
        for (Card card : summaryCards) {
            if (card.getRank().equals(rank)) {
                ans++;
            }
        }
        if (ans >= 3) {
            return true;
        }

        ans = 0;
        rank = summaryCards.get(3).getRank();
        for (Card card : summaryCards) {
            if (card.getRank().equals(rank)) {
                ans++;
            }
        }
        if (ans >= 3) {
            return true;
        }

        return false;
    }

    public boolean isTwoPair(ArrayList<Card> summaryCards) {

        if (summaryCards.get(0).getRank().equals(summaryCards.get(1).getRank())) {
            if (summaryCards.get(2).getRank().equals(summaryCards.get(3).getRank()) ||
                    summaryCards.get(3).getRank().equals(summaryCards.get(4).getRank())) {
                return true;
            }
        } else if (summaryCards.get(1).getRank().equals(summaryCards.get(2).getRank()) &&
                summaryCards.get(3).getRank().equals(summaryCards.get(4).getRank())) {
            return true;
        }
        return false;
    }

    public boolean isOnePair(ArrayList<Card> summaryCards) {
        boolean ans = false;
        for (int i = 0; i < summaryCards.size(); ++i) {
            for (int j = 0; j < summaryCards.size(); ++j) {
                if (i != j && summaryCards.get(i).getRank().equals(summaryCards.get(j).getRank())) {
                    ans = true;
                }
            }
        }
        if (ans) {
            return true;
        }
        return false;
    }
}
