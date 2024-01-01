public class Location {
    // r.. black side
    // a.. ---------- indices
    // n.. xxxxxxxxxx 0-9
    // k.. xxxxxxxxxx 10-19
    // 8 . x________x 20-29
    // 7 . x________x 30-39
    // 6 . x________x 40-49
    // 5 . x________x 50-59
    // 4 . x________x 60-69
    // 3 . x________x 70-79
    // 2 . x________x 80-89
    // 1 . x________x 90-99
    // ... xxxxxxxxxx 100-109
    // ... xxxxxxxxxx 110-119
    // ... .abcdefgh. <- file
    // ... white side
    // valid values are 0-119 (inclusive) and not on a padding square

    public final int index;

    // These are the the offset in indices from the current location to these
    // adjacent locations.
    public static final int LEFT = -1;
    public static final int RIGHT = 1;
    public static final int UP = -10;
    public static final int DOWN = 10;

    // Creates a location from an index.
    Location(final int index) {
        this.index = index;
    }

    // Returns true if the location is valid, false otherwise.
    // A location is considered valid if it is on the board (not on a padding square
    // or out of bounds).
    public boolean isValid() {
        throw new UnsupportedOperationException("Not implemented yet. (Implement me!)");
    }

    // Converts a file and rank to a location with an index corresponding to the
    // file and rank.
    // (beware of the empty padding on the left, right, top, and bottom of the
    // board)
    // Throw an IllegalArgumentException if the file or rank is invalid.
    // e.g. fromFileRank('a', 1) -> index 91
    // e.g. fromFileRank('e', 4) -> index 65
    Location(
            final char file,
            final int rank) {
        throw new UnsupportedOperationException("Not implemented yet. (Implement me!)");
    }

    // Returns the file (a-h, inclusive) of this location
    // If the location is invalid, throw an UnsupportedOperationException.
    public char file() {
        throw new UnsupportedOperationException("Not implemented yet. (Implement me!)");
    }

    // Returns the rank (1-8, inclusive) of this location
    // If the location is invalid, throw an UnsupportedOperationException.
    public int rank() {
        throw new UnsupportedOperationException("Not implemented yet. (Implement me!)");
    }

    // Returns if this location is the same as the other location.
    // (two locations are the same if they have the same index)
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Location))
            return false;
        return this.index == ((Location) other).index;
    }
}
