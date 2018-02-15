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

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JButton;
public class cell extends JButton{
    double aggressiveness =0.75;
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
    
    public cell(cell c) {
        this.mouseOver = c.mouseOver;
        this.placeable = c.placeable;
        this.baseCellColor = c.baseCellColor;
        this.hoverCellColor = c.hoverCellColor;
        this.movableSelectedCellColor = c.movableSelectedCellColor;
        this.movableUnselectedCellColor = c.movableUnselectedCellColor;
        this.attacking = new ArrayList<cell>();
        if(c.attacking != null)
            this.attacking.addAll(c.attacking);
        this.attackedBy = new ArrayList<cell>();
        if(c.attackedBy != null)
            this.attackedBy.addAll(c.attackedBy);
        this.posX = c.posX;
        this.posY = c.posY;
        
        if(c.currentPiece != null)
            switch(c.currentPiece.pieceT)  {
                case rook:
                    this.currentPiece = new rook(c.currentPiece);
                    break;
                case knight:
                    this.currentPiece = new knight(c.currentPiece);
                    break;
                case bishop:
                    this.currentPiece = new bishop(c.currentPiece);
                    break;
                case queen:
                    this.currentPiece = new queen(c.currentPiece);
                    break;
                case king:
                    this.currentPiece = new king(c.currentPiece);
                    break;
                case pawn:
                    this.currentPiece = new pawn(c.currentPiece);
                    break;
                default:
                    this.currentPiece = null;
            }
        else
            this.currentPiece = null;

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
    
    final double getPieceValue() {
        double value = 0.0;
        if(this.currentPiece != null)
            switch(this.currentPiece.pieceT) {
                case pawn:
                    value += 10 + (this.currentPiece.pieceC == pieceColor.blue ? PawnTable[posX * 8 + posY] : PawnTable[63 - posX * 8 - posY]);
                    break;
                case rook:
                    value += 50 + (this.currentPiece.pieceC == pieceColor.blue ? RookTable[posX * 8 + posY] : RookTable[63 - posX * 8 - posY]);
                    break;
                case knight:
                    value += 30 + (this.currentPiece.pieceC == pieceColor.blue ? KnightTable[posX * 8 + posY] : KnightTable[63 - posX * 8 - posY]);
                    break;
                case bishop:
                    value += 30 + (this.currentPiece.pieceC == pieceColor.blue ? BishopTable[posX * 8 + posY] : BishopTable[63 - posX * 8 - posY]);
                    break;
                case queen:
                    value += 90 + (this.currentPiece.pieceC == pieceColor.blue ? QueenTable[posX * 8 + posY] : QueenTable[63 - posX * 8 - posY]);
                    break;
                case king:
                    value += 9000 + (this.currentPiece.pieceC == pieceColor.blue ? KingTable[posX * 8 + posY] : KingTable[63 - posX * 8 - posY]);
                    break;
            }
        return this.currentPiece == null ? 0 : this.currentPiece.pieceC == pieceColor.blue ? (1-aggressiveness) * value : aggressiveness * -value; 

    }

    private static double[] PawnTable = new double[]
    {
        0.0,  0.0,  0.0,  0.0,  0.0,  0.0,  0.0,  0.0,
        5.0,  5.0,  5.0,  5.0,  5.0,  5.0,  5.0,  5.0,
        1.0,  1.0,  2.0,  3.0,  3.0,  2.0,  1.0,  1.0,
        0.5,  0.5,  1.0,  2.5,  2.5,  1.0,  0.5,  0.5,
        0.0,  0.0,  0.0,  2.0,  2.0,  0.0,  0.0,  0.0,
        0.5, -0.5, -1.0,  0.0,  0.0, -1.0, -0.5,  0.5,
        0.5,  1.0, 1.0,  -2.0, -2.0,  1.0,  1.0,  0.5,
        0.0,  0.0,  0.0,  0.0,  0.0,  0.0,  0.0,  0.0
    };
    private static double[] KnightTable = new double[]
    {
        -5.0, -4.0, -3.0, -3.0, -3.0, -3.0, -4.0, -5.0,
        -4.0, -2.0,  0.0,  0.0,  0.0,  0.0, -2.0, -4.0,
        -3.0,  0.0,  1.0,  1.5,  1.5,  1.0,  0.0, -3.0,
        -3.0,  0.5,  1.5,  2.0,  2.0,  1.5,  0.5, -3.0,
        -3.0,  0.0,  1.5,  2.0,  2.0,  1.5,  0.0, -3.0,
        -3.0,  0.5,  1.0,  1.5,  1.5,  1.0,  0.5, -3.0,
        -4.0, -2.0,  0.0,  0.5,  0.5,  0.0, -2.0, -4.0,
        -5.0, -4.0, -3.0, -3.0, -3.0, -3.0, -4.0, -5.0
    };

    private static double[] BishopTable = new double[]
    {
        -2.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -2.0,
        -1.0,  0.0,  0.0,  0.0,  0.0,  0.0,  0.0, -1.0,
        -1.0,  0.0,  0.5,  1.0,  1.0,  0.5,  0.0, -1.0,
        -1.0,  0.5,  0.5,  1.0,  1.0,  0.5,  0.5, -1.0,
        -1.0,  0.0,  1.0,  1.0,  1.0,  1.0,  0.0, -1.0,
        -1.0,  1.0,  1.0,  1.0,  1.0,  1.0,  1.0, -1.0,
        -1.0,  0.5,  0.0,  0.0,  0.0,  0.0,  0.5, -1.0,
        -2.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -2.0
    };

    private static double[] KingTable = new double[]
    {
        -3.0, -4.0, -4.0, -5.0, -5.0, -4.0, -4.0, -3.0,
        -3.0, -4.0, -4.0, -5.0, -5.0, -4.0, -4.0, -3.0,
        -3.0, -4.0, -4.0, -5.0, -5.0, -4.0, -4.0, -3.0,
        -3.0, -4.0, -4.0, -5.0, -5.0, -4.0, -4.0, -3.0,
        -2.0, -3.0, -3.0, -4.0, -4.0, -3.0, -3.0, -2.0,
        -1.0, -2.0, -2.0, -2.0, -2.0, -2.0, -2.0, -1.0,
         2.0,  2.0,  0.0,  0.0,  0.0,  0.0,  2.0,  2.0,
         2.0,  3.0,  1.0,  0.0,  0.0,  1.0,  3.0,  2.0
    };

//    private static short[] KingTableEndGame = new short[]
//    {
//        -50,-40,-30,-20,-20,-30,-40,-50,
//        -30,-20,-10,  0,  0,-10,-20,-30,
//        -30,-10, 20, 30, 30, 20,-10,-30,
//        -30,-10, 30, 40, 40, 30,-10,-30,
//        -30,-10, 30, 40, 40, 30,-10,-30,
//        -30,-10, 20, 30, 30, 20,-10,-30,
//        -30,-30,  0,  0,  0,  0,-30,-30,
//        -50,-30,-30,-30,-30,-30,-30,-50
//    };

    private static double[] RookTable = new double[]
    {
         0.0,  0.0,  0.0,  0.0,  0.0,  0.0,  0.0,  0.0,
         0.5,  1.0,  1.0,  1.0,  1.0,  1.0,  1.0,  0.5,
        -0.5,  0.0,  0.0,  0.0,  0.0,  0.0,  0.0, -0.5,
        -0.5,  0.0,  0.0,  0.0,  0.0,  0.0,  0.0, -0.5,
        -0.5,  0.0,  0.0,  0.0,  0.0,  0.0,  0.0, -0.5,
        -0.5,  0.0,  0.0,  0.0,  0.0,  0.0,  0.0, -0.5,
        -0.5,  0.0,  0.0,  0.0,  0.0,  0.0,  0.0, -0.5,
         0.0,   0.0, 0.0,  0.5,  0.5,  0.0,  0.0,  0.0
    };
    
    private static double[] QueenTable = new double[]
    {
        -2.0, -1.0, -1.0, -0.5, -0.5, -1.0, -1.0, -2.0,
        -1.0,  0.0,  0.0,  0.0,  0.0,  0.0,  0.0, -1.0,
        -1.0,  0.0,  0.5,  0.5,  0.5,  0.5,  0.0, -1.0,
        -0.5,  0.0,  0.5,  0.5,  0.5,  0.5,  0.0, -0.5,
         0.0,  0.0,  0.5,  0.5,  0.5,  0.5,  0.0, -0.5,
        -1.0,  0.5,  0.5,  0.5,  0.5,  0.5,  0.0, -1.0,
        -1.0,  0.0,  0.5,  0.0,  0.0,  0.0,  0.0, -1.0,
        -2.0, -1.0, -1.0, -0.5, -0.5, -1.0, -1.0, -2.0
    };
    
}
