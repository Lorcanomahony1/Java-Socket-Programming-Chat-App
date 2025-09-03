package ChatApp;
import java.net.*;
import java.io.*;




//THIS CONNECTS TO CLIENTS THEN MAKES A THREAD TO HANDLE THAT CLIENT, LIKE CREATING A MINI SERVER//
public class TheServer {
    public static void main(String[] args) {
    
        int portNumber = 9023;
        if (args.length == 1) {
            portNumber = Integer.parseInt(args[0]);
        } else if (args.length == 0) {
            portNumber = 9032;
        }
        else {
            System.out.println("Only one port number is allowed");
        }
    
        if (!isPortFree(portNumber)) {
            System.out.println(portNumber + " his portnumber is not free");
            portNumber = findFreePort();
        }
        
        
        //THIS CREATES A NEW THREAD FOR EVERY TIME A CLIENT CONNECTS TO THE SERVER
        //IT RUNS THE CLIENTHANDLER ON IT.
        
        try (ServerSocket server = new ServerSocket(portNumber)) {
            System.out.println("Listening for connection on port " + portNumber);
            while (true) {
                try {
                    Socket connection = server.accept();
                    System.out.println("Client connected on port" + connection.getInetAddress() + ":" + connection.getPort());
                    Thread task = new TheClientHandlerThread(connection);
                    task.start();
                } catch (IOException ex) {
                    System.err.println("Error accepting connection: " + ex.getMessage());
                }
            }
        } catch (IOException ex) {
            System.err.println("Could not listen on port " + portNumber + ": " + ex.getMessage());
        }
    }

    //THIS CHECKS IF THE PORT IS FREE
    public static boolean isPortFree(int portNumber) {
        try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
            serverSocket.close();
            return true;
        } catch (IOException ex) {
            return false;
        }
    }

    //THIS GOES THROUGH ALL PORTS AND FINDS A FREE ONE FOR THE
    //...SERVER TO CONNECT O
    public static int findFreePort() {
        for (int port = 1024; port < 65535; port++) {
            try {
                ServerSocket serverSocket = new ServerSocket(port);
                serverSocket.close();
                return port;
            } catch (IOException ex) {
            }
        }
        throw new IllegalStateException("No free port found");
    }
    

    
    
    
    

  
 
    
    



//THIS IS A SERVER THREAD THAT HANDLES THE INTERACTION BETWEEN SERVER AND CLIENT
private static class TheClientHandlerThread extends Thread {
  private Socket connection;

  public TheClientHandlerThread(Socket connection) {
      this.connection = connection;
  }

  @Override
  public void run() {
      try (
    	  //THIS GETS THE MESSAGE BEING SENT OUT FROM SERVER TO CLIENT
          PrintWriter out = new PrintWriter(connection.getOutputStream(), true);
    	  //THIS GETS THE INPUT THAT COMES IN FROM THE CLIENT
          BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
          BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))

      ) {
          
    	  //THIS LINE SENDS THIS MESSAGE TO THE CLIENT THIS INITIATES THE CONVERSATION WHILE LOOP
          out.println("Server: Hello, this is the server, please write a message and press enter to send it"); 

          String clientResponse;
          String ServerResponse;

          //WHILE THE CLIENTRESPONSE IS NOT EMPTY RUN THIS CODE
          while ((clientResponse = in.readLine()) != null) {
        	  
        	  //PRINT THE CLIENT RESPONSE
              System.out.println("Client: " + clientResponse);
              //THIS PROMPTS THE SERVER AND PRINTS THE RESPONSE
              ServerResponse = stdIn.readLine();
              //IF THE CLIENT TYPES "BYE" THE PROGRAM ENDS
              if (clientResponse.equals("\\q")) {
                  out.println("You have ended the chat");
                  //YOU HAVE TYPED "Bye" AND EXITED THE CHAT
                  break;
              } else {
            	  //PRINT THE MESSAGE FROM THE SERVER
                  out.println(ServerResponse);
              }
          }
      } catch (IOException ex) {
          System.err.println(ex);
      } finally {
          try {
              connection.close();
          } catch (IOException e) {
              System.err.println("Error closing connection: " + e.getMessage());
          }
      }
  }
}
}



