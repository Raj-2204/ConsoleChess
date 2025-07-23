

public class Bishop extends Piece {

    public Bishop(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public String getSymbol() {
        return isWhite ? "♗" : "♝";
    }

    @Override
    public boolean isValidMove(int fromRow, int fromCol, int 
toRow, int toCol, Piece[][] board) {
        if (!isValidDestination(toRow, toCol, board)) {
            return false;
        }

        // Bishop moves diagonally
        int rowDiff = Math.abs(toRow - fromRow);
        int colDiff = Math.abs(toCol - fromCol);

        if (rowDiff != colDiff) {
            return false;
        }

        // Check if diagonal path is clear
        return isPathClear(fromRow, fromCol, toRow, toCol,
board);
    }
}