
import java.util.Random;
import java.util.Scanner;

public class playerPart {
    public static void main(String[] args) {
        //heads = 0 tails = 1
        Scanner val = new Scanner(System.in);
        Scanner val2 = new Scanner(System.in);
        System.out.println("Избeте име:");
        String playerOneName = val.next();
        System.out.println("Избeте име:");
        String playerTwoName = val2.next();
        Scanner val3 = new Scanner(System.in);
        Scanner val4 = new Scanner(System.in);
        System.out.println("Избора на " + playerOneName + " e:");
        String playerOneChoice = val3.next();
        System.out.println("Избора на " + playerTwoName + " e:");
        String playerTwoChoice = val4.next();
        boolean playerOneTurn = false;
        boolean playerTwoTurn = false;
        Random rand = new Random();
        int tailsOrHeads = rand.nextInt(2);
        if (checkIfChoicesAreCorrect(playerOneChoice, playerTwoChoice)) {
            if ((playerOneChoice.equals("heads") && tailsOrHeads == 0) ||
                    (playerOneChoice.equals("tails") && tailsOrHeads == 1)) {
                playerOneTurn = true;
            } else {
                playerTwoTurn = true;
            }
            if (playerOneTurn) {
                System.out.println("Първи ще е: " + playerOneName);

            } else {
                System.out.println("Първи ще е: " + playerTwoName);
            }
        } else {
            System.out.println("The Choices given aren't correct!");
        }
    }

    public static boolean checkIfChoicesAreCorrect(String playerOneChoice, String playerTwoChoice) {
        if ((!(playerOneChoice.equalsIgnoreCase("heads") ||
                playerOneChoice.equals("tails"))) || (!(playerTwoChoice.equals("heads") ||
                playerTwoChoice.equals("tails"))) || (playerOneChoice.equals("heads") &&
                playerTwoChoice.equals("heads")) || (playerOneChoice.equals("tails") &&
                playerTwoChoice.equals("tails"))) {
            return false;
        } else {
            return true;
        }

    }
}

