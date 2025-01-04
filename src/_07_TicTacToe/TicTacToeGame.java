package _07_TicTacToe;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame {

    Deque<Player> players;
    Board board;

    public TicTacToeGame(){
        initializeGame();
    }

    public void initializeGame(){
        players = new ArrayDeque<>();
        PlayingPiece playingPiece1 = new PlayingPieceX();
        Player player1 = new Player("Hello",playingPiece1);

        PlayingPiece playingPiece2 = new PlayingPieceY();
        Player player2 = new Player("Test",playingPiece2);

        players.add(player1);
        players.add(player2);

        board = new Board(3);
    }

    public String startGame(){
        boolean noWinner = true;
        while(noWinner){
            Player playerTurn =  players.removeFirst();

            board.printBoard();
            List<Pair<Integer,Integer>> freespaces = board.getFreeSpaces();

            if(freespaces.isEmpty()){
                noWinner=false;
                continue;
            }

            System.out.println("Player Turn "+ playerTurn.name+"Enter row column :");
            Scanner scn = new Scanner(System.in);
            int row = scn.nextInt();
            int column = scn.nextInt();

            boolean isPieceAddedSuccessfully = board.addPieceToBoard(row,column,playerTurn.playingPiece);
            if(!isPieceAddedSuccessfully){
                System.out.println("Please chose another position");
                players.addFirst(playerTurn);
                continue;
            }

            players.addLast(playerTurn);
            boolean winner = isWinnerAvailable(row,column,playerTurn.playingPiece.pieceType);

            if(winner){
                return playerTurn.name;
            }
        }

        return "tie";
    }

    //instead of this you can use n-queen as it may solve this in o(1)
    public boolean isWinnerAvailable(int row , int column , PieceType pieceType){
        boolean checkrow = true;
        boolean checkcolumn = true;
        boolean checkdiagonal = true;
        boolean checkantidiagonal = true;

        //check for row
        for(int i=0;i<board.size;i++){
            if(board.board[row][i] == null || board.board[row][i].pieceType!=pieceType){
                checkrow = false;
            }
        }

        //check for column
        for(int i=0;i<board.size;i++){
            if(board.board[i][column] == null || board.board[i][column].pieceType!=pieceType){
                checkcolumn = false;
            }
        }

        //checkdiagonal
        return checkrow || checkcolumn;
    }


}
