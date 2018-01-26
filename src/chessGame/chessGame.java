/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessGame;

/**
 *
 * @author ashir basu
 */

import java.awt.GridLayout;  import java.awt.Container;
    import javax.swing.JFrame;
    import javax.swing.JTextField;
    
public class chessGame {
    public static void start() {
            
           cell[][] cellGrid = new cell[8][8];
           GridLayout grid = new GridLayout(8,8,0,0);
           JFrame frame = new JFrame("Button Example");
           frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           frame.setResizable(false);
           Container contents = frame.getContentPane();
           
           contents.setLayout(grid);
           contents.add(cellGrid[0][0] = new cell(new chessPiece(pieceType.rook, pieceColor.yellow)));
           contents.add(cellGrid[0][1] = new cell(new chessPiece(pieceType.bishop, pieceColor.yellow)));
           contents.add(cellGrid[0][2] = new cell(new chessPiece(pieceType.knight, pieceColor.yellow)));
           contents.add(cellGrid[0][3] = new cell(new chessPiece(pieceType.queen, pieceColor.yellow)));
           contents.add(cellGrid[0][4] = new cell(new chessPiece(pieceType.king, pieceColor.yellow)));
           contents.add(cellGrid[0][5] = new cell(new chessPiece(pieceType.knight, pieceColor.yellow)));
           contents.add(cellGrid[0][6] = new cell(new chessPiece(pieceType.bishop, pieceColor.yellow)));
           contents.add(cellGrid[0][7] = new cell(new chessPiece(pieceType.rook, pieceColor.yellow)));
           
           
           contents.add(cellGrid[1][0] = new cell(new chessPiece(pieceType.pawn, pieceColor.yellow)));
           contents.add(cellGrid[1][1] = new cell(new chessPiece(pieceType.pawn, pieceColor.yellow)));
           contents.add(cellGrid[1][2] = new cell(new chessPiece(pieceType.pawn, pieceColor.yellow)));
           contents.add(cellGrid[1][3] = new cell(new chessPiece(pieceType.pawn, pieceColor.yellow)));
           contents.add(cellGrid[1][4] = new cell(new chessPiece(pieceType.pawn, pieceColor.yellow)));
           contents.add(cellGrid[1][5] = new cell(new chessPiece(pieceType.pawn, pieceColor.yellow)));
           contents.add(cellGrid[1][6] = new cell(new chessPiece(pieceType.pawn, pieceColor.yellow)));
           contents.add(cellGrid[1][7] = new cell(new chessPiece(pieceType.pawn, pieceColor.yellow)));
           
           
           contents.add(cellGrid[2][0] = new cell());
           contents.add(cellGrid[2][1] = new cell());
           contents.add(cellGrid[2][2] = new cell());
           contents.add(cellGrid[2][3] = new cell());
           contents.add(cellGrid[2][4] = new cell());
           contents.add(cellGrid[2][5] = new cell());
           contents.add(cellGrid[2][6] = new cell());
           contents.add(cellGrid[2][7] = new cell());
           
           
           contents.add(cellGrid[3][0] = new cell());
           contents.add(cellGrid[3][1] = new cell());
           contents.add(cellGrid[3][2] = new cell());
           contents.add(cellGrid[3][3] = new cell());
           contents.add(cellGrid[3][4] = new cell());
           contents.add(cellGrid[3][5] = new cell());
           contents.add(cellGrid[3][6] = new cell());
           contents.add(cellGrid[3][7] = new cell());
           
           
           contents.add(cellGrid[4][0] = new cell());
           contents.add(cellGrid[4][1] = new cell());
           contents.add(cellGrid[4][2] = new cell());
           contents.add(cellGrid[4][3] = new cell());
           contents.add(cellGrid[4][4] = new cell());
           contents.add(cellGrid[4][5] = new cell());
           contents.add(cellGrid[4][6] = new cell());
           contents.add(cellGrid[4][7] = new cell());
           
           
           contents.add(cellGrid[5][0] = new cell());
           contents.add(cellGrid[5][1] = new cell());
           contents.add(cellGrid[5][2] = new cell());
           contents.add(cellGrid[5][3] = new cell());
           contents.add(cellGrid[5][4] = new cell());
           contents.add(cellGrid[5][5] = new cell());
           contents.add(cellGrid[5][6] = new cell());
           contents.add(cellGrid[5][7] = new cell());
           
           
           contents.add(cellGrid[6][0] = new cell(new chessPiece(pieceType.pawn, pieceColor.blue)));
           contents.add(cellGrid[6][1] = new cell(new chessPiece(pieceType.pawn, pieceColor.blue)));
           contents.add(cellGrid[6][2] = new cell(new chessPiece(pieceType.pawn, pieceColor.blue)));
           contents.add(cellGrid[6][3] = new cell(new chessPiece(pieceType.pawn, pieceColor.blue)));
           contents.add(cellGrid[6][4] = new cell(new chessPiece(pieceType.pawn, pieceColor.blue)));
           contents.add(cellGrid[6][5] = new cell(new chessPiece(pieceType.pawn, pieceColor.blue)));
           contents.add(cellGrid[6][6] = new cell(new chessPiece(pieceType.pawn, pieceColor.blue)));
           contents.add(cellGrid[6][7] = new cell(new chessPiece(pieceType.pawn, pieceColor.blue)));
           
           
           contents.add(cellGrid[7][0] = new cell(new chessPiece(pieceType.rook, pieceColor.blue)));
           contents.add(cellGrid[7][1] = new cell(new chessPiece(pieceType.bishop, pieceColor.blue)));
           contents.add(cellGrid[7][2] = new cell(new chessPiece(pieceType.knight, pieceColor.blue)));
           contents.add(cellGrid[7][3] = new cell(new chessPiece(pieceType.queen, pieceColor.blue)));
           contents.add(cellGrid[7][4] = new cell(new chessPiece(pieceType.king, pieceColor.blue)));
           contents.add(cellGrid[7][5] = new cell(new chessPiece(pieceType.knight, pieceColor.blue)));
           contents.add(cellGrid[7][6] = new cell(new chessPiece(pieceType.bishop, pieceColor.blue)));
           contents.add(cellGrid[7][7] = new cell(new chessPiece(pieceType.rook, pieceColor.blue)));
           frame.pack();
           frame.setVisible(true);
       }
    
}
