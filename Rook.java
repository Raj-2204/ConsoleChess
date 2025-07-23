
public class Rook extends Piece {

    public Rook(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public String getSymbol() {
        return isWhite ? "♖" : "♜";
    }

    @Override
    public boolean isValidMove(int fromRow, int fromCol, int 
toRow, int toCol, Piece[][] board) {
        if (!isValidDestination(toRow, toCol, board)) {
            return false;
        }

        // Rook moves horizontally or vertically
        if (fromRow != toRow && fromCol != toCol) {
            return false;
        }

        // Check if path is clear
        return isPathClear(fromRow, fromCol, toRow, toCol,
board);
    }
}

