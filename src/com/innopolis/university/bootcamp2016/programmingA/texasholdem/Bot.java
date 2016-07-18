package com.innopolis.university.bootcamp2016.programmingA.texasholdem;

import java.util.Random;

/**
 * Created by mer_e on 18.07.2016.
 */
public class Bot extends Player
{
   public int difficulty; // 1 - easy, 2 - medium, 3 - hard

    public Bot()
    {

    }

    public Bot(String bart)
    {
        super(bart);
    }
    public Bot(String bart, int difficulty)
    {
        super(bart);
        this.difficulty = difficulty;
    }


    public void setDifficulty(int difficulty)
    {
        this.difficulty = difficulty;
    }

    public Decision makeDesion()
    {
        return Decision.values()[new Random().nextInt(Decision.values().length)];
    }

}
