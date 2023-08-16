/**
 * @author Alisher Darmenov
 * @since 27.07.2023
 */
public class MainChallenge {
    public static void main(String[] args) {
        int initiatorPort = 5000; // taking the dynamic port for initiator
        int answererPort = 5001; // taking the dynamic port for answerer

        ChallengePlayer initiator = new ChallengePlayer("Initiator", answererPort); //Player - Initiator
        ChallengePlayer answerer = new ChallengePlayer("Answerer", initiatorPort); // Player - Answerer

        //To run codes simultaneously and make their communication asynchronous
        new Thread(initiator::receiveMessage).start(); // giving the thread to initiator
        new Thread(answerer::receiveMessage).start();// giving the thread to answerer

        initiator.sendMessage("Hi, Let's play the game");// Initiator sends the first message and begins the game
    }
}

