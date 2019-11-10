/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker5;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import static javafx.scene.paint.Color.color;
import static javafx.scene.paint.Color.color;
import javafx.stage.Stage;
import javax.imageio.ImageIO;


/**
 *
 * @author Mohamed
 */
public class Poker5 extends Application {
    
   public static String Serv , user ; 
   public static TextField bet  = new TextField();
   public static TextField ServerIp = new TextField();
   public static TextField Username = new TextField();
   public static int port = 8000;
   public static String host = "localhost";
   static Socket s ;
   DataInputStream din ;
   DataOutputStream dout = null;
   String X = "1000$"; 
   TextArea ind = new TextArea();
   ImageView image2 ;
   ImageView image3 ;
   GridPane pane1 = new GridPane();
   ImageView TCard1 ;
   ImageView TCard2 ;
   ImageView TCard3;
   ImageView TCard4;
   ImageView TCard5;
   Socket socket;
   ImageView[] Players = new ImageView[4];
   int w = 0;
   Button roundButton = new Button();
   Button roundButton1 = new Button();
   Button roundButton2 = new Button();
   String no;
   Label Money = new Label();
   AnchorPane An2 = new AnchorPane();
   
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Start Game");
        
          roundButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
            
                try {
                    sendToServer("Player "+no+" Checked");
                } catch (IOException ex) {
                    Logger.getLogger(Poker5.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            }
          });
          
          roundButton1.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
            
                try {
                    sendToServer("Player "+no+" Folded");
                    
                    
                    Platform.runLater(() -> { 
                        
                        image2.setVisible(false);
                        image3.setVisible(false);
                        pane1.setDisable(true);
                        
                    });
                    
                    
                } catch (IOException ex) {
                    Logger.getLogger(Poker5.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            }
          });
          
          
          roundButton2.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
            
                try {
                    sendToServer("Player " +no+" Raised "+ bet.getText().trim());
                    
                    
              
                   
                    
                } catch (IOException ex) {
                    Logger.getLogger(Poker5.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            }
          });
        
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
         
               
               Stage stage = new Stage();
               
               
               
               
               Money.setText(X);
               An2.setStyle(
               "-fx-background-color: #081c2a;-fx-width:10px"
               );
              
              
               An2.getChildren().add(Money);
               
               
               AnchorPane An3 = new AnchorPane();
               
               
               ind.setPrefWidth(300);
               ind.setPrefHeight(180);
               
               An3.setLayoutX(500);
               An3.getChildren().add(ind);
          
               
               AnchorPane An1 = new AnchorPane();
               An1.setStyle("-fx-background-color: #111c0a");
               
               
               GridPane pane = new GridPane();
               pane.setLayoutX(50);
               pane.setLayoutY(480);
               pane.setPrefWidth(200);
               pane.setPrefHeight(100);
               pane.setPadding(new Insets(5.0,5.0,5.0,5.0));
               pane.setHgap(5.5);
               pane.setVgap(5.5);
               pane.setStyle("-fx-background-color:#200c04;-fx-opacity:0.8");
               pane.toFront();
               
               
               GridPane Table = new GridPane();
               Table.setLayoutX(200);
               Table.setLayoutY(300);
               Table.toFront();
               Table.setStyle("-fx-background-color:#016a09;-fx-opacity:0.7");
               Table.setPrefWidth(400);
               Table.setPrefHeight(100);
               
               
               ImageView image1 = new ImageView("/Images/field.png");
               image1.setX(85);
               image1.setY(170);
               
               
               pane1.setLayoutX(480);
               pane1.setLayoutY(480);
               pane1.setPrefWidth(200);
               pane1.setPrefHeight(100);
               pane1.setPadding(new Insets(5.0,5.0,5.0,5.0));
               pane1.setHgap(5.5);
               pane1.setVgap(5.5);
               pane1.setStyle("-fx-background-color:#200c04;-fx-opacity:0.8");
               pane1.toFront();
               
              
               roundButton.setText("Check");
        roundButton.setStyle(
                "-fx-background-radius: 40em; " +
                
                "-fx-min-width: 80px; " +
                "-fx-min-height: 40px; " +
                "-fx-max-width: 80px; " +
                "-fx-max-height: 40px;" +
                "-fx-text-align: center;" 
                
        );
        
        
        
        roundButton1.setText("Fold");
        roundButton1.setStyle(
                "-fx-background-radius: 40em; " +
               
                "-fx-min-width: 80px; " +
                "-fx-min-height: 40px; " +
                "-fx-max-width: 80px; " +
                "-fx-max-height: 40px;"
        );
        
  
        roundButton2.setText("Raise");
        roundButton2.setStyle(
                "-fx-background-radius: 40em; " +
                
                "-fx-min-width: 80px; " +
                "-fx-min-height: 40px; " +
                "-fx-max-width: 80px; " +
                "-fx-max-height: 40px;"
        );

        
               
               
               
               Players[1] = new ImageView("/Images/Player.png");
               
               Players[1].setFitHeight(80);
               Players[1].setFitWidth(50);
               Players[1].setX(100);
               Players[1].setY(100);
               Players[1].toFront();
               
              
               Players[2] = new ImageView("/Images/Player.png");
               Players[2].setFitHeight(80);
               Players[2].setFitWidth(50);
               Players[2].setX(300);
               Players[2].setY(80);
               Players[2].toFront();
               
               Players[0] = new ImageView("/Images/Player.png");
               Players[0].setFitHeight(80);
               Players[0].setFitWidth(50);
               Players[0].setX(20);
               Players[0].setY(250);
               Players[0].toFront();
               
               Players[3] = new ImageView("/Images/Player.png");
               Players[3].setFitHeight(80);
               Players[3].setFitWidth(50);
               Players[3].setX(720);
               Players[3].setY(250);
               Players[3].toFront();
               
               Players[0].setVisible(false);
               Players[1].setVisible(false);
               Players[2].setVisible(false);
               Players[3].setVisible(false);
                       
               
               
               
               
              
                       
                  
            
             
               ImageView Wood = new ImageView("/Images/Wood.jpg");
               Wood.setFitHeight(600);
               Wood.setFitWidth(800);
               Wood.toBack();
               
               
               
               pane1.add(bet, 0, 0);
               pane1.add(roundButton, 0, 1);
               pane1.add(roundButton1, 1, 1);
               pane1.add(roundButton2, 1, 0);
               pane1.setDisable(true);
               An1.getChildren().addAll(Wood,An3,An2,image1,pane,pane1,Table,Players[0],Players[1],Players[2],Players[3]);
               
               
               Scene sc = new Scene(An1,800,600);
               stage.setTitle("Game");
               stage.setScene(sc);
               stage.show();
               primaryStage.close();
               
               new Thread(()-> { 
                   
               
                   try {
                       socket = new Socket(host,port);
                   } catch (IOException ex) {
                       Logger.getLogger(Poker5.class.getName()).log(Level.SEVERE, null, ex);
                   }
               connectToServer();
                  
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
                  
                  
                   try {
                       String A =  receiveFromServer();
                       
                       String[] temp = A.split(" ");
                       
                        no = temp[2];
                       
                       String card1 = temp[5];
                       String card2 = temp[6];
                       
                       String tabCard1 = temp[7];
                       String tabCard2 = temp[8];
                       String tabCard3 = temp[9];
                       String tabCard4 = temp[10];
                       String tabCard5 = temp[11];
                       
                  Platform.runLater(() -> {
                       
                      
                       
                      if(no.equals("1")){}
                      
                      if(no.equals("2")){ Players[3].setVisible(true);}
                      
                      
                      if(no.equals("3")){ Players[2].setVisible(true);  Players[3].setVisible(true);}
                      
                      
                      if(no.equals("4")){ Players[1].setVisible(true); Players[2].setVisible(true);Players[3].setVisible(true); }
                      
                      
                      if(no.equals("5")){ Players[1].setVisible(true); Players[2].setVisible(true);
                      
                      
                      
               Players[3].setVisible(true);
               Players[0].setVisible(true);}
                       
               TCard1 = new ImageView(deck[Integer.parseInt(tabCard1)].getCardImage());
               TCard1.setFitHeight(100);
               TCard1.setFitWidth(80);
               Table.add(TCard1, 0, 0);  
               TCard1.setVisible(false);
               
               
               TCard2 = new ImageView(deck[Integer.parseInt(tabCard2)].getCardImage());
               TCard2.setFitHeight(100);
               TCard2.setFitWidth(80);
               Table.add(TCard2, 1, 0);
               TCard2.setVisible(false);
               
               TCard3 = new ImageView(deck[Integer.parseInt(tabCard3)].getCardImage());
               TCard3.setFitHeight(100);
               TCard3.setFitWidth(80);
               TCard3.setVisible(false);
               Table.add(TCard3, 2, 0);
               
               TCard4 = new ImageView(deck[Integer.parseInt(tabCard4)].getCardImage());
               TCard4.setFitHeight(100);
               TCard4.setFitWidth(80);
               TCard4.setVisible(false);
               Table.add(TCard4, 3, 0);
               
               
               TCard5 = new ImageView(deck[Integer.parseInt(tabCard5)].getCardImage());
               TCard5.setFitHeight(100);
               TCard5.setFitWidth(80);
               TCard5.setVisible(false);
               Table.add(TCard5, 4, 0);
               
               
               
                           
                          
               image2 = new ImageView(deck[Integer.parseInt(card1)].getCardImage());
               image3 = new ImageView(deck[Integer.parseInt(card2)].getCardImage());
               image2.setFitHeight(100);
               image2.setFitWidth(90);
               pane.add(image2, 0, 0);
               
               image3.setFitHeight(100);
               image3.setFitWidth(90);
               pane.add(image3, 2, 0);
             
               image2.setVisible(false);
               image3.setVisible(false);
                    ind.appendText(A);
                    ind.appendText("\n");
                });
                     
                     
                      
                       try
                       {
                          
                          
                         while(true){
                             
                              
                             
                          String p =din.readUTF();
                          
                          String[] h = p.split(" ");
                  
                          
                       try{   
                          if(h[2].equals("Entered")){
                              
                              
                              Platform.runLater(() -> {
                                  
                                
                                  Players[w].setVisible(true);
                                  w++;
                              
                });
                              
                              
                              
                          }}
                       catch(Exception e)
                       {    System.out.println(e);     }
                         
                        
                         
                          if(h[0].equals("Start"))
                                      {
                                          Platform.runLater(() -> {
                                       
                                          image2.setVisible(true);
                                          image3.setVisible(true);
                                    });   }
                          
                          if(p.trim().equals("Deal Three Cards"))
                                      {
                                          Platform.runLater(() -> {
                                          TCard1.setVisible(true);
                                          TCard2.setVisible(true);
                                          TCard3.setVisible(true);
                               
                                    });   }
                          
                          if(p.trim().equals("Deal The Fifth Card"))
                                      {
                                          Platform.runLater(() -> {
                                          
                                              TCard5.setVisible(true);
                               
                                    });   }
                          
                          if(p.trim().equals("Deal The Fourth Card"))
                                      {
                                          Platform.runLater(() -> {
                                   
                                               TCard4.setVisible(true);
                                              
                                    });   }
                          
                          
                          if(p.trim().equals("Player One Turn") && no.equals("1"))
                                      {
                                          
                                          
                                        
                                          Platform.runLater(() -> {
                                          
                                              pane1.setDisable(false);
                                          
                                    });   }
                        
                          if(p.trim().equals("Player Two Turn") && !no.equals("2"))
                                      {
                                          
                                          Platform.runLater(() -> {
                                              
                                              
                                          
                                              pane1.setDisable(true);
                                              
                                              
                                              
                                    });   }
                          
                          if(p.trim().equals("Player Three Turn") && !no.equals("3"))
                                      {
                                          
                                          Platform.runLater(() -> {
                                          
                                              pane1.setDisable(true);
                                              
                                              
                                              
                                    });   }
                          
                          if(p.trim().equals("Player Four Turn") && !no.equals("4"))
                                      {
                                          
                                          Platform.runLater(() -> {
                                          
                                              pane1.setDisable(true);
                                              
                                              
                                              
                                    });   }
                          
                          if(p.trim().equals("Player Five Turn") && !no.equals("5"))
                                      {
                                      
                                          Platform.runLater(() -> {
                                          
                                              pane1.setDisable(true);
                                              
                                              
                                              
                                    });   }
                          
                          if(p.trim().equals("Player Two Turn") && no.equals("2"))
                                      {
                                        
                                          
                                          Platform.runLater(() -> {
                                          
                                              pane1.setDisable(false);
                                              
                                              
                                              
                                    });   }
                          
                          if(p.trim().equals("Player Three Turn") && no.equals("3"))
                                      {    
                                          Platform.runLater(() -> {
                                          
                                              pane1.setDisable(false);
                                              
                                              
                                              
                                    });   }
                          
                          if(p.trim().equals("Player Four Turn") && no.equals("4"))
                                      {   
                                          
                                          Platform.runLater(() -> {
                                          
                                              
                                              pane1.setDisable(false);
                                              
                                              
                                              
                                    });   }
                          
                          
                          if(p.trim().equals("Player Five Turn") && no.equals("5"))
                                      {   
                                          Platform.runLater(() -> {
                                          
                                              pane1.setDisable(false);
                                              
                                              
                                              
                                    });   }
                          
                          
                           Platform.runLater(() -> {
                  ind.appendText(p);
                });
                           
                         }
                       
                         
                         
                       }
                       
                       catch (IOException ex) {
                                 Logger.getLogger(ServerS.class.getName()).log(Level.SEVERE, null, ex);
                             }
                       
                     
                   
                   
            
                   
              
            } catch (IOException ex) {
                                 Logger.getLogger(ServerS.class.getName()).log(Level.SEVERE, null, ex);
                             }
                   
                   
                   }).start();
                    
                
            }
        });
        
       // StackPane root = new StackPane();
        AnchorPane An1 = new AnchorPane();
        
        An1.setStyle("-fx-border-width: 1; -fx-background-color: #240000");
       
        
        
        GridPane pane = new GridPane();
        pane.setLayoutX(235);
        pane.setLayoutY(120);
        pane.setPrefWidth(250);
        pane.setPrefHeight(300);
        pane.setPadding(new Insets(5.0,5.0,5.0,5.0));
        pane.setHgap(5.5);
        pane.setVgap(5.5);
        pane.setStyle("-fx-background-color:#360d27;-fx-opacity:0.8");
        pane.add(ServerIp,8,10);
        pane.add(Username, 8, 18);
        pane.add(btn, 8, 25);
        ImageView image2 = new ImageView("/Images/images.jpg");
        image2.setFitHeight(100);
        image2.setFitWidth(150);
        pane.add(image2, 8, 0);
        
        ServerIp.promptTextProperty().setValue("Server IP");
        ServerIp.textProperty().setValue("localhost");
        Username.promptTextProperty().setValue("Username");
        
        
        ImageView image1 = new ImageView("/Images/Chips.jpg");
        image1.setFitHeight(500);
        image1.setFitWidth(700);
        ImageView image3 = new ImageView("/Images/aces.png");
        image3.setFitHeight(180);
        image3.setFitWidth(250);
        image3.setLayoutX(240);
        
        
        
        
      
        
        An1.getChildren().addAll(image1,pane,image3);
        
        Scene scene = new Scene(An1,700,500);
       
        primaryStage.setTitle("Poker");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void connectToServer(){
        
        try{
                   
                   
                   
              
              dout = new DataOutputStream(socket.getOutputStream());
              din = new DataInputStream(socket.getInputStream());
              
                       
             
              }
              catch(IOException ex){
                  System.out.println(ex);
              }  
        
             
             try
              {
                  
              String msgout="";
              msgout = Username.getText().trim();  
              dout.writeUTF(msgout);
              dout.flush();
              
              
             
              }
              catch(IOException ex)
              {
              System.err.println(ex);
              }
        
        
    }
    
    
    public void sendToServer(String s) throws IOException{
        
        dout.writeUTF(s);
        
    }
    
    public String receiveFromServer() throws IOException{
        
       String in =  din.readUTF();
        
       return in ;
    }
    
    
    /*
    class readFromServer implements Runnable{
         
         private Socket socket;
         
         public readFromServer(Socket socket){
             this.socket = socket;
         }
         
         public void run(){
             try{
                 DataInputStream inputFromServer = new DataInputStream(socket.getInputStream());
                 
                 while(true ){
                     String s = inputFromServer.readUTF();
                     
                     Platform.runLater(new Runnable() {
                         @Override
                         public void run() {
                             
                             ind.appendText(s);
                             String temp[]= s.split(" ");
                             int x = Integer.parseInt(temp[0]);
                             int y = Integer.parseInt(temp[1]);
                       
                             Platform.runLater(() -> {
                
                    image2 = new ImageView("/Images/AS.png");
                    image3 = new ImageView("/Images/2S.png");
                });
                            
                         }
                     });
                 }
             }
             catch(IOException e){
                 e.printStackTrace();
             }
         }
     }*/
    /*
    void InitializeDeck() throws IOException{
        
        
        
        
    }
      */         
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        launch(args);
   
        
    }
 
    
}
