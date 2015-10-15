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
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Adam Kowalewski
 */
@Entity
@Table(name = "opw_wynikkandydata", catalog = "opw_pre", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OpwWynikkandydata.findAll", query = "SELECT o FROM OpwWynikkandydata o"),
    @NamedQuery(name = "OpwWynikkandydata.findByOpwKandydatId", query = "SELECT o FROM OpwWynikkandydata o WHERE o.opwWynikkandydataPK.opwKandydatId = :opwKandydatId"),
    @NamedQuery(name = "OpwWynikkandydata.findByOpwWynikId", query = "SELECT o FROM OpwWynikkandydata o WHERE o.opwWynikkandydataPK.opwWynikId = :opwWynikId"),
    @NamedQuery(name = "OpwWynikkandydata.findByGlosow", query = "SELECT o FROM OpwWynikkandydata o WHERE o.glosow = :glosow")})
public class OpwWynikkandydata implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OpwWynikkandydataPK opwWynikkandydataPK;
    @Column(name = "glosow")
    private Integer glosow;
    @JoinColumn(name = "opw_kandydat_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private OpwKandydat opwKandydat;
    @JoinColumn(name = "opw_wynik_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private OpwWynik opwWynik;

    public OpwWynikkandydata() {
    }

    public OpwWynikkandydata(OpwWynikkandydataPK opwWynikkandydataPK) {
        this.opwWynikkandydataPK = opwWynikkandydataPK;
    }

    public OpwWynikkandydata(int opwKandydatId, int opwWynikId) {
        this.opwWynikkandydataPK = new OpwWynikkandydataPK(opwKandydatId, opwWynikId);
    }

    public OpwWynikkandydataPK getOpwWynikkandydataPK() {
        return opwWynikkandydataPK;
    }

    public void setOpwWynikkandydataPK(OpwWynikkandydataPK opwWynikkandydataPK) {
        this.opwWynikkandydataPK = opwWynikkandydataPK;
    }

    public Integer getGlosow() {
        return glosow;
    }

    public void setGlosow(Integer glosow) {
        this.glosow = glosow;
    }

    public OpwKandydat getOpwKandydat() {
        return opwKandydat;
    }

    public void setOpwKandydat(OpwKandydat opwKandydat) {
        this.opwKandydat = opwKandydat;
    }

    public OpwWynik getOpwWynik() {
        return opwWynik;
    }

    public void setOpwWynik(OpwWynik opwWynik) {
        this.opwWynik = opwWynik;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (opwWynikkandydataPK != null ? opwWynikkandydataPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OpwWynikkandydata)) {
            return false;
        }
        OpwWynikkandydata other = (OpwWynikkandydata) object;
        if ((this.opwWynikkandydataPK == null && other.opwWynikkandydataPK != null) || (this.opwWynikkandydataPK != null && !this.opwWynikkandydataPK.equals(other.opwWynikkandydataPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.otwartapw.opw.pre.entity.OpwWynikkandydata[ opwWynikkandydataPK=" + opwWynikkandydataPK + " ]";
    }
    
}
