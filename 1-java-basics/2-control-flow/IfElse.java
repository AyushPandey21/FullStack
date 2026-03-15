/**
 * Java Control Flow - IfElse.java
 * 
 * This program demonstrates:
 * - If statements
 * - Else statements
 * - Else-if statements
 * - Comparison operators
 * - Logical operators (&&, ||, !)
 */

public class IfElse {
    public static void main(String[] args) {
        // Example 1: Simple if statement
        System.out.println("=== Example 1: Simple If ===");
        int age = 20;
        
        if (age >= 18) {
            System.out.println("You are an adult");
        }
        System.out.println();
        
        // Example 2: If-Else
        System.out.println("=== Example 2: If-Else ===");
        int score = 45;
        
        if (score >= 50) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println();
        
        // Example 3: If-Else-If
        System.out.println("=== Example 3: If-Else-If ===");
        int marks = 75;
        
        if (marks >= 90) {
            System.out.println("Grade: A");
        } else if (marks >= 80) {
            System.out.println("Grade: B");
        } else if (marks >= 70) {
            System.out.println("Grade: C");
        } else {
            System.out.println("Grade: F");
        }
        System.out.println();
        
        // Example 4: Logical operators
        System.out.println("=== Example 4: Logical Operators ===");
        int hours = 40;
        double salary = 50000;
        
        // AND operator (&&) - both conditions must be true
        if (hours >= 8 && salary > 30000) {
            System.out.println("Eligible for bonus");
        }
        
        // OR operator (||) - at least one condition must be true
        if (hours < 8 || salary < 20000) {
            System.out.println("Needs review");
        } else {
            System.out.println("Good status");
        }
        
        // NOT operator (!)
        boolean isWeekday = true;
        if (!isWeekday) {
            System.out.println("It's weekend");
        }
        System.out.println();
        
        // Example 5: Nested if
        System.out.println("=== Example 5: Nested If ===");
        int country = 2; // 1=USA, 2=INDIA, 3=UK
        int state = 5;
        
        if (country == 2) {
            System.out.println("Country: India");
            if (state == 5) {
                System.out.println("State: Karnataka");
            } else if (state == 6) {
                System.out.println("State: Tamil Nadu");
            }
        }
    }
}

/*
 * OUTPUT:
 * === Example 1: Simple If ===
 * You are an adult
 * 
 * === Example 2: If-Else ===
 * FAIL
 * 
 * === Example 3: If-Else-If ===
 * Grade: C
 * 
 * === Example 4: Logical Operators ===
 * Eligible for bonus
 * Good status
 * 
 * === Example 5: Nested If ===
 * Country: India
 * State: Karnataka
 */
