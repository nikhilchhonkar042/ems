package net.javaguides.ems.mapper;

import net.javaguides.ems.dto.EmployeeDto;
import net.javaguides.ems.entity.Employee;

public class EmployeeMapper {
    public static EmployeeDto  mapToEmployeeDto(Employee employee){
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }
    public static Employee mapToEmployee(EmployeeDto employeeDto){
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail()
        );
    }
}


/*Yes, Nikhil — that’s the correct `EmployeeMapper` class **for your current DTO**.

---

### ✅ Your current `EmployeeMapper` is perfect **as long as your DTO has only these fields**:

```java
private Long id;
private String firstName;
private String lastName;
private String email;
```

### 🔁 But if you **enhance your `EmployeeDto`** with extra fields like:

```java
private String phoneNumber;
private String department;
private String status;
private LocalDateTime createdAt;
private LocalDateTime updatedAt;
```

Then you’ll also need to update your `EmployeeMapper` like this:

---

### 🔧 **Updated `EmployeeMapper` (only if you enhance DTO + Entity):**

```java
public class EmployeeMapper {
    public static EmployeeDto mapToEmployeeDto(Employee employee) {
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getPhoneNumber(),
                employee.getDepartment(),
                employee.getStatus(),
                employee.getCreatedAt(),
                employee.getUpdatedAt()
        );
    }

    public static Employee mapToEmployee(EmployeeDto dto) {
        return new Employee(
                dto.getId(),
                dto.getFirstName(),
                dto.getLastName(),
                dto.getEmail(),
                dto.getPhoneNumber(),
                dto.getDepartment(),
                dto.getStatus(),
                dto.getCreatedAt(),
                dto.getUpdatedAt()
        );
    }
}
```

> ⚠️ **Remember:** You’ll also need to update your `Employee` entity constructor to support these extra fields.

---

### 🔚 Summary:

* ✅ If you're not changing your DTO — no need to modify the mapper.
* 🔁 If you enhance the DTO/entity — update the mapper accordingly.

Let me know if you'd like me to generate the **updated `Employee` entity, DTO, and full mapper class** with more fields.
*/