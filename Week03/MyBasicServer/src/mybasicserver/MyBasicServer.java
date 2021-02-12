/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybasicserver;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CelilRehaESGICE
 */
public class MyBasicServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException {
        try {
            ServerSocket sSocket=new ServerSocket(4000);
            Socket cSocket=sSocket.accept();
            System.out.println("bir client bağlandı");
            ObjectInputStream cInStream=new ObjectInputStream(cSocket.getInputStream());
            System.out.println(cInStream.readObject().toString());
            ObjectOutputStream cOutStream=new ObjectOutputStream(cSocket.getOutputStream());
            cOutStream.writeObject("merhaba ben server");
            sSocket.close();
            cSocket.close();
        } catch (IOException ex) {
            Logger.getLogger(MyBasicServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
}
