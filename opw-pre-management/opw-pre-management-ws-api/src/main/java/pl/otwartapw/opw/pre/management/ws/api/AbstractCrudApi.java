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
package pl.otwartapw.opw.pre.management.ws.api;

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
import static javax.ws.rs.core.MediaType.TEXT_PLAIN;

/**
 * Default CRUD API definition.
 *
 * @param <T> entity.
 * @author Adam Kowalewski
 * @version 2015.10.25
 *
 */
public interface AbstractCrudApi<T> {

    @GET
    @Produces({APPLICATION_JSON, APPLICATION_XML})
    List<T> findAll();

    @POST
    @Consumes({APPLICATION_JSON, APPLICATION_XML})
    void create(@NotNull @Valid T dto);

    @GET
    @Path("{id}")
    @Produces({APPLICATION_JSON, APPLICATION_XML})
    T find(@NotNull @PathParam("id") Integer id);

    @DELETE
    @Path("{id}")
    void remove(@NotNull @PathParam("id") Integer id);

    @PUT
    @Path("{id}")
    @Consumes({APPLICATION_JSON, APPLICATION_XML})
    void edit(@PathParam("id") Integer id, @NotNull @Valid T dto);

    @GET
    @Path("{from}/{to}")
    @Produces({APPLICATION_JSON, APPLICATION_XML})
    List<T> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to);

    @GET
    @Path("count")
    @Produces(TEXT_PLAIN)
    String count();
}
