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
package pl.otwartapw.opw.pre.inbound.ws.api.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Represents a Komisja Obwodowa.
 *
 * @author Adam Kowalewski
 * @version 2015.10.19
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ObwodowaDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String pkwId;
    private String name;
    private String address;
    private OkregowaDto okregowa;
    private List<KandydatDto> kandydatList;
    private List<ProtokolDto> protokolList;

    public ObwodowaDto() {
        this.kandydatList = new ArrayList<>();
        this.protokolList = new ArrayList<>();
    }

    public ObwodowaDto(String pkwId, String name, String address, OkregowaDto okregowa, List<KandydatDto> kandydatList, List<ProtokolDto> protokolList) {
        this.pkwId = pkwId;
        this.name = name;
        this.address = address;
        this.okregowa = okregowa;
        this.kandydatList = kandydatList;
        this.protokolList = protokolList;
    }

    public String getPkwId() {
        return pkwId;
    }

    public void setPkwId(String pkwId) {
        this.pkwId = pkwId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public OkregowaDto getOkregowa() {
        return okregowa;
    }

    public void setOkregowa(OkregowaDto okregowa) {
        this.okregowa = okregowa;
    }

    public List<KandydatDto> getKandydatList() {
        return kandydatList;
    }

    public void setKandydatList(List<KandydatDto> kandydatList) {
        this.kandydatList = kandydatList;
    }

    public List<ProtokolDto> getProtokolList() {
        return protokolList;
    }

    public void setProtokolList(List<ProtokolDto> protokolList) {
        this.protokolList = protokolList;
    }

    @Override
    public String toString() {
        return "ObwodowaDto{"
                + "pkwId=" + pkwId
                + ", name=" + name
                + ", address=" + address
                + ", okregowa=" + okregowa
                + ", kandydatList=" + kandydatList
                + ", protokolList=" + protokolList
                + '}';
    }

}
