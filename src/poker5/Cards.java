/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker5;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Mohamed
 */
public class Cards {
    
    private String faceName , Suit,cardImage ;
    private int faceValue,suitValue ;
      
    
    Cards(String faceName,String Suit,String cardImage,int faceValue,int suitValue){
        
        this.faceName = faceName ;
        this.Suit = Suit ;
        this.cardImage = cardImage ;
        this.faceValue = faceValue ;
        this.suitValue = suitValue;
        
    }

 

 

    public String getFaceName() {
        return faceName;
    }

    public String getSuit() {
        return Suit;
    }
    
     public String getCardImage() {
        return cardImage;
    }

    public int getFaceValue() {
        return faceValue;
    }

    public int getSuitValue() {
        return suitValue;
    }

   
    
    
}
