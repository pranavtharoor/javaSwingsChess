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
    boolean placeable = false;
    
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
        currentPiece = null;
        this.posX=posX;
        this.posY=posY;
        setBaseColor();
        
    }
    
    final void setPiece(chessPiece piece){
        currentPiece=piece; 
        setBaseColor();
    }
    
    final void setBaseColor(){
        if (currentPiece==null){
            this.setIcon(new chessCellIcon(baseCellColor,pieceType.NULL,pieceColor.NULL));       
        }
        else{
            this.setIcon(new chessCellIcon(currentPiece.baseCellColor, currentPiece.pieceT, currentPiece.pieceC));
        }
    }
    final void setHoverColor(){
        if (currentPiece==null){
            this.setIcon(new chessCellIcon(hoverCellColor,pieceType.NULL,pieceColor.NULL));       
        }
        else{
            this.setIcon(new chessCellIcon(currentPiece.hoverCellColor, currentPiece.pieceT, currentPiece.pieceC));
        }
    }
    final void setHoverInvalidColor(){
        this.setIcon(new chessCellIcon(currentPiece.hoverInvalidCellColor, currentPiece.pieceT, currentPiece.pieceC));
    }
    
    final void setMovableUnselectedColor(){
        if (currentPiece==null){
            this.setIcon(new chessCellIcon(movableUnselectedCellColor,pieceType.NULL,pieceColor.NULL));       
        }
        else{
            this.setIcon(new chessCellIcon(movableUnselectedCellColor, currentPiece.pieceT, currentPiece.pieceC));
        }
    }
    
    final void setMovableSelectedColor(){
        if (currentPiece==null){
            this.setIcon(new chessCellIcon(movableSelectedCellColor,pieceType.NULL,pieceColor.NULL));       
        }
        else{
            this.setIcon(new chessCellIcon(currentPiece.movableSelectedCellColor, currentPiece.pieceT, currentPiece.pieceC));
        }
    }
    
    void setAttacking(ArrayList<cell> list){
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
    
    final void setPlaceable() {
        this.placeable = true;
    }
    
    final void unsetPlaceable() {
        this.placeable = false;
    }
    
    final boolean getPlaceable() {
        return this.placeable;
    }
}
