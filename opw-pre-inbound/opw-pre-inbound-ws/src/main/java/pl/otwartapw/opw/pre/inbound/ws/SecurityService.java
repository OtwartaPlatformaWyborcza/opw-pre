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
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.otwartapw.opw.pre.commons.UserHelper;
import pl.otwartapw.opw.pre.entity.OpwUser;

public class SecurityService implements Serializable {

  private static final long serialVersionUID = 1L;
  private final Logger log = LoggerFactory.getLogger(this.getClass());

  private UserHelper userHelper = new UserHelper();

  public SecurityService() {
  }

  public boolean verifyCredentials(OpwUser user, String password) {
    log.trace("verifyCredentials {}", user.getEmail());

    String pwd = encryptPassword(user.getSalt(), password, Configuration.APP_SALT);

    if (pwd.equals(user.getPassword()) && user.getActive()) {
      return true;
    }

    return false;

  }

  public String encryptPassword(String userSalt, String userPassword, String applicationSalt) {
    log.trace("encryptPassword {} {} {}", userSalt, userPassword, applicationSalt);

//    userHelper.encryptSHA()
//    user.getSalt()
    return "";

  }

  public boolean validateSession() {
    return false;
  }

  /**
   * Generates a SHA-256 hash from the given String.
   *
   * @param value plain text password to be encrypted.
   * @return String hashed text.
   * @author Adam Kowalewski
   * @version 2015.03.27
   */
  public String encryptSHA(String value) {
    StringBuilder encrypted = new StringBuilder();
    String algorithm = "SHA-256";
    byte[] passwordArray = value.getBytes();

    try {
      MessageDigest md = MessageDigest.getInstance(algorithm);
      md.reset();
      md.update(passwordArray);
      byte[] encryptedArray = md.digest();

      for (int i = 0; i < encryptedArray.length; i++) {
        encrypted.append(Integer.toHexString(0xFF & encryptedArray[i]));
      }
    } catch (NoSuchAlgorithmException ex) {
      return null;
    }
    return encrypted.toString();
  }

}
