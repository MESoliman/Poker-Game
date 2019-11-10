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
public class Hand {
    
    
    public static Card[] cards;
    public Deck deck;
    public int suits[];    // holds the number of each suit in a hand
    public int values[];    // holds the number of each type card 

    public Hand() {
        cards = new Card[2];
        suits = new int[4];     
        values = new int[13];   
        deck = new Deck();
    }

    
    public void newHand() {
       
        for (int i = 1; i <=2; i++) {
            cards[i] = deck.deal();
            suits[cards[i].getSuit()]++; //
            values[cards[i].getValue()]++ ; //
        }
        sort();
    }

    
    public static String[] getHand() {
        String[] cardsInHand = new String[2];
        for (int i = 0; i <2; i++)
            cardsInHand[i] = cards[i].getName();
        return cardsInHand;
    }

    private void sort() 
    {
        int max=0; // holds the position of the highest valued card
        for (int place = 2; place > 0; place--) {
           
            for (int i = 1; i <= place; i++) {
                if (cards[i].getValue() > cards[max].getValue())
                    max = i;
            }
           
            Card temp = cards[place];
            cards[place] = cards[max];
            cards[max] = temp;
        }
    }
    
}
