/**
 * Java Variables and Data Types
 * 
 * This program demonstrates:
 * - Declaring variables
 * - Different data types (int, double, String, boolean, char)
 * - Type casting
 * - Using variables in calculations
 */

public class Variables {
    public static void main(String[] args) {
        // INTEGER - Whole numbers
        int age = 25;
        int yearOfBirth = 1999;
        
        System.out.println("=== Integer Type ===");
        System.out.println("Age: " + age);
        System.out.println("Year of Birth: " + yearOfBirth);
        System.out.println();
        
        // DOUBLE - Decimal numbers
        double salary = 50000.50;
        double pi = 3.14159;
        
        System.out.println("=== Double Type ===");
        System.out.println("Salary: " + salary);
        System.out.println("Pi value: " + pi);
        System.out.println();
        
        // STRING - Text
        String name = "John Doe";
        String city = "New York";
        
        System.out.println("=== String Type ===");
        System.out.println("Name: " + name);
        System.out.println("City: " + city);
        System.out.println();
        
        // BOOLEAN - True or False
        boolean isStudent = true;
        boolean hasJob = false;
        
        System.out.println("=== Boolean Type ===");
        System.out.println("Is Student: " + isStudent);
        System.out.println("Has Job: " + hasJob);
        System.out.println();
        
        // CHAR - Single character
        char grade = 'A';
        char initial = 'J';
        
        System.out.println("=== Char Type ===");
        System.out.println("Grade: " + grade);
        System.out.println("Initial: " + initial);
        System.out.println();
        
        // CALCULATIONS
        int result = 10 + 5;
        double average = (50 + 60 + 70) / 3.0;
        
        System.out.println("=== Calculations ===");
        System.out.println("10 + 5 = " + result);
        System.out.println("Average: " + average);
    }
}

/*
 * OUTPUT:
 * === Integer Type ===
 * Age: 25
 * Year of Birth: 1999
 * 
 * === Double Type ===
 * Salary: 50000.5
 * Pi value: 3.14159
 * 
 * === String Type ===
 * Name: John Doe
 * City: New York
 * 
 * === Boolean Type ===
 * Is Student: true
 * Has Job: false
 * 
 * === Char Type ===
 * Grade: A
 * Initial: J
 * 
 * === Calculations ===
 * 10 + 5 = 15
 * Average: 60.0
 */
