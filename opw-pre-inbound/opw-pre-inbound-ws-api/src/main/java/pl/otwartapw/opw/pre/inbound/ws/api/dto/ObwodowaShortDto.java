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
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * DTO represents a single row in Komisja Obwodowa table.
 *
 * @author Adam Kowalewski
 * @version 2015.10.19
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ObwodowaShortDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String pkwId;
    private String name;
    private String address;
    private int protokolCount;

    public ObwodowaShortDto() {
    }

    public ObwodowaShortDto(int id, String pkwId, String name, String address, int protokolCount) {
        this.id = id;
        this.pkwId = pkwId;
        this.name = name;
        this.address = address;
        this.protokolCount = protokolCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getProtokolCount() {
        return protokolCount;
    }

    public void setProtokolCount(int protokolCount) {
        this.protokolCount = protokolCount;
    }

    @Override
    public String toString() {
        return "ObwodowaShortDto{"
                + "id=" + id
                + ", pkwId=" + pkwId
                + ", name=" + name
                + ", address=" + address
                + ", protokolCount=" + protokolCount
                + '}';
    }

}
