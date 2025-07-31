package net.javaguides.ems.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message){
        super(message);
    }
}


/*Your `EmployeeRepository` looks clean and functional. Here's a quick review and suggestions on **what you have**, **what you can add**, and **how to enhance** it.

---

### ✅ **Current Implementation (Correct & Functional)**

```java
List<Employee> findByFirstName(String employeeFirstName);
```

This will retrieve all employees with the exact first name.

---

### 🛠️ **What You Can Add to Make It More Powerful**

#### 1. **Find by Email**

```java
Optional<Employee> findByEmail(String email);
```

#### 2. **Check if Email Exists**

```java
boolean existsByEmail(String email);
```

#### 3. **Find by First and Last Name**

```java
List<Employee> findByFirstNameAndLastName(String firstName, String lastName);
```

#### 4. **Find by First Name (Case Insensitive)**

```java
List<Employee> findByFirstNameIgnoreCase(String firstName);
```

#### 5. **Search by Name Contains (Like Search)**

```java
List<Employee> findByFirstNameContainingIgnoreCase(String keyword);
```

#### 6. **Count by First Name**

```java
long countByFirstName(String firstName);
```

#### 7. **Delete by Email**

```java
void deleteByEmail(String email);
```

---

### 🧪 Example Usage in Service

```java
Optional<Employee> emp = employeeRepository.findByEmail("abc@example.com");
if (emp.isEmpty()) throw new ResourceNotFoundException("Not found");
```

---

### 📌 Bonus: Pagination & Sorting Support (Optional)

You can also add:

```java
Page<Employee> findAll(Pageable pageable);
```

Usage:

```java
Pageable pageable = PageRequest.of(0, 10, Sort.by("firstName"));
Page<Employee> page = employeeRepository.findAll(pageable);
```

---

Would you like me to update your `EmployeeService` and `EmployeeServiceImpl` interfaces accordingly to match the above enhancements?

Let me know what features you want to prioritize (search, pagination, validation, etc.).
*/