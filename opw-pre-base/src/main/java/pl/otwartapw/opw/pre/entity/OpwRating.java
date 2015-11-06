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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Adam Kowalewski
 */
@Entity
@Table(name = "opw_rating", catalog = "opwpre", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OpwRating.findAll", query = "SELECT o FROM OpwRating o"),
    @NamedQuery(name = "OpwRating.findById", query = "SELECT o FROM OpwRating o WHERE o.id = :id"),
    @NamedQuery(name = "OpwRating.findByPositiv", query = "SELECT o FROM OpwRating o WHERE o.positiv = :positiv"),
    @NamedQuery(name = "OpwRating.findByActive", query = "SELECT o FROM OpwRating o WHERE o.active = :active"),
    @NamedQuery(name = "OpwRating.findByDateCreated", query = "SELECT o FROM OpwRating o WHERE o.dateCreated = :dateCreated")})
public class OpwRating implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "positiv")
    private Boolean positiv;
    @Column(name = "active")
    private Boolean active;
    @Column(name = "dateCreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    @JoinColumn(name = "opw_protokol_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private OpwProtokol opwProtokolId;
    @JoinColumn(name = "opw_user_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private OpwUser opwUserId;

    public OpwRating() {
    }

    public OpwRating(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getPositiv() {
        return positiv;
    }

    public void setPositiv(Boolean positiv) {
        this.positiv = positiv;
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

    public OpwProtokol getOpwProtokolId() {
        return opwProtokolId;
    }

    public void setOpwProtokolId(OpwProtokol opwProtokolId) {
        this.opwProtokolId = opwProtokolId;
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
        if (!(object instanceof OpwRating)) {
            return false;
        }
        OpwRating other = (OpwRating) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.otwartapw.opw.pre.entity.OpwRating[ id=" + id + " ]";
    }
    
}
