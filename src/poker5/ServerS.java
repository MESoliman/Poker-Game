/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import static java.lang.Double.max;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

/**
 *
 * @author Mohamed
 */
public class ServerS extends Application {
    
    private TextArea ta = new TextArea();
    private int clientNo = 0;
    Cards[] deck = new Cards[51];
    DataInputStream inputFromClient ;
    DataOutputStream dout ;
    int x = 0;
    Player[] p = new Player[5] ;
    int[] card = new int[51];
    int n,m,c1,c2,c3,c4,c5;
    String[] msg = new String[4];
    int z = 0;
    String fromp = "Player Checked";
    public int c = 0;
    public String[] play = new String[5];
    int deal = 0;
    boolean[] isfold = new boolean[5];
    boolean[] iscalled = new boolean[5];
    boolean[] ischecked = new boolean[5];
    boolean[] israised = new boolean[5];
    
    Client[] cl = new Client[5];
    int[] ca = new int[7];
    receiver[] r = new receiver[5];
    String[] hy = new String[5];
    int call = 0;
    Cards[] sv = new Cards[7];
    
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        
          
        
        
        Scene scene = new Scene(new ScrollPane(ta), 450, 300);
        
        primaryStage.setTitle("Server");
        primaryStage.setScene(scene);
        primaryStage.show();
    
        
        for(int i=0;i<51;i++)
        {
            card[i]=i;
        }
        
         
            Random rand = new Random();

            
            
        
        
