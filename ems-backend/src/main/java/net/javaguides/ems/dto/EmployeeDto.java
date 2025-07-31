package net.javaguides.ems.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

}


/*Yes, your current `EmployeeDto` is good and already supports the features like searching by first name, last name, and email. However, if you're planning to **add new features** such as:

* Case-insensitive search
* Partial match search
* Sorting or pagination-related fields
* Metadata (createdAt, updatedAt)
* Additional fields (e.g., phone, department, status)

Then enhancing the `EmployeeDto` makes sense.

---

### ✅ Your current `EmployeeDto` is fine for basic CRUD and search:

```java
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
```

---

### 💡 Here's an **Enhanced `EmployeeDto`** if you plan to scale functionality:

```java
package net.javaguides.ems.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    // Optional enhancements
    private String phoneNumber;
    private String department;
    private String status; // ACTIVE, INACTIVE, etc.

    // For audit/logging (if you're mapping this from entity)
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
```

---

### 🔁 If you enhance DTO like this, remember to update:

1. **`Employee` Entity**
2. **`EmployeeMapper` class**
3. **Form/request payloads on frontend (if any)**

---

### ✅ If you only want to support `findByFirstName`, `findByEmail`, or similar read-only operations — your current DTO is enough. No changes needed.

Let me know which features you're planning to add so I can help update your `Mapper` class or suggest which parts to reflect in `Controller/Service`.
*/