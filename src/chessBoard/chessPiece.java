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
abstract class chessPiece {
    protected
    pieceColor pieceC;
    pieceType pieceT;
    cellColor baseCellColor;
    cellColor hoverCellColor;
    cellColor hoverInvalidCellColor;
    cellColor selectedCellColor;
    pieceMove[] movesAllowed;
    int numberMoves;
    
    abstract void setMoves();
    chessPiece(pieceColor pieceC, int numberMoves){
        this.pieceC=pieceC;
        if (pieceC.name().equals("blue")){
            baseCellColor = cellColor.blue;
        }
        else{
            baseCellColor = cellColor.yellow;
        }
        
        hoverCellColor = cellColor.green;
        hoverInvalidCellColor=cellColor.red;
        selectedCellColor = cellColor.red;
        this.numberMoves = numberMoves;
        movesAllowed = new pieceMove[numberMoves];
        setMoves();
    }
}

class pawn extends chessPiece{
    pawn (pieceColor pieceC){
        super(pieceC,3);
        pieceT=pieceType.pawn;
    }
    
    @Override
    void setMoves(){
        movesAllowed[0] = new pieceMove(0,1,moveType.cannotCapture);
        movesAllowed[1] = new pieceMove(1,1,moveType.onlyCapture);
        movesAllowed[2] = new pieceMove(-1,1,moveType.onlyCapture);
    }
}

class rook extends chessPiece{
    rook (pieceColor pieceC){
        super(pieceC,4);
        pieceT=pieceType.rook;
    }
    
    @Override
    void setMoves(){
        movesAllowed[0] = new pieceMove(0,1,moveType.recursive);
        movesAllowed[1] = new pieceMove(0,-1,moveType.recursive);
        movesAllowed[2] = new pieceMove(1,0,moveType.recursive);
        movesAllowed[3] = new pieceMove(-1,0,moveType.recursive);
    }
}
class bishop extends chessPiece{
    bishop (pieceColor pieceC){
        super(pieceC,4);
        pieceT=pieceType.bishop;
    }
    
    @Override
    void setMoves(){
        movesAllowed[0] = new pieceMove(1,1,moveType.recursive);
        movesAllowed[1] = new pieceMove(1,-1,moveType.recursive);
        movesAllowed[2] = new pieceMove(-1,1,moveType.recursive);
        movesAllowed[3] = new pieceMove(-1,-1,moveType.recursive);
    }
}
class knight extends chessPiece{
    knight (pieceColor pieceC){
        super(pieceC,8);
        pieceT=pieceType.knight;
    }
    
    @Override
    void setMoves(){
        movesAllowed[0] = new pieceMove(1,2,moveType.single);
        movesAllowed[1] = new pieceMove(-1,2,moveType.single);
        movesAllowed[2] = new pieceMove(2,1,moveType.single);
        movesAllowed[3] = new pieceMove(2,-1,moveType.single);
        movesAllowed[4] = new pieceMove(-2,1,moveType.single);
        movesAllowed[5] = new pieceMove(-2,-1,moveType.single);
        movesAllowed[6] = new pieceMove(1,-2,moveType.single);
        movesAllowed[7] = new pieceMove(-1,-2,moveType.single);
    }
}

class queen extends chessPiece{
    queen (pieceColor pieceC){
        super(pieceC,8);
        pieceT=pieceType.queen;
    }
    
    @Override
    void setMoves(){
        movesAllowed[0] = new pieceMove(0,1,moveType.recursive);
        movesAllowed[1] = new pieceMove(0,-1,moveType.recursive);
        movesAllowed[2] = new pieceMove(1,0,moveType.recursive);
        movesAllowed[3] = new pieceMove(-1,0,moveType.recursive);
        movesAllowed[4] = new pieceMove(1,1,moveType.recursive);
        movesAllowed[5] = new pieceMove(1,-1,moveType.recursive);
        movesAllowed[6] = new pieceMove(-1,1,moveType.recursive);
        movesAllowed[7] = new pieceMove(-1,-1,moveType.recursive);
    }
}


class king extends chessPiece{
    king (pieceColor pieceC){
        super(pieceC,8);
        pieceT=pieceType.king;
        numberMoves=8;
    }
    
    @Override
    void setMoves(){
        movesAllowed[0] = new pieceMove(0,1,moveType.single);
        movesAllowed[1] = new pieceMove(0,-1,moveType.single);
        movesAllowed[2] = new pieceMove(1,0,moveType.single);
        movesAllowed[3] = new pieceMove(-1,0,moveType.single);
        movesAllowed[4] = new pieceMove(1,1,moveType.single);
        movesAllowed[5] = new pieceMove(1,-1,moveType.single);
        movesAllowed[6] = new pieceMove(-1,1,moveType.single);
        movesAllowed[7] = new pieceMove(-1,-1,moveType.single);
    }
}

