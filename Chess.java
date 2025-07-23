

import java.util.Scanner;
  import java.util.ArrayList;

  public class Chess {
      private ChessBoard board;
      private Scanner scanner;
      private boolean isWhiteTurn;
      private ArrayList<String> moveHistory;

      public Chess() {
          this.board = new ChessBoard();
          this.scanner = new Scanner(System.in);
          this.isWhiteTurn = true;  // White always starts
          this.moveHistory = new ArrayList<>();
      }

      public void startGame() {
          displayWelcome();

          while (true) {
              clearScreen();
              board.displayBoard();
              displayGameStatus();
              displayMoveHistory();

              String input = getPlayerInput();

              if (input.equalsIgnoreCase("quit") ||
  input.equalsIgnoreCase("exit")) {
                  displayGoodbye();
                  break;
              }

              if (processMove(input)) {
                  // Record the move
                  String player = isWhiteTurn ? "White" :
  "Black";
                  moveHistory.add(player + ": " + input);

                  // Switch turns
                  isWhiteTurn = !isWhiteTurn;
              } else {
                  displayInvalidMove();
                  waitForUser();
              }
          }

          scanner.close();
      }

      private void displayWelcome() {
          System.out.println();
          System.out.println("  ♔♕♖♗♘♙  CONSOLE CHESS GAME  ♟♞♝♜♛♚");
          System.out.println("  ═══════════════════════════════════════");
          System.out.println("  Instructions:");
          System.out.println("  • Enter moves like: e2 e4");
          System.out.println("  • Type 'quit' to exit the game");
          System.out.println("  • White pieces move first");
          System.out.println("  • Have fun playing chess!");
          System.out.println();
          System.out.print("  Press Enter to start...");
          scanner.nextLine();
      }

      private void displayGameStatus() {
          if (isWhiteTurn) {
              System.out.println("  ♔ WHITE'S TURN ♔");
          } else {
              System.out.println("  ♚ BLACK'S TURN ♚");
          }
          System.out.println();
      }

      private void displayMoveHistory() {
          if (!moveHistory.isEmpty()) {
              System.out.println("  Recent moves:");
              int start = Math.max(0, moveHistory.size() - 3);
              for (int i = start; i < moveHistory.size(); i++)
  {
                  System.out.println("  " + (i + 1) + ". " +
  moveHistory.get(i));
              }
              System.out.println();
          }
      }

      private String getPlayerInput() {
          System.out.print("  ➤ Enter your move (from to): ");
          return scanner.nextLine().trim();
      }

      private boolean processMove(String input) {
          String[] parts = input.split(" ");
          if (parts.length != 2) {
              return false;
          }

          String from = parts[0].toLowerCase();
          String to = parts[1].toLowerCase();

          return board.makeMove(from, to, isWhiteTurn);
      }

      private void displayInvalidMove() {
          System.out.println("  ❌ Invalid move! Please try  again.");
          System.out.println("  Make sure:");
          System.out.println("  • You own the piece you're  trying to move");
          System.out.println("  • The move follows the piece's rules");
          System.out.println("  • The destination is valid");
      }

      private void waitForUser() {
          System.out.print("  Press Enter to continue...");
          scanner.nextLine();
      }

      private void displayGoodbye() {
          System.out.println();
          System.out.println("  ♔♕♖♗♘♙  THANKS FOR PLAYING!  ♟♞♝♜♛♚");
          System.out.println("  Hope you enjoyed your chess game!");
          System.out.println();
      }

      private void clearScreen() {
          // Print empty lines to simulate clearing screen
          for (int i = 0; i < 50; i++) {
              System.out.println();
          }
      }

      public static void main(String[] args) {
          Chess game = new Chess();
          game.startGame();
      }
  }