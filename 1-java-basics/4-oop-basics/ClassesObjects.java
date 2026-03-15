/**
 * Java OOP Basics - ClassesObjects.java
 * 
 * This program demonstrates:
 * - Creating a class
 * - Creating objects from a class
 * - Instance variables
 * - Instance methods
 * 
 * Real-world example: A Student class
 */

// Define the Student class
class Student {
    // Instance variables (properties)
    String name;
    int age;
    String email;
    double gpa;
    
    // Display student information
    void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Email: " + email);
        System.out.println("GPA: " + gpa);
    }
    
    // Update GPA
    void updateGPA(double newGPA) {
        gpa = newGPA;
        System.out.println("GPA updated to: " + gpa);
    }
    
    // Check if student is an honor student (GPA > 3.5)
    boolean isHonorStudent() {
        return gpa > 3.5;
    }
}

// Demo class
public class ClassesObjects {
    public static void main(String[] args) {
        System.out.println("=== Creating Objects from a Class ===\n");
        
        // Create first student object
        System.out.println("--- Student 1 ---");
        Student student1 = new Student();
        student1.name = "Alice";
        student1.age = 20;
        student1.email = "alice@university.edu";
        student1.gpa = 3.8;
        student1.displayInfo();
        System.out.println();
        
        // Create second student object
        System.out.println("--- Student 2 ---");
        Student student2 = new Student();
        student2.name = "Bob";
        student2.age = 21;
        student2.email = "bob@university.edu";
        student2.gpa = 3.2;
        student2.displayInfo();
        System.out.println();
        
        // Creating third student
        System.out.println("--- Student 3 ---");
        Student student3 = new Student();
        student3.name = "Charlie";
        student3.age = 19;
        student3.email = "charlie@university.edu";
        student3.gpa = 3.6;
        student3.displayInfo();
        System.out.println();
        
        // Calling methods on objects
        System.out.println("--- Method Calls ---");
        System.out.println("Is Alice an honor student? " + student1.isHonorStudent());
        System.out.println("Is Bob an honor student? " + student2.isHonorStudent());
        System.out.println();
        
        // Updating data
        System.out.println("--- Updating Bob's GPA ---");
        student2.updateGPA(3.9);
        System.out.println("Is Bob now an honor student? " + student2.isHonorStudent());
    }
}

/*
 * OUTPUT:
 * === Creating Objects from a Class ===
 * 
 * --- Student 1 ---
 * Name: Alice
 * Age: 20
 * Email: alice@university.edu
 * GPA: 3.8
 * 
 * --- Student 2 ---
 * Name: Bob
 * Age: 21
 * Email: bob@university.edu
 * GPA: 3.2
 * 
 * --- Student 3 ---
 * Name: Charlie
 * Age: 19
 * Email: charlie@university.edu
 * GPA: 3.6
 * 
 * --- Method Calls ---
 * Is Alice an honor student? true
 * Is Bob an honor student? false
 * 
 * --- Updating Bob's GPA ---
 * GPA updated to: 3.9
 * Is Bob now an honor student? true
 */
