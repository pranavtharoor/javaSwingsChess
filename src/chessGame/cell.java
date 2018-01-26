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

import java.awt.Dimension;
import javax.swing.JButton;
public class cell extends JButton{
    
    private
    cellColor baseCellColor;
    cellColor hoverCellColor;
    cellColor selectedCellColor;
    chessPiece currentPiece;
    
    public
    cell(){
        super("");
        this.setSize(200,200);
        this.setPreferredSize(new Dimension(200,200));
        this.setFocusable(false);
        this.setBorderPainted(false);
        this.setBorder(null);
        currentPiece = null;
        update();
    }
    
    cell(chessPiece initial){
        super("");
        this.setSize(200,200);
        this.setPreferredSize(new Dimension(200,200));
        this.setFocusable(false);
        this.setBorderPainted(false);
        this.setBorder(null);
        
        currentPiece = initial;
        
        update();
        
    }
    void update(){
        if (currentPiece==null){
            this.setIcon(new chessCellIcon(cellColor.green,pieceType.NULL,pieceColor.NULL));
        }
        else{
            this.setIcon(new chessCellIcon(currentPiece.baseCellColor, currentPiece.pieceT, currentPiece.pieceC));
        }
    }
}
