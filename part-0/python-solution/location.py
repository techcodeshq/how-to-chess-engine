FILE_TO_OFFSET = {
    "a": 1,
    "b": 2,
    "c": 3,
    "d": 4,
    "e": 5,
    "f": 6,
    "g": 7,
    "h": 8
}

OFFSET_TO_FILE = {
    1: "a",
    2: "b",
    3: "c",
    4: "d",
    5: "e",
    6: "f",
    7: "g",
    8: "h"
}


class Location:
    """
    ```
    r black side
    a ---------- indices
    n xxxxxxxxxx 0-9
    k xxxxxxxxxx 10-19
    8 x________x 20-29
    7 x________x 30-39
    6 x________x 40-49
    5 x________x 50-59
    4 x________x 60-69
    3 x________x 70-79
    2 x________x 80-89
    1 x________x 90-99
      xxxxxxxxxx 100-109
      xxxxxxxxxx 110-119
      .abcdefgh. <- file
      white side
    ```
    valid values are 0-119 (inclusive) and not on a padding square
    """

    # These constants are the directions that a piece can move in
    LEFT = -1
    RIGHT = 1
    UP = 10
    DOWN = -10

    def __init__(self, index: int):
        """Create an instance of a location on the board from an index"""
        self.index = index

    def is_valid(self) -> bool:
        """
        Returns true if this location is a valid location on the board
        """
        return self.index in range(21, 98) and self.index % 10 != 0 and self.index % 10 != 9

    @staticmethod
    def from_file_rank(file: str, rank: int) -> "Location":
        """
        Converts a file and rank to an index.
        (beware of the empty padding on the left, right, top, and bottom of the board)
        Raise an exception if the rank or file is invalid
        e.g. from_file_rank('a', 1) -> index 91
        e.g. from_file_rank('e', 4) -> index 65
        """
        if file not in FILE_TO_OFFSET or rank not in range(1, 9):
            raise Exception("Invalid location")

        file_offset = FILE_TO_OFFSET[file]
        rank_offset = 10 * (8 - rank) + 20

        return Location(file_offset + rank_offset)

    def to_file_rank(self) -> tuple[str, int]:
        """
        Inverse of from_file_rank
        Converts an index to a file and rank.
        (beware of the empty padding on the left, right, top, and bottom of the board)
        Raise an exception if the index is invalid
        e.g. to_file_rank(91) -> ('a', 1)
        e.g. to_file_rank(65) -> ('e', 4)

        * Use variable_a, variable_b to return a "tuple" of two values
        """
        if not self.is_valid():
            raise Exception("Invalid location")
        file_offset = self.index % 10
        rank_offset = 10 - self.index // 10
        return OFFSET_TO_FILE[file_offset], rank_offset

    def file(self) -> str:
        """
        Returns the file (a-h, inclusive) of this location
        """
        return self.to_file_rank()[0]

    def rank(self) -> int:
        """
        Returns the rank (1-8, inclusive) of this location
        """
        return self.to_file_rank()[1]

    # These methods are used for convenience
    def __eq__(self, other):
        return self.index == other.index

    # Python "dunder" (double under) methods are special methods that
    # are used by Python to implement certain features. In this case,
    # we're using __repr__ to tell Python how to represent this object
    # as a string when we print it.
    def __repr__(self):
        return f"Location({self.index})"

    # __str__ is used to tell Python how to represent this object as a
    # string when we cast it to a string (e.g. str(location))
    def __str__(self):
        return f"Location({self.index})"
