# et1
This Java code creates a simple calculator application with a graphical user interface (GUI) using the javax.swing library.

The program's main features include:

1. GUI Components: It uses a JFrame for the main window, a JTextField to display numbers and results, and an array of JButton objects for all the numbers and arithmetic operations.

2. Event Handling: The class implements the ActionListener interface to handle button clicks.

3. Logical Methods: The actionPerformed method calls separate, dedicated methods to handle different types of user input, such as:

4. handleNumberButtons() for number and decimal input.

5. handleOperatorButtons() for arithmetic operations.

6. performCalculation() to compute the final result when the equals button is pressed.

7. Functionality: It supports basic arithmetic (+, -, *, /) and includes error handling to prevent division by zero. It also has Clear and Delete buttons for managing input.
