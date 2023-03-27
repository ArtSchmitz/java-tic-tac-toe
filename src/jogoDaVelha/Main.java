package jogoDaVelha;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        GameClass board = new GameClass();
        PlayerClass player1 = new PlayerClass("X");
        PlayerClass player2 = new PlayerClass("Y");

        PlayerClass thePlayer = player1;

        while(true) {
            board.printBoard();

            System.out.print("Jogador " + thePlayer.getSymbol() + ", digite a coordenada da linha de (0-2): ");
            int play1 = sc.nextInt();
            System.out.print("Jogador " + thePlayer.getSymbol() + ", digite a coordenada da coluna de (0-2): ");
            int play2 = sc.nextInt();

            if (board.Move(thePlayer, play1, play2)) {

                if (board.Win(thePlayer)) {
                    board.printBoard();
                    System.out.println("Jogador " + thePlayer.getSymbol() + " venceu!");
                    break;
                }

                if (board.checkTie()) {
                    board.printBoard();
                    System.out.println("O jogo empatou!");
                    break;
                }

                if (thePlayer == player1) {
                    thePlayer = player2;
                } else {
                    thePlayer = player1;
                }
            } else {
                System.out.println("Jogada inválida, tente novamente!");
            }

        }

    }

}
