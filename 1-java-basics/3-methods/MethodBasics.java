/**
 * Java Methods - MethodBasics.java
 * 
 * This program demonstrates:
 * - Method definition and calling
 * - Methods with parameters
 * - Methods with return values
 * - Void methods
 * - Method scope
 */

public class MethodBasics {
    
    // Method 1: Void method with no parameters
    public static void greet() {
        System.out.println("Hello, welcome to Java!");
    }
    
    // Method 2: Void method with one parameter
    public static void greetUser(String name) {
        System.out.println("Hello, " + name + "!");
    }
    
    // Method 3: Method with return value
    public static int add(int a, int b) {
        int result = a + b;
        return result;
    }
    
    // Method 4: Method with multiple parameters and return value
    public static double calculateAverage(double num1, double num2, double num3) {
        double sum = num1 + num2 + num3;
        double average = sum / 3;
        return average;
    }
    
    // Method 5: Check if number is even
    public static boolean isEven(int number) {
        if (number % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }
    
    // Method 6: Print multiplication table
    public static void printMultiplicationTable(int number, int limit) {
        System.out.println("Multiplication table of " + number);
        for (int i = 1; i <= limit; i++) {
            System.out.println(number + " x " + i + " = " + (number * i));
        }
    }
    
    // Main method - program entry point
    public static void main(String[] args) {
        System.out.println("=== Method Examples ===\n");
        
        // Calling Method 1: Simple greeting
        System.out.println("--- Calling greet() ---");
        greet();
        System.out.println();
        
        // Calling Method 2: Greeting with parameter
        System.out.println("--- Calling greetUser() ---");
        greetUser("Alice");
        greetUser("Bob");
        System.out.println();
        
        // Calling Method 3: Add two numbers
        System.out.println("--- Calling add() ---");
        int sum = add(10, 20);
        System.out.println("10 + 20 = " + sum);
        System.out.println();
        
        // Calling Method 4: Calculate average
        System.out.println("--- Calling calculateAverage() ---");
        double avg = calculateAverage(85, 90, 78);
        System.out.println("Average: " + avg);
        System.out.println();
        
        // Calling Method 5: Check if even
        System.out.println("--- Calling isEven() ---");
        System.out.println("Is 10 even? " + isEven(10));
        System.out.println("Is 15 even? " + isEven(15));
        System.out.println();
        
        // Calling Method 6: Print multiplication table
        System.out.println("--- Calling printMultiplicationTable() ---");
        printMultiplicationTable(5, 3);
    }
}

/*
 * OUTPUT:
 * === Method Examples ===
 * 
 * --- Calling greet() ---
 * Hello, welcome to Java!
 * 
 * --- Calling greetUser() ---
 * Hello, Alice!
 * Hello, Bob!
 * 
 * --- Calling add() ---
 * 10 + 20 = 30
 * 
 * --- Calling calculateAverage() ---
 * Average: 84.33333333333333
 * 
 * --- Calling isEven() ---
 * Is 10 even? true
 * Is 15 even? false
 * 
 * --- Calling printMultiplicationTable() ---
 * Multiplication table of 5
 * 5 x 1 = 5
 * 5 x 2 = 10
 * 5 x 3 = 15
 */
