package week1.practice_problems;

import java.util.concurrent.ThreadLocalRandom;

public class P1_RockPaperScissorsGame {
    private static final String[] MOVES = {"Rock", "Paper", "Scissors"};

    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }
        boolean playerWins = (playerMove.equalsIgnoreCase("Rock") && computerMove.equalsIgnoreCase("Scissors"))
                || (playerMove.equalsIgnoreCase("Paper") && computerMove.equalsIgnoreCase("Rock"))
                || (playerMove.equalsIgnoreCase("Scissors") && computerMove.equalsIgnoreCase("Paper"));
        return playerWins ? "Player Wins" : "Computer Wins";
    }

    public static void main(String[] args) {
        String[] playerMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"};
        String[] computerMoves = new String[playerMoves.length];
        String[] results = new String[playerMoves.length];
        int wins = 0;
        int losses = 0;
        int draws = 0;

        for (int i = 0; i < playerMoves.length; i++) {
            computerMoves[i] = MOVES[ThreadLocalRandom.current().nextInt(MOVES.length)];
            results[i] = playRound(playerMoves[i], computerMoves[i]);
            if (results[i].equals("Player Wins")) {
                wins++;
            } else if (results[i].equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }
        }

        System.out.println("Round | Player Move | Computer Move | Result");
        for (int i = 0; i < playerMoves.length; i++) {
            System.out.printf("%5d | %-11s | %-13s | %s%n", i + 1, playerMoves[i], computerMoves[i], results[i]);
        }
        System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n",
                wins, losses, draws, (wins * 100.0) / playerMoves.length);
    }
}
