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
package pl.otwartapw.opw.pre.register.ws;

import javax.ejb.EJB;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.otwartapw.opw.pre.commons.version.VersionBuilder;
import pl.otwartapw.opw.pre.commons.version.VersionDto;
import pl.otwartapw.opw.pre.register.ws.api.PersonDto;
import pl.otwartapw.opw.pre.register.ws.api.RegisterApi;

/**
 * Implementation of REST API.
 *
 * @author Adam Kowalewski
 */
@Path(RegisterApi.SERVICE_PATH)
public class RegisterResource implements RegisterApi {

  private final Logger logger = LoggerFactory.getLogger(this.getClass());
  
  VersionBuilder versionBuilder = new VersionBuilder();
  
  @EJB
  RegisterService registerService;

  public RegisterResource() {
    logger.debug("RegisterResource");
  }

  @Override
  public Response.Status register(PersonDto personDto) {
    logger.info("Register a new user");
    logger.trace("register {} ", personDto.toString());

    try {
      registerService.register(personDto);
      return Response.Status.OK;
    }
    catch (Exception e) {
      throw new InternalServerErrorException(e.getMessage());
    }
  }

  @Override
  public VersionDto version() {
    logger.info("Read artifact version");
    String uri = "/META-INF/maven/pl.otwartapw.opw-pre/opw-pre-register-ws/pom.properties";
    return versionBuilder.build(uri);
  }

}
