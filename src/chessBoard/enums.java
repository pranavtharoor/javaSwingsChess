
package chessBoard;
enum cellColor{
    white,
    grey,
    red,
    green,
    blue,
    yellow,
    NULL
}
enum pieceType{
    king,
    queen,
    rook,
    bishop,
    knight,
    pawn,
    NULL
}
enum pieceColor{
    blue,
    yellow,
    NULL
}

enum moveType{
    recursive,
    single,
    cannotCapture,
    onlyCapture
}

class pieceMove{
    int x;
    int y;
    moveType type;
    pieceMove(int x, int y, moveType type){
        this.x=x;
        this.y=y;
        this.type=type;
    }
}

abstract class specialAction{
    abstract void validateAction();
    abstract void takeAction();
}