package net.javaguides.ems.controller;

import lombok.AllArgsConstructor;
import net.javaguides.ems.dto.EmployeeDto;
import net.javaguides.ems.entity.Employee;
import net.javaguides.ems.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {


    private EmployeeService employeeService;
    //Build Rest API

    // Post Api
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }




    //Get Api
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId){
        EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(employeeDto);
    }
    // Get Api for getting all employees as a list
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        List<EmployeeDto> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }
    //Get Api for getting List of employee with first name
    @GetMapping("/firstName/{firstName}")
    public ResponseEntity<List<EmployeeDto>> getAllEmployeeByFirstName(@PathVariable("firstName") String employeeFirstName){
        List<EmployeeDto> employees = employeeService.getAllEmployeeByFirstName(employeeFirstName);
        return ResponseEntity.ok(employees);
    }

    // Build API for update the employee
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId,@RequestBody EmployeeDto updatedEmployee){
         EmployeeDto employeeDto = employeeService.updateEmployee(employeeId,updatedEmployee);
        return  ResponseEntity.ok(employeeDto);
    }







    //Build Api for delete the employee by it
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){

        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee deleted successfully");
    }
}



/*
* Your `EmployeeController` is well-structured and clean. Here’s feedback along with **additional suggestions** you can add to make it more feature-rich, robust, and production-ready:

---

### ✅ **What's Good**

* RESTful conventions (`@GetMapping`, `@PostMapping`, etc.)
* Clear endpoints and method naming
* Consistent response structure

---

### 🛠️ **What You Can Improve or Add**

#### 1. 🔍 **Find by Email**

Allow lookup by email:

```java
@GetMapping("/email/{email}")
public ResponseEntity<EmployeeDto> getEmployeeByEmail(@PathVariable("email") String email) {
    EmployeeDto employee = employeeService.getEmployeeByEmail(email);
    return ResponseEntity.ok(employee);
}
```

#### 2. 🔍 **Search by Full Name**

```java
@GetMapping("/fullname")
public ResponseEntity<List<EmployeeDto>> getEmployeesByFullName(
        @RequestParam String firstName,
        @RequestParam String lastName) {
    List<EmployeeDto> employees = employeeService.getEmployeesByFullName(firstName, lastName);
    return ResponseEntity.ok(employees);
}
```

#### 3. 📊 **Get Total Employee Count**

```java
@GetMapping("/count")
public ResponseEntity<Long> getTotalEmployees() {
    return ResponseEntity.ok(employeeService.countTotalEmployees());
}
```

#### 4. ✅ **Check if Email Exists**

```java
@GetMapping("/exists/email/{email}")
public ResponseEntity<Boolean> existsByEmail(@PathVariable("email") String email) {
    return ResponseEntity.ok(employeeService.existsByEmail(email));
}
```

#### 5. 📥 **Save Multiple Employees**

```java
@PostMapping("/bulk")
public ResponseEntity<List<EmployeeDto>> saveAllEmployees(@RequestBody List<EmployeeDto> employeeDtos) {
    List<EmployeeDto> saved = employeeService.saveAllEmployees(employeeDtos);
    return new ResponseEntity<>(saved, HttpStatus.CREATED);
}
```

#### 6. 🗑️ **Delete Multiple Employees**

```java
@DeleteMapping("/bulk")
public ResponseEntity<String> deleteEmployeesByIds(@RequestBody List<Long> ids) {
    employeeService.deleteEmployeesByIds(ids);
    return ResponseEntity.ok("Employees deleted successfully");
}
```

---

### 🔐 Optional: Add Validation (if not done already)

Add `@Valid` on input DTOs and validation annotations inside your `EmployeeDto`.

```java
@PostMapping
public ResponseEntity<EmployeeDto> createEmployee(@Valid @RequestBody EmployeeDto employeeDto) { ... }
```

---

### 🧼 Optional: Use `@Slf4j` for Logging

```java
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
```

---

Would you like me to:

* Refactor all endpoints with Swagger docs (`@Operation`)
* Create Postman collection
* Generate response wrapper (`ApiResponse<T>`) class for consistency

Let me know what level of polish or features you want to add.
*/

