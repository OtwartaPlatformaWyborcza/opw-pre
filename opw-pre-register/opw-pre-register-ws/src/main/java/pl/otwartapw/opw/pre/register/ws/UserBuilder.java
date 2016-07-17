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
package pl.otwartapw.opw.pre.register.ws;

import java.util.Date;
import pl.otwartapw.opw.pre.register.ws.api.PersonDto;

/**
 *
 * @author Adam Kowalewski
 */
public class UserBuilder {

  public UserBuilder() {
  }

  public OpwUser fromPerson(PersonDto person) {
    OpwUser user = new OpwUser();
    user.setFirstname(person.getFirstname());
    user.setLastname(person.getLastname());
    user.setEmail(person.getEmail());
    user.setPhone(person.getPhone());
    user.setPassword(person.getPassword());
    user.setOrigin(Configuration.ORIGIN);
    user.setDateCreated(new Date());
    user.setActive(Boolean.TRUE);
    
    return user;
  }

}
