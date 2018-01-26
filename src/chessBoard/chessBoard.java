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
    
    public cell[][] cellGrid = new cell[8][8];           
    public chessBoard() {
            
           GridLayout grid = new GridLayout(8,8,0,0);
           
           this.setLayout(grid);
           this.add(cellGrid[0][0] = new cell(new chessPiece(pieceType.rook, pieceColor.yellow)));
           this.add(cellGrid[0][1] = new cell(new chessPiece(pieceType.bishop, pieceColor.yellow)));
           this.add(cellGrid[0][2] = new cell(new chessPiece(pieceType.knight, pieceColor.yellow)));
           this.add(cellGrid[0][3] = new cell(new chessPiece(pieceType.queen, pieceColor.yellow)));
           this.add(cellGrid[0][4] = new cell(new chessPiece(pieceType.king, pieceColor.yellow)));
           this.add(cellGrid[0][5] = new cell(new chessPiece(pieceType.knight, pieceColor.yellow)));
           this.add(cellGrid[0][6] = new cell(new chessPiece(pieceType.bishop, pieceColor.yellow)));
           this.add(cellGrid[0][7] = new cell(new chessPiece(pieceType.rook, pieceColor.yellow)));
           
           
           this.add(cellGrid[1][0] = new cell(new chessPiece(pieceType.pawn, pieceColor.yellow)));
           this.add(cellGrid[1][1] = new cell(new chessPiece(pieceType.pawn, pieceColor.yellow)));
           this.add(cellGrid[1][2] = new cell(new chessPiece(pieceType.pawn, pieceColor.yellow)));
           this.add(cellGrid[1][3] = new cell(new chessPiece(pieceType.pawn, pieceColor.yellow)));
           this.add(cellGrid[1][4] = new cell(new chessPiece(pieceType.pawn, pieceColor.yellow)));
           this.add(cellGrid[1][5] = new cell(new chessPiece(pieceType.pawn, pieceColor.yellow)));
           this.add(cellGrid[1][6] = new cell(new chessPiece(pieceType.pawn, pieceColor.yellow)));
           this.add(cellGrid[1][7] = new cell(new chessPiece(pieceType.pawn, pieceColor.yellow)));
           
           
           this.add(cellGrid[2][0] = new cell());
           this.add(cellGrid[2][1] = new cell());
           this.add(cellGrid[2][2] = new cell());
           this.add(cellGrid[2][3] = new cell());
           this.add(cellGrid[2][4] = new cell());
           this.add(cellGrid[2][5] = new cell());
           this.add(cellGrid[2][6] = new cell());
           this.add(cellGrid[2][7] = new cell());
           
           
           this.add(cellGrid[3][0] = new cell());
           this.add(cellGrid[3][1] = new cell());
           this.add(cellGrid[3][2] = new cell());
           this.add(cellGrid[3][3] = new cell());
           this.add(cellGrid[3][4] = new cell());
           this.add(cellGrid[3][5] = new cell());
           this.add(cellGrid[3][6] = new cell());
           this.add(cellGrid[3][7] = new cell());
           
           
           this.add(cellGrid[4][0] = new cell());
           this.add(cellGrid[4][1] = new cell());
           this.add(cellGrid[4][2] = new cell());
           this.add(cellGrid[4][3] = new cell());
           this.add(cellGrid[4][4] = new cell());
           this.add(cellGrid[4][5] = new cell());
           this.add(cellGrid[4][6] = new cell());
           this.add(cellGrid[4][7] = new cell());
           
           
           this.add(cellGrid[5][0] = new cell());
           this.add(cellGrid[5][1] = new cell());
           this.add(cellGrid[5][2] = new cell());
           this.add(cellGrid[5][3] = new cell());
           this.add(cellGrid[5][4] = new cell());
           this.add(cellGrid[5][5] = new cell());
           this.add(cellGrid[5][6] = new cell());
           this.add(cellGrid[5][7] = new cell());
           
           
           this.add(cellGrid[6][0] = new cell(new chessPiece(pieceType.pawn, pieceColor.blue)));
           this.add(cellGrid[6][1] = new cell(new chessPiece(pieceType.pawn, pieceColor.blue)));
           this.add(cellGrid[6][2] = new cell(new chessPiece(pieceType.pawn, pieceColor.blue)));
           this.add(cellGrid[6][3] = new cell(new chessPiece(pieceType.pawn, pieceColor.blue)));
           this.add(cellGrid[6][4] = new cell(new chessPiece(pieceType.pawn, pieceColor.blue)));
           this.add(cellGrid[6][5] = new cell(new chessPiece(pieceType.pawn, pieceColor.blue)));
           this.add(cellGrid[6][6] = new cell(new chessPiece(pieceType.pawn, pieceColor.blue)));
           this.add(cellGrid[6][7] = new cell(new chessPiece(pieceType.pawn, pieceColor.blue)));
           
           
           this.add(cellGrid[7][0] = new cell(new chessPiece(pieceType.rook, pieceColor.blue)));
           this.add(cellGrid[7][1] = new cell(new chessPiece(pieceType.bishop, pieceColor.blue)));
           this.add(cellGrid[7][2] = new cell(new chessPiece(pieceType.knight, pieceColor.blue)));
           this.add(cellGrid[7][3] = new cell(new chessPiece(pieceType.queen, pieceColor.blue)));
           this.add(cellGrid[7][4] = new cell(new chessPiece(pieceType.king, pieceColor.blue)));
           this.add(cellGrid[7][5] = new cell(new chessPiece(pieceType.knight, pieceColor.blue)));
           this.add(cellGrid[7][6] = new cell(new chessPiece(pieceType.bishop, pieceColor.blue)));
           this.add(cellGrid[7][7] = new cell(new chessPiece(pieceType.rook, pieceColor.blue)));
           
           this.setVisible(true);
       }
    
}
