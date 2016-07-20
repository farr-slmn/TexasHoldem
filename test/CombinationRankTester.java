import com.innopolis.university.bootcamp2016.programmingA.texasholdem.Bot;
import com.innopolis.university.bootcamp2016.programmingA.texasholdem.Card;
import com.innopolis.university.bootcamp2016.programmingA.texasholdem.CombinationRank;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by mer_e on 19.07.2016.
 */
public class CombinationRankTester {
    @Test
    public void testRoyalFlush() {
        ArrayList<Card> playersCards = new ArrayList<>();
        playersCards.add(new Card(Card.CardSuitEnum.CLUBS, Card.CardRankEnum.CARD_10));
        playersCards.add(new Card(Card.CardSuitEnum.CLUBS, Card.CardRankEnum.JACK));
        ArrayList<Card> tableCards = new ArrayList<>();
        tableCards.add(new Card(Card.CardSuitEnum.CLUBS, Card.CardRankEnum.QUEEN));
        tableCards.add(new Card(Card.CardSuitEnum.CLUBS, Card.CardRankEnum.KING));
        tableCards.add(new Card(Card.CardSuitEnum.CLUBS, Card.CardRankEnum.ACE));

        CombinationRank combo = new CombinationRank(playersCards, tableCards);

        Assert.assertEquals(combo.isRoyalFlush(combo.summaryCards), true);


    }
    @Test
    public void testIsOnePair() {
        ArrayList<Card> playersCards = new ArrayList<>();
        playersCards.add(new Card(Card.CardSuitEnum.CLUBS, Card.CardRankEnum.CARD_10));
        playersCards.add(new Card(Card.CardSuitEnum.CLUBS, Card.CardRankEnum.JACK));
        ArrayList<Card> tableCards = new ArrayList<>();
        tableCards.add(new Card(Card.CardSuitEnum.CLUBS, Card.CardRankEnum.CARD_10));
        tableCards.add(new Card(Card.CardSuitEnum.CLUBS, Card.CardRankEnum.KING));
        tableCards.add(new Card(Card.CardSuitEnum.CLUBS, Card.CardRankEnum.ACE));

        CombinationRank combo = new CombinationRank(playersCards, tableCards);

        Assert.assertEquals(combo.isOnePair(combo.summaryCards), true);


    }

    @Test
    public void testIsTwoPair() {
        ArrayList<Card> playersCards = new ArrayList<>();
        playersCards.add(new Card(Card.CardSuitEnum.CLUBS, Card.CardRankEnum.CARD_10));
        playersCards.add(new Card(Card.CardSuitEnum.CLUBS, Card.CardRankEnum.JACK));
        ArrayList<Card> tableCards = new ArrayList<>();
        tableCards.add(new Card(Card.CardSuitEnum.CLUBS, Card.CardRankEnum.CARD_10));
        tableCards.add(new Card(Card.CardSuitEnum.CLUBS, Card.CardRankEnum.JACK));
        tableCards.add(new Card(Card.CardSuitEnum.CLUBS, Card.CardRankEnum.ACE));

        CombinationRank combo = new CombinationRank(playersCards, tableCards);

        Assert.assertEquals(combo.isTwoPair(combo.summaryCards), true);


    }

    @Test
    public void testIsThreeOfKind() {
        ArrayList<Card> playersCards = new ArrayList<>();
        playersCards.add(new Card(Card.CardSuitEnum.SPADES, Card.CardRankEnum.CARD_10));
        playersCards.add(new Card(Card.CardSuitEnum.SPADES, Card.CardRankEnum.JACK));
        ArrayList<Card> tableCards = new ArrayList<>();
        tableCards.add(new Card(Card.CardSuitEnum.SPADES, Card.CardRankEnum.CARD_10));
        tableCards.add(new Card(Card.CardSuitEnum.CLUBS, Card.CardRankEnum.JACK));
        tableCards.add(new Card(Card.CardSuitEnum.CLUBS, Card.CardRankEnum.ACE));

        CombinationRank combo = new CombinationRank(playersCards, tableCards);

        Assert.assertEquals(combo.isThreeOfKind(combo.summaryCards), true);


    }

    @Test
    public void testBestCombination()
    {
        ArrayList<Card> playersCards = new ArrayList<>();
        playersCards.add(new Card(Card.CardSuitEnum.CLUBS, Card.CardRankEnum.CARD_10));
        playersCards.add(new Card(Card.CardSuitEnum.CLUBS, Card.CardRankEnum.JACK));
        ArrayList<Card> tableCards = new ArrayList<>();
        tableCards.add(new Card(Card.CardSuitEnum.CLUBS, Card.CardRankEnum.QUEEN));
        tableCards.add(new Card(Card.CardSuitEnum.CLUBS, Card.CardRankEnum.KING));
        tableCards.add(new Card(Card.CardSuitEnum.CLUBS, Card.CardRankEnum.ACE));

        CombinationRank combo = new CombinationRank(playersCards, tableCards);

        Assert.assertEquals(combo.bestCombination(), CombinationRank.Combinations.ROYAL_FLUSH);


    }

