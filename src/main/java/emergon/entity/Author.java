/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kkats
 */
@Entity
@Table(name = "author")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Author.findAll", query = "SELECT a FROM Author a")
    , @NamedQuery(name = "Author.findById", query = "SELECT a FROM Author a WHERE a.id = :id")
    , @NamedQuery(name = "Author.findByName", query = "SELECT a FROM Author a WHERE a.name = :name")
    , @NamedQuery(name = "Author.findByStathero", query = "SELECT a FROM Author a WHERE a.stathero = :stathero")
    , @NamedQuery(name = "Author.findByKinito", query = "SELECT a FROM Author a WHERE a.kinito = :kinito")
    , @NamedQuery(name = "Author.findByPerioxi", query = "SELECT a FROM Author a WHERE a.perioxi = :perioxi")
    , @NamedQuery(name = "Author.findByEidospolisis", query = "SELECT a FROM Author a WHERE a.eidospolisis = :eidospolisis")
    , @NamedQuery(name = "Author.findByNotes", query = "SELECT a FROM Author a WHERE a.notes = :notes")
    , @NamedQuery(name = "Author.findByMylead", query = "SELECT a FROM Author a WHERE a.mylead = :mylead")
    , @NamedQuery(name = "Author.findByMydate", query = "SELECT a FROM Author a WHERE a.mydate = :mydate")})
public class Author implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    
    @Size(max = 45)
    @NotNull
    @NotEmpty
    @Column(name = "name")
    private String name;
    
    @Size(max = 10)
    @NotNull
    @NotEmpty
    @Column(name = "stathero")
    private String stathero;
    
    @Size(max = 10)
    @NotNull
    @NotEmpty
    @Column(name = "kinito")
    private String kinito;
    
    @Size(max = 20)
    @NotNull
    @NotEmpty
    @Column(name = "perioxi")
    private String perioxi;
    
    @Size(max = 45)    
    @Column(name = "eidospolisis")
    private String eidospolisis;
    
    @Size(max = 1000)
    @NotNull
    @NotEmpty
    @Column(name = "notes")
    private String notes;
    
    @Size(max = 45)    
    @Column(name = "mylead")
    private String mylead;
    
    @Size(max = 20)
    @NotNull
    @NotEmpty
    @Column(name = "mydate")
    private String mydate;

    public Author() {
    }

    public Author(Integer id) {
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

    public String getStathero() {
        return stathero;
    }

    public void setStathero(String stathero) {
        this.stathero = stathero;
    }

    public String getKinito() {
        return kinito;
    }

    public void setKinito(String kinito) {
        this.kinito = kinito;
    }

    public String getPerioxi() {
        return perioxi;
    }

    public void setPerioxi(String perioxi) {
        this.perioxi = perioxi;
    }

    public String getEidospolisis() {
        return eidospolisis;
    }

    public void setEidospolisis(String eidospolisis) {
        this.eidospolisis = eidospolisis;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getMylead() {
        return mylead;
    }

    public void setMylead(String mylead) {
        this.mylead = mylead;
    }

    public String getMydate() {
        return mydate;
    }

    public void setMydate(String mydate) {
        this.mydate = mydate;
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
        if (!(object instanceof Author)) {
            return false;
        }
        Author other = (Author) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "emergon.entity.Author[ id=" + id + " ]";
    }
    
}
