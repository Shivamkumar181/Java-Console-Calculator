import java.util.Scanner;

public class Calculator {
    // Scanner object for user input
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        // Display welcome message
        System.out.println("Java Console Calculator");
        System.out.println("-----------------------");
        
        // Main calculator loop
        boolean running = true;
        while (running) {
            // Display menu
            displayMenu();
            
            // Get user choice
            int choice = getIntInput("Enter your choice (1-5): ", 1, 5);
            
            // Process choice
            switch (choice) {
                case 1:
                    performOperation("Addition", '+');
                    break;
                case 2:
                    performOperation("Subtraction", '-');
                    break;
                case 3:
                    performOperation("Multiplication", '*');
                    break;
                case 4:
                    performOperation("Division", '/');
                    break;
                case 5:
                    running = false;
                    System.out.println("Exiting calculator. Goodbye!");
                    break;
            }
        }
        
        scanner.close();
    }
    
    // Display the calculator menu
    private static void displayMenu() {
        System.out.println("\nChoose an operation:");
        System.out.println("1. Addition (+)");
        System.out.println("2. Subtraction (-)");
        System.out.println("3. Multiplication (*)");
        System.out.println("4. Division (/)");
        System.out.println("5. Exit");
    }
    
    // Perform a calculation based on the operation
    private static void performOperation(String operationName, char operator) {
        System.out.println("\n" + operationName + " Operation");
        System.out.println("-------------------");
        
        double num1 = getDoubleInput("Enter first number: ");
        double num2 = getDoubleInput("Enter second number: ");
        
        double result = 0;
        boolean validOperation = true;
        
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    System.out.println("Error: Division by zero is not allowed.");
                    validOperation = false;
                }
                break;
        }
        
        if (validOperation) {
            System.out.printf("Result: %.2f %c %.2f = %.2f%n", num1, operator, num2, result);
        }
    }
    
    // Get integer input with validation
    private static int getIntInput(String prompt, int min, int max) {
        int value = 0;
        boolean valid = false;
        
        while (!valid) {
            System.out.print(prompt);
            try {
                value = Integer.parseInt(scanner.nextLine());
                if (value >= min && value <= max) {
                    valid = true;
                } else {
                    System.out.printf("Please enter a number between %d and %d.%n", min, max);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
        
        return value;
    }
    
    // Get double input with validation
    private static double getDoubleInput(String prompt) {
        double value = 0;
        boolean valid = false;
        
        while (!valid) {
            System.out.print(prompt);
            try {
                value = Double.parseDouble(scanner.nextLine());
                valid = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
        
        return value;
    }
}