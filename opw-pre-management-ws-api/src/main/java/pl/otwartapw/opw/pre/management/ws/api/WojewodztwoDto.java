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
package pl.otwartapw.opw.pre.management.ws.api;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * DTO represents Wojewodztwo.
 *
 * @author Adam Kowalewski
 * @version 2015.10.23
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class WojewodztwoDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    @Size(max = 64)
    private String name;

    @NotNull
    @Size(max = 2)
    private String teryt;

    public WojewodztwoDto() {
    }

    public WojewodztwoDto(String name, String teryt) {
        this.name = name;
        this.teryt = teryt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeryt() {
        return teryt;
    }

    public void setTeryt(String teryt) {
        this.teryt = teryt;
    }

    @Override
    public String toString() {
        return "WojewodztwoDto{"
                + "name=" + name
                + ", teryt=" + teryt
                + '}';
    }

}
