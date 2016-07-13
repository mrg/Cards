package com.rubicode;

/**
 * Represents a standard playing card of a given rank and suit.
 */
public class Card
{
    private final RankType rank; // Card's rank.
    private final SuitType suit; // Card's suit.

    /**
     * Constructs a card instance of the given rank and suit. Ideally, cards
     * will be cached and, if so, == and != can be used to compare them.
     *
     * @param rank
     *            The card's rank.
     * @param suit
     *            The card's suit.
     */
    public Card(RankType rank, SuitType suit)
    {
        this.rank = rank;
        this.suit = suit;
    }

    /**
     * @return The rank of this card.
     */
    public RankType getRank()
    {
        return rank;
    }

    /**
     * @return The suit of this card.
     */
    public SuitType getSuit()
    {
        return suit;
    }

    @Override
    public String toString()
    {
        return rank + " of " + suit + "S";
    }
}