        new Thread(() -> {
            try{
                ServerSocket serversocket = new ServerSocket(8000);
                
                
                
                  Cards[] deck = new Cards[52];   
               
                  deck[0] = new Cards("Spades","Ace","/Images/AS.png",14,4);
                  deck[1] = new Cards("Spades","Two","/Images/2S.png",2,4);
                  deck[2] = new Cards("Spades","Three","/Images/3S.png",3,4);
                  deck[3] = new Cards("Spades","Four","/Images/4S.png",4,4);
                  deck[4] = new Cards("Spades","Five","/Images/5S.png",5,4);
                  deck[5] = new Cards("Spades","Six","/Images/6S.png",6,4);
                  deck[6] = new Cards("Spades","Seven","/Images/7S.png",7,4);
                  deck[7] = new Cards("Spades","Eight","/Images/8S.png",8,4);
                  deck[8] = new Cards("Spades","Nine","/Images/9S.png",9,4);
                  deck[9] = new Cards("Spades","Ten","/Images/10S.png",10,4);
                  deck[10] = new Cards("Spades","Jack","/Images/JS.png",11,4);
                  deck[11] = new Cards("Spades","Queen","/Images/QS.png",12,4);
                  deck[12] = new Cards("Spades","King","/Images/KS.png",13,4);
                  
                  
                  deck[13] = new Cards("Hearts","Ace","/Images/AH.png",14,3);
                  deck[14] = new Cards("Hearts","Two","/Images/2H.png",2,3);
                  deck[15] = new Cards("Hearts","Three","/Images/3H.png",3,3);
                  deck[16] = new Cards("Hearts","Four","/Images/4H.png",4,3);
                  deck[17] = new Cards("Hearts","Five","/Images/5H.png",5,3);
                  deck[18] = new Cards("Hearts","Six","/Images/6H.png",6,3);
                  deck[19] = new Cards("Hearts","Seven","/Images/7H.png",7,3);
                  deck[20] = new Cards("Hearts","Eight","/Images/8H.png",8,3);
                  deck[21] = new Cards("Hearts","Nine","/Images/9H.png",9,3);
                  deck[22] = new Cards("Hearts","Ten","/Images/10H.png",10,3);
                  deck[23] = new Cards("Hearts","Jack","/Images/JH.png",11,3);
                  deck[24] = new Cards("Hearts","Queen","/Images/QH.png",12,3);
                  deck[25] = new Cards("Hearts","King","/Images/KH.png",13,3);
                 
                  
                  deck[26] = new Cards("Clubs","Ace","/Images/AC.png",14,1);
                  deck[27] = new Cards("Clubs","Two","/Images/2C.png",2,1);
                  deck[28] = new Cards("Clubs","Three","/Images/3C.png",3,1);
                  deck[29] = new Cards("Clubs","Four","/Images/4C.png",4,1);
                  deck[30] = new Cards("Clubs","Five","/Images/5C.png",5,1);
                  deck[31] = new Cards("Clubs","Six","/Images/6C.png",6,1);
                  deck[32] = new Cards("Clubs","Seven","/Images/7C.png",7,1);
                  deck[33] = new Cards("Clubs","Eight","/Images/8C.png",8,1);
                  deck[34] = new Cards("Clubs","Nine","/Images/9C.png",9,1);
                  deck[35] = new Cards("Clubs","Ten","/Images/10C.png",10,1);
                  deck[36] = new Cards("Clubs","Jack","/Images/JC.png",11,1);
                  deck[37] = new Cards("Clubs","Queen","/Images/QC.png",12,1);
                  deck[38] = new Cards("Clubs","King","/Images/KC.png",13,1);
                  
                  deck[39] = new Cards("Diamonds","Ace","/Images/AD.png",14,2);
                  deck[40] = new Cards("Diamonds","Two","/Images/2D.png",2,2);
                  deck[41] = new Cards("Diamonds","Three","/Images/3D.png",3,2);
                  deck[42] = new Cards("Diamonds","Four","/Images/4D.png",4,2);
                  deck[43] = new Cards("Diamonds","Five","/Images/5D.png",5,2);
                  deck[44] = new Cards("Diamonds","Six","/Images/6D.png",6,2);
                  deck[45] = new Cards("Diamonds","Seven","/Images/7D.png",7,2);
                  deck[46] = new Cards("Diamonds","Eight","/Images/8D.png",8,2);
                  deck[47] = new Cards("Diamonds","Nine","/Images/9D.png",9,2);
                  deck[48] = new Cards("Diamonds","Ten","/Images/10D.png",10,2);
                  deck[49] = new Cards("Diamonds","Jack","/Images/JD.png",11,2);
                  deck[50] = new Cards("Diamonds","Queen","/Images/QD.png",12,2);
                  deck[51] = new Cards("Diamonds","King","/Images/KD.png",13,2);
                
                
                ta.appendText("Server Started At "+ new Date() + "\n");
              
                c1 = rand.nextInt(51)+0;
                
                card[c1] = 99;

                c2 = rand.nextInt(51)+0;
                
                while(card[c2] == 99)
                {
                    
                    c2 = rand.nextInt(51) + 0;
                }
                card[c2] = 99;
                
                c3 = rand.nextInt(51)+0;
                
                while(card[c3] == 99)
                {
                    
                    c3 = rand.nextInt(51) + 0;
                }
                card[c3] = 99;
                
                
                c4 = rand.nextInt(51)+0;
                
                while(card[c4] == 99)
                {
                    
                    c4 = rand.nextInt(51) + 0;
                }
                card[c4] = 99;
                
                c5 = rand.nextInt(51)+0;
                
                while(card[c5] == 99)
                {
                    
                    c5 = rand.nextInt(51) + 0;
                }
                card[c5] = 99;
                
                while(true){
                    
                Socket socket =  serversocket.accept();
                
                clientNo++;
                
                
                
                  n = rand.nextInt(51) + 0;
                
                while(card[n] == 99)
                {
                    
                    n = rand.nextInt(51) + 0;
                }
                
                card[n] = 99;
                
                 m =rand.nextInt(51) + 0;
                
                while(card[m] == 99){
                    
                    m = rand.nextInt(51) + 0;
                }
                
                card[m]=99;
               
                
                Platform.runLater(() -> {
                    ta.appendText("Starting thread for client "+ clientNo + " at " + new Date() + "\n");
                    InetAddress inetAddress = socket.getInetAddress();
                    ta.appendText("Client "+ clientNo + "'s Host Name in "+ inetAddress.getHostName()+"\n");
                    ta.appendText("Client " + clientNo + "'s IP Address is "+ inetAddress.getHostAddress()+ "\n");
                });
                
               inputFromClient = new DataInputStream(socket.getInputStream());
                dout = new DataOutputStream(socket.getOutputStream());
                
                String s = inputFromClient.readUTF();
                    
                     Platform.runLater(new Runnable() {
                         @Override
                         public void run() {
                             try {
                                 ta.appendText("Client's name is " + s +"\n");
                                 
                                 
                                 String msg = "Welcome player "+ clientNo +" : " + s +" "+n+" "+m+" "+c1+" "+c2+" "+c3
                                         +" "+c4+" "+c5;
                               
                                 dout.writeUTF(msg);
                                 dout.flush();
                             } catch (IOException ex) {
                                 Logger.getLogger(ServerS.class.getName()).log(Level.SEVERE, null, ex);
                             }
                         }
                     });
                sv[0]=deck[n];
                sv[1]=deck[m];
                sv[2]=deck[c1];
                sv[3]=deck[c2];
                sv[4]=deck[c3];
                sv[5]=deck[c4];
                sv[6]=deck[c5];
                
                
                     
                //cl[x] = new Client(clientNo,s,sv); 
                //HandTypes t = new HandTypes(cl[x].sort());
                p[x] =    new Player(socket,clientNo);
                
                
                Platform.runLater(new Runnable() {
                         @Override
                         public void run() {
                             try {
                                 for(int i =0;i<p.length;i++){
                    
                               
                               if(clientNo == p[i].getClientNo())
                               
                               {
                               
                               DataOutputStream toPlayers = new DataOutputStream(p[i].getSocket().getOutputStream());
                    toPlayers.writeUTF("Game Started at "+new Date()+ "\n");
                               
                               }   
                               else{
                    DataOutputStream toPlayers = new DataOutputStream(p[i].getSocket().getOutputStream());
                    toPlayers.writeUTF(s +" has Entered The Room "+ clientNo + "\n");
                   
                               }
                                  }
                                 
                             } catch (IOException ex) {
                                 Logger.getLogger(ServerS.class.getName()).log(Level.SEVERE, null, ex);
                             }
                         }
                     });
                
                x++;
                
                if(clientNo == 5){
                      
                
                    break;
                }
                }
                Platform.runLater(new Runnable() {
                         @Override
                         public void run() {
                            
                             try {
                               
                                 
                                     for(int i =0;i<p.length;i++){
                                         
                                         DataOutputStream toPlayers = new DataOutputStream(p[i].getSocket().getOutputStream());
                                         toPlayers.writeUTF("Start Game now"+"\n");
                                         
                                     }
                                     
                                   
                                 
                             
                             } catch (IOException ex) {
                                 Logger.getLogger(ServerS.class.getName()).log(Level.SEVERE, null, ex);
                             } 
                             
                         }
                });
                
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ServerS.class.getName()).log(Level.SEVERE, null, ex);
                }
                
               while(true){
                
                             try {
                                  
                                 if(isfold[0] == false){
                                for(int i =0;i<p.length;i++){
                   
                               DataOutputStream toPlayers = new DataOutputStream(p[i].getSocket().getOutputStream());
                               toPlayers.writeUTF("Player One Turn"+"\n");
                                }
                                 
                             
                                DataInputStream  f = new DataInputStream(p[0].getSocket().getInputStream());
                                play[0] = f.readUTF();
                              
                                
                                if(deal > 0 ){
                                    
                                    for(int i =0;i<israised.length;i++){
                                        
                                        if(israised[i]==true){
                                            
                                            iscalled[0]=true;
                                            call = i;
                                            break;
                                        }
                                        
                                    }
                                    
                                 
                                if(iscalled[0]==true && play[0].trim().equals("Player 1 Checked")){
                                    
                                    hy = play[call].split(" ");
                                    play[0] = "Player One Called " + hy[3] ;
                                    
                                    
                                }}
                                
                                hy = play[0].split(" ");
                                if(hy[2].equals("Raised")){
                                    
                                    israised[0] = true;
                                    
                                }
                              
                                if(play[0]==null || play[0].trim().equals("Player 1 Folded"))
                               
                                {isfold[0] = true;
                                    
                                    for(int i =0;i<p.length;i++){
                   
                               DataOutputStream toPlayers = new DataOutputStream(p[i].getSocket().getOutputStream());
                               toPlayers.writeUTF("Player One Folded"+"\n");
                               
                               }
                                }
                                else{
                                 for(int i =0;i<p.length;i++){
                   
                               DataOutputStream toPlayers = new DataOutputStream(p[i].getSocket().getOutputStream());
                               toPlayers.writeUTF(play[0]+"\n");
                               
                               }
                                }
                              }
                                 
                                 if(isfold[1] == false){
                                 for(int i =0;i<p.length;i++){
                   
                               DataOutputStream toPlayers = new DataOutputStream(p[i].getSocket().getOutputStream());
                               toPlayers.writeUTF("Player Two Turn"+"\n");
                               
                               }
                                
                                DataInputStream  f1 = new DataInputStream(p[1].getSocket().getInputStream());
                                play[1] = f1.readUTF();
                                
                                for(int i =0;i<israised.length;i++){
                                        
                                        if(israised[i]==true){
                                            
                                            iscalled[1]=true;
                                            call = i;
                                            break;
                                        }
                                        
                                    }
                                    
                                 
                                if(iscalled[1]==true && play[1].trim().equals("Player 2 Checked")){
                                    
                                    hy = play[call].split(" ");
                                    play[1] = "Player Two Called " + hy[3] ;
                                }
                                
                                
                                hy = play[1].split(" ");
                                if(hy[2].equals("Raised")){
                                    
                                    israised[1] = true;
                                    
                                }
                               
                                
                                if(play[1]==null || play[1].trim().equals("Player 2 Folded"))
                                {
                                    isfold[1] = true;
                                    for(int i =0;i<p.length;i++){
                   
                               DataOutputStream toPlayers = new DataOutputStream(p[i].getSocket().getOutputStream());
                               toPlayers.writeUTF("Player Two Folded"+"\n");
                               
                               
                               }}
                                    else{
                                 for(int i =0;i<p.length;i++){
                   
                               DataOutputStream toPlayers = new DataOutputStream(p[i].getSocket().getOutputStream());
                               toPlayers.writeUTF(play[1]+"\n");
                               
                               }
                                            }}
                                 
                                 if(isfold[2] == false){
                                for(int i =0;i<p.length;i++){
                   
                               DataOutputStream toPlayers = new DataOutputStream(p[i].getSocket().getOutputStream());
                               toPlayers.writeUTF("Player Three Turn"+"\n");
                               
                               }
                                
                              DataInputStream  f2 = new DataInputStream(p[2].getSocket().getInputStream());
                                play[2] = f2.readUTF();
                                
                                
                                for(int i =0;i<israised.length;i++){
                                        
                                        if(israised[i]==true){
                                            
                                            iscalled[2]=true;
                                            call = i;
                                            break;
                                        }
                                        
                                    }
                                    
                                 
                                if(iscalled[2]==true && play[2].trim().equals("Player 3 Checked")){
                                    
                                    hy = play[call].split(" ");
                                    play[2] = "Player Three Called " + hy[3] ;
                                }
                            
                                 
                                hy = play[2].split(" ");
                                if(hy[2].equals("Raised")){
                                    
                                    israised[2] = true;
                                    
                                }
                            
                                if(play[2]==null || play[2].trim().equals("Player 3 Folded"))
                                {
                                    
                                    for(int i =0;i<p.length;i++){
                   
                               DataOutputStream toPlayers = new DataOutputStream(p[i].getSocket().getOutputStream());
                               toPlayers.writeUTF("Player Three Folded"+"\n");
                               isfold[2] = true;
                               
                               }}
                                else{
                                 for(int i =0;i<p.length;i++){
                   
                               DataOutputStream toPlayers = new DataOutputStream(p[i].getSocket().getOutputStream());
                               toPlayers.writeUTF(play[2]+"\n");
                               
                               }}
                                 }
                                 
                                 if(isfold[3] == false){
                                for(int i =0;i<p.length;i++){
                   
                               DataOutputStream toPlayers = new DataOutputStream(p[i].getSocket().getOutputStream());
                               toPlayers.writeUTF("Player Four Turn"+"\n");
                               
                               }
                                
                               DataInputStream  f3 = new DataInputStream(p[3].getSocket().getInputStream());
                                play[3] = f3.readUTF();
                                 
                                
                                for(int i =0;i<israised.length;i++){
                                        
                                        if(israised[i]==true){
                                            
                                            iscalled[3]=true;
                                            call = i;
                                            break;
                                        }
                                        
                                    }
                                    
                                 
                                if(iscalled[3]==true && play[3].trim().equals("Player 4 Checked")){
                                    
                                    hy = play[call].split(" ");
                                    play[3] = "Player Four Called " + hy[3] ;
                                }
                                
                             
                                hy = play[3].split(" ");
                                if(hy[2].equals("Raised")){
                                    
                                    israised[3] = true;
                                    
                                }
                           
                                 if(play[3]==null || play[3].trim().equals("Player 4 Folded"))
                                {
                                    
                                    for(int i =0;i<p.length;i++){
                   
                               DataOutputStream toPlayers = new DataOutputStream(p[i].getSocket().getOutputStream());
                               toPlayers.writeUTF("Player Four Folded"+"\n");
                               isfold[3] = true;
                               
                               }
                                }
                                 else{
                                 for(int i =0;i<p.length;i++){
                   
                               DataOutputStream toPlayers = new DataOutputStream(p[i].getSocket().getOutputStream());
                               toPlayers.writeUTF(play[3]+"\n");
                               
                               }
                                 }}
                                 
                                 if(isfold[4] == false){
                                for(int i =0;i<p.length;i++){
                   
                               DataOutputStream toPlayers = new DataOutputStream(p[i].getSocket().getOutputStream());
                               toPlayers.writeUTF("Player Five Turn"+"\n");
                               
                               }
                               
                                DataInputStream  f4 = new DataInputStream(p[4].getSocket().getInputStream());
                                play[4] = f4.readUTF();
                             
                                
                                for(int i =0;i<israised.length;i++){
                                        
                                        if(israised[i]==true){
                                            
                                            iscalled[4]=true;
                                            call = i;
                                            break;
                                        }
                                        
                                    }
                                    
                                 
                                if(iscalled[4]==true && play[4].trim().equals("Player 5 Checked")){
                                    
                                    hy = play[call].split(" ");
                                    play[4] = "Player Five Called " + hy[3] ;
                                }
                                
                                
                                hy= play[4].split(" ");
                             
                                if(hy[2].equals("Raised")){
                                    
                                    israised[4] = true;
                                    
                                }
                             
                                 if(play[4]==null || play[4].trim().equals("Player 5 Folded"))
                                {
                                    
                                    for(int i =0;i<p.length;i++){
                   
                               DataOutputStream toPlayers = new DataOutputStream(p[i].getSocket().getOutputStream());
                               toPlayers.writeUTF("Player Five Folded"+"\n");
                               isfold[4] = true;
                               }
                                }
                                 else{
                                 for(int i =0;i<p.length;i++){
                   
                               DataOutputStream toPlayers = new DataOutputStream(p[i].getSocket().getOutputStream());
                               toPlayers.writeUTF(play[4]+"\n");
                               
                               }
                                 }}
                                 
                                 Thread.sleep(5000);
                                 
                               /*  if((israised[0]==true && israised[1]==false && israised[2]==false && israised[3]==false && israised[4]==false)
                                     || (israised[0]==false && israised[1]==true && israised[2]==false && israised[3]==false && israised[4]==false)    
                                     || (israised[0]==false && israised[1]==false && israised[2]==true && israised[3]==false && israised[4]==false)
                                     || (israised[0]==false && israised[1]==false && israised[2]==false && israised[3]==true && israised[4]==false)
                                     || (israised[0]==false && israised[1]==false && israised[2]==false && israised[3]==false && israised[4]==true)){
                                 */for(int i =0;i<p.length;i++){
                   
                               DataOutputStream toPlayers = new DataOutputStream(p[i].getSocket().getOutputStream());
                               toPlayers.writeUTF("Deal Three Cards"+"\n");
                               
                               
                               }
                                 
                                 
                                 if(deal == 1){
                                 for(int i =0;i<p.length;i++){
                   
                               DataOutputStream toPlayers = new DataOutputStream(p[i].getSocket().getOutputStream());
                               toPlayers.writeUTF("Deal The Fourth Card"+"\n");
                               
                               }
                                 }
                                 
                                 
                                 if(deal == 2){
                                 for(int i =0;i<p.length;i++){
                   
                               DataOutputStream toPlayers = new DataOutputStream(p[i].getSocket().getOutputStream());
                               toPlayers.writeUTF("Deal The Fifth Card"+"\n");
                                                              }
                                 }
                                 
                             } catch (IOException ex) {
                                 Logger.getLogger(ServerS.class.getName()).log(Level.SEVERE, null, ex);
                             } catch (InterruptedException ex) {
                                 Logger.getLogger(ServerS.class.getName()).log(Level.SEVERE, null, ex);
                             }
                             
                
                
                deal++;
            }
                
                
            }
                
                
             catch (IOException ex) {
                System.err.println(ex);
            }
       
            
    
    
    
            }).start();

        
                }
    
 
        
   class  receiver {

       Player player;
       
       
       
       public receiver(Player player){
       
       this.player = player;
       
   }
       
        
        public String FromUser() {
           
            
            try {
             DataInputStream  f = new DataInputStream(player.getSocket().getInputStream());
                play[c] = f.readUTF();
               c++;
  
           } catch (IOException ex) {
               Logger.getLogger(ServerS.class.getName()).log(Level.SEVERE, null, ex);
           } 
           
            
            return play[c];
        } 
    }

    public static void main(String[] args) {
        launch(args);
    }
 
}
