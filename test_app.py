import unittest
import io
import sys
from app import main

class TestToDoApp(unittest.TestCase):
    def test_output(self):
        # Capture stdout to verify the app runs
        capturedOutput = io.StringIO()
        sys.stdout = capturedOutput
        main()
        sys.stdout = sys.__stdout__
        self.assertIn("To-Do List App", capturedOutput.getvalue())

if __name__ == '__main__':
    unittest.main()