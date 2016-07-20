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
    public void testy(){
        StringBuffer sb = new StringBuffer();
        System.setOut(new PrintStream(System.out) {
            public void println(String s) {
                sb.append(s);
                super.println(s);
            }
        });
        InputStream old = System.in;
        String userinput = "fold";
        Game game = new Game(50000, new Bot("Tamara"), new Player("John", Long.parseLong("646866556656")), new Player("Albert", 53), new Player("Zak", 79465));
        game.initializeGame();
        int was = game.getCurrPlayers().size();
        System.setIn(new ByteArrayInputStream(userinput.getBytes(StandardCharsets.UTF_8)));
        while(game.runNextStage() != Game.GameStage.END) {
        }
        int become = game.getCurrPlayers().size();
        become += sb.toString().split("FOLDS").length - 1;
        Assert.assertEquals(was, become);
        System.setIn(old);
    }
}
