package org.example.laba13.resource;

import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/secure")
@Produces(MediaType.TEXT_PLAIN)
public class PostResource {
  @GET
  @RolesAllowed("admin")
  @Path("/admin")
  public String adminFunction() {
    return "This endpoint is accessible only by admin.";
  }

  @GET
  @RolesAllowed({"admin", "user"})
  @Path("/user")
  public String userFunction() {
    return "This endpoint is accessible only by user and admin.";
  }
}

