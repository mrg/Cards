package com.rubicode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Represents a standard deck of cards (no Jokers).
 */
public class Deck
{
    // Cache for a pre-built deck to use for creating all new decks of 52 cards.
    private static final List<Card> masterDeck = new ArrayList<Card>(52);

    // Local copy of the deck, initialized to all cards in the master deck.
    private List<Card> deck = new ArrayList<Card>(masterDeck);

    /**
     * Shuffles the deck three times. If you've already drawn cards from the
     * deck, only the remaining cards will be shuffled.
     */
    public void shuffle()
    {
        // Shuffle 3 times.
        for (int i = 0; i < 3; i++)
        {
            // Create the new deck with a size equal to the current deck.
            List<Card> newDeck = new ArrayList<Card>(size());

            while (isNotEmpty())
                newDeck.add(deck.remove(ThreadLocalRandom.current().nextInt(size())));

            deck = newDeck;
        }
    }

    /**
     * Draws a card from the deck (and removes it).
     *
     * @return The card drawn.
     * @throws EmptyDeckException If you try to draw a card from an empty deck.
     */
    public Card draw() throws EmptyDeckException
    {
        // Can't draw a card from an empty deck.
        if (isEmpty())
            throw new EmptyDeckException();

        // Remove from the end for efficiency.
        return deck.remove(size() - 1);
    }

    /**
     * @return The number of cards currently in the deck (0-52).
     */
    public int size()
    {
        return deck.size();
    }

    /**
     * @return True if the deck is empty, false otherwise.
     */
    public boolean isEmpty()
    {
        return deck.isEmpty();
    }

    /**
     * @return True if the deck is not empty, false otherwise.
     */
    public boolean isNotEmpty()
    {
        return isEmpty() == false;
    }

    /*
     * Static class initializer to pre-fill and cache our reference/master deck of cards.
     */
    static
    {
        for (SuitType suit : SuitType.values())
            for (RankType rank : RankType.values())
                masterDeck.add(new Card(rank, suit));
    }
}
