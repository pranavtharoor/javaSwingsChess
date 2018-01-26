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
public class chessPiece {
    public
    pieceColor pieceC;
    pieceType pieceT;
    cellColor baseCellColor;
    cellColor hoverCellColor;
    cellColor selectedCellColor;
    
            chessPiece(pieceType pieceT, pieceColor pieceC){
                this.pieceC=pieceC;
                this.pieceT=pieceT;
                if (pieceC.name().equals("blue"))
                    baseCellColor = cellColor.blue;
                else
                    baseCellColor = cellColor.yellow;
            }
    
}
