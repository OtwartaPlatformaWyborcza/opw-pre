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
package pl.otwartapw.opw.pre.inbound.ws;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.otwartapw.opw.pre.inbound.ws.api.ObwodowaApi;
import pl.otwartapw.opw.pre.inbound.ws.api.dto.ObwodowaDto;
import pl.otwartapw.opw.pre.inbound.ws.api.dto.ObwodowaShortDto;
import pl.otwartapw.opw.pre.inbound.ws.api.dto.ProtokolDto;

/**
 * Komisja Obwodowa REST resource implementation.
 *
 * @author Adam Kowalewski
 */
public class ObwodowaResource implements Serializable, ObwodowaApi {

  private static final long serialVersionUID = 1L;
  private final Logger log = LoggerFactory.getLogger(this.getClass());

  @EJB
  private ObwodowaService service;

  @Override
  public List<ObwodowaDto> getObwodowaList() {
    log.info("getObwodowaList");
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public List<ObwodowaShortDto> getObwodowaShortList() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public ObwodowaDto getObwodowa(String pkwId) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public List<ProtokolDto> getObwodowaProtokolList(String pkwId) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public ProtokolDto postObwodowaProtokol(String pkwId, ProtokolDto protokolDto) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

}
