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
                return -o1.getRank().compareTo(o2.getRank());
            }
        });

        summaryCards.sort(new Comparator<Card>() {
            @Override
            public int compare(Card o1, Card o2) {
                if (o1.getRank().equals(o2.getRank()) && o1.getSuit().compareTo(o2.getSuit()) < 0){
                    return -1;
                }
                else if (o1.getRank().equals(o2.getRank()) && o1.getSuit().compareTo(o2.getSuit()) > 0){
                    return 1;
                }
                else return 0;
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
        for (int i = 1; i < 5; ++i) {
            if (summaryCards.get(i).getRank().ordinal() + 1 != summaryCards.get(i - 1).getRank().ordinal()) {
                t = false;
            }
            if (!summaryCards.get(i).getSuit().equals(summaryCards.get(i - 1).getSuit())){
                t = false;
            }
        }
        if (!summaryCards.get(0).getRank().equals(Card.CardRankEnum.ACE)){
            t = false;
        }
        if (!t && summaryCards.size() == 6){
            t = true;
            for (int i = 2; i < 6; ++i) {
                if (summaryCards.get(i).getRank().ordinal() + 1 != summaryCards.get(i - 1).getRank().ordinal()) {
                    t = false;
                }
                if (!summaryCards.get(i).getSuit().equals(summaryCards.get(i - 1).getSuit())){
                    t = false;
                }
            }
            if (!summaryCards.get(1).getRank().equals(Card.CardRankEnum.ACE)){
                t = false;
            }
        }
        if (!t && summaryCards.size() == 7){
            t = true;
            for (int i = 3; i < 7; ++i) {
                if (summaryCards.get(i).getRank().ordinal() + 1 != summaryCards.get(i - 1).getRank().ordinal()) {
                    t = false;
                }
                if (!summaryCards.get(i).getSuit().equals(summaryCards.get(i - 1).getSuit())){
                    t = false;
                }
            }
            if (!summaryCards.get(2).getRank().equals(Card.CardRankEnum.ACE)){
                t = false;
            }
        }
        if (t){
            return true;
        }
        //else {

        //}
        return false;
    }

    public boolean isStraightFlush(ArrayList<Card> summaryCards) {

        boolean t = true;
        for (int i = 1; i < 5; ++i) {
            if (summaryCards.get(i).getRank().ordinal() + 1 != summaryCards.get(i - 1).getRank().ordinal()) {
                t = false;
            }
            if (!summaryCards.get(i).getSuit().equals(summaryCards.get(i - 1).getSuit())){
                t = false;
            }
        }
        if (!t && summaryCards.size() == 6){
            t = true;
            for (int i = 2; i < 6; ++i) {
                if (summaryCards.get(i).getRank().ordinal() + 1 != summaryCards.get(i - 1).getRank().ordinal()) {
                    t = false;
                }
                if (!summaryCards.get(i).getSuit().equals(summaryCards.get(i - 1).getSuit())){
                    t = false;
                }
            }
        }
        if (!t && summaryCards.size() == 7){
            t = true;
            for (int i = 3; i < 7; ++i) {
                if (summaryCards.get(i).getRank().ordinal() + 1 != summaryCards.get(i - 1).getRank().ordinal()) {
                    t = false;
                }
                if (!summaryCards.get(i).getSuit().equals(summaryCards.get(i - 1).getSuit())){
                    t = false;
                }
            }
        }
        if (t){
            return true;
        }
//        else {
//            int one = 0, two = 0, three = 0, four = 0, five = 0;
//            if (summaryCards.contains(Card.CardRankEnum.ACE) && summaryCards.contains(Card.CardRankEnum.CARD_2)
//                    && summaryCards.contains(Card.CardRankEnum.CARD_3) && summaryCards.contains(Card.CardRankEnum.CARD_4)
//                    && summaryCards.contains(Card.CardRankEnum.CARD_5)) {
//                one = summaryCards.indexOf(Card.CardRankEnum.ACE);
//                two = summaryCards.indexOf(Card.CardRankEnum.CARD_2);
//                three = summaryCards.indexOf(Card.CardRankEnum.CARD_3);
//                four = summaryCards.indexOf(Card.CardRankEnum.CARD_4);
//                five = summaryCards.indexOf(Card.CardRankEnum.CARD_5);
//                t = true;
//            }
//            if (t && summaryCards.get(one).getSuit().equals(summaryCards.get(two).getSuit()) &&
//                    summaryCards.get(two).getSuit().equals(summaryCards.get(three).getSuit()) &&
//                    summaryCards.get(three).getSuit().equals(summaryCards.get(four).getSuit()) &&
//                    summaryCards.get(four).getSuit().equals(summaryCards.get(five).getSuit())) {
//                t = true;
//            }
//            else{
//                t = false;
//            }
//        }
        return false;
    }

    public boolean isFourOfKind(ArrayList<Card> summaryCards) {
        int ans = 0;
        Card.CardRankEnum rank = summaryCards.get(3).getRank();
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
        boolean ans = false;
        int one1 = 0,one2 = 0,one3 = 0;
        for (int i = 0; i < summaryCards.size(); ++i) {
            for (int j = 0; j < summaryCards.size(); ++j) {
                for(int k=0;k<summaryCards.size();++k){
                    if (i != j && j != k && i != k &&
                            summaryCards.get(i).getRank().equals(summaryCards.get(j).getRank()) &&
                            summaryCards.get(j).getRank().equals(summaryCards.get(k).getRank())) {
                        ans = true;
                        one1 = i;
                        one2 = j;
                        one3 = k;
                    }
                }
            }
        }
        if (ans) {
            ans = false;
            for (int i = 0; i < summaryCards.size(); ++i) {
                for (int j = 0; j < summaryCards.size(); ++j) {
                    if (i != j && one1 != i && one2 != j && one1 != j && one2 != i && one3 != i && one3 != j &&
                            summaryCards.get(i).getRank().equals(summaryCards.get(j).getRank())) {
                        ans = true;
                    }
                }
            }
            return ans;
        }
        else return false;
    }

    public boolean isFlush(ArrayList<Card> summaryCards) {
        boolean t = true;
        for (int i = 1; i < 5; ++i) {
            if (!summaryCards.get(i).getSuit().equals(summaryCards.get(i - 1).getSuit())) {
                t = false;
            }
        }
        if (!t && summaryCards.size() == 6){
            t = true;
            for (int i = 2; i < 6; ++i) {
                if (!summaryCards.get(i).getSuit().equals(summaryCards.get(i - 1).getSuit())) {
                    t = false;
                }
            }
        }
        if (!t && summaryCards.size() == 7){
            t = true;
            for (int i = 3; i < 7; ++i) {
                if (!summaryCards.get(i).getSuit().equals(summaryCards.get(i - 1).getSuit())) {
                    t = false;
                }
            }
        }
        return t;
    }

    public boolean isStraight(ArrayList<Card> summaryCards) {
        boolean t = true;
        for (int i = 1; i < 5; ++i) {
            if (summaryCards.get(i).getRank().ordinal() + 1 != summaryCards.get(i - 1).getRank().ordinal()) {
                t = false;
            }
        }
        if (!t && summaryCards.size() == 6){
            t = true;
            for (int i = 2; i < 6; ++i) {
                if (summaryCards.get(i).getRank().ordinal() + 1 != summaryCards.get(i - 1).getRank().ordinal()) {
                    t = false;
                }
            }
        }
        if (!t && summaryCards.size() == 7){
            t = true;
            for (int i = 3; i < 7; ++i) {
                if (summaryCards.get(i).getRank().ordinal() + 1 != summaryCards.get(i - 1).getRank().ordinal()) {
                    t = false;
                }
            }
        }
        if (t){
            return true;
        }
        else {
            if (summaryCards.contains(Card.CardRankEnum.ACE) && summaryCards.contains(Card.CardRankEnum.CARD_2)
                    && summaryCards.contains(Card.CardRankEnum.CARD_3) && summaryCards.contains(Card.CardRankEnum.CARD_4)
                    && summaryCards.contains(Card.CardRankEnum.CARD_5)) {
                t = true;
            }
        }
        return t;
    }

    public boolean isThreeOfKind(ArrayList<Card> summaryCards) {
        int ans = 0;
        Card.CardRankEnum rank = summaryCards.get(2).getRank();
        for (Card card : summaryCards) {
            if (card.getRank().equals(rank)) {
                ans++;
            }
        }
        if (ans >= 3) {
            return true;
        }

        ans = 0;
        rank = summaryCards.get(4).getRank();
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
        boolean ans = false;
        int one1 = 0,one2 = 0;
        for (int i = 0; i < summaryCards.size(); ++i) {
            for (int j = 0; j < summaryCards.size(); ++j) {
                if (i != j && summaryCards.get(i).getRank().equals(summaryCards.get(j).getRank())) {
                    ans = true;
                    one1 = i;
                    one2 = j;
                }
            }
        }
        if (ans) {
            ans = false;
            for (int i = 0; i < summaryCards.size(); ++i) {
                for (int j = 0; j < summaryCards.size(); ++j) {
                    if (i != j && one1 != i && one2 != j && one1 != j && one2 != i && summaryCards.get(i).getRank().equals(summaryCards.get(j).getRank())) {
                        ans = true;
                    }
                }
            }
            return ans;
        }
        else return false;
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
        return ans;
    }
}
