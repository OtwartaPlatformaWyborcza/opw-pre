/*
 * The MIT License
 *
 * Copyright 2015 Adam Kowalewski.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package pl.otwartapw.opw.pre.register.ws.api;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.APPLICATION_XML;
import static javax.ws.rs.core.MediaType.TEXT_PLAIN;
import javax.ws.rs.core.Response;

/**
 * REST API definition for OPW-PRE registration.
 *
 * @author Adam Kowalewski
 * @version 2015.12.15
 */
@Path(RegisterApi.SERVICE_PATH)
public interface RegisterApi {

  static final String SERVICE_PATH = "/user";

  /**
   * Register a new user.
   *
   * @param personDto user information.
   * @return
   */
  @POST
  @Path("/register")
  @Consumes({APPLICATION_JSON, APPLICATION_XML})
  @Produces({APPLICATION_JSON, APPLICATION_XML})
  Response register(@NotNull @Valid PersonDto personDto);

  /**
   * Dry run verification if usec can be registered.
   *
   * @param personDto user information.
   * @return
   */
  @POST
  @Path("/validate")
  @Consumes({APPLICATION_JSON, APPLICATION_XML})
  @Produces({APPLICATION_JSON, APPLICATION_XML})
  Response validate(@NotNull @Valid PersonDto personDto);

  /**
   * Generates a random password.
   *
   * @return random password.
   */
  @GET
  @Path("/password")
  @Produces({TEXT_PLAIN})
  String generatePassword();

  @POST
  @Path("/password/complexity")
  @Consumes(TEXT_PLAIN)
  @Produces(TEXT_PLAIN)
  Response checkPasswordComplexity(String password);

  @GET
  @Path("/version")
  @Produces({APPLICATION_JSON, APPLICATION_XML, TEXT_PLAIN})
  Response version();

}