    @Test
    public void testFourOfKind()
    {
        ArrayList<Card> playersCards = new ArrayList<>();
        playersCards.add(new Card(Card.CardSuitEnum.SPADES, Card.CardRankEnum.CARD_10));
        playersCards.add(new Card(Card.CardSuitEnum.CLUBS, Card.CardRankEnum.CARD_10));
        ArrayList<Card> tableCards = new ArrayList<>();
        tableCards.add(new Card(Card.CardSuitEnum.DIAMONDS, Card.CardRankEnum.CARD_10));
        tableCards.add(new Card(Card.CardSuitEnum.HEARTS, Card.CardRankEnum.CARD_10));
        tableCards.add(new Card(Card.CardSuitEnum.CLUBS, Card.CardRankEnum.ACE));

        CombinationRank combo = new CombinationRank(playersCards, tableCards);

        Assert.assertEquals(combo.isFourOfKind(combo.summaryCards), true);


    }

    @Test
    public void testThreeOfKind()
    {
        ArrayList<Card> playersCards = new ArrayList<>();
        playersCards.add(new Card(Card.CardSuitEnum.SPADES, Card.CardRankEnum.CARD_10));
        playersCards.add(new Card(Card.CardSuitEnum.CLUBS, Card.CardRankEnum.CARD_10));
        ArrayList<Card> tableCards = new ArrayList<>();
        tableCards.add(new Card(Card.CardSuitEnum.DIAMONDS, Card.CardRankEnum.CARD_10));
        tableCards.add(new Card(Card.CardSuitEnum.HEARTS, Card.CardRankEnum.KING));
        tableCards.add(new Card(Card.CardSuitEnum.CLUBS, Card.CardRankEnum.ACE));

        CombinationRank combo = new CombinationRank(playersCards, tableCards);

        Assert.assertEquals(combo.isThreeOfKind(combo.summaryCards), true);


    }

    @Test
    public void testFullHouse()
    {
        ArrayList<Card> playersCards = new ArrayList<>();
        playersCards.add(new Card(Card.CardSuitEnum.SPADES, Card.CardRankEnum.CARD_10));
        playersCards.add(new Card(Card.CardSuitEnum.CLUBS, Card.CardRankEnum.CARD_10));
        ArrayList<Card> tableCards = new ArrayList<>();
        tableCards.add(new Card(Card.CardSuitEnum.DIAMONDS, Card.CardRankEnum.CARD_10));
        tableCards.add(new Card(Card.CardSuitEnum.HEARTS, Card.CardRankEnum.KING));
        tableCards.add(new Card(Card.CardSuitEnum.CLUBS, Card.CardRankEnum.KING));

        CombinationRank combo = new CombinationRank(playersCards, tableCards);

        Assert.assertEquals(combo.isFullHouse(combo.summaryCards), true);

        //не работает ибо нужна сортировка суммари кардс
    }

    @Test
    public void testFlush()
    {
        ArrayList<Card> playersCards = new ArrayList<>();
        playersCards.add(new Card(Card.CardSuitEnum.CLUBS, Card.CardRankEnum.CARD_2));
        playersCards.add(new Card(Card.CardSuitEnum.CLUBS, Card.CardRankEnum.CARD_3));
        ArrayList<Card> tableCards = new ArrayList<>();
        tableCards.add(new Card(Card.CardSuitEnum.CLUBS, Card.CardRankEnum.CARD_4));
        tableCards.add(new Card(Card.CardSuitEnum.CLUBS, Card.CardRankEnum.KING));
        tableCards.add(new Card(Card.CardSuitEnum.CLUBS, Card.CardRankEnum.ACE));

        CombinationRank combo = new CombinationRank(playersCards, tableCards);

        Assert.assertEquals(combo.isFlush(combo.summaryCards), true);


    }

    @Test
    public void testStraight()
    {
        ArrayList<Card> playersCards = new ArrayList<>();
        playersCards.add(new Card(Card.CardSuitEnum.CLUBS, Card.CardRankEnum.CARD_2));
        playersCards.add(new Card(Card.CardSuitEnum.CLUBS, Card.CardRankEnum.CARD_3));
        ArrayList<Card> tableCards = new ArrayList<>();
        tableCards.add(new Card(Card.CardSuitEnum.CLUBS, Card.CardRankEnum.CARD_4));
        tableCards.add(new Card(Card.CardSuitEnum.SPADES, Card.CardRankEnum.CARD_5));
        tableCards.add(new Card(Card.CardSuitEnum.CLUBS, Card.CardRankEnum.ACE));

        CombinationRank combo = new CombinationRank(playersCards, tableCards);

        Assert.assertEquals(combo.isStraight(combo.summaryCards), true);

        // АСЕ считается как самая высокая и как самая низкая нужно указать это в коде
    }

}
