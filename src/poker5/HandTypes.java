
package poker5;

/**
 *
 * @author Mohamed
 */
public class HandTypes extends Hand{
    
    Cards[] card ;
    
    public HandTypes(Cards[] card){
        
        card = new Cards[7];
        
    }

    public Cards[] getCard() {
        return card;
    }
    
    private static String[] handType = new String[]{
            "(highest card)","(1 pair)","(2 pair)","(three of a kind)",
            "(straight)", "(flush)","(full house)","(four of a kind)",
            "(straight flush)", "(Royal Flush)"
    };

    public int evaluateHand() {

        if (royalFlush())
            return 100;

        else if (straightFlush())
            return 90;

        else if (fourOfAKind())
            return 80;

        else if (fullHouse())
            return 70;

        else if (flush())
            return 60;

        else if (straight())
            return 50;

        else if (threeOfAKind())
            return 40;

        else if (twoPair())
            return 30;

        else if(pair())
            return 20;
        else
            return 10;
    }

    private boolean royalFlush()

    {
       
        //10, J,Q,K,A of the same suit
        boolean sameSuit = false;   // true if all same suit
        boolean isRoyalty = false;  // true if cards are 10,J,K,Q,A
        for (int i = 1; i < card.length; i++) {
            // all five cards of one suit?
            if (suits[i] == 5)
                sameSuit = true;

            // one Ace && one 10 && one J &&one Q&&one K
            if (isRoyalty = (values[1] == 1 &&
                    values[10] == 1 &&
                    values[11] == 1 &&
                    values[12] == 1 &&
                    values[13] == 1))
                isRoyalty = true;
        }

        return (sameSuit && isRoyalty);  // true if both conditions are true
    }

    private boolean straightFlush()
    {
        boolean sameSuit = false;
        boolean ranksInOrder = false;
        // same suit
        for (int i = 1; i<= 4; i++) {
            if (suits[i] == 5)
                sameSuit = true;
            // cards in sequence?
            if(ranksInOrder = cards[1].getValue() == (cards[0].getValue() + 1) &&
                            cards[2].getValue() == (cards[0].getValue() + 2) &&
                            cards[3].getValue() == (cards[0].getValue() + 3) &&
                            cards[4].getValue() == (cards[0].getValue() + 4))
                return true;
        }
        return (sameSuit && ranksInOrder);

    }

    private boolean flush()
    {

        for (int i = 1; i <= 4; i++)
            if (suits[i] == 5)  // all the same suit?
                return true;
        return false;
    }
    private boolean fourOfAKind()
    {
        for (int i = 1 ; i<= 13; i++)
            if (values[i]== 4)
                return true;
        return false;
    }

    private boolean fullHouse() {
        boolean three = false;
        boolean two = false;
        for (int i = 1; i <= 13; i++)
            if (values[i] == 3)     // three of one kind
                three = true;
            else if (values[i] == 2)        // two of another kind
                two = true;
        return two && three;    // both conditions
    }

    private boolean straight()
    {
        // checks value of 5 cards after original card to make sure if its straight and special case is when
        // ace then ten jack queen king!!!!!
        return (cards[1].getValue() == (cards[0].getValue() + 1) && cards[2].getValue() == (cards[0].getValue() + 2) &&
                cards[3].getValue() == (cards[0].getValue() + 3) && cards[4].getValue() == (cards[0].getValue() + 4))
                || ( values[1]==1 && // Ace
                                values[10]==1 && // Ten
                                values[11]==1 && // Jack
                                values[12]==1 && // Queen
                                values[13]==1);  // King
    }

    private boolean threeOfAKind()
    {
        for (int i = 1 ; i <=13; i++)
            if (values[i]== 3)
                return true;
        return false;
    }

    private boolean twoPair() {
        int count = 0;
        for (int i = 1; i <= 13; i++)
            if (values[i] == 2) // count the number of pairs
                count++;
        if (count == 2)
            return true;
        else
            return false;
    }

    private boolean pair()
    {
        for(int i = 1; i <= 13; i++)
            if (values[i] == 2)
                return true;
        return false;
    }
   
}
