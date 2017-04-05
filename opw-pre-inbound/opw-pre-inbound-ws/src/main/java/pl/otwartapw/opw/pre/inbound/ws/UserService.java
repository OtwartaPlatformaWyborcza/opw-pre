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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.otwartapw.opw.pre.entity.OpwObwodowa;
import pl.otwartapw.opw.pre.entity.OpwUser;
import pl.otwartapw.opw.pre.inbound.ws.api.dto.ObwodowaShortDto;
import pl.otwartapw.opw.pre.inbound.ws.api.dto.UserDto;
import pl.otwartapw.opw.pre.inbound.ws.facade.ObwodowaFacade;
import pl.otwartapw.opw.pre.inbound.ws.facade.UserFacade;


@Stateless
public class UserService implements Serializable {

  private static final long serialVersionUID = 1L;
  private final Logger log = LoggerFactory.getLogger(this.getClass());

  private final UserMapper userMapper = new UserMapper();
  private final ObwodowaMapper obwodowaMapper = new ObwodowaMapper();
  private final SecurityService securityService = new SecurityService();

  @EJB
  private UserFacade userFacade;

  @EJB
  private ObwodowaFacade obwodowaFacade;

  public UserService() {
    log.debug("UserService");
  }

  public UserDto login(String login, String password) {
    log.trace("login {}", login);
    OpwUser user = userFacade.find(login);

    if (securityService.verifyCredentials(user, password)){
      return userMapper.from(user);
    }
    // TODO
    return null;
  }

  public void logout(int userId){
    log.trace("logout {}", userId);
  }

  public List<ObwodowaShortDto> deleteObwodowa(int userId, String pkwId) {
    log.trace("deleteObwodowa {} {}", userId, pkwId);

    OpwUser user = userFacade.find(userId);
    OpwObwodowa obwodowa = obwodowaFacade.find(pkwId);

    user.getOpwObwodowaList().remove(obwodowa);
    obwodowa.getOpwUserList().remove(user);
    userFacade.edit(user);
    obwodowaFacade.edit(obwodowa);
    return getObwodowaList(userId);
  }

  public List<ObwodowaShortDto> addObwodowa(int userId, String pkwId) {
    log.trace("addObwodowa {} {}", userId, pkwId);
    OpwUser user = userFacade.find(userId);
    OpwObwodowa obwodowa = obwodowaFacade.find(pkwId);

    user.getOpwObwodowaList().add(obwodowa);
    obwodowa.getOpwUserList().add(user);
    userFacade.edit(user);
    obwodowaFacade.edit(obwodowa);
    return getObwodowaList(userId);
  }

  public List<ObwodowaShortDto> getObwodowaList(int userId) {
    log.trace("getObwodowaList {}", userId);
    List<ObwodowaShortDto> obwodowaShortList = new ArrayList<>();
    List<OpwObwodowa> obwodowaList = userFacade.find(userId).getOpwObwodowaList();

    for (OpwObwodowa opwObwodowa : obwodowaList) {
      obwodowaShortList.add(obwodowaMapper.from(opwObwodowa));
    }

    return obwodowaShortList;
  }

}
