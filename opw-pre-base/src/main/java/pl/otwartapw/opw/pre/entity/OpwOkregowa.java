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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Adam Kowalewski
 */
@Entity
@Table(name = "opw_okregowa", catalog = "opwpre", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"pkwId"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OpwOkregowa.findAll", query = "SELECT o FROM OpwOkregowa o"),
    @NamedQuery(name = "OpwOkregowa.findById", query = "SELECT o FROM OpwOkregowa o WHERE o.id = :id"),
    @NamedQuery(name = "OpwOkregowa.findByPkwId", query = "SELECT o FROM OpwOkregowa o WHERE o.pkwId = :pkwId"),
    @NamedQuery(name = "OpwOkregowa.findByName", query = "SELECT o FROM OpwOkregowa o WHERE o.name = :name"),
    @NamedQuery(name = "OpwOkregowa.findByAddress", query = "SELECT o FROM OpwOkregowa o WHERE o.address = :address"),
    @NamedQuery(name = "OpwOkregowa.findByPowiaty", query = "SELECT o FROM OpwOkregowa o WHERE o.powiaty = :powiaty"),
    @NamedQuery(name = "OpwOkregowa.findByMiasta", query = "SELECT o FROM OpwOkregowa o WHERE o.miasta = :miasta")})
public class OpwOkregowa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "pkwId")
    private Integer pkwId;
    @Size(max = 128)
    @Column(name = "name", length = 128)
    private String name;
    @Size(max = 128)
    @Column(name = "address", length = 128)
    private String address;
    @Size(max = 128)
    @Column(name = "powiaty", length = 128)
    private String powiaty;
    @Size(max = 128)
    @Column(name = "miasta", length = 128)
    private String miasta;
    @JoinColumn(name = "opw_wojewodztwo_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private OpwWojewodztwo opwWojewodztwoId;

    public OpwOkregowa() {
    }

    public OpwOkregowa(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPkwId() {
        return pkwId;
    }

    public void setPkwId(Integer pkwId) {
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

    public String getPowiaty() {
        return powiaty;
    }

    public void setPowiaty(String powiaty) {
        this.powiaty = powiaty;
    }

    public String getMiasta() {
        return miasta;
    }

    public void setMiasta(String miasta) {
        this.miasta = miasta;
    }

    public OpwWojewodztwo getOpwWojewodztwoId() {
        return opwWojewodztwoId;
    }

    public void setOpwWojewodztwoId(OpwWojewodztwo opwWojewodztwoId) {
        this.opwWojewodztwoId = opwWojewodztwoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OpwOkregowa)) {
            return false;
        }
        OpwOkregowa other = (OpwOkregowa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.otwartapw.opw.pre.entity.OpwOkregowa[ id=" + id + " ]";
    }
    
}
