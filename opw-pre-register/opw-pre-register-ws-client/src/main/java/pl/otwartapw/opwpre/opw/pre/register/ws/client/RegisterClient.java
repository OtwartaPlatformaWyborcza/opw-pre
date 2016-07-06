/*
 * The MIT License
 *
 * Copyright 2016 Otwarta Platforma Wyborcza.
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
package pl.otwartapw.opwpre.opw.pre.register.ws.client;

import java.io.Serializable;
import javax.ws.rs.core.Response;
import pl.otwartapw.opw.pre.commons.version.VersionDto;
import pl.otwartapw.opw.pre.register.ws.api.PersonDto;
import pl.otwartapw.opw.pre.register.ws.api.RegisterApi;

/**
 *
 * @author Adam Kowalewski
 */
public class RegisterClient implements RegisterApi, Serializable {

  private static final long serialVersionUID = 1L;

  private final ClientFactory clientFactory;
  private String serviceUrl;

  public RegisterClient(String serviceUrl) {
    clientFactory = new ClientFactory();
    this.serviceUrl = "http://localhost:8080/opw-pre-register-ws/service";
  }

  @Override
  public void register(PersonDto person) {
    clientFactory.getClient(serviceUrl).register(person);
  }

  @Override
  public VersionDto version() {
    return clientFactory.getClient(serviceUrl).version();
  }

}
