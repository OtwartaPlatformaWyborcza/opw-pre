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
import java.util.Date;
import java.util.List;
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
@Table(name = "opw_protokol", catalog = "opwpre", schema = "")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "OpwProtokol.findAll", query = "SELECT o FROM OpwProtokol o"),
  @NamedQuery(name = "OpwProtokol.findById", query = "SELECT o FROM OpwProtokol o WHERE o.id = :id"),
  @NamedQuery(name = "OpwProtokol.findByPkwId", query = "SELECT o FROM OpwProtokol o WHERE o.pkwId = :pkwId"),
  @NamedQuery(name = "OpwProtokol.findByUprawnionych", query = "SELECT o FROM OpwProtokol o WHERE o.uprawnionych = :uprawnionych"),
  @NamedQuery(name = "OpwProtokol.findByKartWaznych", query = "SELECT o FROM OpwProtokol o WHERE o.kartWaznych = :kartWaznych"),
  @NamedQuery(name = "OpwProtokol.findByKartNiewaznych", query = "SELECT o FROM OpwProtokol o WHERE o.kartNiewaznych = :kartNiewaznych"),
  @NamedQuery(name = "OpwProtokol.findByGlosowWaznych", query = "SELECT o FROM OpwProtokol o WHERE o.glosowWaznych = :glosowWaznych"),
  @NamedQuery(name = "OpwProtokol.findByGlosowNiewaznych", query = "SELECT o FROM OpwProtokol o WHERE o.glosowNiewaznych = :glosowNiewaznych"),
  @NamedQuery(name = "OpwProtokol.findByFileOriginal", query = "SELECT o FROM OpwProtokol o WHERE o.fileOriginal = :fileOriginal"),
  @NamedQuery(name = "OpwProtokol.findByActive", query = "SELECT o FROM OpwProtokol o WHERE o.active = :active"),
  @NamedQuery(name = "OpwProtokol.findByDateCreated", query = "SELECT o FROM OpwProtokol o WHERE o.dateCreated = :dateCreated"),
  @NamedQuery(name = "OpwProtokol.findByDateModified", query = "SELECT o FROM OpwProtokol o WHERE o.dateModified = :dateModified")})
public class OpwProtokol implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id", nullable = false)
  private Integer id;
  @Size(max = 64)
  @Column(name = "pkwId", length = 64)
  private String pkwId;
  @Column(name = "uprawnionych")
  private Integer uprawnionych;
  @Column(name = "kartWaznych")
  private Integer kartWaznych;
  @Column(name = "kartNiewaznych")
  private Integer kartNiewaznych;
  @Column(name = "glosowWaznych")
  private Integer glosowWaznych;
  @Column(name = "glosowNiewaznych")
  private Integer glosowNiewaznych;
  @Size(max = 256)
  @Column(name = "fileOriginal", length = 256)
  private String fileOriginal;
  @Column(name = "active")
  private Boolean active;
  @Column(name = "dateCreated")
  @Temporal(TemporalType.TIMESTAMP)
  private Date dateCreated;
  @Column(name = "dateModified")
  @Temporal(TemporalType.TIMESTAMP)
  private Date dateModified;
  @JoinColumn(name = "opw_obwodowa_id", referencedColumnName = "id", nullable = false)
  @ManyToOne(optional = false)
  private OpwObwodowa opwObwodowaId;
  @OneToMany(mappedBy = "parentId")
  private List<OpwProtokol> opwProtokolList;
  @JoinColumn(name = "parent_id", referencedColumnName = "id")
  @ManyToOne
  private OpwProtokol parentId;
  @JoinColumn(name = "opw_status_id", referencedColumnName = "id")
  @ManyToOne
  private OpwStatus opwStatusId;
  @JoinColumn(name = "opw_user_id", referencedColumnName = "id", nullable = false)
  @ManyToOne(optional = false)
  private OpwUser opwUserId;

  public OpwProtokol() {
  }

  public OpwProtokol(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getPkwId() {
    return pkwId;
  }

  public void setPkwId(String pkwId) {
    this.pkwId = pkwId;
  }

  public Integer getUprawnionych() {
    return uprawnionych;
  }

  public void setUprawnionych(Integer uprawnionych) {
    this.uprawnionych = uprawnionych;
  }

  public Integer getKartWaznych() {
    return kartWaznych;
  }

  public void setKartWaznych(Integer kartWaznych) {
    this.kartWaznych = kartWaznych;
  }

  public Integer getKartNiewaznych() {
    return kartNiewaznych;
  }

  public void setKartNiewaznych(Integer kartNiewaznych) {
    this.kartNiewaznych = kartNiewaznych;
  }

  public Integer getGlosowWaznych() {
    return glosowWaznych;
  }

  public void setGlosowWaznych(Integer glosowWaznych) {
    this.glosowWaznych = glosowWaznych;
  }

  public Integer getGlosowNiewaznych() {
    return glosowNiewaznych;
  }

  public void setGlosowNiewaznych(Integer glosowNiewaznych) {
    this.glosowNiewaznych = glosowNiewaznych;
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

  public Date getDateModified() {
    return dateModified;
  }

  public void setDateModified(Date dateModified) {
    this.dateModified = dateModified;
  }

  public OpwObwodowa getOpwObwodowaId() {
    return opwObwodowaId;
  }

  public void setOpwObwodowaId(OpwObwodowa opwObwodowaId) {
    this.opwObwodowaId = opwObwodowaId;
  }

  @XmlTransient
  public List<OpwProtokol> getOpwProtokolList() {
    return opwProtokolList;
  }

  public void setOpwProtokolList(List<OpwProtokol> opwProtokolList) {
    this.opwProtokolList = opwProtokolList;
  }

  public OpwProtokol getParentId() {
    return parentId;
  }

  public void setParentId(OpwProtokol parentId) {
    this.parentId = parentId;
  }

  public OpwStatus getOpwStatusId() {
    return opwStatusId;
  }

  public void setOpwStatusId(OpwStatus opwStatusId) {
    this.opwStatusId = opwStatusId;
  }

  public OpwUser getOpwUserId() {
    return opwUserId;
  }

  public void setOpwUserId(OpwUser opwUserId) {
    this.opwUserId = opwUserId;
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
    if (!(object instanceof OpwProtokol)) {
      return false;
    }
    OpwProtokol other = (OpwProtokol) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "pl.otwartapw.opw.pre.entity.OpwProtokol[ id=" + id + " ]";
  }
  
}
