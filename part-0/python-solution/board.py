from piece import Piece
from location import Location


class Board:
    """
    We'll use a 10x12 board. The outer edges will be used to simplify detecting
    when a piece goes out of the board

    black side
    ---------- indices
    xxxxxxxxxx 0-9
    xxxxxxxxxx 10-19
    x........x 20-29
    x........x 30-39
    x........x 40-49
    x........x 50-59
    x........x 60-69
    x........x 70-79
    x........x 80-89
    x........x 90-99
    xxxxxxxxxx 100-109
    xxxxxxxxxx 110-119
    white side
    """

    def __init__(self, pieces: list[Piece]):
        self.piece = pieces

    @staticmethod
    def from_fen(fen: str) -> "Board":
        """
        Takes a FEN string and returns a Board object.
        (only worry about the piece placement part of FEN for now! Ignore the rest
        but make sure your code doesn't crash if it sees it)
        raise an exception if the FEN is invalid
        For more information on FEN, see https://www.chess.com/terms/fen-chess 
        """

        out = []
        out.extend([Piece(Piece.INVALID)] * 21)

        for line in fen.split("/"):
            for char in line:
                if char.isdigit():
                    out.extend([Piece(Piece.EMPTY)] * int(char))
                else:
                    out.append(Piece.from_char(char))

            out.extend([Piece(Piece.INVALID)] * 2)

        out.extend([Piece(Piece.INVALID)] * 19)

        assert len(out) == 120, f"Invalid length for board {len(out)}"

        return Board(out)

    @staticmethod
    def starting_position() -> "Board":
        """
        Returns a Board object with the starting position
        """
        return Board.from_fen("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR")

    def get_piece(self, location: Location) -> Piece:
        """
        Returns the piece at the given location.
        Raise an exception if the location is invalid
        """
        return self.piece[location.index]

    # This method is optional, but it will make your life easier.
    # It is called when you try to print a Board object, return what
    # you want to be printed.
    # You can use lowercase letters for black pieces and uppercase letters for
    # An example of what this could look like:
    # https://www.maketecheasier.com/assets/uploads/2023/01/terminal-stockfish-command-d-shows-a-virtual-chess-board.jpg.webp
    def __repr__(self) -> str:
        """
        Returns a string representation of the board
        """
        raise NotImplementedError("Implement me!")
