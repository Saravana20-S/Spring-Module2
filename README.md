# 🚀 Spring Boot Request Flow & Data Flow – 20 Real-Time Scenarios

A comprehensive collection of **20 real-world Spring Boot Request Flow & Data Flow interview scenarios** designed to help Java Full Stack developers master how an HTTP request travels from the **client to the database and back to the client**.

This repository focuses on the internal working of **Tomcat, Filters, DispatcherServlet, Spring Security, JWT, Controllers, DTOs, Validation, JPA, Hibernate, AOP, and Global Exception Handling** through practical business scenarios.

---

## 📚 Learning Objective

The purpose of this repository is to understand not only **what happens** in Spring Boot, but also **why it happens** and **what happens internally** during every request.

Each scenario follows three interview levels:

- **Level 1:** What would you do?
- **Level 2:** Why would you do it that way?
- **Level 3:** What happens internally inside Spring?

---

## 🛠️ Tech Stack

- Java 17
- Spring Boot
- Spring MVC
- Spring Security
- JWT Authentication
- Spring Data JPA
- Hibernate
- MySQL
- Bean Validation
- Spring AOP
- Maven
- Tomcat (Embedded)

---

## 📂 Repository Structure

```text
springboot-request-flow-scenarios/
│
├── 01-Login-Request-Flow
├── 02-DispatcherServlet
├── 03-Filter-vs-Interceptor
├── 04-JWT-Authentication-Filter
├── 05-FilterChain
├── 06-Cookie-Based-Login
├── 07-Session-Based-Authentication
├── 08-Cookie-vs-Session
├── 09-Session-Expiration
├── 10-Multiple-Requests-Same-Session
├── 11-DTO-Data-Flow
├── 12-RequestBody-Internals
├── 13-Response-Data-Flow
├── 14-Exception-Flow
├── 15-Exception-In-Filter
├── 16-Filter-Ordering
├── 17-Complete-ECommerce-Flow
├── 18-Session-vs-JWT
├── 19-Stateless-REST-API
├── 20-Complete-Banking-Request-Lifecycle
│
└── README.md
```

---

## 🎯 20 Real-Time Scenarios

| No. | Scenario | Concepts Covered |
|------|----------|------------------|
| 01 | Login Request Flow | Tomcat, DispatcherServlet |
| 02 | Finding the Controller | HandlerMapping |
| 03 | Filter vs Interceptor | Request Processing |
| 04 | JWT Authentication | SecurityContext |
| 05 | Filter Chain | OncePerRequestFilter |
| 06 | Cookie Login | HTTP Cookies |
| 07 | Session Authentication | JSESSIONID |
| 08 | Cookie vs Session | Session Management |
| 09 | Session Timeout | Session Lifecycle |
| 10 | Multiple Requests | Session Tracking |
| 11 | DTO Data Flow | Jackson, DTO |
| 12 | @RequestBody Internals | HttpMessageConverter |
| 13 | Response Flow | ResponseEntity, Jackson |
| 14 | Exception Flow | ControllerAdvice |
| 15 | Security Exception | Filter Exception Handling |
| 16 | Filter Ordering | Security Filters |
| 17 | Complete Order API | End-to-End Flow |
| 18 | Session vs JWT | Authentication Design |
| 19 | Stateless REST API | JWT Architecture |
| 20 | Banking Transfer | Complete Spring Lifecycle |

---

## 🌱 Spring Concepts Covered

### HTTP & Web

- HTTP Request & Response
- Request Headers
- Response Headers
- Cookies
- Sessions
- JSESSIONID
- Stateless APIs

### Spring MVC

- DispatcherServlet
- HandlerMapping
- Controllers
- @RequestBody
- ResponseEntity
- HttpMessageConverter
- Jackson Serialization

### Spring Security

- Security Filter Chain
- OncePerRequestFilter
- JWT Validation
- SecurityContextHolder
- Authentication
- Authorization

### Persistence Layer

- DTO
- Entity
- Service
- Repository
- Hibernate
- JPA
- MySQL

### Cross Cutting Concerns

- Bean Validation
- @Transactional
- Spring AOP
- Logging
- Audit
- Global Exception Handling

---

## 🔄 Complete Spring Request Lifecycle

```text
                CLIENT
                   │
                   ▼
             HTTP REQUEST
                   │
                   ▼
                TOMCAT
                   │
                   ▼
                FILTERS
                   │
          ┌────────┴────────┐
          │                 │
      Cookies             JWT
          │                 │
          └────────┬────────┘
                   ▼
        SPRING SECURITY
                   │
          Authentication
                   │
                   ▼
        DISPATCHERSERVLET
                   │
                   ▼
             CONTROLLER
                   │
            @RequestBody
                   │
                   ▼
                  DTO
                   │
                @Valid
                   │
                   ▼
               SERVICE
                   │
          @Transactional
                   │
                   ▼
           AOP / LOGGING
                   │
                   ▼
           JPA REPOSITORY
                   │
                   ▼
              HIBERNATE
                   │
                   ▼
                MYSQL
                   │
                   ▼
          DATABASE RESULT
                   │
                   ▼
               SERVICE
                   │
                   ▼
             CONTROLLER
                   │
           ResponseEntity
                   │
                   ▼
               JACKSON
                   │
            Java → JSON
                   │
                   ▼
            HTTP RESPONSE
                   │
                   ▼
                CLIENT
```

---

## 🔍 Failure Scenarios Practiced

The final banking scenario includes handling real production failures:

- ❌ Missing JWT
- ❌ Expired JWT
- ❌ Invalid Role (403 Forbidden)
- ❌ Validation Failure
- ❌ Account Not Found
- ❌ Insufficient Balance
- ❌ Database Exception
- ❌ Transaction Rollback
- ❌ AOP Logging Failure
- ❌ Global Exception Handling

---

## 🎓 Interview Preparation Pattern

Every scenario is explained using three levels.

### Level 1 — What?

- Which component handles the request?
- Which Spring annotation is used?
- Which layer performs the operation?

### Level 2 — Why?

- Why use a Filter?
- Why DispatcherServlet?
- Why DTO instead of Entity?
- Why JWT for stateless APIs?

### Level 3 — How?

- How does DispatcherServlet find the Controller?
- How does Jackson convert JSON to Java?
- How is Authentication stored in SecurityContext?
- How does ResponseEntity become JSON?
- How does the Filter Chain continue execution?

---

## 💡 Skills You Will Gain

After completing these scenarios, you'll be able to:

- Explain the complete Spring Boot request lifecycle
- Understand Tomcat and Servlet processing
- Implement JWT authentication using Filters
- Differentiate Filters, Interceptors, and Controllers
- Work with Cookies and HTTP Sessions
- Build stateless REST APIs
- Convert JSON ↔ Java using Jackson
- Design layered Spring Boot architecture
- Handle exceptions globally
- Explain Spring Security internals confidently in interviews

---

## 👨‍💻 Ideal For

- Java Full Stack Developers
- Spring Boot Learners
- Backend Developers
- Product-Based Company Interview Preparation
- Anyone wanting to master Spring Request & Data Flow

---

## ⭐ Key Takeaway

> **Master the complete Spring Boot request lifecycle by understanding every step from Client → Tomcat → Filters → DispatcherServlet → Controller → Service → Repository → Database → Response.**