package string.class_problems;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    public static String playRound(String playerMove, String computerMove) {

        if (playerMove.equals(computerMove)) {
            return "Draw";
        }

        if (playerMove.equals("Rock") && computerMove.equals("Scissors")) {
            return "Player Wins";
        }

        if (playerMove.equals("Paper") && computerMove.equals("Rock")) {
            return "Player Wins";
        }

        if (playerMove.equals("Scissors") && computerMove.equals("Paper")) {
            return "Player Wins";
        }

        return "Computer Wins";
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] moves = {"Rock", "Paper", "Scissors"};

        int wins = 0;
        int losses = 0;
        int draws = 0;

        String[] playerMoves = new String[5];
        String[] computerMoves = new String[5];
        String[] results = new String[5];

        for (int round = 0; round < 5; round++) {

            System.out.print("Enter your move (Rock/Paper/Scissors): ");
            String playerMove = scanner.nextLine();

            int randomIndex = random.nextInt(3);
            String computerMove = moves[randomIndex];

            String result = playRound(playerMove, computerMove);

            playerMoves[round] = playerMove;
            computerMoves[round] = computerMove;
            results[round] = result;

            System.out.println("Computer: " + computerMove);
            System.out.println("Result: " + result);
            System.out.println();

            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }
        }

        System.out.println("Final Summary");
        System.out.println("---------------------------------------------");
        System.out.println("Round\tPlayer Move\tComputer Move\tResult");

        for (int i = 0; i < 5; i++) {
            System.out.println(
                (i + 1) + "\t" +
                playerMoves[i] + "\t\t" +
                computerMoves[i] + "\t\t" +
                results[i]
            );
        }

        double winPercentage = (wins / 5.0) * 100;

        System.out.println("---------------------------------------------");
        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Draws: " + draws);
        System.out.println("Win %: " + winPercentage + "%");

        scanner.close();
    }
}