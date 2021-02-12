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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CelilRehaESGICE
 */
public class MyBasicServer {

    public static ServerSocket sSocket;
    public static Socket cSocket;
    public static ArrayList<sClient> clientList;

    public static void main(String[] args) {

        try {
            sSocket = new ServerSocket(4000);
            clientList = new ArrayList<sClient>();

            while (!sSocket.isClosed()) {
                cSocket = sSocket.accept();
                sClient newClient = new sClient(cSocket);
                clientList.add(newClient);
                System.out.println("bir client bağlandı");
                newClient.sendMessage(newClient.no + ". client geldi");
            }
            sSocket.close();
            //tek client bağlanacaksa while buraya konur
            /*while (sSocket.isClosed() || cSocket.isConnected()) {
                ObjectInputStream cInStream = new ObjectInputStream(cSocket.getInputStream());
                System.out.println(cInStream.readObject().toString());
                ObjectOutputStream cOutStream = new ObjectOutputStream(cSocket.getOutputStream());
                cOutStream.writeObject("merhaba ben server");
            }*/
        } catch (IOException ex) {
            Logger.getLogger(MyBasicServer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
