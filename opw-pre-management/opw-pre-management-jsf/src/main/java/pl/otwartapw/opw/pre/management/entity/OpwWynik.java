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
package pl.otwartapw.opw.pre.management.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Adam Kowalewski
 */
@Entity
@Table(name = "opw_wynik", catalog = "opw_pre", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OpwWynik.findAll", query = "SELECT o FROM OpwWynik o"),
    @NamedQuery(name = "OpwWynik.findById", query = "SELECT o FROM OpwWynik o WHERE o.id = :id"),
    @NamedQuery(name = "OpwWynik.findByLUprawnionych", query = "SELECT o FROM OpwWynik o WHERE o.lUprawnionych = :lUprawnionych"),
    @NamedQuery(name = "OpwWynik.findByLKartWydanych", query = "SELECT o FROM OpwWynik o WHERE o.lKartWydanych = :lKartWydanych"),
    @NamedQuery(name = "OpwWynik.findByLKartWaznych", query = "SELECT o FROM OpwWynik o WHERE o.lKartWaznych = :lKartWaznych"),
    @NamedQuery(name = "OpwWynik.findByLGlosowNiewaznych", query = "SELECT o FROM OpwWynik o WHERE o.lGlosowNiewaznych = :lGlosowNiewaznych"),
    @NamedQuery(name = "OpwWynik.findByLGlosowWaznych", query = "SELECT o FROM OpwWynik o WHERE o.lGlosowWaznych = :lGlosowWaznych"),
    @NamedQuery(name = "OpwWynik.findByFileOriginal", query = "SELECT o FROM OpwWynik o WHERE o.fileOriginal = :fileOriginal"),
    @NamedQuery(name = "OpwWynik.findByActive", query = "SELECT o FROM OpwWynik o WHERE o.active = :active"),
    @NamedQuery(name = "OpwWynik.findByDateCreated", query = "SELECT o FROM OpwWynik o WHERE o.dateCreated = :dateCreated"),
    @NamedQuery(name = "OpwWynik.findByRatedPositiv", query = "SELECT o FROM OpwWynik o WHERE o.ratedPositiv = :ratedPositiv"),
    @NamedQuery(name = "OpwWynik.findByRatedNegativ", query = "SELECT o FROM OpwWynik o WHERE o.ratedNegativ = :ratedNegativ"),
    @NamedQuery(name = "OpwWynik.findByStatus", query = "SELECT o FROM OpwWynik o WHERE o.status = :status")})
public class OpwWynik implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "lUprawnionych")
    private Short lUprawnionych;
    @Column(name = "lKartWydanych")
    private Short lKartWydanych;
    @Column(name = "lKartWaznych")
    private Short lKartWaznych;
    @Column(name = "lGlosowNiewaznych")
    private Short lGlosowNiewaznych;
    @Column(name = "lGlosowWaznych")
    private Short lGlosowWaznych;
    @Size(max = 128)
    @Column(name = "fileOriginal", length = 128)
    private String fileOriginal;
    @Column(name = "active")
    private Boolean active;
    @Column(name = "dateCreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    @Column(name = "ratedPositiv")
    private Integer ratedPositiv;
    @Column(name = "ratedNegativ")
    private Integer ratedNegativ;
    @Column(name = "status")
    private Integer status;
    @JoinColumn(name = "opw_obwodowa_komisja_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private OpwObwodowaKomisja opwObwodowaKomisjaId;
    @JoinColumn(name = "opw_user_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private OpwUser opwUserId;
    @OneToMany(mappedBy = "parentId")
    private List<OpwWynik> opwWynikList;
    @JoinColumn(name = "parentId", referencedColumnName = "id")
    @ManyToOne
    private OpwWynik parentId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "opwWynikId")
    private List<OpwLink> opwLinkList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "opwWynik")
    private List<OpwWynikkandydata> opwWynikkandydataList;

    public OpwWynik() {
    }

    public OpwWynik(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Short getLUprawnionych() {
        return lUprawnionych;
    }

    public void setLUprawnionych(Short lUprawnionych) {
        this.lUprawnionych = lUprawnionych;
    }

    public Short getLKartWydanych() {
        return lKartWydanych;
    }

    public void setLKartWydanych(Short lKartWydanych) {
        this.lKartWydanych = lKartWydanych;
    }

    public Short getLKartWaznych() {
        return lKartWaznych;
    }

    public void setLKartWaznych(Short lKartWaznych) {
        this.lKartWaznych = lKartWaznych;
    }

    public Short getLGlosowNiewaznych() {
        return lGlosowNiewaznych;
    }

    public void setLGlosowNiewaznych(Short lGlosowNiewaznych) {
        this.lGlosowNiewaznych = lGlosowNiewaznych;
    }

    public Short getLGlosowWaznych() {
        return lGlosowWaznych;
    }

    public void setLGlosowWaznych(Short lGlosowWaznych) {
        this.lGlosowWaznych = lGlosowWaznych;
    }

    public String getFileOriginal() {
        return fileOriginal;
    }

    public void setFileOriginal(String fileOriginal) {
        this.fileOriginal = fileOriginal;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Integer getRatedPositiv() {
        return ratedPositiv;
    }

    public void setRatedPositiv(Integer ratedPositiv) {
        this.ratedPositiv = ratedPositiv;
    }

    public Integer getRatedNegativ() {
        return ratedNegativ;
    }

    public void setRatedNegativ(Integer ratedNegativ) {
        this.ratedNegativ = ratedNegativ;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public OpwObwodowaKomisja getOpwObwodowaKomisjaId() {
        return opwObwodowaKomisjaId;
    }

    public void setOpwObwodowaKomisjaId(OpwObwodowaKomisja opwObwodowaKomisjaId) {
        this.opwObwodowaKomisjaId = opwObwodowaKomisjaId;
    }

    public OpwUser getOpwUserId() {
        return opwUserId;
    }

    public void setOpwUserId(OpwUser opwUserId) {
        this.opwUserId = opwUserId;
    }

    @XmlTransient
    public List<OpwWynik> getOpwWynikList() {
        return opwWynikList;
    }

    public void setOpwWynikList(List<OpwWynik> opwWynikList) {
        this.opwWynikList = opwWynikList;
    }

    public OpwWynik getParentId() {
        return parentId;
    }

    public void setParentId(OpwWynik parentId) {
        this.parentId = parentId;
    }

    @XmlTransient
    public List<OpwLink> getOpwLinkList() {
        return opwLinkList;
    }

    public void setOpwLinkList(List<OpwLink> opwLinkList) {
        this.opwLinkList = opwLinkList;
    }

    @XmlTransient
    public List<OpwWynikkandydata> getOpwWynikkandydataList() {
        return opwWynikkandydataList;
    }

    public void setOpwWynikkandydataList(List<OpwWynikkandydata> opwWynikkandydataList) {
        this.opwWynikkandydataList = opwWynikkandydataList;
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
        if (!(object instanceof OpwWynik)) {
            return false;
        }
        OpwWynik other = (OpwWynik) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.otwartapw.opw.pre.management.entity.OpwWynik[ id=" + id + " ]";
    }
    
}
