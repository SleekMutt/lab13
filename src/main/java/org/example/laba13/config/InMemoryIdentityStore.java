package org.example.laba13.config;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.security.enterprise.credential.Credential;
import jakarta.security.enterprise.credential.UsernamePasswordCredential;
import jakarta.security.enterprise.identitystore.CredentialValidationResult;
import jakarta.security.enterprise.identitystore.IdentityStore;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


@ApplicationScoped
public class InMemoryIdentityStore implements IdentityStore {
  private static final Map<String, String> USERS = new HashMap<>();
  private static final Map<String, String> ROLES = new HashMap<>();

  static {
    USERS.put("admin", "admin123");
    USERS.put("user", "user123");

    ROLES.put("admin", "admin");
    ROLES.put("user", "user");
  }

  @Override
  public CredentialValidationResult validate(Credential credential) {
    UsernamePasswordCredential usernamePasswordCredential = (UsernamePasswordCredential) credential;
    String password = USERS.get(usernamePasswordCredential.getCaller());
    if (password != null && password.equals(usernamePasswordCredential.getPasswordAsString())) {
      return new CredentialValidationResult(usernamePasswordCredential.getCaller(),
              Collections.singleton(ROLES.get(usernamePasswordCredential.getCaller())));
    }
    return CredentialValidationResult.INVALID_RESULT;
  }
}
