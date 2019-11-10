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
public class Client {
    
    int cn ;
    String name;
    Cards[] card;
    
    
    public Client(int cn,String name,Cards[] card){
        
        this.cn = cn ;
        this.name= name;
        card = new Cards[7];
        
        
    }

    Client() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getCn() {
        return cn;
    }

    public String getName() {
        return name;
    }

    public Cards[] getCard() {
        return card;
    }

    
    
    
    
    public Cards[] sort(){
        
        
        for(int i =0;i<card.length-1;i++){
            for(int j=1;j<card.length;i++){
                
                if(card[j].getFaceValue() <  card[i].getFaceValue()){
                    
                    Cards temp = card[j];
                    card[j] = card[i];
                    card[i] = temp ;
                  
                }
            }
            
        }
        /*
        for(int i=0;i<card.length-1;i++){
            for(int j=1;j<card.length;i++){
                
                if(card[j].getSuitValue() <  card[i].getSuitValue()){
                    
                    Cards temp = card[j];
                    card[j] = card[i];
                    card[i] = temp ;
                  
                }
            }
            
            
            
            
        }*/
        
        
        
        
        return card ;
    }
    
    
    
}
