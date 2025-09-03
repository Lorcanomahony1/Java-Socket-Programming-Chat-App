# Network Programming Socket Assignment Design Document

**Author**: Lorcan O'Mahony  
**Student ID**: G00362689

## How to Use the Program

1. Open the application in Eclipse.
2. Click the "Run" button on the `Server` class.
3. Copy the port number printed to the console.
4. Run the `Client` class and enter the port number.
5. Send messages back and forth between the server and client.
6. Enter `\q` to exit the program.

## Server

### Finding a Free Port Number
- The user enters a port number as an argument when running the `Server` function.
- The server has a default port number of **9023**, used if the entered port is unavailable.
- The `isPortFree` function checks if the specified port is free.
- If the port is not free, the `findFreePort` function loops through port numbers until it finds one that connects.
- The free port number is printed to the console.

### Connecting to a Client
- The server waits for a client to connect.
- Upon connection, a new thread is created to handle communication between the client and server.
- This is managed by a separate function called `clientHandlerThread`.

## Client

### Connecting to the Port
- The client is prompted to enter a port number (use the one printed by the server).
- When the client and server connect, both initiate the chatting functionality.
- The server sends a message to the client to start the chat.
- The client reads the server's output, and if it is not null, it triggers a while loop allowing back-and-forth messaging using input and output streams.

## Chat Functionality

### Server Side
- Sends a message to the client to initiate the chat (triggers the client's while loop).
- Waits for the client's response, which triggers the server's while loop.
- Prints the client's message.
- Reads input from the command line using `stdIn.readLine()`.
- Sends the server's command-line input to the client using `out.println`.

![Server Screenshot](https://github.com/user-attachments/assets/0954777c-e80e-4007-9fe0-70c5907fa0e1)

### Client Side
- Waits for input from the server using `in.readLine()`.
- Upon receiving a message (`fromServer`), prints it and runs a while loop.
- The while loop checks if the server sent `\q`; if so, it exits the loop and ends the chat.
- Checks if the client entered something into the console using `stdIn`.
- If input is provided, sends the message to the server and ends the loop.
- This triggers the server's while loop, prompting a response.

![Client Screenshot](https://github.com/user-attachments/assets/26f7c556-8e7c-4c55-ab12-a3375a14d9ce)

## References

- Oracle (2025) 'Characters', *The Java™ Tutorials*. Available at: [https://docs.oracle.com/javase/tutorial/java/data/characters.html](https://docs.oracle.com/javase/tutorial/java/data/characters.html) (Accessed: 25 August 2025).
- Oracle (n.d.) 'Java™ Platform, Standard Edition 8 API Specification: Class InetAddress'. Available at: [https://docs.oracle.com/javase/8/docs/api/java/net/InetAddress.html](https://docs.oracle.com/javase/8/docs/api/java/net/InetAddress.html) (Accessed: 25 August 2025).
- Oracle (n.d.) 'Java™ Platform, Standard Edition 8 API Specification: Class Scanner'. Available at: [https://docs.oracle.com/javase/8/docs/api/java/util/Scanner.html](https://docs.oracle.com/javase/8/docs/api/java/util/Scanner.html) (Accessed: 25 August 2025).
- French, J. (2022) *Socket Programming Examples*. [Video]. ATU Galway. Available at: [https://atlantictu-my.sharepoint.com/:v:/g/personal/john_french_atu_ie/EXdlNhUigHRKuJzwC92nf2sBbcR1BeH96AjhHohDeV-vcQ](https://atlantictu-my.sharepoint.com/:v:/g/personal/john_french_atu_ie/EXdlNhUigHRKuJzwC92nf2sBbcR1BeH96AjhHohDeV-vcQ) (Accessed: 25 August 2025).
- Oracle Corporation (2025) 'KKMultiServerThread.java'. Available at: [https://docs.oracle.com/javase/tutorial/networking/sockets/examples/KKMultiServerThread.java](https://docs.oracle.com/javase/tutorial/networking/sockets/examples/KKMultiServerThread.java) (Accessed: 25 August 2025).
- GeeksforGeeks (2025) 'How to Implement a Simple Chat Application Using Sockets in Java?', *GeeksforGeeks*. Available at: [https://www.geeksforgeeks.org/simple-chat-application-using-sockets-in-java/](https://www.geeksforgeeks.org/simple-chat-application-using-sockets-in-java/) (Accessed: 25 August 2025).
- Oracle Corporation (2025) 'What Is a Socket?'. Available at: [https://docs.oracle.com/javase/tutorial/networking/sockets/definition.html](https://docs.oracle.com/javase/tutorial/networking/sockets/definition.html) (Accessed: 25 August 2025).
- Oracle Corporation (2025) 'All About Sockets'. Available at: [https://docs.oracle.com/javase/tutorial/networking/sockets/index.html](https://docs.oracle.com/javase/tutorial/networking/sockets/index.html) (Accessed: 25 August 2025).
- Oracle Corporation (2025) 'Writing a Client/Server Pair'. Available at: [https://docs.oracle.com/javase/tutorial/networking/sockets/clientServer.html](https://docs.oracle.com/javase/tutorial/networking/sockets/clientServer.html) (Accessed: 25 August 2025).
- Oracle Corporation (2025) 'Reading from and Writing to a Socket'. Available at: [https://docs.oracle.com/javase/tutorial/networking/sockets/readingWriting.html](https://docs.oracle.com/javase/tutorial/networking/sockets/readingWriting.html) (Accessed: 25 August 2025).
- Oracle Corporation (2025) 'KKMultiServer.java'. Available at: [https://docs.oracle.com/javase/tutorial/networking/sockets/examples/KKMultiServer.java](https://docs.oracle.com/javase/tutorial/networking/sockets/examples/KKMultiServer.java) (Accessed: 25 August 2025).
- Department of Computer Science, Princeton University (2024) 'StdIn'. Available at: [https://introcs.cs.princeton.edu/java/stdlib/javadoc/StdIn.html](https://introcs.cs.princeton.edu/java/stdlib/javadoc/StdIn.html) (Accessed: 25 August 2025).
