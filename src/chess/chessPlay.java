/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import java.util.ArrayList;

/**
 *
 * @author student
 */
public class chessPlay {
    
    
    static pieceColor currentTurn;
    static cell[][] cellGrid;
    final static void calculateAttacks(cell[][] cellgrid, pieceColor currentturn){
        cellGrid=cellgrid;
        currentTurn = currentturn;
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                cellGrid[i][j].setAttacking(populateMoves(cellGrid[i][j]));
            }
        }
        cellGrid=null;
        currentTurn = null;
    }
    
    
    
    final static ArrayList<cell> populateMoves(cell current){
        ArrayList<cell> moves = new ArrayList<>();    
        if (current.currentPiece==null) {
            return null;
        } else {
            
            for (int i=0; i<current.currentPiece.specialMoves.size(); i++){
                moves.addAll(findPossibleMoves(current, current.currentPiece.specialMoves.get(i)));
            }
            for (int i=0; i<current.currentPiece.movesAllowed.size(); i++){
                moves.addAll(findPossibleMoves(current, current.currentPiece.movesAllowed.get(i)));
            }
        }
        if (moves.isEmpty())
            return null;
        else
            return moves;
    }
    
    
    
    
    final static ArrayList<cell> findPossibleMoves(cell current, specialAction currentMove){
        if (currentMove.validateAction()){
            return findPossibleMoves(current, (pieceMove) currentMove);
        }        
        return new ArrayList<cell>();
    }
    
    final static ArrayList<cell> findPossibleMoves(cell current, pieceMove currentMove, cell[][] cellgrid){
        cellGrid=cellgrid;
        ArrayList<cell> temp = findPossibleMoves(current, currentMove);
        cellGrid=null;        
        return temp;
    }
    final static ArrayList<cell> findPossibleMoves(cell current, pieceMove currentMove){
        boolean blue = (current.currentPiece.pieceC.name().equals("blue"));
        int x=current.posX, y=current.posY;
        ArrayList<cell> moves = new ArrayList<>();    
        if (currentMove.type == moveType.recursive){
            while (true){
                x += currentMove.x;
                y -= currentMove.y * (blue?1:-1);
                if (x<8 && y<8 && x>=0 && y>=0) {
                    if (cellGrid[y][x].currentPiece==null) {
                        moves.add(cellGrid[y][x]);
                    } else{
                        if(cellGrid[y][x].currentPiece.pieceC!=currentTurn) {
                            moves.add(cellGrid[y][x]);
                        }
                        break;
                    }
                }
                else {
                    break;
                }   
            }
        }
        else{
            x += currentMove.x;
            y -= currentMove.y * (blue?1:-1);
            if (x<8 && y<8 && x>=0 && y>=0) {
                if (currentMove.type == moveType.single) {
                    if (cellGrid[y][x].currentPiece==null) {
                        moves.add(cellGrid[y][x]);
                    } else{
                        if(cellGrid[y][x].currentPiece.pieceC!=currentTurn) {
                            moves.add(cellGrid[y][x]);
                        }
                    }
                } else if (currentMove.type == moveType.cannotCapture && cellGrid[y][x].currentPiece==null) {
                    if (cellGrid[y][x].currentPiece==null) {
                        moves.add(cellGrid[y][x]);
                    } else{
                        if(cellGrid[y][x].currentPiece.pieceC!=currentTurn) {
                            moves.add(cellGrid[y][x]);
                        }
                    }
                } else if (currentMove.type == moveType.onlyCapture && cellGrid[y][x].currentPiece!=null) {
                    if (cellGrid[y][x].currentPiece==null) {
                        moves.add(cellGrid[y][x]);
                    } else {
                        if(cellGrid[y][x].currentPiece.pieceC!=currentTurn) {
                            moves.add(cellGrid[y][x]);
                        }
                    }
                }
            }
        }
        return moves;
    }  
    
    
    
    
    
}
