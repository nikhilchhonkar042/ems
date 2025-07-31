package net.javaguides.ems.service;

import net.javaguides.ems.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    //datatype EmployeeDto


    //Create Interface
    //create new employee
    EmployeeDto createEmployee(EmployeeDto employeeDto);



    //Get Interface
    //Get employee by id
    EmployeeDto getEmployeeById(Long employeeId);
    //Get All employee by firstName
    List<EmployeeDto> getAllEmployeeByFirstName(String employeeFirstName);
    //Get all employee
    List<EmployeeDto> getAllEmployees();


    //Update Interface
    //Update employee
    EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee);



    //Delete Interface
    // Delete employee
    void deleteEmployee(Long employeeId);
}


/*
* Great structure so far, Nikhil. You've already covered the basic **CRUD** and a useful **search-by-firstName** method.

Now, here are several **realistic and practical service method ideas** you can add to `EmployeeService` — grouped by use case:

---

## ✅ **1. Advanced Search Services**

Add these for better querying capabilities:

```java
// Get employees by last name
List<EmployeeDto> getAllEmployeeByLastName(String lastName);

// Get employees by email
EmployeeDto getEmployeeByEmail(String email);

// Get employees by full name
List<EmployeeDto> getEmployeesByFullName(String firstName, String lastName);
```

---

## ✅ **2. Pagination and Sorting**

Useful when the DB grows:

```java
// Get all employees with pagination and sorting
Page<EmployeeDto> getAllEmployees(int page, int size, String sortBy, String sortDir);
```

> You'll need to return `Page<EmployeeDto>` and modify your repository/controller accordingly.

---

## ✅ **3. Filtering by Status/Role/Department (if you add those fields)**

```java
List<EmployeeDto> getEmployeesByStatus(String status);
List<EmployeeDto> getEmployeesByDepartment(String departmentName);
List<EmployeeDto> getEmployeesByRole(String role);
```

---

## ✅ **4. Bulk Operations**

```java
// Save a list of employees at once
List<EmployeeDto> saveAllEmployees(List<EmployeeDto> employees);

// Delete multiple employees
void deleteEmployeesByIds(List<Long> employeeIds);
```

---

## ✅ **5. Count, Exists & Analytics**

```java
// Count total employees
long countTotalEmployees();

// Check if an employee exists by email
boolean existsByEmail(String email);
```

---

## ✅ **6. Soft Delete or Archive**

If you add a `status` or `deleted` column:

```java
void softDeleteEmployee(Long employeeId);  // Just mark as inactive
List<EmployeeDto> getActiveEmployees();    // Return only active employees
```

---

## ✅ **7. Audit & History (Optional)**

Only if you're tracking timestamps:

```java
List<EmployeeDto> getEmployeesCreatedAfter(LocalDateTime date);
List<EmployeeDto> getEmployeesUpdatedBetween(LocalDateTime from, LocalDateTime to);
```

---

### 🔥 Bonus Ideas (Future Scope)

* Export employee data to CSV or Excel
* Import employees from a file
* Assign employees to projects (one-to-many)
* Integration with external APIs (e.g., HR, Payroll)

---

## ✅ Updated Interface (Example)

```java
public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(Long employeeId);
    List<EmployeeDto> getAllEmployees();
    List<EmployeeDto> getAllEmployeeByFirstName(String employeeFirstName);
    EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee);
    void deleteEmployee(Long employeeId);

    // Add-ons
    List<EmployeeDto> getAllEmployeeByLastName(String lastName);
    EmployeeDto getEmployeeByEmail(String email);
    long countTotalEmployees();
    boolean existsByEmail(String email);
    List<EmployeeDto> getEmployeesByStatus(String status);
    List<EmployeeDto> saveAllEmployees(List<EmployeeDto> employees);
    void deleteEmployeesByIds(List<Long> employeeIds);
}
```

---
*/