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

import java.awt.GridLayout;  import java.awt.Container;
    import javax.swing.JPanel;
    
public class chessBoard extends JPanel{
    
    cell[][] cellGrid = new cell[8][8];           
    public chessBoard() {
        GridLayout grid = new GridLayout(8,8,0,0);
        this.setLayout(grid);
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                cellGrid[i][j] = new cell();
                this.add(cellGrid[i][j]);
            }
        }
        setInitialConfig();
        this.setVisible(true);
    }   
    
    void setInitialConfig(){
        
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
}
