Network programming socket assignment 
design document 


Lorcan OʼMahony
 G00362689

  How to use the program
  Open the application in eclipse
  Click the run class button on the server class,
  Copy the port number printed to the console
  Run the Client class and enter the port number
  Send messages back and fort from server and client
  enter \q to exit the program 
Server 
Finding a free port number
 The user enters their port number as an argument when running the server function
 The server has a default port number of 9023, this is the port number used if the port entered doesnʼt work
 The isportfree function is called on the portnumber to check if it is free
 If it is not free then the findfreeport function is called and this gets a free port number by just looping through all of the 
port numbers until it finds one that connects
 The free port is printed to the console 
Connecting to a client 
The server waits for a client to connect
 When the client connects a new thread is created to handle the communication between the client and the server
 This is a seperate function called clienthandlerThread
 Client
 1
 Network programming socket assignment design documen

 Connecting to the port
 The client is prompted to enter a portnumber, the hosts portnumber was already printed to the console so you can just 
enter that 
When the client and server connect they both run the chatting part
 The server sends a message to the client
 The client reads the output from the server and if the output is not null it triggers a while loop that allows the client and 
server to send messages back and forth using output and input streams 
Chat Functionality
 Server Side
  This sends a message to the client to initiate the chat (ie the while loop in the client class)
  Then it waits fir the client response, this triggers the while loop
  This prints the message from the client
  Then it reads the input from the command line using stdIn.readline()
  Then it takes what the server enters in the command line and sends it to the client using out.println
 Client Side
  The Client waits for the input from the server with in.readline() 
 When the fromServer message is received it prints the message and runs the while loop
  The while loop checks if the server entered  \q and if it did, then it it exits the loop and ends the chat
  The stdIn checks if the client entered something into the console
  If something was entered it sends the message to the server then ends the loop
  This initiates the while loop the server which prompts the server to respond
 2
 Network programming socket assignment design document
References 
Oracle 2025 'Characters', The Java™ Tutorials. Available at: 
https://docs.oracle.com/javase/tutorial/java/data/characters.html Accessed: 25 August 2025
 Oracle. (n.d.). Java™ Platform, Standard Edition 8 API Specification: Class InetAddress. [online] Available at: 
https://docs.oracle.com/javase/8/docs/api/java/net/InetAddress.html Accessed 25 Aug. 2025.
 Oracle. (n.d.). Java™ Platform, Standard Edition 8 API Specification: Class Scanner. [online] Available at: 
https://docs.oracle.com/javase/8/docs/api/java/util/Scanner.html Accessed 25 Aug. 2025.
 French, J. 2022 Socket Programming Examples. Video]. ATU Galway. Available at: 
https://atlantictu
my.sharepoint.com/:v:/g/personal/john_french_atu_ie/EXdlNhUigHRKuJzwC92nf2sBbcR1BeH96AjhHohDeV-vcQ?
 e=hRpftR&nav=eyJyZWZlcnJhbEluZm8iOnsicmVmZXJyYWxBcHAiOiJTdHJlYW1XZWJBcHAiLCJyZWZlcnJhbFZpZXciOiJTaG
 (Accessed: 25 August 2025.
 https://vlegalwaymayo.atu.ie/mod/resource/view.php?id=1021333 
Oracle Corporation 2025 'KKMultiServerThread.java'. Available at: 
https://docs.oracle.com/javase/tutorial/networking/sockets/examples/KKMultiServerThread.java Accessed: 25 August 
2025.
 GeeksforGeeks 2025 How to Implement a Simple Chat Application Using Sockets in Java?, GeeksforGeeks. Available at: 
https://www.geeksforgeeks.org/simple-chat-application-using-sockets-in-java/ Accessed: 25 August 2025. 
Oracle Corporation 2025 'What Is a Socket?' Available at: 
https://docs.oracle.com/javase/tutorial/networking/sockets/definition.html Accessed: 25 August 2025.
 Oracle Corporation 2025 'All About Sockets' Available at: 
https://docs.oracle.com/javase/tutorial/networking/sockets/index.html Accessed: 25 August 202
