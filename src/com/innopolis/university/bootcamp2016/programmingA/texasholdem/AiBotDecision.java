package com.innopolis.university.bootcamp2016.programmingA.texasholdem;

import java.util.ArrayList;

/**
 * Created by mer_e on 21.07.2016.
 */
public class AiBotDecision
{
        Game game;
        Bot me;
        double probabilityOfWinning;
        double probabilityOfGettingNeededCard;

        public AiBotDecision(Game game, Bot me)
        {
            this.game=game;
            this.me=me;
        }

        public Player.Decision getDecision()
        {
            if(game.currStage==Game.GameStage.Preflop)
            {
                return Player.Decision.CALL;
            }
            else if(game.currStage== Game.GameStage.Flop)
            {
                CombinationRank combo = new CombinationRank( me.getCards(), game.tableCards);

                CombinationRank.Combinations com = combo.bestCombination();

                Deck deck =new Deck();

                deck.cards.removeAll(me.getCards());
                deck.cards.removeAll(game.tableCards);

                ArrayList<Card> addedCards = new ArrayList<>(2);
                CombinationRank.Combinations comTemp=null;
                CombinationRank combTemp;
                int max=0;


                    this.probabilityOfWinning = 0;

                    for(Card c1 : deck.cards)
                    {
                        addedCards.add(c1);


                        addedCards.addAll(game.tableCards);
                        combTemp = new CombinationRank(me.getCards(), addedCards);

                        comTemp = combTemp.bestCombination();



                        if(comTemp.ordinal()>max)
                        {
                            max = comTemp.ordinal();
                            probabilityOfWinning = max;
                            probabilityOfGettingNeededCard = 2/47;
                        }

                        for(Card c2 : deck.cards)
                        {
                            addedCards.add(c2);
                            addedCards.addAll(game.tableCards);
                            comTemp = combo.bestCombination();
                            if(comTemp.ordinal()>max)
                            {
                                max = comTemp.ordinal();
                                probabilityOfGettingNeededCard = 1/47;
                            }
                        }

                        addedCards.clear();
                    }

                    if(comTemp.ordinal() > 5)
                    {
                        return Player.Decision.CALL;
                    }
                    else
                    {
                        return Player.Decision.FOLD;
                    }
                }

            else if(game.currStage== Game.GameStage.Turn)
            {
                CombinationRank combo = new CombinationRank( me.getCards(), game.tableCards);

                CombinationRank.Combinations com = combo.bestCombination();

                Deck deck =new Deck();

                deck.cards.removeAll(me.getCards());
                deck.cards.removeAll(game.tableCards);

                ArrayList<Card> addedCards = new ArrayList<>(2);
                CombinationRank.Combinations comTemp=null;
                CombinationRank combTemp;
                int max=0;


                this.probabilityOfWinning = 0;

                for(Card c1 : deck.cards)
                {
                    addedCards.add(c1);


                    addedCards.addAll(game.tableCards);
                    combTemp = new CombinationRank(me.getCards(), addedCards);

                    comTemp = combTemp.bestCombination();



                    if(comTemp.ordinal()>max)
                    {
                        max = comTemp.ordinal();
                        probabilityOfWinning = max;
                        probabilityOfGettingNeededCard = 2/47;
                    }

                    for(Card c2 : deck.cards)
                    {
                        addedCards.add(c2);
                        addedCards.addAll(game.tableCards);
                        comTemp = combo.bestCombination();
                        if(comTemp.ordinal()>max)
                        {
                            max = comTemp.ordinal();
                            probabilityOfGettingNeededCard = 1/47;
                        }
                    }

                    addedCards.clear();
                }

                if(comTemp.ordinal() > 5 && comTemp.ordinal() < 9)
                {
                    return Player.Decision.CALL;
                }
                else if(comTemp.ordinal() < 5)
                {
                    return Player.Decision.CHECK;
                }
            }
            else if(game.currStage== Game.GameStage.River)
            {
                CombinationRank combo = new CombinationRank( me.getCards(), game.tableCards);

                CombinationRank.Combinations com = combo.bestCombination();

                Deck deck =new Deck();

                deck.cards.removeAll(me.getCards());
                deck.cards.removeAll(game.tableCards);

                ArrayList<Card> addedCards = new ArrayList<>(2);
                CombinationRank.Combinations comTemp=null;
                CombinationRank combTemp;
                int max=0;


                this.probabilityOfWinning = 0;

                for(Card c1 : deck.cards)
                {
                    addedCards.add(c1);


                    addedCards.addAll(game.tableCards);
                    combTemp = new CombinationRank(me.getCards(), addedCards);

                    comTemp = combTemp.bestCombination();



                    if(comTemp.ordinal()>max)
                    {
                        max = comTemp.ordinal();
                        probabilityOfWinning = max;
                        probabilityOfGettingNeededCard = 2/47;
                    }

                    for(Card c2 : deck.cards)
                    {
                        addedCards.add(c2);
                        addedCards.addAll(game.tableCards);
                        comTemp = combo.bestCombination();
                        if(comTemp.ordinal()>max)
                        {
                            max = comTemp.ordinal();
                            probabilityOfGettingNeededCard = 1/47;
                        }
                    }

                    addedCards.clear();
                }

                if(comTemp.ordinal() > 5 && comTemp.ordinal() < 9)
                {
                    return Player.Decision.CALL;
                }
                else if(comTemp.ordinal() < 5)
                {
                    return Player.Decision.CHECK;
                }
                else if(comTemp.ordinal() >= 9)
                {
                    return Player.Decision.RAISE;
                }
            }

                return Player.Decision.CALL;
        }
}
