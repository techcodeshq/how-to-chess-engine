# This is called an "enum" in programming. It's a way to represent
# a set of (integer) constants in human readable form. In this case,
# we're using it to represent the different sides of the game.
class Color:
    """
    Construct like:
    ```
    a = Color(Color.WHITE)
    b = Color(Color.BLACK)
    ```
    in order to use class methods
    """
    WHITE = 0
    BLACK = 1

    def __init__(self, color: int):
        self.color = color

    def opposite(self) -> "Color":
        """
        Returns the opposite color
        """
        raise NotImplementedError("Implement me!")

    def __eq__(self, other):
        return self.color == other.color


class PieceType:
    """
    Construct like:
    ```
    a = PieceType(PieceType.PAWN)
    b = PieceType(PieceType.KNIGHT)
    ```
    in order to use class methods
    """
    PAWN = 0
    KNIGHT = 1
    BISHOP = 2
    ROOK = 3
    QUEEN = 4
    KING = 5

    def __init__(self, color: int):
        self.color = color

    def __eq__(self, other):
        return self.color == other.color


class Piece:
    # Reminder: feel free to change these values!!
    INVALID = -1
    EMPTY = 0

    WHITE_PAWN = 1
    WHITE_KNIGHT = 2
    WHITE_BISHOP = 3
    WHITE_ROOK = 4
    WHITE_QUEEN = 5
    WHITE_KING = 6

    BLACK_PAWN = 7
    BLACK_KNIGHT = 8
    BLACK_BISHOP = 9
    BLACK_ROOK = 10
    BLACK_QUEEN = 11
    BLACK_KING = 12

    def __init__(self, piece: int):
        """
        Construct like:
        ```
        a = Piece(Piece.WHITE_QUEEN)
        b = Piece(Piece.BLACK_QUEEN)
        ```
        in order to use class methods
        """
        self.piece = piece

    def color(self) -> Color:
        """
        Returns the color of this piece
        """
        raise NotImplementedError("Implement me!")

    def piece_type(self) -> PieceType:
        """
        Returns the type of this piece
        """
        raise NotImplementedError("Implement me!")
