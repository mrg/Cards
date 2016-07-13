package com.rubicode;

import junit.framework.TestCase;

public class TestCard extends TestCase
{
    public void test1()
    {
        Card card = new Card(RankType.ACE, SuitType.SPADE);

        assertEquals(RankType.ACE, card.getRank());
        assertEquals(SuitType.SPADE, card.getSuit());
    }

    public void test2()
    {
        Card card = new Card(RankType.JACK, SuitType.HEART);

        assertEquals("JACK of HEARTS", card.toString());
    }
}
