package com.innopolis.university.bootcamp2016.programmingA.texasholdem;

import java.util.Random;

/**
 * Created by mer_e on 18.07.2016.
 */
public class Bot extends Player
{
   public int difficulty; // 1 - easy, 2 - medium, 3 - hard

    public Bot(String bart)
    {
        super(bart, 1000000);
    }

    public Bot(String bart, int difficulty)
    {
        super(bart, 1000000);
        this.difficulty = difficulty;
    }


    public void setDifficulty(int difficulty)
    {
        this.difficulty = difficulty;
    }

    public Decision makeDecision(Game game)
    {
        Decision decision;
        if(this.difficulty == 2)
        {

            decision = mediumLevel();
        }
          else if (this.difficulty == 3)
        {
            decision = hardLevel(game);
        }
        else
        {
            decision = Decision.values()[new Random().nextInt(Decision.values().length)];
        }
        if(Decision.RAISE.equals(decision))
            raise = new Random().nextInt((int)(getMoney() - game.call))+ game.call + 1;
        return decision;
    }


    public Decision mediumLevel()
    {

        return Decision.values()[new Random().nextInt(Decision.values().length-1)];
    }

    public Decision hardLevel(Game game)
    {
        AiBotDecision ai = new AiBotDecision(game, this);

        return ai.getDecision();

    }

}
