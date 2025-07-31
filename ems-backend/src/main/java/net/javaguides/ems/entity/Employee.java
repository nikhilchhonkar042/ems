package net.javaguides.ems.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email_id", nullable = false, unique = true)
    private String email;
}



/*
* Your `Employee` entity is a good start — it's clean and follows JPA best practices. Here's a **checklist** and a few **enhancements** you can consider adding based on typical real-world use cases and best practices:

---

### ✅ 1. **Add Timestamps**

Automatically track when an employee was created or updated:

```java
@CreationTimestamp
@Column(name = "created_at", updatable = false)
private LocalDateTime createdAt;

@UpdateTimestamp
@Column(name = "updated_at")
private LocalDateTime updatedAt;
```

> 🔧 Also add:

```java
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;
```

---

### ✅ 2. **Status Field (Optional)**

Useful if you want to soft-delete or enable/disable employees.

```java
@Column(name = "status")
private String status; // or use an Enum
```

Or define:

```java
public enum Status {
    ACTIVE, INACTIVE, TERMINATED
}
```

---

### ✅ 3. **Soft Delete Support (Optional Advanced)**

Add a `deleted` boolean flag:

```java
@Column(name = "is_deleted")
private boolean isDeleted = false;
```

You can then override delete behavior in the service to set this flag instead of removing from DB.

---

### ✅ 4. **Phone Number or Address Fields**

If you're building a more complete HR system:

```java
@Column(name = "phone_number")
private String phoneNumber;

@Column(name = "address")
private String address;
```

---

### ✅ 5. **Validation Annotations (DTO Side)**

While you may not want them in the entity, in your DTO you can add:

```java
@NotBlank
@Email
@Column(name = "email_id", nullable = false, unique = true)
private String email;
```

Also consider:

```java
@Size(min = 2, max = 50)
@NotNull
```

---

### ✅ 6. **Unique Constraints at the Table Level** (Optional if you have multiple fields to make unique together):

```java
@Table(
    name = "employees",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"email_id"})
    }
)
```

---

### ✅ 7. **Override `toString()` / Equals and HashCode** (only if needed for comparisons or logging):

If you're using Lombok, you can use:

```java
@ToString
@EqualsAndHashCode
```

Or avoid it if sensitive info should not be logged.

---

### ✅ 8. **Auditing (Advanced Enterprise Use)**

If you’re working with enterprise-level needs:

```java
@EnableJpaAuditing
@EntityListeners(AuditingEntityListener.class)
```

This requires Spring configuration but is very powerful for tracking changes.

---

### Final Suggested Entity (Summary):

```java
@Entity
@Table(name = "employees")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email_id", nullable = false, unique = true)
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "status")
    private String status; // ACTIVE, INACTIVE, etc.

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
```
* | Change                      | Safe to Add? | Needs Code Update?                   |
| --------------------------- | ------------ | ------------------------------------ |
| New nullable field          | ✅ Yes        | ❌ Not unless you use it              |
| New non-nullable field      | ⚠️ No        | ✅ Yes (set default or provide value) |
| Timestamps with annotations | ✅ Yes        | ❌ Not unless you expose it           |
| Add to DTO/Mapper           | ❌ No         | ✅ Yes, if needed in APIs             |

*/
