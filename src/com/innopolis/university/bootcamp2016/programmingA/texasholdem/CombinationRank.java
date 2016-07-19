package com.innopolis.university.bootcamp2016.programmingA.texasholdem;

import java.util.*;

public class CombinationRank {

    public ArrayList<Card> summaryCards;
    ArrayList<Card> bestCombination;

    public CombinationRank(ArrayList<Card> playerCards, ArrayList<Card> tableCards){
        bestCombination = new ArrayList<>();
        summaryCards = new ArrayList<>();
        summaryCards.addAll(playerCards);
        summaryCards.addAll(tableCards);

        //Descending sort

        summaryCards.sort(new Comparator<Card>() {
            @Override
            public int compare(Card o1, Card o2) {
                return -(o1.getRank().compareTo(o2.getRank()));
            }
        });
    }

    public ArrayList<Card> bestCombination(){

        if (isRoyalFlush(summaryCards))
        {
            return bestCombination;
        }
        else if (isStraightFlush(summaryCards)){
            return bestCombination;
        }
        else if (isFourOfKind(summaryCards)){
            return bestCombination;
        }
        else if (isFullHouse(summaryCards)){
            return bestCombination;
        }
        else if (isFlush(summaryCards)){
            return bestCombination;
        }
        else if (isStraight(summaryCards)){
            return bestCombination;
        }
        else if (isThreeOfKind(summaryCards)){
            return bestCombination;
        }
        else if (isTwoPair(summaryCards)){
            return bestCombination;
        }
        else if (isOnePair(summaryCards)){
            return bestCombination;
        }
        else if (isHighCard(summaryCards)){
            return bestCombination;
        }
        return bestCombination;
    }

    public boolean isRoyalFlush(ArrayList<Card> summaryCards){

        bestCombination.clear();
        boolean t=true;
        Card.CardSuitEnum suit = summaryCards.get(0).getSuit();
        for(Card card : summaryCards){
            if (card.getSuit().compareTo(suit)!=0){
                t=false;
            }
        }
        for(int i=1;i<summaryCards.size();++i){
            if (summaryCards.get(i).getRank().compareTo(summaryCards.get(i-1).getRank())<=0){
                t=false;
            }
        }
        if (t && summaryCards.get(0).getRank().equals(Card.CardRankEnum.ACE)){
            for(Card card : summaryCards){
                bestCombination.add(card);
            }
        }
        else t=false;
        return false;
    }

    public boolean isStraightFlush(ArrayList<Card> summaryCards){
        bestCombination.clear();
        boolean t=true;
        Card.CardSuitEnum suit = summaryCards.get(0).getSuit();
        for(Card card : summaryCards){
            if (card.getSuit().compareTo(suit)!=0){
                t=false;
            }
        }
        for(int i=1;i<summaryCards.size();++i){
            if (summaryCards.get(i).getRank().compareTo(summaryCards.get(i-1).getRank())<=0){
                t=false;
            }
        }
        if (t){
            for(Card card : summaryCards){
                bestCombination.add(card);
            }
        }
        return t;
    }

    public boolean isFourOfKind(ArrayList<Card> summaryCards){
        bestCombination.clear();
        int ans=-1;
        Card.CardRankEnum rank = summaryCards.get(0).getRank();
        for(Card card : summaryCards){
            if (card.getRank().equals(rank)){
                ans++;
            }
        }
        if (ans>=4) {
            for (Card card : summaryCards) {
                bestCombination.add(card);
            }
            return true;
        }

        rank = summaryCards.get(summaryCards.size()-1).getRank();
        ans=-1;
        for(Card card : summaryCards){
            if (card.getRank().equals(rank)){
                ans++;
            }
        }
        if (ans>=4) {
            for (Card card : summaryCards) {
                bestCombination.add(card);
            }
            return true;
        }

        return false;
    }

