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
package pl.otwartapw.opw.pre.inbound.ws.api.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * DTO represents OPW user in client applications.
 *
 * @author Adam Kowalewski
 * @version 2016.08.24
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class UserDto implements Serializable {

  private static final long serialVersionUID = 1L;

  private int id;
  private String firstname;
  private String lastname;
  private String email;
  private String sessionToken;
  private Date sessionTimeout;

  private List<String> groupList = new ArrayList<>();

  public UserDto() {
  }

  public UserDto(int id, String firstname, String lastname, String email, String sessionToken, Date sessionTimeout) {
    this.id = id;
    this.firstname = firstname;
    this.lastname = lastname;
    this.email = email;
    this.sessionToken = sessionToken;
    this.sessionTimeout = sessionTimeout;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getSessionToken() {
    return sessionToken;
  }

  public void setSessionToken(String sessionToken) {
    this.sessionToken = sessionToken;
  }

  public Date getSessionTimeout() {
    return sessionTimeout;
  }

  public void setSessionTimeout(Date sessionTimeout) {
    this.sessionTimeout = sessionTimeout;
  }

  public List<String> getGroupList() {
    return groupList;
  }

  public void setGroupList(List<String> groupList) {
    this.groupList = groupList;
  }

  @Override
  public String toString() {
    return "UserDto{" + "id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email + ", sessionToken=" + sessionToken + ", sessionTimeout=" + sessionTimeout + ", groupList=" + groupList + '}';
  }

}
