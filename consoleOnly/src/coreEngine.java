import java.util.Random;
import java.util.Scanner;

public class coreEngine {
    public static void main(String[] args) {
        String[][] countriesAndCapitals = {
                {"Bulgaria", "England", "Russia", "Belgium", "Brazil", "Canada", "Chile", "China", "Greece", "Hungary",
                        "Italy", "Japan", "Saudi Arabia", "Switzerland", "United States of America", "Mexico",
                        "Malta", "Luxembourg", "Macedonia", "Libya", "Monaco", "Germany", "Serbia"},
                {"Sofia", "London", "Moscow", "Brussels", "Brasilia", "Ottawa", "Santiago", "Beijing", "Athens",
                        "Budapest", "Rome", "Tokyo", "Riyadh", "Bern", "Washington", "Mexico",
                        "Valletta", "Luxembourg", "Skopje", "Tripoli", "Monaco", "Berlin", "Belgrade"}
        };
        //heads = 0 tails = 1
        Scanner val1 = new Scanner(System.in);
        System.out.println("Избeте име:");
        String playerOneName = val1.next();
        System.out.println("Избeте име:");
        String playerTwoName = val1.next();
        System.out.println("Избора на " + playerOneName + " e:");
        String playerOneChoice = val1.next();
        System.out.println("Избора на " + playerTwoName + " e:");
        String playerTwoChoice = val1.next();
        boolean playerOneTurn = false;
        boolean playerTwoTurn = false;
        Random randomNumber = new Random();
        int tailsOrHeads = randomNumber.nextInt(2);
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
        Random rand = new Random();
        int scorePlayerOne = 0;
        int scorePlayerTwo = 0;
        int index;
        Scanner val = new Scanner(System.in);
        while (scorePlayerOne <= 15 || scorePlayerTwo <= 15) {
            index = rand.nextInt(countriesAndCapitals[0].length);
            System.out.println(countriesAndCapitals[0][index]);
            if (playerOneTurn == true) {
                System.out.println("Your Turn " + playerOneName);
                String answerPlayerOne = val.next();
                if (answerPlayerOne.equals(countriesAndCapitals[1][index])) {
                    System.out.println("Correct! " + playerOneName);
                    scorePlayerOne++;
                    playerOneTurn = false;
                    playerTwoTurn = true;
                    System.out.println(playerOneName + "score is: " + scorePlayerOne);
                } else {
                    System.out.println("Not Correct!");
                    playerOneTurn = false;
                    playerTwoTurn = true;
                    System.out.println(playerOneName + "score is: " + scorePlayerOne);
                }
            } else {
                System.out.println("Your Turn " + playerTwoName);
                String answerPlayerTwo = val.next();
                if (answerPlayerTwo.equals(countriesAndCapitals[1][index])) {
                    System.out.println("Correct! " + playerTwoName);
                    scorePlayerTwo++;
                    playerOneTurn = true;
                    playerTwoTurn = false;
                    System.out.println(playerTwoName + " score is: " + scorePlayerTwo);
                } else {
                    System.out.println("Not Correct!");
                    playerOneTurn = true;
                    playerTwoTurn = false;
                    System.out.println(playerTwoName + " score is: " + scorePlayerTwo);
                }
            }
        }
    }

    public static boolean checkIfChoicesAreCorrect(String playerOneChoice, String playerTwoChoice) {
        if ((!(playerOneChoice.equals("heads") ||
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
