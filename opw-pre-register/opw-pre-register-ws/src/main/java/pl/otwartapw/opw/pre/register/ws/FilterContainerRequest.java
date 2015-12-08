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

import java.io.IOException;
import java.util.List;
import java.util.Map.Entry;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Adam Kowalewski
 */
@Provider
public class FilterContainerRequest implements ContainerRequestFilter {

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  public FilterContainerRequest() {
    logger.info("FilterRequest()");
  }

  @Override
  public void filter(ContainerRequestContext requestContext) throws IOException {
    logger.info("filter()");

    if (logger.isDebugEnabled()) {
      printHttpHeaders(requestContext.getHeaders());
    }

  }

  private void printHttpHeaders(MultivaluedMap<String, String> headers) {
    logger.debug("printHttpHeaders");
    for (Entry<String, List<String>> entry : headers.entrySet()) {
      logger.debug("{}: {}", entry.getKey(), entry.getValue());
    }
  }

}
