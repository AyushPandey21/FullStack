/**
 * Java Control Flow - Loops.java
 * 
 * This program demonstrates:
 * - For loops
 * - While loops
 * - Do-While loops
 * - Break and continue statements
 * - Nested loops
 */

public class Loops {
    public static void main(String[] args) {
        
        // Example 1: For Loop - Print numbers 1 to 5
        System.out.println("=== Example 1: For Loop ===");
        for (int i = 1; i <= 5; i++) {
            System.out.println("Number: " + i);
        }
        System.out.println();
        
        // Example 2: For Loop - Calculate sum
        System.out.println("=== Example 2: Sum using For Loop ===");
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            sum = sum + i;
        }
        System.out.println("Sum of 1 to 10: " + sum);
        System.out.println();
        
        // Example 3: For Loop - Counting down
        System.out.println("=== Example 3: Counting Down ===");
        for (int i = 5; i >= 1; i--) {
            System.out.println(i);
        }
        System.out.println("Blast off!");
        System.out.println();
        
        // Example 4: While Loop
        System.out.println("=== Example 4: While Loop ===");
        int count = 1;
        while (count <= 3) {
            System.out.println("Count: " + count);
            count = count + 1;
        }
        System.out.println();
        
        // Example 5: While Loop - User input simulation
        System.out.println("=== Example 5: While Loop (Decrement) ===");
        int x = 5;
        while (x > 0) {
            System.out.println("x = " + x);
            x--;
        }
        System.out.println();
        
        // Example 6: Do-While Loop
        System.out.println("=== Example 6: Do-While Loop ===");
        int j = 1;
        do {
            System.out.println("Iteration: " + j);
            j++;
        } while (j <= 3);
        System.out.println();
        
        // Example 7: Break statement
        System.out.println("=== Example 7: Break Statement ===");
        for (int i = 1; i <= 10; i++) {
            if (i == 5) {
                System.out.println("Breaking at: " + i);
                break;
            }
            System.out.println("i = " + i);
        }
        System.out.println();
        
        // Example 8: Continue statement
        System.out.println("=== Example 8: Continue Statement ===");
        for (int i = 1; i <= 5; i++) {
            if (i == 3) {
                System.out.println("Skipping: " + i);
                continue;
            }
            System.out.println("i = " + i);
        }
        System.out.println();
        
        // Example 9: Nested Loops - Multiplication Table
        System.out.println("=== Example 9: Nested Loops (3x3 Grid) ===");
        for (int i = 1; i <= 3; i++) {
            for (int k = 1; k <= 3; k++) {
                System.out.print(i * k + " ");
            }
            System.out.println();
        }
        System.out.println();
        
        // Example 10: Nested Loops - Pattern
        System.out.println("=== Example 10: Star Pattern ===");
        for (int i = 1; i <= 5; i++) {
            for (int k = 0; k < i; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}

/*
 * OUTPUT:
 * === Example 1: For Loop ===
 * Number: 1
 * Number: 2
 * Number: 3
 * Number: 4
 * Number: 5
 * 
 * === Example 2: Sum using For Loop ===
 * Sum of 1 to 10: 55
 * 
 * === Example 3: Counting Down ===
 * 5
 * 4
 * 3
 * 2
 * 1
 * Blast off!
 * 
 * === Example 4: While Loop ===
 * Count: 1
 * Count: 2
 * Count: 3
 * 
 * === Example 5: While Loop (Decrement) ===
 * x = 5
 * x = 4
 * x = 3
 * x = 2
 * x = 1
 * 
 * === Example 6: Do-While Loop ===
 * Iteration: 1
 * Iteration: 2
 * Iteration: 3
 * 
 * === Example 7: Break Statement ===
 * i = 1
 * i = 2
 * i = 3
 * i = 4
 * Breaking at: 5
 * 
 * === Example 8: Continue Statement ===
 * i = 1
 * i = 2
 * Skipping: 3
 * i = 4
 * i = 5
 * 
 * === Example 9: Nested Loops (3x3 Grid) ===
 * 1 2 3 
 * 2 4 6 
 * 3 6 9 
 * 
 * === Example 10: Star Pattern ===
 * * 
 * * * 
 * * * * 
 * * * * * 
 */
