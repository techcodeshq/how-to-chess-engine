public enum Piece {
    // The numbers are the ordinal values of the enum.
    Invalid, // 0
    Empty, // 1

    WhitePawn, // 2
    WhiteKnight,
    WhiteBishop,
    WhiteRook,
    WhiteQueen,
    WhiteKing, // 7

    BlackPawn, // 8
    BlackKnight,
    BlackBishop,
    BlackRook,
    BlackQueen,
    BlackKing; // 9

    // Returns the color of the piece.
    public Color color() {
        if (this == Invalid || this == Empty)
            throw new UnsupportedOperationException("Piece cannot be Invalid or Empty.");
        return this.ordinal() <= 7 ? Color.White : Color.Black;
    }

    public enum Color {
        White,
        Black;

        // Returns the opposite color.
        // Throws an UnsupportedOperationException("Piece cannot be Invalid or Empty.")
        // if called on Invalid or Empty.
        public Color opposite() {
            if (this == White)
                return Black;
            return White;
        }
    }

    // Returns the type of the piece.
    // Throws an UnsupportedOperationException("Piece cannot be Invalid or Empty.")
    // if called on Invalid or Empty.
    public PieceType type() {
        switch (this) {
            // note: fallthrough is intentional here
            case WhitePawn:
            case BlackPawn:
                return PieceType.Pawn;
            case WhiteKnight:
            case BlackKnight:
                return PieceType.Knight;
            case WhiteBishop:
            case BlackBishop:
                return PieceType.Bishop;
            case WhiteRook:
            case BlackRook:
                return PieceType.Rook;
            case WhiteQueen:
            case BlackQueen:
                return PieceType.Queen;
            case WhiteKing:
            case BlackKing:
                return PieceType.King;
            default:
                throw new UnsupportedOperationException("Piece cannot be Invalid or Empty.");
        }
    }

    public enum PieceType {
        Pawn,
        Knight,
        Bishop,
        Rook,
        Queen,
        King
    }

    public static Piece fromChar(char c) {
        switch (Character.toLowerCase(c)) {
            case 'p':
                return Character.isUpperCase(c) ? WhitePawn : BlackPawn;
            case 'n':
                return Character.isUpperCase(c) ? WhiteKnight : BlackKnight;
            case 'b':
                return Character.isUpperCase(c) ? WhiteBishop : BlackBishop;
            case 'r':
                return Character.isUpperCase(c) ? WhiteRook : BlackRook;
            case 'q':
                return Character.isUpperCase(c) ? WhiteQueen : BlackQueen;
            case 'k':
                return Character.isUpperCase(c) ? WhiteKing : BlackKing;
            default:
                throw new IllegalArgumentException("Invalid piece character: " + c);
        }
    }

    public char toChar() {
        switch (this) {
            case WhitePawn:
            case BlackPawn:
                return color() == Color.White ? 'P' : 'p';
            case WhiteKnight:
            case BlackKnight:
                return color() == Color.White ? 'N' : 'n';
            case WhiteBishop:
            case BlackBishop:
                return color() == Color.White ? 'B' : 'b';
            case WhiteRook:
            case BlackRook:
                return color() == Color.White ? 'R' : 'r';
            case WhiteQueen:
            case BlackQueen:
                return color() == Color.White ? 'Q' : 'q';
            case WhiteKing:
            case BlackKing:
                return color() == Color.White ? 'K' : 'k';
            case Empty:
                return ' ';
            default:
                return 'X';
        }
    }
}
