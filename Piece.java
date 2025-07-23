

public abstract class Piece {
    protected boolean isWhite;

    public Piece(boolean isWhite) {
        this.isWhite = isWhite;
    }

    public boolean isWhite() {
        return isWhite;
    }

    
    public abstract String getSymbol();

    
    public abstract boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol, Piece[][] board);

    
    protected boolean isPathClear(int fromRow, int fromCol, int toRow, int toCol, Piece[][] board) {
        int rowDirection = Integer.compare(toRow, fromRow);
        int colDirection = Integer.compare(toCol, fromCol);

        int currentRow = fromRow + rowDirection;
        int currentCol = fromCol + colDirection;

        while (currentRow != toRow || currentCol != toCol) {
            if (board[currentRow][currentCol] != null) {
                return false;
            }
            currentRow += rowDirection;
            currentCol += colDirection;
        }
        return true;
    }

    
    protected boolean isValidDestination(int toRow, int toCol, Piece[][] board) {
        
        if (toRow < 0 || toRow >= 8 || toCol < 0 || toCol >= 8) {
            return false;
        }

        
        Piece destinationPiece = board[toRow][toCol];
        return destinationPiece == null || destinationPiece.isWhite() != this.isWhite();
    }
}