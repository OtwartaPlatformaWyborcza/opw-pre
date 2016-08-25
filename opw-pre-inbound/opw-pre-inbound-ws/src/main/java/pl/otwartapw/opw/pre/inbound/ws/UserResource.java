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
package pl.otwartapw.opw.pre.inbound.ws;

import java.util.List;
import javax.ejb.EJB;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.otwartapw.opw.pre.inbound.ws.api.UserApi;
import pl.otwartapw.opw.pre.inbound.ws.api.dto.LoginDto;
import pl.otwartapw.opw.pre.inbound.ws.api.dto.ObwodowaShortDto;
import pl.otwartapw.opw.pre.inbound.ws.api.dto.UserDto;

/**
 *
 * @author Adam Kowalewski
 */
public class UserResource implements UserApi{

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  @EJB
  private UserService userService;

  @Override
  public List<ObwodowaShortDto> loadObwodowaShortList(int userId) {
    logger.info("Load list of Komisja Obwodowa for user {}", userId);
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void putObwodowa(int userId, String pkwId) {
    logger.info("Add Komisja Obwodowa {} to user {} list.", pkwId, userId);
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void deleteObwodowa(int userId, String pkwId) {
    logger.info("Remove Komisja Obwodowa {} from user {} list.", pkwId, userId);
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public UserDto login(LoginDto login) {
    logger.info("Login {}", login.getLogin());
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void logout(int userId) {
    logger.info("Logout user {}", userId);
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }



}
