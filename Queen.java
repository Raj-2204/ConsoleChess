

public class Queen extends Piece {

    public Queen(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public String getSymbol() {
        return isWhite ? "♕" : "♛";
    }

    @Override
    public boolean isValidMove(int fromRow, int fromCol, int 
toRow, int toCol, Piece[][] board) {
        if (!isValidDestination(toRow, toCol, board)) {
            return false;
        }

        int rowDiff = Math.abs(toRow - fromRow);
        int colDiff = Math.abs(toCol - fromCol);

        // Queen combines rook and bishop moves
        boolean isRookMove = (fromRow == toRow || fromCol ==
toCol);
        boolean isBishopMove = (rowDiff == colDiff);

        if (!isRookMove && !isBishopMove) {
            return false;
        }

        // Check if path is clear
        return isPathClear(fromRow, fromCol, toRow, toCol,
board);
    }
}