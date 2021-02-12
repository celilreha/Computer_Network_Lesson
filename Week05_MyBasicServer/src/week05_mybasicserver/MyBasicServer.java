/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week05_mybasicserver;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CelilRehaESGICE
 */
public class MyBasicServer {
public class ListenServerThread extends Thread{
        private MyBasicServer server;
        public ListenServerThread(MyBasicServer gmyserver){
            this.server=gmyserver;
        }
        //client dinleme fonksiyonu
        public void run() {
            while(!this.server.sSocket.isClosed()){
                try {
                    Socket cSocket=sSocket.accept();
                    sClient newClient= new sClient(cSocket);
                    clientList.add(newClient);
                } catch (IOException ex) {
                    Logger.getLogger(sClient.class.getName()).log(Level.SEVERE, null, ex);
                }  
            } 
        }
    }
    public static ServerSocket sSocket;
    //public static Socket cSocket;
    public static ArrayList<sClient> clientList;
    public ListenServerThread ServerThread;
    public MyBasicServer(int port){
        try {
            sSocket = new ServerSocket(4000);
            clientList =new ArrayList<sClient>();
        } catch (IOException ex) {
            Logger.getLogger(MyBasicServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void StartServer() throws IOException{
       // while(!sSocket.isClosed()){
            this.ServerThread=new ListenServerThread(this);
            this.ServerThread.start();
        //}
    }
    public void StopServer() throws IOException{
        sSocket.close();
    }
    public void SendBroadcastMessage(Object message) throws IOException{
        for (sClient gclient : clientList) {
            gclient.sendMessage(message);
        }
    }
    public void SendtMessage(Object message,sClient gclient) throws IOException{
        gclient.sendMessage(message);
    }
    public static void main(String[] args) {
       
    }

}
