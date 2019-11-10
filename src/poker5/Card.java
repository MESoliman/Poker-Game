/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker5;

/**
 *
 * @author Mohamed
 */
public class Card {
    
    
    private int suit;
    private int value;

    public Card() // Ace of Hearts default
    {
        suit = 1;
        value = 1;
    }

    public Card(int s, int v) {
        suit = s;
        value = v;
    }

    public int getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }

    public void setSuit(int s) {
        suit = s;
    }

    public void setValue(int v) {
        value = v;
    }

    public String getName() // returns string, e.g., "Ace of Hearts"
    {
        String name = " ";
        if (value == 1)
            name = "Ace of";
        else if (value == 11)
            name = "Jack of";
        else if (value == 12)
            name = "Queen of";
        else if (value == 13)
            name = "King of";
        else // use the numerical value
            name = value + " of";
        // Add on the suit

        if (suit == 1)
            name += " Hearts";
        else if (suit == 2)
            name += " Diamonds";
        else if (suit == 3)
            name += " Clubs";
        else if (suit == 4)
            name += " Spades";
        return name;
    }
    
}
