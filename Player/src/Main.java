/**
 * @author Alisher Darmenov
 * @since 27.07.2023
 */
public class Main {
    public static void main(String[] args) {
        Player initiator = new Player("Initiator");  //Player - Initiator
        Player answerer = new Player("Answerer"); // Player - Answerer

        initiator.setOther(answerer); //setting the friend of Initiator
        answerer.setOther(initiator); //setting the friend of Answerer

        initiator.sendMessage("Hi, Let's play the game"); // Initiator sends the first message and begins the game

    }
}
