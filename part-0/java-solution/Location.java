import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

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

    private static final Map<Character, Integer> FILE_TO_OFFSET = Collections
            .unmodifiableMap(new HashMap<>() {
                {
                    put('a', 1);
                    put('b', 2);
                    put('c', 3);
                    put('d', 4);
                    put('e', 5);
                    put('f', 6);
                    put('g', 7);
                    put('h', 8);
                }
            });
    private static final Map<Integer, Character> OFFSET_TO_FILE = Collections
            .unmodifiableMap(new HashMap<>() {
                {
                    put(1, 'a');
                    put(2, 'b');
                    put(3, 'c');
                    put(4, 'd');
                    put(5, 'e');
                    put(6, 'f');
                    put(7, 'g');
                    put(8, 'h');
                }
            });

    // Creates a location from an index.
    Location(final int index) {
        this.index = index;
    }

    // Returns true if the location is valid, false otherwise.
    // A location is considered valid if it is on the board (not on a padding square
    // or out of bounds).
    public boolean isValid() {
        return (
        // not on the left padding
        this.index % 10 != 0
                // not on the right padding
                && this.index % 10 != 9
                // not on the top padding
                && this.index >= 20
                // not on the bottom padding
                && this.index <= 99);
    }

    // Converts a file and rank to a location with an index corresponding to the
    // file and rank.
    // (beware of the empty padding on the left, right, top, and bottom of the
    // board)
    // Throw an IllegalArgumentException if the file or rank is invalid.
    // e.g. new Location('a', 1) -> index 91
    // e.g. new Location('e', 4) -> index 65
    Location(
            final char file,
            final int rank) {
        if (!FILE_TO_OFFSET.containsKey(file) || rank < 1 || rank > 8)
            throw new IllegalArgumentException("Invalid location");
        // fileOffset of 'a' is 1, 'b' is 2, it's how much index to add from the padding
        int fileOffset = FILE_TO_OFFSET.get(file);
        // rankOffset of 1 is 110, 2 is 100, how much to add from the top
        int rankOffset = 10 * (8 - rank) + 20;
        this.index = fileOffset + rankOffset;
    }

    // Returns the file (a-h, inclusive) of this location
    // If the location is invalid, throw an UnsupportedOperationException.
    public char file() {
        if (!this.isValid())
            throw new UnsupportedOperationException("Invalid location");
        int fileOffset = this.index % 10;
        return OFFSET_TO_FILE.get(fileOffset);
    }

    // Returns the rank (1-8, inclusive) of this location
    // If the location is invalid, throw an UnsupportedOperationException.
    public int rank() {
        if (!this.isValid())
            throw new UnsupportedOperationException("Invalid location");
        return (10 - this.index / 10);
    }

    // Returns if this location is the same as the other location.
    // (two locations are the same if they have the same index)
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Location))
            return false;
        return this.index == ((Location) other).index;
    }

    @Override
    public String toString() {
        return String.format("Location(%d)", this.index);
    }
}
