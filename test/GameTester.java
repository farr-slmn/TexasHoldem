import com.innopolis.university.bootcamp2016.programmingA.texasholdem.Game;
import com.innopolis.university.bootcamp2016.programmingA.texasholdem.Player;
import org.junit.Assert;
import org.junit.Test;

import java.io.PrintStream;


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
        Game game = new Game(50000, new Player("Tamara"), new Player("John"), new Player("Albert"), new Player("Zak"));
        int was = game.getCurrPlayers().size();
        int become = game.getCurrPlayers().size();
        become += sb.toString().split("FOLDS").length - 1;
        Assert.assertEquals(was, become);
    }
}
