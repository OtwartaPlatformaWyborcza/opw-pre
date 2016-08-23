/*
 * The MIT License
 *
 * Copyright 2015 Otwarta Platforma Wyborcza.
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
package pl.otwartapw.opw.pre.inbound.ws.api;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.APPLICATION_XML;
import pl.otwartapw.opw.pre.inbound.ws.api.dto.LoginDto;
import pl.otwartapw.opw.pre.inbound.ws.api.dto.ObwodowaShortDto;
import pl.otwartapw.opw.pre.inbound.ws.api.dto.UserDto;

/**
 * REST API definition for OPW-PRE user.
 *
 * @author Adam Kowalewski
 * @version 2016.08.23
 */
@Path("/user")
public interface UserApi {

  public static final String PP_USER_ID = "userId";
  public static final String PP_PKW_ID = "pkwId";

  /**
   * Returns a list of all Komisja Obwodowa attached to given user.
   *
   * @param userId unique ID of user.
   * @return if successful all Komisja Obwodowa attached to user, otherwise proper HTTP status code.
   */
  @GET
  @Path("/{" + PP_USER_ID + "}/obwodowa")
  @Produces({APPLICATION_JSON, APPLICATION_XML})
  List<ObwodowaShortDto> loadObwodowaShortList(@NotNull @PathParam(PP_USER_ID) int userId);

  /**
   * Adds a given Komisja Obwodowa to users list.
   *
   * @param userId unique ID of user.
   * @param pkwId unique ID of Komisja Obwodowa.
   */
  @PUT
  @Path("/{" + PP_USER_ID + "}/obwodowa/{" + PP_PKW_ID + "}")
  void putObwodowa(
          @NotNull @PathParam(PP_USER_ID) int userId,
          @NotNull @PathParam(PP_PKW_ID) String pkwId);

  /**
   * Deletes given Komisja Obwodowa from users list.
   *
   * @param userId unique ID of user.
   * @param pkwId unique ID of Komisja Obwodowa.
   */
  @DELETE
  @Path("/{" + PP_USER_ID + "}/obwodowa/{" + PP_PKW_ID + "}")
  void deleteObwodowa(
          @NotNull @PathParam(PP_USER_ID) int userId,
          @NotNull @PathParam(PP_PKW_ID) String pkwId);

  /**
   * Authenticates user against OPW.
   *
   * @param login credentials.
   * @return if successful instance of user, otherwise proper HTTP status code.
   */
  @POST
  @Path("/login")
  @Consumes({APPLICATION_JSON, APPLICATION_XML})
  @Produces({APPLICATION_JSON, APPLICATION_XML})
  UserDto login(@NotNull @Valid LoginDto login);

  /**
   * Ends user session.
   */
  @GET
  @Path("/logout")
  void logout();

}
