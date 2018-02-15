/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

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
    private pieceColor currentTurn = pieceColor.blue;
    private cell selectedCell = null;
    private boolean pieceSelected = false;
    private boolean singlePlayer = true;
    
    public chessBoard(int cellSize) {
    
        GridLayout grid = new GridLayout(8,8,0,0);
        this.setLayout(grid);
        global.size=cellSize;
        
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                global.cellGrid[i][j] = new cell(j,i);
                this.add(global.cellGrid[i][j]);
                setButtonConfig(global.cellGrid[i][j]);
            }
        }
        setInitialConfig();
        chessPlay.calculateAttacks(global.cellGrid, currentTurn);
        this.setVisible(true);
    }   
    
    final void setButtonConfig(cell current){
        current.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if (!pieceSelected){
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
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (!pieceSelected){
                    current.setBaseColor();
                    if (current.currentPiece!=null){
                        if (current.currentPiece.pieceC == currentTurn) {
                            unsetMovable(current);
                        }
                    }
                }
            }
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt){
                if (!pieceSelected && current.currentPiece!=null){
                    if (current.currentPiece.pieceC != currentTurn){
                        current.setBaseColor();
                        JOptionPane.showMessageDialog(null,"It is "+currentTurn.name()+"'s turn");
                        return;
                    }
                    else if (current.attacking==null){
                        current.setBaseColor();
                        JOptionPane.showMessageDialog(null,"This piece has no valid moves");
                        return;                        
                    }
                    else{
                        moveHandler(current);
                    }
                }
                else if (pieceSelected){
                    moveHandler(current);
                }
            }
        });
    }
    
    final void setInitialConfig(){
        for (int i=0;i<8;i++){
            global.cellGrid[1][i].setPiece(new pawn(pieceColor.yellow, global.cellGrid[1][i]));
            global.cellGrid[6][i].setPiece(new pawn(pieceColor.blue, global.cellGrid[6][i]));
        }
        
        
        global.cellGrid[0][0].setPiece(new rook(pieceColor.yellow, global.cellGrid[0][0]));
        global.cellGrid[0][1].setPiece(new knight(pieceColor.yellow, global.cellGrid[0][1]));
        global.cellGrid[0][2].setPiece(new bishop(pieceColor.yellow, global.cellGrid[0][2]));
        global.cellGrid[0][3].setPiece(new queen(pieceColor.yellow, global.cellGrid[0][3]));
        global.cellGrid[0][4].setPiece(new king(pieceColor.yellow, global.cellGrid[0][4]));
        global.cellGrid[0][5].setPiece(new bishop(pieceColor.yellow, global.cellGrid[0][5]));
        global.cellGrid[0][6].setPiece(new knight(pieceColor.yellow, global.cellGrid[0][6]));
        global.cellGrid[0][7].setPiece(new rook(pieceColor.yellow, global.cellGrid[0][7]));
        
        
        global.cellGrid[7][0].setPiece(new rook(pieceColor.blue, global.cellGrid[7][0]));
        global.cellGrid[7][1].setPiece(new knight(pieceColor.blue, global.cellGrid[7][0]));
        global.cellGrid[7][2].setPiece(new bishop(pieceColor.blue, global.cellGrid[7][0]));
        global.cellGrid[7][3].setPiece(new queen(pieceColor.blue, global.cellGrid[7][0]));
        global.cellGrid[7][4].setPiece(new king(pieceColor.blue, global.cellGrid[7][0]));
        global.cellGrid[7][5].setPiece(new bishop(pieceColor.blue, global.cellGrid[7][0]));
        global.cellGrid[7][6].setPiece(new knight(pieceColor.blue, global.cellGrid[7][0]));
        global.cellGrid[7][7].setPiece(new rook(pieceColor.blue, global.cellGrid[7][0]));
        
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
    
    
    final void unsetMovable(cell current){
        ArrayList<cell> moves = current.attacking;
        if (moves==null) {
            return;
        }
        for (int i=0;i<moves.size();i++){
            moves.get(i).setBaseColor();
            moves.get(i).unsetPlaceable();
        }
    }
    
    
    final int setMovableSelected(cell current){
        ArrayList<cell> moves = current.attacking;
        if (moves==null) {
            return 0;
        }
        for (int i=0;i<moves.size();i++){
            moves.get(i).setMovableSelectedColor();
            moves.get(i).setPlaceable();
        }
        current.setMovableUnselectedColor();
        return moves.size();
    }
    
    final void moveHandler(cell current){
        if (pieceSelected) {
            if (current==selectedCell) {
                current.setHoverColor();
                setMovableUnselected(current);
                pieceSelected=false;
                selectedCell=null;
            }
            else if(current.getPlaceable()){
                
		specialAction action = wasSpecialAction(current, selectedCell);
                current.currentPiece = selectedCell.currentPiece;
                
                unsetMovable(selectedCell);
                selectedCell.setAttacking(null);
                selectedCell.currentPiece = null;
                selectedCell.setBaseColor();
                current.currentPiece.setCell(current);
                
                current.setHoverInvalidColor();
                
                
                pieceSelected=false;
                selectedCell=null;
                current.currentPiece.onMove();
                
                
                if (currentTurn.name().equals("blue")) {
                    currentTurn  = pieceColor.yellow;
                    
//                System.out.println("Blue Board: " + evaluateBoard(global.cellGrid));
                    if(singlePlayer) {
                        aiMove();
                    }
                } else {
                    currentTurn  = pieceColor.blue;
//                System.out.println("Yellow Board: " + evaluateBoard(global.cellGrid) + "\n");
                }
                
                if (action!=null)   action.postClick();
                chessPlay.calculateAttacks(global.cellGrid, currentTurn);
            }
        } else{
            pieceSelected=true;
            selectedCell=current;
            setMovableSelected(current);
        }
    }
    
    final specialAction wasSpecialAction(cell current, cell selectedCell){
        for (int i=0; i<selectedCell.currentPiece.specialMoves.size(); i++){
                if(chessPlay.findPossibleMoves(selectedCell, selectedCell.currentPiece.specialMoves.get(i), global.cellGrid).contains(current)){
                    return selectedCell.currentPiece.specialMoves.get(i);
                }
            }
        return null;
    }
    
    final void aiMove() {
        
        chessPlay.calculateAttacks(global.cellGrid, currentTurn);
        
        cell game[][] = new cell[8][8];
        for(int i = 0; i < global.cellGrid.length; i++)
            for(int j = 0; j < global.cellGrid.length; j++)
                game[i][j] = new cell(global.cellGrid[i][j]);
        
        int bestStartX = 0, bestStartY = 0, bestEndX = 0, bestEndY = 0;
        double bestMove = -9999.0;
        int depth = 3;
        boolean isMaximisingPlayer = true;
        
        for(int i = 0; i < game.length; i++)
            for(int j = 0; j < game[i].length; j++) {
                if(game[i][j].currentPiece != null && game[i][j].currentPiece.pieceC == currentTurn && game[i][j].attacking != null) {
                    for(cell attack: game[i][j].attacking) {
                        if(attack.currentPiece == null || (attack.currentPiece != null && attack.currentPiece.pieceC != currentTurn)) {
//                            System.out.println();
//                            System.out.println(i + " " + j + "..." + attack.posY  +  " " + attack.posX + "///////////////////////////////" + game[i][j].currentPiece.pieceT);
                            cell tempCell = new cell(game[attack.posY][attack.posX]);
                            cell tempCellStart = new cell(game[i][j]);
                            game[attack.posY][attack.posX].currentPiece = game[i][j].currentPiece;
                            game[i][j].currentPiece = null;
//                            dispBoard(game);
                            double value = minimax(depth - 1, game, -10000, 10000, !isMaximisingPlayer, currentTurn);
                            game[i][j] = tempCellStart;
                            game[attack.posY][attack.posX] = tempCell;
//                            System.out.println(value);
//                            dispBoard(game);
                            if(value >= bestMove) {
                                bestMove = value;
                                bestStartX = i;
                                bestStartY = j;
                                bestEndX = attack.posY;
                                bestEndY = attack.posX;
                            }
                        }
//                        System.out.println();
                                System.out.println(g);
//                                System.out.println();
g = 0.0;
                        chessPlay.calculateAttacks(game, currentTurn);
                        
                    }
                }
            }
        System.out.println(bestStartX + ", " + bestStartY + " -> " + bestEndX + ", " + bestEndY);
        moveHandler(global.cellGrid[bestStartX][bestStartY]);
        moveHandler(global.cellGrid[bestEndX][bestEndY]);
        System.gc();
    }
    
    double g = 0.0;
    
    final double minimax(int depth, cell[][] game, double alpha, double beta, boolean isMaximisingPlayer, pieceColor currentTurn) {
        
        if(currentTurn == pieceColor.blue)
            currentTurn = pieceColor.yellow;
        else
            currentTurn = pieceColor.blue;
            
        chessPlay.calculateAttacks(game, currentTurn);
        
        if(depth == 0) {
            double a = -evaluateBoard(game);
            g += a;
//            System.out.print(a + " ");
            return a;
        }
//        System.out.println("" + currentTurn + currentTurn + currentTurn + currentTurn + isMaximisingPlayer);
        if(isMaximisingPlayer) {
            double bestMove = -9999.0;
            for(int i = 0; i < game.length; i++)
                for(int j = 0; j < game[i].length; j++) {
                    if(game[i][j].currentPiece != null && game[i][j].currentPiece.pieceC == currentTurn && game[i][j].attacking != null) {
                        for(cell attack: game[i][j].attacking) {
                            if(attack.currentPiece == null || (attack.currentPiece != null && attack.currentPiece.pieceC != currentTurn)) {
                                cell tempCell = new cell(game[attack.posY][attack.posX]);
                                cell tempCellStart = new cell(game[i][j]);
                                game[attack.posY][attack.posX].currentPiece = game[i][j].currentPiece;
                                game[i][j].currentPiece = null;
//                                chessPlay.calculateAttacks(game, currentTurn);
                                double tempVal = minimax(depth - 1, game, alpha, beta, !isMaximisingPlayer, currentTurn);
//                                System.out.println(i + " " + j + "..." + bestMove + " "  + depth + "..." + attack.posY  +  " " + attack.posX);
//                                System.out.println("\t" + tempVal + " " + game[attack.posY][attack.posX].currentPiece.pieceT);
                                if(depth == 1)
                                    System.out.println("\t" + tempVal);
//                                    dispBoard(game);
                                if(tempVal > bestMove)
                                    bestMove = tempVal;
                                game[i][j] = tempCellStart;
                                game[attack.posY][attack.posX] = tempCell;
                                chessPlay.calculateAttacks(game, currentTurn);
                                alpha = Math.max(alpha, bestMove);
//                                dispBoard(game);
                                if(beta <= alpha)
                                    return bestMove;
                            }
                        }
                    }
                }
            return bestMove;
        } else {
            double bestMove = 9999.0;
            for(int i = 0; i < game.length; i++)
                for(int j = 0; j < game[i].length; j++) {
                    if(game[i][j].currentPiece != null && game[i][j].currentPiece.pieceC == currentTurn && game[i][j].attacking != null) {
                        for(cell attack: game[i][j].attacking) {
                            if(attack.currentPiece == null || (attack.currentPiece != null && attack.currentPiece.pieceC != currentTurn)) {
                                cell tempCell = new cell(game[attack.posY][attack.posX]);
                                cell tempCellStart = new cell(game[i][j]);
                                game[attack.posY][attack.posX].currentPiece = game[i][j].currentPiece;
                                game[i][j].currentPiece = null;
//                                chessPlay.calculateAttacks(game, currentTurn);
                                double tempVal = minimax(depth - 1, game, alpha, beta, !isMaximisingPlayer, currentTurn);
//                                System.out.println("\t" + tempVal + " " + game[attack.posY][attack.posX].currentPiece.pieceT);
//                                System.out.println(i + " " + j + "..." + bestMove + " " + depth + "..." + attack.posY  +  " " + attack.posX);
                                if(depth == 1)
                                    System.out.println("\t" + tempVal);

//                                    dispBoard(game);
                                if(tempVal < bestMove)
                                    bestMove = tempVal;
                                game[i][j] = tempCellStart;
                                game[attack.posY][attack.posX] = tempCell;
                                chessPlay.calculateAttacks(game, currentTurn);
                                beta = Math.min(beta, bestMove);
//                                dispBoard(game);
                                if(beta <= alpha)
                                    return bestMove;
                            }
                        }
                    }   
                }
            return bestMove;
        }
    }
    
    final double evaluateBoard(cell[][] game) {
        double value = 0.0;
        for(int i = 0; i < game.length; i++) {
            for(int j = 0; j < game.length; j++) {
                value += game[i][j].getPieceValue();
            }
        }
//        dispBoard(game);
        return value;
    }
    
    final void dispBoard(cell[][] game) {
        for(int i = 0; i < game.length; i++) {
            for(int j = 0; j < game.length; j++) {
                if(game[i][j].currentPiece != null)
                    System.out.print("" + game[i][j].currentPiece.pieceT.toString().charAt(0) + game[i][j].getPieceValue() + "\t");
                else System.out.print("____\t");
            }
            System.out.println();
        }
        System.out.println();
    }
    
}
