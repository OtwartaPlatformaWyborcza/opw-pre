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

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.otwartapw.opw.pre.entity.OpwGroup;
import pl.otwartapw.opw.pre.entity.OpwUser;
import pl.otwartapw.opw.pre.inbound.ws.api.dto.UserDto;

/**
 *
 * @author Adam Kowalewski
 */
public class UserMapper {

  private final Logger log = LoggerFactory.getLogger(this.getClass());

  public UserMapper() {
    log.debug("UserConverter");
  }

  public UserDto from(OpwUser user) {
    log.trace("from {}", user);
    UserDto result = new UserDto();
    result.setId(user.getId());
    result.setFirstname(user.getFirstname());
    result.setLastname(user.getLastname());
    result.setEmail(user.getEmail());
    result.setGroupList(extractList(user.getOpwGroupList()));
    return result;
  }

  private List<String> extractList(List<OpwGroup> groupList) {
    log.trace("extractList {}", groupList);
    List<String> result = new ArrayList<>();

    for (OpwGroup group : groupList) {
      result.add(group.getName());
    }

    return result;
  }

}
