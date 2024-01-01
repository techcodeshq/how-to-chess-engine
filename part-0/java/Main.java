public class Main {
    // Worry about this!!
    private static void runTests() {
        // If you want to see how this works, look at PrimitiveTestFramework.java
        PrimitiveTestFramework t = new PrimitiveTestFramework();

        // Examples:
        t.assertTrue("true", true);
        t.assertEqual("1 + 1 == 2", 1 + 1, 2);

        // Try writing your own tests!
        locationTests(t);
        boardTests(t);

        t.endTests();
    }

    private static void locationTests(PrimitiveTestFramework t) {
        t.assertEqual("Two locations should be equal if they have the same index", new Location(65), new Location(65));

        t.assertEqual("Location a1 should be index 91", new Location('a', 1), new Location(91));
        t.assertEqual("Location a8 should be index 21", new Location('a', 8), new Location(21));
        t.assertEqual("Location h8 should be index 28", new Location('h', 8), new Location(28));
        t.assertEqual("Location e5 should be index 55", new Location('e', 5), new Location(55));

        t.assertTrue("Location with index 4 should not be valid", !new Location(4).isValid());
        t.assertTrue("Location with index 10 should not be valid", !new Location(10).isValid());
        t.assertTrue("Location with index 19 should not be valid", !new Location(19).isValid());
        t.assertTrue("Location with index 50 should not be valid", !new Location(50).isValid());
        t.assertTrue("Location with index 101 should not be valid", !new Location(101).isValid());

        t.assertTrue("Location with index 21 should be valid", new Location(21).isValid());
        t.assertTrue("Location with index 28 should be valid", new Location(28).isValid());
        t.assertTrue("Location with index 55 should be valid", new Location(55).isValid());

        // TODO: Add more tests here!
    }

    private static void boardTests(PrimitiveTestFramework t) {
        Board board = Board.startingPosition();
        t.assertEqual("Starting position a1", board.getPiece(new Location('a', 1)), Piece.WhiteRook);
        t.assertEqual("Starting position e8", board.getPiece(new Location('e', 8)), Piece.BlackKing);
        t.assertEqual("Starting position d3", board.getPiece(new Location('a', 1)), Piece.Empty);
        t.assertEqual("Starting position b7", board.getPiece(new Location('a', 1)), Piece.BlackPawn);

        // TODO: Add more tests here!
    }

    // Don't worry about this!!
    public static void main(String[] args) {
        if (args.length != 0 && args[0].equals("test")) {
            runTests();
        } else {
            runProgram();
        }
    }

    private static void runProgram() {
        System.out.println("We'll get to this soon!");
        System.out.println("If you want to run tests, run with the argument \"test\".");
    }
}
