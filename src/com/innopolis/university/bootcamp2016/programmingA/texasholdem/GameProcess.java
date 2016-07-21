package com.innopolis.university.bootcamp2016.programmingA.texasholdem;


public class GameProcess {
    public static void main(String[] args) {
        //Game game = new Game(50000, new Player("Tamara", 10000000), new Player("John", 50), new Bot("Albert"), new Player("Zak",500005));
        Game game = new Game(500, new Bot("Albert", 2), new Bot("John", 2), new Bot("Zion", 2), new Bot("Carbon", 2));
        game.currStage = Game.GameStage.START;
        while(true) {
            if(game.runNextStage() == Game.GameStage.END)
                break;
            while(game.runNextStage() != Game.GameStage.END);
            game.runNextStage();
            game.currStage = Game.GameStage.START;
        }
        //OUTPUT START
        for (Player p : game.players)
            System.out.println(p + " [Bank: " + p.getMoney() + "]");
        //OUTPUT END

    }
}
