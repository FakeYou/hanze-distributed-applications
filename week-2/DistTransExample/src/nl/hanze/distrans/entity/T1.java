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
@Table(name = "T1")
@NamedQueries({
    @NamedQuery(name = "T1.findAll", query = "SELECT t FROM T1 t"),
    @NamedQuery(name = "T1.findByT1id", query = "SELECT t FROM T1 t WHERE t.t1id = :t1id"),
    @NamedQuery(name = "T1.findByT1number", query = "SELECT t FROM T1 t WHERE t.t1number = :t1number")})
public class T1 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "T1ID")
    private Integer t1id;
    @Column(name = "T1NUMBER")
    private Integer t1number;

    public T1() {
    }

    public T1(Integer t1id) {
        this.t1id = t1id;
    }

    public Integer getT1id() {
        return t1id;
    }

    public void setT1id(Integer t1id) {
        this.t1id = t1id;
    }

    public Integer getT1number() {
        return t1number;
    }

    public void setT1number(Integer t1number) {
        this.t1number = t1number;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (t1id != null ? t1id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof T1)) {
            return false;
        }
        T1 other = (T1) object;
        if ((this.t1id == null && other.t1id != null) || (this.t1id != null && !this.t1id.equals(other.t1id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "nl.hanze.distrans.entity.T1[ t1id=" + t1id + " ]";
    }
    
}
