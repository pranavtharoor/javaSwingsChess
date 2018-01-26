/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessBoard;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.Icon;
/**
 *
 * @author ashir basu
 */

public class chessCellIcon implements Icon{
    private ImageIcon cell;
    private ImageIcon piece;
    private Boolean pieceSet = false;
    chessCellIcon(cellColor cellC, pieceType pieceT, pieceColor pieceC){
        String cellIcon = "/tile_" + cellC.name()+".png";
        cell = new ImageIcon(new ImageIcon(getClass().getResource(cellIcon)).getImage().getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH));
        
        if (!pieceT.name().equals("NULL")){
            pieceSet=true;
            String pieceIcon = "/"+pieceT.name()+"_"+pieceC.toString()+".png";
            piece = new ImageIcon(new ImageIcon(getClass().getResource(pieceIcon)).getImage().getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH));
        }
    }
    @Override
     public int getIconHeight() {
        if (pieceSet)
            return Math.max(cell.getIconHeight(), piece.getIconHeight());
        else
            return cell.getIconHeight();
    }
    @Override
    public int getIconWidth() {
        if (pieceSet)
            return Math.max(cell.getIconWidth(), piece.getIconWidth());
        else
            return cell.getIconWidth();
    }
    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        
        cell.paintIcon(c, g, x, y);
        if (pieceSet)
            piece.paintIcon(c, g, x, y);
    }
}
