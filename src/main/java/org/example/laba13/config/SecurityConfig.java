package org.example.laba13.config;

import jakarta.annotation.security.DeclareRoles;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.security.enterprise.authentication.mechanism.http.BasicAuthenticationMechanismDefinition;

@BasicAuthenticationMechanismDefinition(
        realmName = "userRealm")
@DeclareRoles({"admin", "user"})
@ApplicationScoped
public class SecurityConfig {}
