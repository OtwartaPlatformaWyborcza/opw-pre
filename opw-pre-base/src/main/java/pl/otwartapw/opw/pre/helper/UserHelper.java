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
package pl.otwartapw.opw.pre.helper;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 *
 * @author Adam Kowalewski
 */
public class UserHelper {

  // ToDo extract to properties 
  public static final int DEFAULT_PWD_LENGTH = 10;

  /**
   * Returns salted password.
   *
   * @param appSalt application level salt.
   * @param userSalt user level salt.
   * @param password password in plaintext.
   * @return salted password.
   * @author Adam Kowalewski
   * @version 2015.03.27
   */
  public static String saltPassword(String appSalt, String userSalt, String password) {
    return encryptSHA(appSalt + password + userSalt);
  }

  /**
   * Generates random token for account activation.
   *
   * @return random token 32 chars.
   * @author Adam Kowalewski
   * @version 2015.04.17
   */
  public static String generateToken() {
    return encryptSHA(generatePassword()).substring(0, 31);
  }

  /**
   * Generates a random password with default length.
   *
   * @return String random password.
   * @author Adam Kowalewski
   * @version 2015.03.27
   */
  public static String generatePassword() {
    return getPassword(DEFAULT_PWD_LENGTH);
  }

  /**
   * Generates a random password.
   *
   * @param length length for password.
   * @return String random password.
   * @author Adam Kowalewski
   * @version 2015.03.27
   */
  public static String generatePassword(int length) {
    return getPassword(length);
  }

  private static String getPassword(int length) {
    SecureRandom random = new SecureRandom();
    String result = new BigInteger(130, random).toString(32);
    result = result.substring(0, Math.min(result.length(), length));
    return result;
  }

  /**
   * Generates a SHA-256 hash from the given String.
   *
   * @param value plain text password to be encrypted.
   * @return String hashed text.
   * @author Adam Kowalewski
   * @version 2015.03.27
   */
  public static String encryptSHA(String value) {
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
