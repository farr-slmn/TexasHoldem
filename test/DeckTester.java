import com.innopolis.university.bootcamp2016.programmingA.texasholdem.Card;
import com.innopolis.university.bootcamp2016.programmingA.texasholdem.Deck;
import com.innopolis.university.bootcamp2016.programmingA.texasholdem.Game;
import com.innopolis.university.bootcamp2016.programmingA.texasholdem.Player;
import org.junit.Assert;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;

public class DeckTester {
    @Test
    public void testy(){
        StringBuffer sb = new StringBuffer();
        System.setOut(new PrintStream(System.out) {
            public void println(String s) {
                sb.append(s);
                super.println(s);
            }
        });
        Deck deck = new Deck();
        ArrayList<Card> was = deck.getCards();
        deck.shuffleDeck();
        ArrayList<Card> become = deck.getCards();



        Assert.assertEquals(was, become);


    }
}