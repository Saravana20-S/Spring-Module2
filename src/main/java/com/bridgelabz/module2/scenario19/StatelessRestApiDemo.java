package com.bridgelabz.module2.scenario19;

import org.springframework.stereotype.Component;

@Component
public class StatelessRestApiDemo {

    public void demonstrate() {

        System.out.println("======================================");
        System.out.println("       SCENARIO 19");
        System.out.println("       STATELESS REST API");
        System.out.println("======================================");

        System.out.println("\n1. API CLAIMS TO BE STATELESS");

        System.out.println(
                "REST API should not store client authentication "
                        + "state in an HTTP session."
        );

        System.out.println("\n2. DEVELOPER STORES USER IN SESSION");

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
                "Session stores logged-in user"
        );

        System.out.println(
                "  ↓"
        );

        System.out.println(
                "JSESSIONID sent to client"
        );

        System.out.println(
                "  ↓"
        );

        System.out.println(
                "Client sends JSESSIONID on later requests"
        );

        System.out.println(
                "  ↓"
        );

        System.out.println(
                "Server looks up user from Session"
        );

        System.out.println(
                "\nRESULT: API IS NOT STATELESS"
        );

        System.out.println("\n3. WHAT DOES STATELESS MEAN?");

        System.out.println(
                "Every request must contain enough information "
                        + "for the server to authenticate and process "
                        + "the request."
        );

        System.out.println(
                "The server does not depend on a previous "
                        + "HTTP session to identify the client."
        );

        System.out.println("\n4. JWT APPROACH");

        System.out.println(
                "Login"
        );

        System.out.println(
                "  ↓"
        );

        System.out.println(
                "Server authenticates user"
        );

        System.out.println(
                "  ↓"
        );

        System.out.println(
                "JWT generated"
        );

        System.out.println(
                "  ↓"
        );

        System.out.println(
                "Client stores access token"
        );

        System.out.println(
                "  ↓"
        );

        System.out.println(
                "Client sends JWT with every request"
        );

        System.out.println(
                "  ↓"
        );

        System.out.println(
                "Authorization: Bearer <JWT>"
        );

        System.out.println(
                "  ↓"
        );

        System.out.println(
                "Server validates JWT"
        );

        System.out.println(
                "  ↓"
        );

        System.out.println(
                "Request processed"
        );

        System.out.println(
                "\nRESULT: API CAN BE STATELESS"
        );

        System.out.println("======================================");
    }
}