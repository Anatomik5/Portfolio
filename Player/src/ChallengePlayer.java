import java.io.*;
import java.net.*;
/**
 * Initialization of Player class for challenge rule 7
 * @author Alisher Darmenov
 * @since 27.07.2023
 */
public class ChallengePlayer {

    private String name;//the name of Player
    private int sent;//counter of sent messages, that player already sent
    private int received;//counter of received messages
    private int friendsPort;//other player port for interaction
    /**
     * Constructor for creating a player for rule 7 and initialize Instance variables
     *
     * @param name         The name of the player.
     * @param opponentPort The port number of the opponent player to establish communication.
     */
    public ChallengePlayer(String name, int opponentPort) {
        this.name = name;
        this.sent = 0;
        this.received = 0;
        this.friendsPort = opponentPort;
    }

    /**
     * The Method that sends message to other player
     * @param message The message that should be sent
     */
    public void sendMessage(String message) {
        sent++;//increasing sent counter
        try {
            Socket socket = new Socket("localhost", friendsPort); // Socket used to connect the server-side player's ServerSocket
            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream()); //for sending message between players through Sockets
            output.writeObject(message);//adding the message to output
            output.flush();//sending the message immediately
            System.out.println(name + " sent: " + message); //Just to check the messages
            socket.close(); //closing socket
        } catch (IOException e) {
            e.printStackTrace(); //to see details of appeared error
        }
    }
    /**
     * The Method that modifies message and check the counter before replying
     */
    public void receiveMessage() {
        try {
            ServerSocket serverSocket = new ServerSocket(friendsPort); //creating server for communication with other Player

            while (true) { //do cycle till get exit
                Socket socket = serverSocket.accept(); //receiving message from sendMessage
                ObjectInputStream input = new ObjectInputStream(socket.getInputStream()); //saving all data received from other player
                String message = (String) input.readObject();
                socket.close();//closing socket

                received++; //increasing received counter
                String responseMessage = message + " " + sent;
                System.out.println(name + " received: " + message); //Just to check the messages and order in console
                if (received == 10 && sent == 10) {//the counters control
                    System.out.println(name + " I sent 10 Messages and got 10 response messages back, I am happy");
                    serverSocket.close(); //closing server
                    System.exit(0); // Ending the game
                }

                sendMessage(responseMessage);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace(); //to see details of appeared error
        }
    }
}