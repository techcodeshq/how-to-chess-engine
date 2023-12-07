public enum Piece {
    Invalid,
    Empty,

    WhitePawn,
    WhiteKnight,
    WhiteBishop,
    WhiteRook,
    WhiteQueen,
    WhiteKing,

    BlackPawn,
    BlackKnight,
    BlackBishop,
    BlackRook,
    BlackQueen,
    BlackKing;

    // Returns the color of the piece.
    public Color color() {
        throw new UnsupportedOperationException("Not implemented yet. (Implement me!)");
    }

    public enum Color {
        White,
        Black;

        // Returns the opposite color.
        // Throws an UnsupportedOperationException("Piece cannot be Invalid or Empty.")
        // if called on Invalid or Empty.
        public Color opposite() {
            throw new UnsupportedOperationException("Not implemented yet. (Implement me!)");
        }
    }

    // Returns the type of the piece.
    // Throws an UnsupportedOperationException("Piece cannot be Invalid or Empty.")
    // if called on Invalid or Empty.
    public PieceType type() {
        throw new UnsupportedOperationException("Not implemented yet. (Implement me!)");
    }

    public enum PieceType {
        Pawn,
        Knight,
        Bishop,
        Rook,
        Queen,
        King
    }
}
