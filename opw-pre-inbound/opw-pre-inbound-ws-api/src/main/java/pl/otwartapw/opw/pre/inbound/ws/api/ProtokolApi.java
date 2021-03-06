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
import pl.otwartapw.opw.pre.inbound.ws.api.dto.ProtokolDto;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.APPLICATION_XML;

/**
 * API definition for Protokol Komisji Obwodowej resource.
 *
 * @author Adam Kowalewski
 */
@Path(ProtokolApi.SERVICE_PATH)
public interface ProtokolApi {

  public static final String SERVICE_PATH = "/protokol";
  public static final String PP_PID = "protokolId";

  @GET
  @Path("/")
  @Produces({APPLICATION_JSON, APPLICATION_XML})
  List<ProtokolDto> getProtokolList();

  @POST
  @Path("/")
  @Consumes({APPLICATION_JSON, APPLICATION_XML})
  @Produces({APPLICATION_JSON, APPLICATION_XML})
  ProtokolDto postProtokol(@NotNull @Valid ProtokolDto dto);

  @GET
  @Path("/{" + PP_PID + "}")
  @Produces({APPLICATION_JSON, APPLICATION_XML})
  ProtokolDto getProtokol(@NotNull @PathParam(PP_PID) String protokolId);

  @PUT
  @Path("/{" + PP_PID + "}")
  @Consumes({APPLICATION_JSON, APPLICATION_XML})
  @Produces({APPLICATION_JSON, APPLICATION_XML})
  ProtokolDto putProtokol(
          @NotNull @PathParam(PP_PID) String protokolId,
          @NotNull @Valid ProtokolDto dto);

}
