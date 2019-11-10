/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker5;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import static poker5.Poker5.Username;
import static poker5.Poker5.host;
import static poker5.Poker5.port;

/**
 *
 * @author Mohamed
 */
public class Player {
    
    private int clientNo ;
    private Socket socket;
    
  
    

    Player(Socket socket, int clientNo) {
    
        this.clientNo = clientNo ;
        this.socket = socket;
    
    
    }
    
       
   

    public int getClientNo() {
        return clientNo;
    }

    public Socket getSocket() {
        return socket;
    }

 
    
}
