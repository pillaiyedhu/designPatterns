package _07_TicTacToe;

public class GameMain {
    public static void main(String[] args) {
        TicTacToeGame ticTacToeGame = new TicTacToeGame();
        String result = ticTacToeGame.startGame();
        System.out.println(result);
    }
}
