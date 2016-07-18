import com.innopolis.university.bootcamp2016.programmingA.texasholdem.Bot;
import com.innopolis.university.bootcamp2016.programmingA.texasholdem.Game;
import com.innopolis.university.bootcamp2016.programmingA.texasholdem.Player;
import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;

/**
 * Created by mer_e on 18.07.2016.
 */
public class PlayerTester
{
    @Test
    public final static InputStream in = null;
    public void testy(){
        Game game = new Game(50000, new Player("Tamara"), new Player("John"), new Player("Albert"), new Player("Zak"));
        Player player = new Player();


       player.makeDecision(game);





        Assert.assertEquals(bot1.difficulty,1);
        Assert.assertEquals(bot2.difficulty,2);
        Assert.assertEquals(bot3.difficulty,3);

    }
}
