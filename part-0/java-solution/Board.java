public class Board {
    // We'll use a 10x12 board. The outer edges will be used to simplify detecting
    // when a piece goes out of the board
    //
    // black side
    // ---------- indices
    // xxxxxxxxxx 0-9
    // xxxxxxxxxx 10-19
    // x........x 20-29
    // x........x 30-39
    // x........x 40-49
    // x........x 50-59
    // x........x 60-69
    // x........x 70-79
    // x........x 80-89
    // x........x 90-99
    // xxxxxxxxxx 100-109
    // xxxxxxxxxx 110-119
    // white side
    private Piece[] board;

    // Takes a FEN string and returns a Board object.
    // (only worry about the piece placement part of FEN for now! Ignore the rest
    // but make sure your code doesn't crash if it sees it)
    // Throws an IllegalArgumentException if the FEN string is invalid.
    // For more information on FEN, see https://www.chess.com/terms/fen-chess
    public Board(final String fen) {
        String[] rows = fen.split("/");

        // first create the board without the padding
        Piece[] pieces = new Piece[64];

        int index = 0;
        for (String row : rows) {
            for (char c : row.toCharArray()) {
                // for every character
                if (Character.isDigit(c)) {
                    // if it's a number, add that many empty squares
                    for (int i = 0; i < Character.getNumericValue(c); i++) {
                        pieces[index] = Piece.Empty;
                        index++;
                    }
                } else {
                    // otherwise, add the piece that corresponds to the character
                    pieces[index] = Piece.fromChar(c);
                    index++;
                }
            }
        }

        // second, create the board with the added padding
        Piece[] paddedPieces = new Piece[120];

        // add 20 invalid squares to the beginning (top padding)
        for (int i = 0; i < 20; i++) {
            paddedPieces[i] = Piece.Invalid;
        }

        int paddedIndex = 20;

        // build each row with the left and right padding from the 8x8 board we built
        for (int row = 0; row < 8; row++) {
            paddedPieces[paddedIndex] = Piece.Invalid;
            paddedIndex++;
            for (int column = 0; column < 8; column++) {
                paddedPieces[paddedIndex] = pieces[row * 8 + column];
                paddedIndex++;
            }
            paddedPieces[paddedIndex] = Piece.Invalid;
            paddedIndex++;
        }

        // add 20 more invalid squares to the end (bottom padding)
        for (int i = 0; i < 20; i++) {
            paddedPieces[paddedIndex + i] = Piece.Invalid;
        }

        // finally, initialize the instance variable
        this.board = paddedPieces;
    }

    // Returns a board with the pieces in their starting positions.
    public static Board startingPosition() {
        return new Board("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR");
    }

    // Returns the piece at the given location.
    public Piece getPiece(final Location location) {
        return this.board[location.index];
    }

    // Prints the board to the console.
    // You can use lowercase letters for black pieces and uppercase letters for
    // white pieces.
    // An example of what this could look like:
    // https://www.maketecheasier.com/assets/uploads/2023/01/terminal-stockfish-command-d-shows-a-virtual-chess-board.jpg.webp
    public void display() {
        throw new UnsupportedOperationException("Not implemented yet. (Implement me!)");
    }
}
