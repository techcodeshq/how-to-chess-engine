public class PrimitiveTestFramework {
    private int passedTests;
    private int failedTests;
    private int testNumber;

    public PrimitiveTestFramework() {
        passedTests = 0;
        failedTests = 0;
        testNumber = 0;
    }

    public <T> void assertEqual(
            String name,
            T actual,
            T expected) {
        testNumber++;
        if (actual.equals(expected)) {
            passedTests++;
            printOneResult(name, true, "");
        } else {
            failedTests++;
            printOneResult(name, false, "Expected: " + expected + ", Actual: " + actual);
        }
    }

    public void assertTrue(
            String name,
            boolean expression) {
        assertEqual(name, expression, true);
    }

    public void endTests() {
        System.out.println("--- Test results: ---");
        if (failedTests == 0)
            System.out.println("✅ All tests passed!");
        else
            System.out.println("✅: " + passedTests + ", ❌: " + failedTests);
    }

    private void printOneResult(
            String name,
            boolean passed,
            String message) {
        System.out.println((passed ? "✅" : "❌") + " [" + testNumber + "] " + name);
        if (message != null && message.length() > 0)
            System.out.println("    | " + message);
    }

}