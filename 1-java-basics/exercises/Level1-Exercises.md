# Level 1: Java Basics - Exercises

Complete these exercises to master Java fundamentals.

## Exercise 1: Basic Java Programs

### 1.1: Simple Calculator

Create a program that takes two numbers and performs basic arithmetic operations (add, subtract, multiply, divide).

**Requirements:**
- Accept two integer inputs
- Perform all 4 operations
- Display results

**Expected Output:**
```
Enter first number: 10
Enter second number: 5
Addition: 15
Subtraction: 5
Multiplication: 50
Division: 2.0
```

**Solution Hint:**
```java
public class SimpleCalculator {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 5;
        
        System.out.println("Addition: " + (num1 + num2));
        System.out.println("Subtraction: " + (num1 - num2));
        System.out.println("Multiplication: " + (num1 * num2));
        System.out.println("Division: " + (double)num1 / num2);
    }
}
```

---

### 1.2: Temperature Converter

Create a program that converts Celsius to Fahrenheit and vice versa.

**Requirements:**
- Read temperature value
- Convert C to F and F to C
- Display results
- Formula: F = (C × 9/5) + 32

**Challenge:**
- Create methods for conversion
- Validate input

---

### 1.3: BMI Calculator

Create a program to calculate Body Mass Index.

**Requirements:**
- Read weight (kg) and height (m)
- Calculate BMI = weight / (height²)
- Display BMI category:
  - < 18.5: Underweight
  - 18.5-24.9: Normal
  - 25-29.9: Overweight
  - ≥ 30: Obese

---

## Exercise 2: Control Flow Mastery

### 2.1: Number Guessing Game

Create a number guessing game.

**Requirements:**
- Program picks random number (1-100)
- User guesses the number
- Program gives hints (too high / too low)
- Count attempts
- Celebrate when guess is correct

**Solution Hint:**
```java
import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        Random random = new Random();
        int secretNumber = random.nextInt(100) + 1;
        int guess = 0;
        int attempts = 0;
        
        Scanner scanner = new Scanner(System.in);
        
        while (guess != secretNumber) {
            System.out.print("Guess a number (1-100): ");
            guess = scanner.nextInt();
            attempts++;
            
            if (guess < secretNumber) {
                System.out.println("Too low!");
            } else if (guess > secretNumber) {
                System.out.println("Too high!");
            } else {
                System.out.println("Correct! Attempts: " + attempts);
            }
        }
    }
}
```

---

### 2.2: Multiplication Table

Create a program that prints multiplication tables.

**Requirements:**
- Accept a number as input
- Print its multiplication table (1-10)
- Format output nicely

**Expected Output:**
```
Enter a number: 5
Multiplication table of 5:
5 x 1 = 5
5 x 2 = 10
5 x 3 = 15
... up to 5 x 10 = 50
```

---

### 2.3: Fibonacci Sequence

Create a program that generates Fibonacci numbers.

**Requirements:**
- Accept count of numbers
- Generate Fibonacci sequence
- Handle edge cases (0, 1, negative)

**Fibonacci**: Each number is sum of previous two (0, 1, 1, 2, 3, 5, 8...)

---

## Exercise 3: Methods and Basic OOP

### 3.1: Bank Account Class

Create a Bank Account class with proper encapsulation.

**Requirements:**
- Properties: accountHolder, balance, accountNumber
- Methods:
  - deposit(amount)
  - withdraw(amount)
  - checkBalance()
  - transfer(amount, otherAccount)
- Prevent invalid operations (negative amounts, overdraft)

**Solution Skeleton:**
```java
class BankAccount {
    private String accountHolder;
    private double balance;
    private String accountNumber;
    
    // Constructor
    BankAccount(String holder, String number, double initialBalance) {
        this.accountHolder = holder;
        this.accountNumber = number;
        this.balance = initialBalance;
    }
    
    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        }
    }
    
    // Withdraw method
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: $" + amount);
        } else {
            System.out.println("Invalid withdrawal");
        }
    }
    
    // Check balance
    public double checkBalance() {
        return balance;
    }
}
```

---

### 3.2: Student Management System

Create a Student class and manage multiple students.

**Requirements:**
- Properties: roll number, name, marks (3 subjects)
- Methods:
  - calculateAverage()
  - getGrade() (A: 80+, B: 70-79, C: 60-69, F: <60)
  - displayDetails()
- Create array of students and display info

---

### 3.3: Library Management

Create a Book and Library system.

**Classes:**
- Book: title, author, ISBN, available
- Library: books array, add book, remove book, search book, lend book, return book

---

## Exercise 4: Mini Project

### 4.1: Student Grade Management System

Build a complete system with all Level 1 concepts.

**Features:**
1. **Add Students**:
   - Input: name, 3 subject marks
   - Store up to 10 students

2. **Calculate Results**:
   - Average marks
   - Grade (A/B/C/D/F)
   - Pass/Fail

3. **Display Results**:
   - Show all students
   - Show top 3 students
   - Search by name

4. **Update Marks**:
   - Modify any student's marks
   - Recalculate results

**Suggested Classes:**
```java
class Student {
    String name;
    int rollNumber;
    double[] marks;  // 3 subjects
    
    // Methods for calculations
}

class GradeManagementSystem {
    Student[] students;
    int count;
    
    // Methods for adding, displaying, searching
}
```

**Bonus Features:**
- Calculate class average
- Find highest and lowest marks
- Filter by grade
- Sort students by marks

---

## Exercise 5: Advanced Challenges

### 5.1: Check Prime Number

Create a method to check if a number is prime.

```java
public static boolean isPrime(int number) {
    if (number < 2) return false;
    for (int i = 2; i * i <= number; i++) {
        if (number % i == 0) return false;
    }
    return true;
}
```

### 5.2: Palindrome Checker

Check if a string is palindrome (reads same forwards and backwards).

```java
public static boolean isPalindrome(String text) {
    String clean = text.replaceAll(" ", "").toLowerCase();
    return clean.equals(new StringBuilder(clean).reverse().toString());
}
```

### 5.3: Array Operations

- Find sum of array
- Find average
- Find maximum and minimum
- Reverse array
- Check if sorted

---

## 🎓 Learning Tips

1. **Type Code**: Always type examples, don't copy
2. **Experiment**: Modify code to see what happens
3. **Debug**: Use System.out.println() to trace execution
4. **Test Edge Cases**: Empty inputs, negative numbers, zero
5. **Comment Code**: Document what each part does

---

## ✅ Success Criteria

- [ ] Can run all exercise programs
- [ ] Understand logic behind code
- [ ] Can modify code without errors
- [ ] Can debug simple problems
- [ ] Can create new programs from scratch

---

## 📝 Submission Checklist

For each exercise:
1. ✅ Program compiles without errors
2. ✅ Produces expected output
3. ✅ Handles edge cases
4. ✅ Code is well-commented
5. ✅ Variable names are meaningful

---

**Ready to move forward?** Once you complete these, move to [Level 2: Spring Boot](../2-spring-boot-basics/README.md)
