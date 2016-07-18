package com.innopolis.university.bootcamp2016.programmingA.texasholdem;

import java.util.ArrayList;

public class CombinationRank {

    ArrayList<Card> summaryCards;
    ArrayList<Card> bestCombination;

    public CombinationRank(ArrayList<Card> playerCards, ArrayList<Card> tableCards){
        bestCombination = new ArrayList<>();
        summaryCards = new ArrayList<>();
        summaryCards.addAll(playerCards);
        summaryCards.addAll(tableCards);
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
        //making best combination
        return true;
    }

    public boolean isStraightFlush(ArrayList<Card> summaryCards){
        bestCombination.clear();
        //making best combination
        return true;
    }

    public boolean isFourOfKind(ArrayList<Card> summaryCards){
        bestCombination.clear();
        //making best combination
        return true;
    }

    public boolean isFullHouse(ArrayList<Card> summaryCards){
        bestCombination.clear();
        //making best combination
        return true;
    }

    public boolean isFlush(ArrayList<Card> summaryCards){
        bestCombination.clear();
        //making best combination
        return true;
    }

    public boolean isStraight(ArrayList<Card> summaryCards){
        bestCombination.clear();
        //making best combination
        return true;
    }

    public boolean isThreeOfKind(ArrayList<Card> summaryCards){
        bestCombination.clear();
        //making best combination
        return true;
    }

    public boolean isTwoPair(ArrayList<Card> summaryCards){
        bestCombination.clear();
        //making best combination
        return true;
    }

    public boolean isOnePair(ArrayList<Card> summaryCards){
        bestCombination.clear();
        //making best combination
        return true;
    }

    public boolean isHighCard(ArrayList<Card> summaryCards){
        bestCombination.clear();
        //making best combination
        return true;
    }
}
