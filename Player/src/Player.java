/**
 * Initialization of Player class
 * @author Alisher Darmenov
 * @since 27.07.2023
 */
public class Player {
    private String name; //the name of Player
    private int sent; //counter of sent messages, that player already sent
    private int received; //counter of received messages
    private Player other; //other player, that will receive the messages and then will reply

    /**
     * Creating Constructor and initialize Instance variables
     * @param name the Player's name
     */
    public Player(String name) {
        this.name = name;
        this.sent = 0;
        this.received = 0;
    }

    /**
     * The method that sets the Player's friend, who will reply on messages
     * @param other the second player
     */

    public void setOther(Player other) {
        this.other = other;
    }

    /**
     * The Method that sends message o other player
     * @param message The message that should be sent
     */
    public void sendMessage(String message) {
        sent++;//increasing sent counter
        System.out.println(name + " sent: " + message); //Just to check the messages and order in console
        other.receiveMessage(message);
    }

    /**
     * The Method that modifies message and check the counter before replying
     * @param message the message that was received and should be modified and sent back
     */
    public void receiveMessage(String message) {
        received++; //increasing received counter
        String responseMessage = message + " " + sent;
        if (received == 10 && sent == 10) { //the counters control
            System.out.println(name + " I sent 10 Messages and got 10 response messages back, I am happy");
            System.exit(0); // Ending the game
        }
        System.out.println(name + " received: " + message); //Just to check the messages and order in console
        sendMessage(responseMessage);
    }
}
