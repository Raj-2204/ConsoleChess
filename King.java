

public class King extends Piece {

    public King(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public String getSymbol() {
        return isWhite ? "♔" : "♚";
    }

    @Override
    public boolean isValidMove(int fromRow, int fromCol, int 
toRow, int toCol, Piece[][] board) {
        if (!isValidDestination(toRow, toCol, board)) {
            return false;
        }
        int rowDiff = Math.abs(toRow - fromRow);
        int colDiff = Math.abs(toCol - fromCol);
        return rowDiff <= 1 && colDiff <= 1 && (rowDiff != 0
|| colDiff != 0);
    }
}