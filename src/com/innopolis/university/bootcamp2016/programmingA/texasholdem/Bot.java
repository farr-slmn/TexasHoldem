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

    public Decision makeDesion(Game game)
    {
        if(this.difficulty == 2)
        {
            return mediumLevel();
        }
          else if (this.difficulty == 3)
        {
            return  hardLevel(game);
        }
        else
        {
            return Decision.values()[new Random().nextInt(Decision.values().length)];
        }
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
