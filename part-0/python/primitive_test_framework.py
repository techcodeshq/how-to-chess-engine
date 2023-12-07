class PrimitiveTestFramework:
    def __init__(self):
        self.passed_tests = 0
        self.failed_tests = 0
        self.test_number = 0

    def assert_equal(self, name, actual, expected):
        self.test_number += 1
        if actual == expected:
            self.passed_tests += 1
            self.print_one_result(name, True)
        else:
            self.failed_tests += 1
            self.print_one_result(
                name, False, f"Expected {expected}, Actual: {actual}")

    def assert_true(self, name, expression):
        self.assert_equal(name, expression, True)

    def end_tests(self):
        print("--- Test results: ---")
        if self.failed_tests == 0:
            print("✅ All tests passed!")
        else:
            print(f"✅: {self.passed_tests}, ❌: {self.failed_tests}")

    def print_one_result(self, name: str, passed: bool, message: str | None = None):
        print(
            f"{'✅' if passed else '❌'} [{self.test_number}] {name}")
        if message:
            print("     | " + message)
