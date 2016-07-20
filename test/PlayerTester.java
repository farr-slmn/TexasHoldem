import com.innopolis.university.bootcamp2016.programmingA.texasholdem.Bot;
import com.innopolis.university.bootcamp2016.programmingA.texasholdem.Card;
import com.innopolis.university.bootcamp2016.programmingA.texasholdem.Game;
import com.innopolis.university.bootcamp2016.programmingA.texasholdem.Player;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * Created by mer_e on 18.07.2016.
 */
public class PlayerTester
{
    enum Decision
    {
        CALL, RAISE, FOLD;
    }


    @Test
    public void testCall(){


        Game game = new Game(50000, new Player("Tamara"), new Player("John"), new Player("Albert"), new Player("Zak"));
        Player player = new Player();

        InputStream old = System.in;
        String userinput = "1";
        System.setIn(new ByteArrayInputStream(userinput.getBytes(StandardCharsets.UTF_8)));


        Assert.assertEquals(Player.Decision.CALL.name(), player.makeDecision(game).name());

        System.setIn(old);

    }

    @Test
    public void testRaise(){


        Game game = new Game(50000, new Player("Tamara"), new Player("John"), new Player("Albert"), new Player("Zak"));
        Player player = new Player();

        InputStream old = System.in;
        String userinput = "2";
        System.setIn(new ByteArrayInputStream(userinput.getBytes(StandardCharsets.UTF_8)));


        Assert.assertEquals(Player.Decision.RAISE.name(), player.makeDecision(game).name());

        System.setIn(old);

    }

    @Test
    public void testFold(){


        Game game = new Game(50000, new Player("Tamara"), new Player("John"), new Player("Albert"), new Player("Zak"));
        Player player = new Player();

        InputStream old = System.in;
        String userinput = "2";
        System.setIn(new ByteArrayInputStream(userinput.getBytes(StandardCharsets.UTF_8)));


        Assert.assertEquals(Player.Decision.FOLD.name(), player.makeDecision(game).name());

        System.setIn(old);

    }





    @Test
    public void testMoneySetting(){


        Game game = new Game(50000, new Player("Tamara"), new Player("John"), new Player("Albert"), new Player("Zak"));
        Player player = new Player();

        player.setMoney(10000);


        Assert.assertEquals(player.getMoney(), 10000);



    }

    @Test
    public void testCardsSetting(){



        Player player = new Player();
        player.setCards(new Card[]{new Card(Card.CardSuitEnum.CLUBS, Card.CardRankEnum.CARD_10), new Card(Card.CardSuitEnum.CLUBS, Card.CardRankEnum.CARD_9)});



        Assert.assertEquals(player.getCards().length, 2);



    }
}
