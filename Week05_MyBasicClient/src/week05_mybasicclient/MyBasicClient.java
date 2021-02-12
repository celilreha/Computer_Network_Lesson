/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week05_mybasicclient;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import static java.time.Clock.system;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
//import mybasicserver.MyBasicServer;


public class MyBasicClient {
    public static Socket cSocket;
    public static void main(String[] args){
        
        try {
            cSocket=new Socket("127.0.0.1",4000);
        
            ObjectOutputStream cOutStream=new ObjectOutputStream(cSocket.getOutputStream());
        
            //cOutStream.writeObject("Merhaba ben client");
            ObjectInputStream cInStream=new ObjectInputStream(cSocket.getInputStream());
            while(cSocket.isConnected()){
                System.out.println(cInStream.readObject().toString());
                cOutStream.writeObject("mesajını aldım");
            }
           // Scanner input=new Scanner(System.in);
           /* while(cSocket.isConnected()){
                String message=input.nextLine();
                cOutStream.writeObject(message);
            }*/
            cSocket.close();
            } catch (IOException ex) {
            Logger.getLogger(MyBasicClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MyBasicClient.class.getName()).log(Level.SEVERE, null, ex);
        }

    
    }
}
