# Level 3: Angular Basics

Welcome to Angular! Now you'll learn to build modern, responsive user interfaces.

## 📖 What is Angular?

**Angular** is a framework for building dynamic web applications with JavaScript/TypeScript. It:
- Creates interactive UIs
- Manages component state
- Handles routing between pages
- Communicates with backend APIs
- Provides data binding and reactive forms

## 📂 Topics Covered

1. HTML, CSS, JavaScript Fundamentals
2. TypeScript Introduction
3. Angular Setup & Components
4. Templates and Data Binding
5. Component Communication
6. Introduction to Services

## ⏱️ Duration

**2-3 weeks** of focused study

## 📂 Folder Structure

```
3-angular-basics/
├── README.md (this file)
├── 1-web-fundamentals/
│   ├── html-css-js-basics.md
│   └── examples/
├── 2-typescript-intro/
│   ├── typescript-guide.md
│   └── examples/
├── 3-angular-setup/
│   ├── install-angular.md
│   └── HelloAngularApp/
├── 4-components-templates/
│   ├── components-guide.md
│   └── ComponentExamples/
└── exercises/
    ├── Exercise1-Components.md
    ├── Exercise2-Forms.md
    └── Exercise3-MiniProject.md
```

## 🎯 Learning Outcomes

By the end of this level, you'll:
- ✅ Write HTML, CSS, and JavaScript
- ✅ Understand TypeScript basics
- ✅ Create Angular components
- ✅ Use property and event binding
- ✅ Pass data between components
- ✅ Create services for data management

## 🚀 Quick Start: Create Your First Angular App

### Step 1: Install Angular CLI

```bash
npm install -g @angular/cli
```

### Step 2: Create New Project

```bash
ng new HelloAngular
cd HelloAngular
```

### Step 3: Generate First Component

```bash
ng generate component hello
```

This creates:
- `hello.component.ts` (TypeScript class)
- `hello.component.html` (Template)
- `hello.component.css` (Styles)
- `hello.component.spec.ts` (Tests)

### Step 4: Create Component Logic

Edit `src/app/hello/hello.component.ts`:

```typescript
import { Component } from '@angular/core';

@Component({
  selector: 'app-hello',
  templateUrl: './hello.component.html',
  styleUrls: ['./hello.component.css']
})
export class HelloComponent {
  message: string = 'Hello from Angular!';
  count: number = 0;
  
  increment() {
    this.count++;
  }
  
  decrement() {
    this.count--;
  }
}
```

### Step 5: Create Component Template

Edit `src/app/hello/hello.component.html`:

```html
<h1>{{ message }}</h1>
<p>Count: {{ count }}</p>
<button (click)="increment()">Increment</button>
<button (click)="decrement()">Decrement</button>
```

### Step 6: Run the Application

```bash
ng serve
```

Visit: http://localhost:4200

---

## 📚 Web Development Fundamentals

### HTML Basics

```html
<!DOCTYPE html>
<html>
<head>
    <title>My Page</title>
</head>
<body>
    <h1>Heading</h1>
    <p>Paragraph</p>
    <button>Click me</button>
    <a href="https://example.com">Link</a>
</body>
</html>
```

### CSS Basics

```css
/* Select by element */
h1 {
    color: blue;
    font-size: 24px;
}

/* Select by class */
.container {
    width: 100%;
    padding: 10px;
}

/* Select by ID */
#main {
    background-color: lightgray;
}
```

### JavaScript Basics

```javascript
// Variables
let name = "John";
const age = 25;

// Functions
function greet(name) {
    return "Hello, " + name;
}

// Objects
const person = {
    name: "John",
    age: 25,
    greet: function() {
        return "Hi, I'm " + this.name;
    }
};

// Arrays
const colors = ["red", "green", "blue"];
colors.forEach(color => console.log(color));
```

---

## 🔤 TypeScript Basics

TypeScript adds types to JavaScript. Benefits:
- Catch errors before runtime
- Better IDE support
- Cleaner code

```typescript
// Basic Types
let name: string = "John";
let age: number = 25;
let isActive: boolean = true;
let numbers: number[] = [1, 2, 3];

// Interfaces (define object shape)
interface User {
    name: string;
    age: number;
    email: string;
}

const user: User = {
    name: "Alice",
    age: 30,
    email: "alice@example.com"
};

// Classes
class Student {
    name: string;
    gpa: number;
    
    constructor(name: string, gpa: number) {
        this.name = name;
        this.gpa = gpa;
    }
    
    isHonorStudent(): boolean {
        return this.gpa > 3.5;
    }
}

const student = new Student("Bob", 3.8);
console.log(student.isHonorStudent()); // true
```

---

## 🎨 Angular Components

### Component Anatomy

```typescript
import { Component } from '@angular/core';

@Component({
  selector: 'app-student',           // Used as HTML tag
  templateUrl: './student.component.html',  // HTML template
  styleUrls: ['./student.component.css']    // Component styles
})
export class StudentComponent {
  // Properties (data)
  name: string = 'Alice';
  gpa: number = 3.8;
  
  // Methods
  updateGPA(newGPA: number) {
    this.gpa = newGPA;
  }
}
```

### Data Binding

```html
<!-- Interpolation: Display data -->
<h1>{{ name }}</h1>

<!-- Property Binding: Set element properties -->
<img [src]="imageUrl" />

<!-- Event Binding: Listen to events -->
<button (click)="updateGPA(3.9)">Update GPA</button>

<!-- Two-Way Binding: Connect form input to property -->
<input [(ngModel)]="name" />
```

---

## 📝 Week-by-Week Breakdown

### Week 1: Web Fundamentals
- HTML structure
- CSS styling
- JavaScript basics
- Introduction to TypeScript

### Week 2: Angular Fundamentals
- Angular setup and CLI
- Components and decorators
- Templates and binding
- Component interaction

### Week 3: Advanced Features
- Services and dependency injection
- HTTP communication
- Routing basics
- Form handling

---

## ✅ Level 3 Checklist

Before moving to Level 4, ensure you:
- [ ] Understand HTML, CSS, JavaScript
- [ ] Know TypeScript basics
- [ ] Angular CLI installed
- [ ] Created first component
- [ ] Understand data binding
- [ ] Can pass data between components
- [ ] Completed all exercises

---

## 🔗 Next Level

Once comfortable with Angular basics:
[Level 4: Full Stack Todo App](../4-full-stack-todo-app/README.md)

---

## 📚 Resources

- **Angular Official Docs**: https://angular.io
- **Angular Tutorial**: https://angular.io/tutorial
- **TypeScript Handbook**: https://www.typescriptlang.org/docs/
- **MDN Web Docs**: https://developer.mozilla.org/en-US/
- **FreeCodeCamp Angular Course**: YouTube
