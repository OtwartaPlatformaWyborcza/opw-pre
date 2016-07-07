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

import javax.ws.rs.core.Response;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;
import pl.otwartapw.opw.pre.commons.version.VersionDto;
import pl.otwartapw.opw.pre.register.ws.api.PersonDto;
import pl.otwartapw.opw.pre.register.ws.api.RegisterApi;

/**
 *
 * @author Adam Kowalewski
 */
@RunWith(MockitoJUnitRunner.class)
public class RegisterClientTest {

  @Mock
  ClientFactory clientFactory;

  private final String serviceUrlMock = "http://localhost";

  public RegisterClientTest() {
  }

  @Test
  public void testRegister() {
    System.out.println("test register");
    // mocks
    PersonDto person = new PersonDto("fn", "ln", "tel", "pwd", "email");
    RegisterApi registerApiMock = mock(RegisterApi.class);
    when(clientFactory.getClient(serviceUrlMock)).thenReturn(registerApiMock);
    when(registerApiMock.register(person)).thenReturn(Response.Status.OK);

    // when
    RegisterClient sut = new RegisterClient(serviceUrlMock, clientFactory);

    // expect 
    assertEquals(sut.register(person), Response.Status.OK);
  }

  @Test
  public void testVersion() {
    System.out.println("test version");
    // mocks    
    VersionDto expResult = new VersionDto("name", "0.1.0");
    RegisterApi registerApiMock = mock(RegisterApi.class);
    when(clientFactory.getClient(serviceUrlMock)).thenReturn(registerApiMock);
    when(registerApiMock.version()).thenReturn(expResult);

    // when
    RegisterClient sut = new RegisterClient(serviceUrlMock, clientFactory);

    // expect
    assertEquals(sut.version().getArtifactId(), expResult.getArtifactId());
    System.out.println("sut.version().getVersion()" + sut.version().getVersion());
    assertEquals(sut.version().getVersion(), expResult.getVersion());
  }

}
