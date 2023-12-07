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
    public static Board fromFEN(final String fen) {
        throw new UnsupportedOperationException("Not implemented yet. (Implement me!)");
    }

    // Returns a board with the pieces in their starting positions.
    public static Board startingPosition() {
        return fromFEN("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR");
    }

    // Returns the piece at the given location.
    // If the location is invalid, throw an IllegalArgumentException.
    public Piece getPiece(final Location location) {
        throw new UnsupportedOperationException("Not implemented yet. (Implement me!)");
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
