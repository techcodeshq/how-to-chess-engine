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
        raise NotImplementedError("Implement me!")

    @staticmethod
    def from_file_rank(file: str, rank: int) -> "Location":
        """
        Converts a file and rank to an index.
        (beware of the empty padding on the left, right, top, and bottom of the board)
        Raise an exception if the rank or file is invalid
        e.g. from_file_rank('a', 1) -> index 91
        e.g. from_file_rank('e', 4) -> index 65
        """
        raise NotImplementedError("Implement me!")

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
        raise NotImplementedError("Implement me!")

    def file(self) -> str:
        """
        Returns the file (a-h, inclusive) of this location
        """
        raise NotImplementedError("Implement me!")

    def rank(self) -> int:
        """
        Returns the rank (1-8, inclusive) of this location
        """
        raise NotImplementedError("Implement me!")

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
