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
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Adam Kowalewski
 */
@Entity
@Table(name = "opw_group", catalog = "opwpre", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OpwGroup.findAll", query = "SELECT o FROM OpwGroup o"),
    @NamedQuery(name = "OpwGroup.findById", query = "SELECT o FROM OpwGroup o WHERE o.id = :id"),
    @NamedQuery(name = "OpwGroup.findByName", query = "SELECT o FROM OpwGroup o WHERE o.name = :name"),
    @NamedQuery(name = "OpwGroup.findByDescription", query = "SELECT o FROM OpwGroup o WHERE o.description = :description")})
public class OpwGroup implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Size(max = 64)
    @Column(name = "name", length = 64)
    private String name;
    @Size(max = 64)
    @Column(name = "description", length = 64)
    private String description;
    @JoinTable(name = "opw_user_has_opw_group", joinColumns = {
        @JoinColumn(name = "opw_group_id", referencedColumnName = "id", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "opw_user_id", referencedColumnName = "id", nullable = false)})
    @ManyToMany
    private List<OpwUser> opwUserList;
    @JoinTable(name = "opw_group_has_opw_permission", joinColumns = {
        @JoinColumn(name = "opw_group_id", referencedColumnName = "id", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "opw_permission_id", referencedColumnName = "id", nullable = false)})
    @ManyToMany
    private List<OpwPermission> opwPermissionList;

    public OpwGroup() {
    }

    public OpwGroup(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public List<OpwUser> getOpwUserList() {
        return opwUserList;
    }

    public void setOpwUserList(List<OpwUser> opwUserList) {
        this.opwUserList = opwUserList;
    }

    @XmlTransient
    public List<OpwPermission> getOpwPermissionList() {
        return opwPermissionList;
    }

    public void setOpwPermissionList(List<OpwPermission> opwPermissionList) {
        this.opwPermissionList = opwPermissionList;
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
        if (!(object instanceof OpwGroup)) {
            return false;
        }
        OpwGroup other = (OpwGroup) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.otwartapw.opw.pre.entity.OpwGroup[ id=" + id + " ]";
    }
    
}