    public boolean isFullHouse(ArrayList<Card> summaryCards){
        bestCombination.clear();
        int three=-1, two=-1;
        Card.CardRankEnum rank1 = summaryCards.get(0).getRank();
        Card.CardRankEnum rank2 = summaryCards.get(summaryCards.size()-1).getRank();
        for(Card card : summaryCards){
            if (card.getRank().equals(rank1)){
                three++;
            }
            if (card.getRank().equals(rank2)){
                two++;
            }
        }
        if (three==3 && two==2) {
            for (Card card : summaryCards) {
                bestCombination.add(card);
            }
            return true;
        }
        else
            return false;
    }

    public boolean isFlush(ArrayList<Card> summaryCards){
        bestCombination.clear();
        boolean t=true;
        Card.CardRankEnum suit = summaryCards.get(0).getRank();
        for(Card card : summaryCards){
            if (!card.getSuit().equals(suit)){
                t=false;
            }
        }
        if (t){
            for (Card card : summaryCards) {
                bestCombination.add(card);
            }
            return true;
        }
        return false;
    }

    public boolean isStraight(ArrayList<Card> summaryCards){
        bestCombination.clear();
        boolean t=true;
        for(int i=1;i<summaryCards.size();++i){
            if (summaryCards.get(i).getRank().compareTo(summaryCards.get(i-1).getRank())<=0){
                t=false;
            }
        }
        if (t){
            for (Card card : summaryCards) {
                bestCombination.add(card);
            }
            return true;
        }
        return false;
    }

    public boolean isThreeOfKind(ArrayList<Card> summaryCards){
        bestCombination.clear();
        int ans=-1;
        Card.CardRankEnum rank = summaryCards.get(0).getRank();
        for(Card card : summaryCards){
            if (card.getRank().equals(rank)){
                ans++;
            }
        }
        if (ans>=3) {
            for (Card card : summaryCards) {
                bestCombination.add(card);
            }
            return true;
        }

        //last three cards rank comparing
        ans=-1;
        rank = summaryCards.get(summaryCards.size()-1).getRank();
        for(Card card : summaryCards){
            if (card.getRank().equals(rank)){
                ans++;
            }
        }
        if (ans>=3) {
            for (Card card : summaryCards) {
                bestCombination.add(card);
            }
            return true;
        }

        //middle three cards rank comparing
        ans=-1;
        rank = summaryCards.get(2).getRank();
        for(Card card : summaryCards){
            if (card.getRank().equals(rank)){
                ans++;
            }
        }
        if (ans>=3) {
            for (Card card : summaryCards) {
                bestCombination.add(card);
            }
            return true;
        }

        return false;
    }

    public boolean isTwoPair(ArrayList<Card> summaryCards){
        bestCombination.clear();

        if (summaryCards.get(0).getRank().equals(summaryCards.get(1).getRank())){
            if (summaryCards.get(2).getRank().equals(summaryCards.get(3).getRank()) ||
                    summaryCards.get(3).getRank().equals(summaryCards.get(4).getRank())){
                for (Card card : summaryCards) {
                    bestCombination.add(card);
                }
                return true;
            }
        }
        else if (summaryCards.get(1).getRank().equals(summaryCards.get(2).getRank()) &&
                summaryCards.get(3).getRank().equals(summaryCards.get(4).getRank())){
            for (Card card : summaryCards) {
                bestCombination.add(card);
            }
            return true;
        }
        return false;
    }

    public boolean isOnePair(ArrayList<Card> summaryCards){
        bestCombination.clear();
        boolean ans=false;
        for(int i=0;i<summaryCards.size();++i){
            for(int j=0;j<summaryCards.size();++j){
                if (i!=j && summaryCards.get(i).getRank().equals(summaryCards.get(j).getRank())){
                    ans=true;
                }
            }
        }
        if (ans){
            for (Card card : summaryCards) {
                bestCombination.add(card);
            }
            return true;
        }
        return false;
    }

    public boolean isHighCard(ArrayList<Card> summaryCards){
        bestCombination.clear();
        for (Card card : summaryCards) {
            bestCombination.add(card);
        }
        return true;
    }
}
