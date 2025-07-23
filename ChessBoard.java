

public class ChessBoard {
    private Piece[][] board;

    public ChessBoard() {
        this.board = new Piece[8][8];
        initializeBoard();
    }

    private void initializeBoard() {
        // Place black pieces (top of board)
        board[0][0] = new Rook(false);
        board[0][1] = new Knight(false);
        board[0][2] = new Bishop(false);
        board[0][3] = new Queen(false);
        board[0][4] = new King(false);
        board[0][5] = new Bishop(false);
        board[0][6] = new Knight(false);
        board[0][7] = new Rook(false);

        // Black pawns
        for (int i = 0; i < 8; i++) {
            board[1][i] = new Pawn(false);
        }

        // Empty squares in middle
        for (int row = 2; row < 6; row++) {
            for (int col = 0; col < 8; col++) {
                board[row][col] = null;
            }
        }

        // White pawns
        for (int i = 0; i < 8; i++) {
            board[6][i] = new Pawn(true);
        }

        // Place white pieces (bottom of board)
        board[7][0] = new Rook(true);
        board[7][1] = new Knight(true);
        board[7][2] = new Bishop(true);
        board[7][3] = new Queen(true);
        board[7][4] = new King(true);
        board[7][5] = new Bishop(true);
        board[7][6] = new Knight(true);
        board[7][7] = new Rook(true);
    }

    public void displayBoard() {
        System.out.println();
        System.out.println("  ╔═════════════════════════════╗");
        System.out.println("  ║    a  b  c  d  e  f  g  h   ║");
        System.out.println("  ╣═════════════════════════════╣");

        for (int row = 0; row < 8; row++) {
            System.out.print("  ║ " + (8 - row) + " ");

            for (int col = 0; col < 8; col++) {
                // Alternate square colors
                boolean isLightSquare = (row + col) % 2 == 0;
                String square = isLightSquare ? "░" : "▓";

                if (board[row][col] == null) {
                    System.out.print(square + square +
square);
                } else {
                    System.out.print(square +
board[row][col].getSymbol() + square);
                }
            }

            System.out.println(" " + (8 - row) + "║");
        }

        System.out.println("  ╠═════════════════════════════╣");
        System.out.println("  ║    a  b  c  d  e  f  g  h   ║");
        System.out.println("  ╚═════════════════════════════╝");
        System.out.println();
    }

    public boolean makeMove(String from, String to, boolean 
isWhiteTurn) {
        int[] fromPos = parsePosition(from);
        int[] toPos = parsePosition(to);

        if (fromPos == null || toPos == null) {
            return false;
        }

        int fromRow = fromPos[0], fromCol = fromPos[1];
        int toRow = toPos[0], toCol = toPos[1];

        Piece piece = board[fromRow][fromCol];

        // Check if there's a piece and it belongs to current player
        if (piece == null || piece.isWhite() != isWhiteTurn)
{
            return false;
        }

        // Check if move is valid for this piece
        if (piece.isValidMove(fromRow, fromCol, toRow, toCol,
 board)) {
            board[toRow][toCol] = piece;
            board[fromRow][fromCol] = null;
            return true;
        }

        return false;
    }

    private int[] parsePosition(String position) {
        if (position.length() != 2) {
            return null;
        }

        char file = position.charAt(0);  // a-h
        char rank = position.charAt(1);  // 1-8

        if (file < 'a' || file > 'h' || rank < '1' || rank >
'8') {
            return null;
        }

        int col = file - 'a';           // Convert a-h to 0-7
        int row = 8 - (rank - '0');     // Convert 1-8 to 7-0 (flipped for array)

        return new int[]{row, col};
    }
}
