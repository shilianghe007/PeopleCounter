package socket_test;

import java.io.*;
import java.net.*;

public class ServerThread extends Thread{
    private Socket connection;
    public ServerThread(Socket _connection) {
        connection = _connection;
        start();
    }
    public void run(){
        try{
            DataInputStream  in  
                = new DataInputStream(connection.getInputStream());
            DataOutputStream out 
                = new DataOutputStream(connection.getOutputStream());
            String line = new String("");
            while (!line.equalsIgnoreCase("QUIT")){
                line = in.readUTF();
                System.out.println("Received warning: " + line + "people");
                out.writeUTF("Received!");
            }
            in.close(); out.close(); connection.close();
            System.out.println("Connection closed.");
        } catch(IOException ioe) {
            System.out.println("Connection closed unexpectedly.");
        }
    }
}
