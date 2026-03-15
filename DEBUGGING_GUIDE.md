# Testing and Debugging Guide

## 🐛 Debugging Java Code

### Using System.out.println() (Simple but Effective)

```java
// Basic variable inspection
System.out.println("User name: " + user.getName());

// Conditional debugging
if (age < 0) {
    System.out.println("ERROR: Age is negative!");
}

// Loop debugging
for (int i = 0; i < items.size(); i++) {
    System.out.println("Item " + i + ": " + items.get(i));
}

// Method entry/exit
public void process() {
    System.out.println(">>> Entering process()");
    // ... code ...
    System.out.println("<<< Exiting process()");
}
```

### Using VS Code Debugger

**Step 1: Set Breakpoint**
- Click on line number (red dot appears)

**Step 2: Run in Debug Mode**
- Press F5 or Debug → Start Debugging

**Step 3: Controls**
- Step Over (F10): Execute current line
- Step Into (F11): Enter function
- Step Out (Shift+F11): Exit current function
- Continue (F5): Run until next breakpoint

**Step 4: Inspect Variables**
- Hover over variables to see values
- Check "Variables" panel on left
- Watch specific expressions: Add to "Watch"

### Example Debugging Session

```java
public class Calculator {
    public static int divide(int a, int b) {
        int result = a / b;  // ← Set breakpoint here
        return result;
    }
}

// Issues to debug:
// 1. What if b is 0? (Division by zero)
// 2. What if a and b are negative?

// Better version:
public static int divide(int a, int b) throws ArithmeticException {
    if (b == 0) {
        throw new ArithmeticException("Cannot divide by zero");
    }
    return a / b;
}
```

---

## 🧪 Testing Java Code

### Unit Testing with JUnit

**Add dependency in pom.xml**:
```xml
<dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.13.2</version>
    <scope>test</scope>
</dependency>
```

**Create test class**:
```java
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {
    
    private Calculator calc = new Calculator();
    
    @Test
    public void testAdd() {
        int result = calc.add(2, 3);
        assertEquals(5, result);
    }
    
    @Test
    public void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> {
            calc.divide(10, 0);
        });
    }
    
    @Test
    public void testMultiply() {
        assertEquals(20, calc.multiply(4, 5));
    }
}
```

**Run tests**:
```bash
mvn test
```

---

## 🌐 Testing Spring Boot APIs

### Using Postman

1. **Download**: postman.com
2. **Create Request**: New → HTTP Request
3. **Enter Details**:
   - Method: GET/POST/PUT/DELETE
   - URL: http://localhost:8080/api/users
   - Headers: Content-Type: application/json (for POST)
   - Body: Raw JSON data

**Example POST Request**:
```json
{
    "name": "John Doe",
    "email": "john@example.com",
    "age": 30
}
```

### Using curl (Command Line)

**GET Request**:
```bash
curl http://localhost:8080/api/users
```

**GET with ID**:
```bash
curl http://localhost:8080/api/users/1
```

**POST Request**:
```bash
curl -X POST http://localhost:8080/api/users \
  -H "Content-Type: application/json" \
  -d '{"name":"John","email":"john@example.com","age":30}'
```

**PUT Request**:
```bash
curl -X PUT http://localhost:8080/api/users/1 \
  -H "Content-Type: application/json" \
  -d '{"name":"Jane","age":25}'
```

**DELETE Request**:
```bash
curl -X DELETE http://localhost:8080/api/users/1
```

### Spring Boot Integration Tests

```java
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
    
    @Autowired
    private MockMvc mockMvc;
    
    @Test
    public void testGetAllUsers() throws Exception {
        mockMvc.perform(get("/api/users"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
    
    @Test
    public void testCreateUser() throws Exception {
        String json = "{\"name\":\"John\",\"email\":\"john@example.com\"}";
        
        mockMvc.perform(post("/api/users")
            .contentType(MediaType.APPLICATION_JSON)
            .content(json))
            .andExpect(status().isOk());
    }
}
```

---

## 🎨 Testing Angular Components

### Unit Testing with Jasmine

**Create test file** (auto-generated):
```typescript
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { HelloComponent } from './hello.component';

describe('HelloComponent', () => {
    let component: HelloComponent;
    let fixture: ComponentFixture<HelloComponent>;
    
    beforeEach(async () => {
        await TestBed.configureTestingModule({
            declarations: [HelloComponent]
        }).compileComponents();
        
        fixture = TestBed.createComponent(HelloComponent);
        component = fixture.componentInstance;
        fixture.detectChanges();
    });
    
    it('should create', () => {
        expect(component).toBeTruthy();
    });
    
    it('should display message', () => {
        component.message = 'Hello Test';
        fixture.detectChanges();
        const compiled = fixture.nativeElement;
        expect(compiled.textContent).toContain('Hello Test');
    });
    
    it('should increment counter', () => {
        component.count = 0;
        component.increment();
        expect(component.count).toBe(1);
    });
});
```

**Run tests**:
```bash
ng test
```

---

## 🔧 Common Debugging Scenarios

