package socket_test;
import java.io.*;
import java.net.*;

public class Server{
    private static boolean running = true;
    public static void main(String args[]){
        try{
            ServerSocket server 
                = new ServerSocket(3333);
            System.out.println("Server started on "
                +server.getLocalPort());
            System.out.println(server.getInetAddress());
            while (running) {
                Socket connection= server.accept();
                System.out.println("New connection moved to thread.");
                System.out.println(connection.getPort()); //who is connected with server?
                //ServerThread handler
                //= new ServerThread(connection);
                ServerThread handler
                    = new ServerThread(connection);
            }
            
        } catch(IOException ioe) {
            System.err.println("Error: " + ioe);
        }
    }
}

