package com.bridgelabz.module2.scenario18;

import org.springframework.stereotype.Component;

@Component
public class SessionVsJwtDemo {

    public void explainAuthenticationChoice() {

        System.out.println("======================================");
        System.out.println("      SCENARIO 18");
        System.out.println("   SESSION VS JWT AUTHENTICATION");
        System.out.println("======================================");

        traditionalWebApplication();

        restApi();

        mobileApplication();

        microservices();

        System.out.println("======================================");
    }

    private void traditionalWebApplication() {

        System.out.println("\n1. TRADITIONAL WEB APPLICATION");

        System.out.println(
                "Recommended: Server Session + JSESSIONID Cookie"
        );

        System.out.println(
                "Flow:"
        );

        System.out.println(
                "Login"
        );

        System.out.println(
                "  ↓"
        );

        System.out.println(
                "Server creates HTTP Session"
        );

        System.out.println(
                "  ↓"
        );

        System.out.println(
                "Server stores user information"
        );

        System.out.println(
                "  ↓"
        );

        System.out.println(
                "Server sends JSESSIONID cookie"
        );

        System.out.println(
                "  ↓"
        );

        System.out.println(
                "Browser automatically sends JSESSIONID"
        );

        System.out.println(
                "  ↓"
        );

        System.out.println(
                "Server identifies user from session"
        );
    }

    private void restApi() {

        System.out.println("\n2. REST API");

        System.out.println(
                "Recommended: JWT / Token-based Authentication"
        );

        System.out.println(
                "Flow:"
        );

        System.out.println(
                "Login"
        );

        System.out.println(
                "  ↓"
        );

        System.out.println(
                "Server validates credentials"
        );

        System.out.println(
                "  ↓"
        );

        System.out.println(
                "Server generates JWT"
        );

        System.out.println(
                "  ↓"
        );

        System.out.println(
                "Client stores token"
        );

        System.out.println(
                "  ↓"
        );

        System.out.println(
                "Client sends Authorization header"
        );

        System.out.println(
                "  ↓"
        );

        System.out.println(
                "Authorization: Bearer <JWT>"
        );
    }

    private void mobileApplication() {

        System.out.println("\n3. MOBILE APPLICATION");

        System.out.println(
                "Recommended: Token-based Authentication"
        );

        System.out.println(
                "JWT or another secure access-token mechanism"
        );

        System.out.println(
                "Flow:"
        );

        System.out.println(
                "Mobile App"
        );

        System.out.println(
                "  ↓"
        );

        System.out.println(
                "Login"
        );

        System.out.println(
                "  ↓"
        );

        System.out.println(
                "Access Token"
        );

        System.out.println(
                "  ↓"
        );

        System.out.println(
                "Authorization: Bearer <token>"
        );

        System.out.println(
                "  ↓"
        );

        System.out.println(
                "API"
        );
    }

    private void microservices() {

        System.out.println("\n4. MICROSERVICES");

        System.out.println(
                "Recommended: Token-based Authentication"
        );

        System.out.println(
                "JWT is commonly used for stateless authentication"
        );

        System.out.println(
                "Flow:"
        );

        System.out.println(
                "Client"
        );

        System.out.println(
                "  ↓"
        );

        System.out.println(
                "JWT"
        );

        System.out.println(
                "  ↓"
        );

        System.out.println(
                "API Gateway"
        );

        System.out.println(
                "  ↓"
        );

        System.out.println(
                "Service A / Service B / Service C"
        );

        System.out.println(
                "  ↓"
        );

        System.out.println(
                "Each service can validate the token"
        );
    }
}