### Scenario 1: Null Pointer Exception

**The Error**:
```
NullPointerException at line 42
```

**Debug Process**:
```java
// This will throw NPE if user is null
String email = user.getEmail();  // BAD: No null check

// Better approach:
if (user != null) {
    String email = user.getEmail();
} else {
    System.out.println("User is null!");
}

// Best practice (Java 8+):
Optional<User> userOpt = repository.findById(id);
String email = userOpt.map(User::getEmail).orElse("Unknown");
```

### Scenario 2: Frontend Not Receiving Data

**Symptoms**:
- Template shows empty
- API works in Postman
- Console error about undefined

**Debugging Steps**:
```typescript
// 1. Check if service method is called
this.service.getUsers().subscribe(
    (data) => {
        console.log('Data received:', data);  // Add this
        this.users = data;
    },
    (error) => {
        console.error('Error:', error);  // Check errors too
    }
);

// 2. Check template binding
<!-- Debug template -->
<pre>{{ users | json }}</pre>  <!-- Shows actual data structure -->

// 3. Check variable initialization
users: User[] = [];  // Must initialize
```

### Scenario 3: CORS Error

**The Error**:
```
Access to XMLHttpRequest from origin 'http://localhost:4200' 
has been blocked by CORS policy
```

**Solution - Spring Boot**:
```java
@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:4200")  // Add this
public class UserController {
    // ...
}

// Or global configuration:
@Configuration
public class CorsConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**")
                    .allowedOrigins("http://localhost:4200")
                    .allowedMethods("GET", "POST", "PUT", "DELETE");
            }
        };
    }
}
```

### Scenario 4: Form Not Submitting

**Debug**:
```typescript
onSubmit() {
    console.log('Form submitted');  // Check if method called
    console.log('Form value:', this.form.value);
    console.log('Form valid:', this.form.valid);
    
    if (this.form.invalid) {
        console.log('Form errors:', this.form.errors);
        return;
    }
    
    // Continue...
}
```

**Template**:
```html
<!-- Always set type="submit" -->
<button type="submit" [disabled]="!form.valid">Submit</button>

<!-- Show validation errors -->
<div *ngIf="form.get('email')?.errors?.['required']">
    Email is required
</div>
```

---

## 📊 Logging Best Practices

### Java Logging

```java
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    
    public User getUser(Long id) {
        logger.debug("Fetching user with id: {}", id);
        User user = repository.findById(id).orElse(null);
        
        if (user == null) {
            logger.warn("User not found for id: {}", id);
        } else {
            logger.info("User found: {}", user.getName());
        }
        return user;
    }
}
```

### Configure logging (application.properties)

```properties
# Set log levels
logging.level.root=INFO
logging.level.com.example=DEBUG
logging.level.org.springframework=WARN

# Log format
logging.pattern.console=%d{yyyy-MM-dd HH:mm:ss} - %msg%n
```

### Angular Logging

```typescript
// Use console with prefixes
console.log('[UserService]', 'Fetching users...');
console.warn('[UserService]', 'Failed to fetch users', error);
console.error('[UserService]', 'Critical error', error);

// Or use custom logger
import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root'
})
export class LoggerService {
    log(source: string, message: string) {
        console.log(`[${source}] ${message}`);
    }
    
    error(source: string, message: string, error?: any) {
        console.error(`[${source}] ${message}`, error);
    }
}
```

---

## ✅ Debugging Checklist

Before declaring something "broken":
- [ ] Checked browser console for errors
- [ ] Checked server logs for errors
- [ ] Verified backend is running
- [ ] Verified database is running
- [ ] Checked if data is actually being returned
- [ ] Verified API endpoint URLs are correct
- [ ] Checked CORS configuration
- [ ] Tested API with Postman/curl
- [ ] Checked network tab in browser
- [ ] Restarted server and cleared browser cache
- [ ] Checked for typos in variable names
- [ ] Verified null checks

---

## 🎯 Pro Tips

1. **Read Error Messages**: They usually tell you exactly what's wrong
2. **Use Debugging Tools**: Don't just println - use debugger
3. **Test in Isolation**: Test one thing at a time
4. **Check Edge Cases**: Empty values, nulls, negative numbers
5. **Read Logs**: Error logs contain gold
6. **Clean Browser Cache**: Ctrl+Shift+Delete
7. **Restart Everything**: Best solution 50% of the time
8. **Ask For Help**: Explain problem to rubber duck (?)
9. **Write Tests**: Tests are documentation
10. **Keep It Simple**: Simple code is easier to debug

---

## 📚 Resources

- **Java Debugging**: https://www.oracle.com/java/technologies/javase/debugging.html
- **Spring Boot Testing**: https://spring.io/guides/gs/testing-web/
- **Angular Testing**: https://angular.io/guide/testing
- **Postman Docs**: https://learning.postman.com/
- **Mozilla DevTools**: https://developer.mozilla.org/en-US/docs/Tools

---

**Remember**: Good developers spend more time debugging than coding. It's a skill! 🔍
