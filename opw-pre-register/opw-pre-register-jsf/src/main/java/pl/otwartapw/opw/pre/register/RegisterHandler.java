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
package pl.otwartapw.opw.pre.register;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.otwartapw.opw.pre.register.ws.api.PersonDto;

/**
 *
 * @author Adam Kowalewski
 */
@Named
@ViewScoped
public class RegisterHandler implements Serializable {

  private static final long serialVersionUID = 1L;

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  private PersonDto person;

  @EJB
  RestClient restClient;

  public RegisterHandler() {
    person = new PersonDto();
  }

  public PersonDto getPerson() {
    return person;
  }

  public void setPerson(PersonDto person) {
    this.person = person;
  }

  public void register() {
    logger.trace("register");
    restClient.registerNewPerson(person);
  }

  public String loadBackendVersion() {
    logger.trace("loadBackendVersion");
    return restClient.readRegisterBackendVersion();
  }

}
