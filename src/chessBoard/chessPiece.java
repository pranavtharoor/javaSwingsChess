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
    cellColor selectedCellColor;
    pieceMove[] movesAllowed;
    int numberMoves;
    
    abstract void setMoves();
    chessPiece(pieceColor pieceC){
        this.pieceC=pieceC;
        if (pieceC.name().equals("blue")){
            baseCellColor = cellColor.blue;
        }
        else{
            baseCellColor = cellColor.yellow;
        }
        
        hoverCellColor = cellColor.white;
        selectedCellColor = cellColor.red;
        movesAllowed = new pieceMove[10];
        setMoves();
    }
}

class pawn extends chessPiece{
    pawn (pieceColor pieceC){
        super(pieceC);
        pieceT=pieceType.pawn;
        numberMoves=3;
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
        super(pieceC);
        pieceT=pieceType.rook;
        numberMoves=4;
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
        super(pieceC);
        pieceT=pieceType.bishop;
        numberMoves=4;
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
        super(pieceC);
        pieceT=pieceType.knight;
        numberMoves=8;
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
        super(pieceC);
        pieceT=pieceType.queen;
        numberMoves=8;
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
        super(pieceC);
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

