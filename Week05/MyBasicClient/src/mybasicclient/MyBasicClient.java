/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybasicclient;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
//"127.0.0.1"
/**
 *
 * @author INSECT
 */
public class MyBasicClient {
     public class ListenClientThread extends Thread {

        private MyBasicClient client;

        public ListenClientThread(MyBasicClient gmyclient) {
            this.client = gmyclient;

        }
        public void run() {
            try {
                while (cSocket.isConnected()) {
                    
                        MyBasicClientGui.lmodel.addElement(cInStream.readObject().toString());
                    } 
                }catch (IOException ex) {
                        Logger.getLogger(MyBasicClient.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(MyBasicClient.class.getName()).log(Level.SEVERE, null, ex);
                    }
            
        }
     }
    ObjectOutputStream cOutStream;
    ObjectInputStream cInStream;
    ListenClientThread clientThread;
    public static Socket cSocket;
    
    public MyBasicClient(String ip,int port){
        try {
            cSocket = new Socket(ip, port);
            cOutStream = new ObjectOutputStream(cSocket.getOutputStream());
            cInStream = new ObjectInputStream(cSocket.getInputStream());
            this.clientThread.start();
            
        } catch (IOException ex) {
            Logger.getLogger(MyBasicClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void StopClient() throws IOException {
        cSocket.close();
    }
    public void SendMessade(Object message) throws IOException {
        cOutStream.writeObject(message);
    }
    public void ReceiveMessage() throws IOException, ClassNotFoundException{
        while (cSocket.isConnected()) {
            MyBasicClientGui.lmodel.addElement(cInStream.readObject().toString());
        }
    }

    
}
