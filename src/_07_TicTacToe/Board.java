package _07_TicTacToe;

import java.util.ArrayList;
import java.util.List;

public class Board {
    int size;
    PlayingPiece[][] board;

    public Board(int size){
        this.size = size;
        board = new PlayingPiece[size][size];
    }

    public boolean addPieceToBoard(int row , int column , PlayingPiece playingPiece){
        if(board[row][column]!=null){
            return false;
        }
        board[row][column] = playingPiece;
        return true;
    }

    public void printBoard(){
        for(int i=0;i<size;i++){
            for (int j=0;j<size;j++){
                if(board[i][j]!=null){
                    System.out.print(board[i][j].pieceType);
                }else{
                    System.out.print("|");
                }
            }
            System.out.println();
        }
    }

    public List<Pair<Integer,Integer>> getFreeSpaces(){
        List<Pair<Integer,Integer>> freeSpaces = new ArrayList<>();
        for(int i=0;i<size;i++){
            for (int j=0;j<size;j++){
                if(board[i][j]==null){
                    Pair<Integer,Integer> pair = new Pair<>(i,j);
                    freeSpaces.add(pair);
                }
            }
        }
        return freeSpaces;
    }
}
