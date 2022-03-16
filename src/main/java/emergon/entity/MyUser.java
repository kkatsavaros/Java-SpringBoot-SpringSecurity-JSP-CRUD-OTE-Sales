/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.entity;

import java.io.Serializable;
import java.util.ArrayList;
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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author user
 */
@Entity
@Table(name = "myuser")
/*@XmlRootElement*/
@NamedQueries({
    @NamedQuery(name = "MyUser.findAll", query = "SELECT m FROM MyUser m")
    , @NamedQuery(name = "MyUser.findByUid", query = "SELECT m FROM MyUser m WHERE m.uid = :uid")
    , @NamedQuery(name = "MyUser.findByUsername", query = "SELECT m FROM MyUser m WHERE m.username = :username")
    , @NamedQuery(name = "MyUser.findByPassword", query = "SELECT m FROM MyUser m WHERE m.password = :password")
    , @NamedQuery(name = "MyUser.findByFname", query = "SELECT m FROM MyUser m WHERE m.fname = :fname")
    , @NamedQuery(name = "MyUser.findByLname", query = "SELECT m FROM MyUser m WHERE m.lname = :lname")
    , @NamedQuery(name = "MyUser.findByEmail", query = "SELECT m FROM MyUser m WHERE m.email = :email")})
public class MyUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "uid")
    private Integer uid;
    
    @Basic(optional = false)
    @Column(name = "username", unique = true)
    @NotEmpty(message = "Username is required!")
    private String username;
    
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    
    @Basic(optional = false)
    @Column(name = "fname")
    private String fname;
    
    @Basic(optional = false)
    @Column(name = "lname")
    private String lname;
    
    @Basic(optional = false)
    @Column(name = "email")
    @Email
    private String email;
    
    @ManyToMany
    @JoinTable(name = "user_role", // name of the DB table
            joinColumns = {@JoinColumn(name = "uid", referencedColumnName = "uid")}, // fk of Table user_role
            inverseJoinColumns = {@JoinColumn(name = "rid", referencedColumnName = "rid")}) // fk of the other side
    
    private List<Role> roles;
    
    //---------------------------------------------------------------------------------------------------------------------
    // Constructors
    //---------------------------------------------------------------------------------------------------------------------
    
    public MyUser() {
    }

    public MyUser(Integer uid) {
        this.uid = uid;
    }

    public MyUser(Integer uid, String username, String password, String fname, String lname, String email) {
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
    }
    
    //---------------------------------------------------------------------------------------------------------------------

    public MyUser(Integer uid, String username) {
        this.uid = uid;
        this.username = username;
    }
    
    //---------------------------------------------------------------------------------------------------------------------
    
    
    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //@XmlTransient
    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
    
    
    
    
    
    
    //64. - 16
    //----------------------------------------------------------------------------------
    public void addRole(Role role){
        // Αν έχουμε να κάνουμε με καινούργιο χρήστη, τότε αρχικοποίησε την λίστα
        // και πρόσθεσε αυτόν τον ρόλο.
        if (roles==null){
            roles=new ArrayList();
        }
        
        roles.add(role);
        
    }
    //-----------------------------------------------------------------------------------
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uid != null ? uid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MyUser)) {
            return false;
        }
        MyUser other = (MyUser) object;
        if ((this.uid == null && other.uid != null) || (this.uid != null && !this.uid.equals(other.uid))) {
            return false;
        }
        return true;
    }

//    @Override
//    public String toString() {
//        return "emergon.entity.MyUser[ uid=" + uid + " ]";
//    }

    
    // //64. - 13
    @Override
    public String toString() {
        return "MyUser{" + "uid=" + uid + ", username=" + username + ", password=" + password + ", fname=" + fname + ", lname=" + lname + ", email=" + email + '}';
    }
    
    
    
}
