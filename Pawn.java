

public class Pawn extends Piece {

    public Pawn(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public String getSymbol() {
        return isWhite ? "♙" : "♟";
    }

    @Override
    public boolean isValidMove(int fromRow, int fromCol, int 
toRow, int toCol, Piece[][] board) {
        if (!isValidDestination(toRow, toCol, board)) {
            return false;
        }

        int direction = isWhite ? -1 : 1; 

        int startRow = isWhite ? 6 : 1;  


        
        if (fromCol == toCol) {
            
            if (board[toRow][toCol] != null) {
                return false;
            }

            
            if (toRow == fromRow + direction) {
                return true;
            }

            
            if (fromRow == startRow && toRow == fromRow + 2 *
 direction) {
                return true;
            }
        }

        
        if (Math.abs(fromCol - toCol) == 1 && toRow ==
fromRow + direction) {
            return board[toRow][toCol] != null &&
board[toRow][toCol].isWhite() != this.isWhite();
        }

        return false;
    }
}