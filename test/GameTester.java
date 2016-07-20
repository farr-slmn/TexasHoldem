import com.innopolis.university.bootcamp2016.programmingA.texasholdem.Bot;
import com.innopolis.university.bootcamp2016.programmingA.texasholdem.Game;
import com.innopolis.university.bootcamp2016.programmingA.texasholdem.Player;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class GameTester {
    @Test
    public void testFold(){

        InputStream old = System.in;
        String userinput = "2";
        Game game = new Game(50000, new Bot("Tamara"), new Player("John", 646866556656l), new Player("Albert", 53), new Player("Zak", 79465));
        game.initializeGame();
        int was = game.getCurrPlayers().size();

        System.setIn(new ByteArrayInputStream(userinput.getBytes(StandardCharsets.UTF_8)));


        game.processDecision(game.getCurrPlayer());

        int become = game.getCurrPlayers().size();
        Assert.assertEquals(was, become+1);
        System.setIn(old);
    }

    @Test
    public void testPassTurn(){
        StringBuffer sb = new StringBuffer();

        InputStream old = System.in;
        String userinput = "2";
        Game game = new Game(50000, new Bot("Tamara"), new Player("John", 646866556656l), new Player("Albert", 53), new Player("Zak", 79465));
        game.initializeGame();

        Player curPlayerWas = game.getCurrPlayer();
        game.passTurn(game.getCurrPlayers());
        Player curPlayerBecome = game.getCurrPlayer();

        Assert.assertNotEquals(curPlayerWas, curPlayerBecome);

    }

    @Test
    public void testInitializer()
    {
        Game game = new Game(50000, new Bot("Tamara"), new Player("John", 646866556656l), new Player("Albert", 53), new Player("Zak", 79465));
        game.initializeGame();

        Assert.assertNotEquals(game.getPlayers(), null);
        Assert.assertNotEquals(game.getCurrPlayer(), null);

    }

}
