/**
 * Java Constructors - Constructors.java
 * 
 * This program demonstrates:
 * - Default constructor
 * - Parameterized constructor
 * - Constructor overloading
 * - Initializing objects efficiently
 * 
 * Constructors are special methods that initialize objects.
 */

class Car {
    // Instance variables
    String brand;
    String model;
    int year;
    double price;
    
    // Constructor 1: Default constructor (no parameters)
    // Sets default values
    Car() {
        brand = "Unknown";
        model = "Unknown";
        year = 2024;
        price = 0;
    }
    
    // Constructor 2: Parameterized constructor
    // Initializes with provided values
    Car(String b, String m, int y, double p) {
        brand = b;
        model = m;
        year = y;
        price = p;
    }
    
    // Constructor 3: Partial parameters
    Car(String b, String m) {
        brand = b;
        model = m;
        year = 2024;
        price = 0;
    }
    
    // Display car information
    void displayInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Price: $" + price);
    }
}

public class Constructors {
    public static void main(String[] args) {
        System.out.println("=== Java Constructors Demo ===\n");
        
        // Example 1: Default constructor
        System.out.println("--- Car 1 (Default Constructor) ---");
        Car car1 = new Car();
        car1.displayInfo();
        System.out.println();
        
        // Example 2: Parameterized constructor (all parameters)
        System.out.println("--- Car 2 (Full Constructor) ---");
        Car car2 = new Car("Toyota", "Camry", 2023, 25000);
        car2.displayInfo();
        System.out.println();
        
        // Example 3: Parameterized constructor (partial parameters)
        System.out.println("--- Car 3 (Partial Constructor) ---");
        Car car3 = new Car("Honda", "Civic");
        car3.displayInfo();
        System.out.println();
        
        // Example 4: Another car
        System.out.println("--- Car 4 (Full Constructor) ---");
        Car car4 = new Car("BMW", "X5", 2024, 65000);
        car4.displayInfo();
        
        System.out.println("\n=== Key Takeaways ===");
        System.out.println("- Constructors have same name as class");
        System.out.println("- Constructors initialize objects");
        System.out.println("- You can have multiple constructors (overloading)");
        System.out.println("- Constructors are called with 'new' keyword");
    }
}

/*
 * OUTPUT:
 * === Java Constructors Demo ===
 * 
 * --- Car 1 (Default Constructor) ---
 * Brand: Unknown
 * Model: Unknown
 * Year: 2024
 * Price: $0
 * 
 * --- Car 2 (Full Constructor) ---
 * Brand: Toyota
 * Model: Camry
 * Year: 2023
 * Price: $25000
 * 
 * --- Car 3 (Partial Constructor) ---
 * Brand: Honda
 * Model: Civic
 * Year: 2024
 * Price: $0
 * 
 * --- Car 4 (Full Constructor) ---
 * Brand: BMW
 * Model: X5
 * Year: 2024
 * Price: $65000
 * 
 * === Key Takeaways ===
 * - Constructors have same name as class
 * - Constructors initialize objects
 * - You can have multiple constructors (overloading)
 * - Constructors are called with 'new' keyword
 */
