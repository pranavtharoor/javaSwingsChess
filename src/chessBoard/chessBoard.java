/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessBoard;

/**
 *
 * @author ashir basu
 */

import java.awt.GridLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.util.ArrayList;

public class chessBoard extends JPanel{ 
    
    private int cellSize;
    private cell[][] cellGrid = new cell[8][8]; 
    private pieceColor currentTurn = pieceColor.blue;
    private cell selectedCell;
    
    public chessBoard(int cellSize) {
    
        GridLayout grid = new GridLayout(8,8,0,0);
        this.setLayout(grid);
        global.size=cellSize;
        
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                cellGrid[i][j] = new cell(j,i);
                this.add(cellGrid[i][j]);
                setButtonConfig(cellGrid[i][j]);
            }
        }
        setInitialConfig();
        calculateAttacks();
        this.setVisible(true);
    }   
    
    final void setButtonConfig(cell current){
        current.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if (current.currentPiece==null) {
                    current.setHoverColor();
                } else if (current.currentPiece.pieceC == currentTurn) {
                    if (setMovableUnselected(current)!=0) {
                        current.setHoverColor();
                    } else {
                        current.setHoverInvalidColor();
                    }
                } else {
                    current.setHoverInvalidColor();
                }
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                current.setBaseColor();
                if (current.currentPiece!=null){
                    if (current.currentPiece.pieceC == currentTurn) {
                        unsetMovableUnselected(current);
                    }
                }
            }
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt){
                if (current.currentPiece!=null){
                    if (current.currentPiece.pieceC != currentTurn){
                        current.setBaseColor();
                        JOptionPane.showMessageDialog(null,"It is "+currentTurn.name()+"'s turn");
                        return;
                    }
                }
                moveHandler(current);
            }
        });
    }
    
    final void setInitialConfig(){
        
        cellGrid[1][0].setPiece(new pawn(pieceColor.yellow));
        cellGrid[1][1].setPiece(new pawn(pieceColor.yellow));
        cellGrid[1][2].setPiece(new pawn(pieceColor.yellow));
        cellGrid[1][3].setPiece(new pawn(pieceColor.yellow));
        cellGrid[1][4].setPiece(new pawn(pieceColor.yellow));
        cellGrid[1][5].setPiece(new pawn(pieceColor.yellow));
        cellGrid[1][6].setPiece(new pawn(pieceColor.yellow));
        cellGrid[1][7].setPiece(new pawn(pieceColor.yellow));
        
        
        cellGrid[6][0].setPiece(new pawn(pieceColor.blue));
        cellGrid[6][1].setPiece(new pawn(pieceColor.blue));
        cellGrid[6][2].setPiece(new pawn(pieceColor.blue));
        cellGrid[6][3].setPiece(new pawn(pieceColor.blue));
        cellGrid[6][4].setPiece(new pawn(pieceColor.blue));
        cellGrid[6][5].setPiece(new pawn(pieceColor.blue));
        cellGrid[6][6].setPiece(new pawn(pieceColor.blue));
        cellGrid[6][7].setPiece(new pawn(pieceColor.blue));
        
        
        
        
        cellGrid[0][0].setPiece(new rook(pieceColor.yellow));
        cellGrid[0][1].setPiece(new bishop(pieceColor.yellow));
        cellGrid[0][2].setPiece(new knight(pieceColor.yellow));
        cellGrid[0][3].setPiece(new queen(pieceColor.yellow));
        cellGrid[0][4].setPiece(new king(pieceColor.yellow));
        cellGrid[0][5].setPiece(new knight(pieceColor.yellow));
        cellGrid[0][6].setPiece(new bishop(pieceColor.yellow));
        cellGrid[0][7].setPiece(new rook(pieceColor.yellow));
        
        
        cellGrid[7][0].setPiece(new rook(pieceColor.blue));
        cellGrid[7][1].setPiece(new bishop(pieceColor.blue));
        cellGrid[7][2].setPiece(new knight(pieceColor.blue));
        cellGrid[7][3].setPiece(new queen(pieceColor.blue));
        cellGrid[7][4].setPiece(new king(pieceColor.blue));
        cellGrid[7][5].setPiece(new knight(pieceColor.blue));
        cellGrid[7][6].setPiece(new bishop(pieceColor.blue));
        cellGrid[7][7].setPiece(new rook(pieceColor.blue));
        
    }
    
    final void calculateAttacks(){
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                cellGrid[i][j].setAttacking(populateMoves(cellGrid[i][j]));
            }
        }
    }
    
    final int setMovableUnselected(cell current){
        ArrayList<cell> moves = current.attacking;
        if (moves==null) {
            return 0;
        }
        for (int i=0;i<moves.size();i++){
            moves.get(i).setMovableUnselectedColor();
        }
        return moves.size();
    }
    
    
    final void unsetMovableUnselected(cell current){
        ArrayList<cell> moves = current.attacking;
        if (moves==null) {
            return;
        }
        for (int i=0;i<moves.size();i++){
            moves.get(i).setBaseColor();
        }
    }
    
    final void moveHandler(cell current){
        
    }
    
    final ArrayList<cell> populateMoves(cell current){
        ArrayList<cell> moves = new ArrayList<>();    
        if (current.currentPiece==null) {
            return null;
        } else if (current.currentPiece.pieceC == pieceColor.blue){
            for (int i=0; i<current.currentPiece.numberMoves; i++){
                moves.addAll(findMoves(current, current.currentPiece.movesAllowed[i], true));
            }
        }
        else{
            for (int i=0; i<current.currentPiece.numberMoves; i++){
                moves.addAll(findMoves(current, current.currentPiece.movesAllowed[i], false));
            }
        }
        return moves;
    }
    
    final ArrayList<cell> findMoves(cell current, pieceMove currentMove, boolean blue){
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