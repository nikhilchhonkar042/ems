package net.javaguides.ems.repository;

import net.javaguides.ems.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {


    List<Employee> findByFirstName(String employeeFirstName);

}


/*Your `EmployeeRepository` interface looks good and is correctly extending `JpaRepository`. You’ve already added a custom query method `findByFirstName`, which is great.

---

### ✅ What You’ve Done Well

```java
List<Employee> findByFirstName(String employeeFirstName);
```

This uses **Spring Data JPA query derivation**, so Spring will automatically implement it.

---

### 🧠 Suggestions: More Useful Query Methods You Can Add

Here are some **commonly useful repository methods** you can add without writing any SQL:

---

#### 🔍 Find by Last Name

```java
List<Employee> findByLastName(String lastName);
```

#### 🔍 Find by Email

```java
Employee findByEmail(String email);
```

#### 🔍 Find by First and Last Name

```java
List<Employee> findByFirstNameAndLastName(String firstName, String lastName);
```

#### 🔍 Find All Ordered by First Name

```java
List<Employee> findAllByOrderByFirstNameAsc();
```

#### ✅ Check if Email Exists

```java
boolean existsByEmail(String email);
```

#### 🗑️ Delete by Email

```java
void deleteByEmail(String email);
```

---

### 💡 Optional: Custom `@Query` Examples (if you need custom behavior)

#### Find by Partial First Name (LIKE %name%)

```java
@Query("SELECT e FROM Employee e WHERE LOWER(e.firstName) LIKE LOWER(CONCAT('%', :name, '%'))")
List<Employee> searchByFirstNameContaining(@Param("name") String name);
```

---

Let me know if you want to:

* Add pagination support?
* Write native SQL queries?
* Return only selected fields with projections?

I'll help accordingly.
*/