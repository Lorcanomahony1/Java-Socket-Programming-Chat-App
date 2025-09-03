package ChatApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TheClient {
    public static void main(String[] args) {

        //THIS GETS THE HOSTNAME AND PORTNUMBER
        String hostname;
        int portNumber;

        try {
            InetAddress localHost = InetAddress.getLocalHost();
            hostname = localHost.getHostName();
        } catch (UnknownHostException e) {
            System.err.println("no hostname chosen");
            hostname = "localhost";
        }

        Scanner reader = new Scanner(System.in);
        System.out.print("Enter port number: ");

        try {
            portNumber = reader.nextInt();
        } catch (java.util.InputMismatchException e) {
            System.err.println("Invalid port number");
            return;
        }

        //THIS IS THE ACTUAL CHAT CODE
        try (
            //THIS CONNECTS TO THE HOST
            Socket socket = new Socket(hostname, portNumber);
            //THIS IS THE MESSAGE BEING SENT OUT FROM THE CLIENT
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            //THIS IS THE MESSAGE COMING IN FROM THE SERVER
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //THIS IS
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))
        ) {
            String fromServer;
            String fromUser;
            
            //THIS WAITS FOR A MESSAGE FROM THE SERVER AND IF IT GETS THE MESSAGE, IT PROMPTS THE 
            //... CLIENT TO SEND ONE BACK, THEN IT SHOULD WAIT UNTIL THE SERVER RESPONDS BEFORE RUNNING AGAIN
            while ((fromServer = in.readLine()) != null) {
                System.out.println("Server: " + fromServer);
                if (fromServer.equals("\\q"))
                    break;

                fromUser = stdIn.readLine();
                if (fromUser != null) {
                    if (fromUser.equalsIgnoreCase("\\q")) {
                        out.println("You have exited the program");
                        break;
                    }
                    out.println(fromUser);
                }
            }
        } catch (UnknownHostException e) {
            System.err.println("Can't connect to host");
        } catch (IOException e) {
            System.err.println("error when connecting.");
        }
    }
}

