# Level 1: Java Basics

Welcome to Level 1! Here you'll learn the fundamentals of Java programming. This is the foundation for everything that comes next.

## 📖 Topics Covered

1. Java Syntax Basics
2. Variables and Data Types
3. Control Flow (if/else, loops)
4. Methods/Functions
5. Object-Oriented Programming Basics
6. Arrays and Collections

## ⏱️ Duration

**2-3 weeks** (Study 5-7 hours per week)

## 📂 Files in This Level

```
1-java-basics/
├── README.md (this file)
├── 1-syntax-basics/
│   ├── HelloWorld.java
│   ├── Variables.java
│   ├── DataTypes.java
│   └── Operators.java
├── 2-control-flow/
│   ├── IfElse.java
│   ├── Loops.java
│   └── Switch.java
├── 3-methods/
│   ├── MethodBasics.java
│   ├── MethodParameters.java
│   └── MethodOverloading.java
├── 4-oop-basics/
│   ├── ClassesObjects.java
│   ├── Constructors.java
│   ├── Inheritance.java
│   └── Encapsulation.java
├── 5-arrays-collections/
│   ├── Arrays.java
│   ├── ArrayLists.java
│   └── HashMaps.java
└── exercises/
    ├── Exercise1-BasicPrograms.md
    ├── Exercise2-ControlFlow.md
    ├── Exercise3-MethodsAndOOP.md
    └── Exercise4-MiniProject.md
```

## 🎯 Learning Outcomes

By the end of this level, you'll understand:
- ✅ How to write and run Java programs
- ✅ Variables, data types, and operators
- ✅ Control flow structures (if/else, loops)
- ✅ How to write and call methods
- ✅ Basics of Object-Oriented Programming
- ✅ How to use arrays and collections

## 📚 Week-by-Week Breakdown

### Week 1: Syntax & Basics
- **Topics**: Variables, data types, operators, hello world
- **Time**: 5-7 hours
- **Exercises**: Write 5-10 simple programs
- **File**: Study `1-syntax-basics/` folder

### Week 2: Control Flow & Logic
- **Topics**: if/else, loops (for, while), switch statements
- **Time**: 5-7 hours
- **Exercises**: Practice loops and decision making
- **File**: Study `2-control-flow/` folder

### Week 3: Methods & OOP Introduction
- **Topics**: Methods, functions, basic OOP, classes, objects
- **Time**: 7-10 hours
- **Exercises**: Create simple classes and objects
- **File**: Study `3-methods/` and `4-oop-basics/` folders

## 🚀 Getting Started

### Step 1: Create First Java Program

In PowerShell:
```bash
mkdir C:\BasicsFullStackDevelopment\1-java-basics\practice
cd C:\BasicsFullStackDevelopment\1-java-basics\practice
```

### Step 2: Write HelloWorld.java

Create a file named `HelloWorld.java`:
```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
```

### Step 3: Compile and Run

```bash
javac HelloWorld.java
java HelloWorld
```

**Expected output:**
```
Hello, World!
```

Congratulations! You've written your first Java program! 🎉

---

## 📝 Key Concepts Quick Reference

### Variables & Data Types
```java
int age = 25;                    // Integer (whole numbers)
double salary = 50000.50;        // Decimal numbers
boolean isActive = true;         // True or False
String name = "John";            // Text
char initial = 'J';              // Single character
```

### Printing Output
```java
System.out.println("Hello");     // Print with new line
System.out.print("No newline");  // Print without new line
```

### Basic Math
```java
int sum = 10 + 5;
int product = 10 * 5;
int remainder = 10 % 3;
double division = 10.0 / 3;
```

### If-Else Statements
```java
if (age > 18) {
    System.out.println("Adult");
} else {
    System.out.println("Minor");
}
```

### For Loop
```java
for (int i = 0; i < 5; i++) {
    System.out.println(i);
}
```

### Methods
```java
public static void greet(String name) {
    System.out.println("Hello, " + name);
}

public static int add(int a, int b) {
    return a + b;
}
```

---

## 🎓 Learning Strategy

1. **Read** the concept explanation
2. **Type out** the example code (don't copy-paste!)
3. **Run** the code and see output
4. **Modify** the code to experiment
5. **Complete** the exercises

## 💡 Pro Tips

- **Type, Don't Copy**: Typing code helps muscle memory
- **Break Things**: Intentionally create errors to learn from them
- **Read Error Messages**: Java error messages are helpful!
- **Comment Your Code**: `// This is a comment`
- **Use Meaningful Names**: `age` not `a`, `firstName` not `fn`

---

## ✅ Level 1 Checklist

Before moving to Level 2, ensure you:
- [ ] Can write and run Java programs
- [ ] Understand variables and data types
- [ ] Can use if/else and loops
- [ ] Can write and call methods
- [ ] Understand classes and objects
- [ ] Can create simple arrays
- [ ] Completed all exercises
- [ ] Built mini-project (see Exercise4)

---

## 🔗 Next Level

Once comfortable with these basics, proceed to:
[Level 2: Spring Boot Basics](../2-spring-boot-basics/README.md)

---

## 📚 Additional Resources

- **Official Java Docs**: https://docs.oracle.com/javase/tutorial/
- **Java Programming MOOC**: https://mooc.fi/en/courses/java/
- **W3Schools Java**: https://www.w3schools.com/java/
- **YouTube**: "Java Programming for Beginners" by various creators

---

**Ready to start? Begin with** [Syntax Basics](./1-syntax-basics/HelloWorld.java)
