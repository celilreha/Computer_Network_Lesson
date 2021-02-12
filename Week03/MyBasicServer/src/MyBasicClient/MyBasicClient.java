/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyBasicClient;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import mybasicserver.MyBasicServer;

/**
 *
 * @author CelilRehaESGICE
 */
public class MyBasicClient {
    public static void main(String[] args) throws ClassNotFoundException {
        try {
            Socket cSocket=new Socket("127.0.0.1",4000);
            ObjectOutputStream cOutStream=new ObjectOutputStream(cSocket.getOutputStream());
            cOutStream.writeObject("Merhaba ben client");
            ObjectInputStream cInStream=new ObjectInputStream(cSocket.getInputStream());
            System.out.println(cInStream.readObject().toString());
            cSocket.close();

        } catch (IOException ex) {
            Logger.getLogger(MyBasicServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
}
