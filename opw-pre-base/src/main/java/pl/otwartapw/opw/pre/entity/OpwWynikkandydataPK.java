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
package pl.otwartapw.opw.pre.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Adam Kowalewski
 */
@Embeddable
public class OpwWynikkandydataPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "opw_kandydat_id", nullable = false)
    private int opwKandydatId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "opw_protokol_id", nullable = false)
    private int opwProtokolId;

    public OpwWynikkandydataPK() {
    }

    public OpwWynikkandydataPK(int opwKandydatId, int opwProtokolId) {
        this.opwKandydatId = opwKandydatId;
        this.opwProtokolId = opwProtokolId;
    }

    public int getOpwKandydatId() {
        return opwKandydatId;
    }

    public void setOpwKandydatId(int opwKandydatId) {
        this.opwKandydatId = opwKandydatId;
    }

    public int getOpwProtokolId() {
        return opwProtokolId;
    }

    public void setOpwProtokolId(int opwProtokolId) {
        this.opwProtokolId = opwProtokolId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) opwKandydatId;
        hash += (int) opwProtokolId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OpwWynikkandydataPK)) {
            return false;
        }
        OpwWynikkandydataPK other = (OpwWynikkandydataPK) object;
        if (this.opwKandydatId != other.opwKandydatId) {
            return false;
        }
        if (this.opwProtokolId != other.opwProtokolId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.otwartapw.opw.pre.entity.OpwWynikkandydataPK[ opwKandydatId=" + opwKandydatId + ", opwProtokolId=" + opwProtokolId + " ]";
    }
    
}
