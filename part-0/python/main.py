from primitive_test_framework import PrimitiveTestFramework
from location import Location
from board import Board
from piece import Piece


# Worry about this!!
def run_tests():
    t = PrimitiveTestFramework()
    t.assert_true("True is true", False)
    t.assert_equal("1 + 1 = 2", 1 + 1, 2)

    # Try writing your own tests!
    location_tests(t)
    board_tests(t)

    t.end_tests()


def location_tests(t: PrimitiveTestFramework):
    t.assert_equal("Two locations should be equal if they have the same index", Location(
        65), Location(65))

    t.assert_equal("Location a1 should be index 91",
                   Location.from_file_rank('a', 1), Location(91))
    t.assert_equal("Location a8 should be index 21",
                   Location.from_file_rank('a', 8), Location(21))
    t.assert_equal("Location h8 should be index 28",
                   Location.from_file_rank('h', 8), Location(28))
    t.assert_equal("Location e5 should be index 55",
                   Location.from_file_rank('e', 5), Location(55))

    t.assert_equal("Location a1 should be in file a",
                   Location.from_file_rank('a', 1).file(), "a")
    t.assert_equal("Location g3 should be in file g",
                   Location.from_file_rank('g', 3).file(), "g")
    t.assert_equal("Location a1 should be in rank 1",
                   Location.from_file_rank('a', 1).rank(), 1)
    t.assert_equal("Location h8 should be in rank 8",
                   Location.from_file_rank('h', 8).rank(), 8)

    t.assert_true("Location with index 4 should not be valid",
                  not Location(4).is_valid())
    t.assert_true("Location with index 10 should not be valid",
                  not Location(10).is_valid())
    t.assert_true("Location with index 19 should not be valid",
                  not Location(19).is_valid())
    t.assert_true("Location with index 50 should not be valid",
                  not Location(50).is_valid())
    t.assert_true("Location with index 101 should not be valid",
                  not Location(101).is_valid())

    t.assert_true("Location with index 21 should be valid",
                  Location(21).is_valid())
    t.assert_true("Location with index 28 should be valid",
                  Location(28).is_valid())
    t.assert_true("Location with index 55 should be valid",
                  Location(55).is_valid())

    # Try writing your own tests!


def board_tests(t: PrimitiveTestFramework):
    t.assert_equal("Starting position a1", Board.starting_position().get_piece(
        Location.from_file_rank('a', 1)), Piece(Piece.WHITE_ROOK))
    t.assert_equal("Starting position e8", Board.starting_position().get_piece(
        Location.from_file_rank('e', 8)), Piece(Piece.BLACK_KING))
    t.assert_equal("Starting position d3", Board.starting_position().get_piece(
        Location.from_file_rank('d', 3)), Piece(Piece.EMPTY))
    t.assert_equal("Starting position b7", Board.starting_position().get_piece(
        Location.from_file_rank('b', 7)), Piece(Piece.BLACK_PAWN))
    # Try writing your own tests!

# Don't worry about this!


def run_program():
    print("We'll do this later!")
    print("If you want to run the tests, run this file with the test argument.")


if __name__ == "__main__":
    import sys
    if len(sys.argv) > 1 and sys.argv[1] == "test":
        run_tests()
    else:
        run_program()
