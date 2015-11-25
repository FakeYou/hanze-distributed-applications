/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.hanze.distrans.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author zech
 */
@Entity
@Table(name = "t2")
@NamedQueries({
    @NamedQuery(name = "T2.findAll", query = "SELECT t FROM T2 t"),
    @NamedQuery(name = "T2.findByT2id", query = "SELECT t FROM T2 t WHERE t.t2id = :t2id"),
    @NamedQuery(name = "T2.findByT2number", query = "SELECT t FROM T2 t WHERE t.t2number = :t2number")})
public class T2 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "t2id")
    private Integer t2id;
    @Column(name = "t2number")
    private Integer t2number;

    public T2() {
    }

    public T2(Integer t2id) {
        this.t2id = t2id;
    }

    public Integer getT2id() {
        return t2id;
    }

    public void setT2id(Integer t2id) {
        this.t2id = t2id;
    }

    public Integer getT2number() {
        return t2number;
    }

    public void setT2number(Integer t2number) {
        this.t2number = t2number;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (t2id != null ? t2id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof T2)) {
            return false;
        }
        T2 other = (T2) object;
        if ((this.t2id == null && other.t2id != null) || (this.t2id != null && !this.t2id.equals(other.t2id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "nl.hanze.distrans.entity.T2[ t2id=" + t2id + " ]";
    }
    
}
