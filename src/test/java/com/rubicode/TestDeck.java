package com.rubicode;

import junit.framework.TestCase;

public class TestDeck extends TestCase
{
    public void test1() throws EmptyDeckException
    {
        Deck deck = new Deck();

        assertEquals(52, deck.size());
        assertTrue(deck.isNotEmpty());
        assertFalse(deck.isEmpty());

        Card card = deck.draw();

        System.out.println(card);

        assertEquals(SuitType.SPADE, card.getSuit());
        assertEquals(RankType.KING, card.getRank());

        while (deck.size() != 1)
            deck.draw();

        card = deck.draw();

        System.out.println(card);

        assertEquals(SuitType.CLUB, card.getSuit());
        assertEquals(RankType.ACE, card.getRank());
    }

    public void test2() throws EmptyDeckException
    {
        Deck shuffledDeck   = new Deck();
        Deck unshuffledDeck = new Deck();

        boolean entirelyTheSame = true;

        shuffledDeck.shuffle();

        assertEquals(52, shuffledDeck.size());
        assertEquals(52, unshuffledDeck.size());

        while (shuffledDeck.isNotEmpty() && entirelyTheSame)
        {
            Card card1 = shuffledDeck.draw();
            Card card2 = unshuffledDeck.draw();

            System.out.println(card1 + " / " + card2);

            // Can use != here because they share the same reference Card objects.
            if (card1 != card2)
                entirelyTheSame = false;
        }

        if (entirelyTheSame)
            throw new AssertionError("Decks appear to not be shuffling.");
    }

    public void test3() throws EmptyDeckException
    {
        Deck deck = new Deck();

        deck.shuffle();

        assertEquals(52, deck.size());

        for (int i = 0; i < 26; i++)
            deck.draw();

        assertEquals(26, deck.size());

        for (int i = 0; i < 25; i++)
            deck.draw();

        assertEquals(1, deck.size());
        assertTrue(deck.isNotEmpty());
        assertFalse(deck.isEmpty());

        deck.draw();

        assertEquals(0, deck.size());
        assertTrue(deck.isEmpty());
        assertFalse(deck.isNotEmpty());

        try
        {
            deck.draw();
        }
        catch (EmptyDeckException e)
        {
        }
    }

    public void test4() throws EmptyDeckException
    {
        Deck deck = new Deck();

        deck.shuffle();

        assertEquals(52, deck.size());

        for (int i = 0; i < 48; i++)
            deck.draw();

        assertEquals(4, deck.size());

        deck.shuffle();

        assertEquals(4, deck.size());
    }

    public void test5() throws EmptyDeckException
    {
        Deck deck = new Deck();

        deck.shuffle();

        while (deck.isNotEmpty())
            System.out.println(deck.draw());
    }
}
