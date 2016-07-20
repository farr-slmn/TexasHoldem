import com.innopolis.university.bootcamp2016.programmingA.texasholdem.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 * Created by mer_e on 18.07.2016.
 */
public class BotTester {
    @Test
    public void testSetDifficulty() {
        Bot bot1 = new Bot("Bart", 1);
        Bot bot2 = new Bot("Homer", 2);
        Bot bot3 = new Bot("Mardge", 3);


        Assert.assertEquals(bot1.difficulty, 1);
        Assert.assertEquals(bot2.difficulty, 2);
        Assert.assertEquals(bot3.difficulty, 3);

    }

    @Test
    public void testDecisionMaker() {
        Bot bot1 = new Bot("Bart", 2);

        Game game = new Game(50000, new Bot("Tamara"), new Player("John", 646866556656l), new Player("Albert", 53), new Player("Zak", 79465));




        Assert.assertNotEquals(bot1.mediumLevel(), Player.Decision.FOLD);

    }
}
