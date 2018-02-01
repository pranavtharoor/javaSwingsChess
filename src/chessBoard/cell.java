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

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JButton;
public class cell extends JButton{
    boolean mouseOver=false;
    
    private
    cellColor baseCellColor = cellColor.grey;
    cellColor hoverCellColor = cellColor.white;
    cellColor movableSelectedCellColor = cellColor.green;
    cellColor movableUnselectedCellColor = cellColor.white;
    chessPiece currentPiece;
    ArrayList<cell> attacking;
    public 
    ArrayList<cell> attackedBy = new ArrayList<>();
    
    public
            int posX, posY;
    public cell(int posX, int posY){
        super("");
        this.setPreferredSize(new Dimension(global.size,global.size));
        this.setFocusable(false);
        this.setBorderPainted(false);
        this.setBorder(null);
        this.setBackground(Color.black);
        currentPiece = null;
        this.posX=posX;
        this.posY=posY;
        setBaseColor();
        
    }
    
    public void setPiece(chessPiece piece){
        currentPiece=piece; 
        setBaseColor();
    }
    
    public final void setBaseColor(){
        if (currentPiece==null){
            this.setIcon(new chessCellIcon(baseCellColor,pieceType.NULL,pieceColor.NULL));       
        }
        else{
            this.setIcon(new chessCellIcon(currentPiece.baseCellColor, currentPiece.pieceT, currentPiece.pieceC));
        }
    }
    public final void setHoverColor(){
        if (currentPiece==null){
            this.setIcon(new chessCellIcon(hoverCellColor,pieceType.NULL,pieceColor.NULL));       
        }
        else{
            this.setIcon(new chessCellIcon(currentPiece.hoverCellColor, currentPiece.pieceT, currentPiece.pieceC));
        }
    }
    public final void setHoverInvalidColor(){
        this.setIcon(new chessCellIcon(currentPiece.hoverInvalidCellColor, currentPiece.pieceT, currentPiece.pieceC));
    }
    
    public final void setMovableUnselectedColor(){
        if (currentPiece==null){
            this.setIcon(new chessCellIcon(movableUnselectedCellColor,pieceType.NULL,pieceColor.NULL));       
        }
        else{
            this.setIcon(new chessCellIcon(movableUnselectedCellColor, currentPiece.pieceT, currentPiece.pieceC));
        }
    }
    
    public final void setMovableSelectedColor(){
        if (currentPiece==null){
            this.setIcon(new chessCellIcon(movableSelectedCellColor,pieceType.NULL,pieceColor.NULL));       
        }
        else{
            this.setIcon(new chessCellIcon(movableSelectedCellColor, currentPiece.pieceT, currentPiece.pieceC));
        }
    }
    
    public void setAttacking(ArrayList<cell> list){
        if (attacking!=null) {
            for (cell i: attacking){
                i.attackedBy.remove(this);
            }
        }
        attacking = list;
        if (attacking!=null){
            for (cell i: attacking){
                i.attackedBy.add(this);
            }
        }
    }
}
