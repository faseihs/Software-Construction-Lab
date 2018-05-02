/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Adnan Iqbal Khan
 */
@Entity
@Table(name = "user", catalog = "car_rent", schema = "")
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
    , @NamedQuery(name = "User.findByUId", query = "SELECT u FROM User u WHERE u.uId = :uId")
    , @NamedQuery(name = "User.findByUName", query = "SELECT u FROM User u WHERE u.uName = :uName")
    , @NamedQuery(name = "User.findByUEmail", query = "SELECT u FROM User u WHERE u.uEmail = :uEmail")
    , @NamedQuery(name = "User.findByUContact", query = "SELECT u FROM User u WHERE u.uContact = :uContact")
    , @NamedQuery(name = "User.findByUPassword", query = "SELECT u FROM User u WHERE u.uPassword = :uPassword")})
public class User implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "u_id")
    private Integer uId;
    @Basic(optional = false)
    @Column(name = "u_name")
    private String uName;
    @Basic(optional = false)
    @Column(name = "u_email")
    private String uEmail;
    @Basic(optional = false)
    @Column(name = "u_contact")
    private int uContact;
    @Basic(optional = false)
    @Column(name = "u_password")
    private String uPassword;

    public User() {
    }

    public User(Integer uId) {
        this.uId = uId;
    }

    public User(Integer uId, String uName, String uEmail, int uContact, String uPassword) {
        this.uId = uId;
        this.uName = uName;
        this.uEmail = uEmail;
        this.uContact = uContact;
        this.uPassword = uPassword;
    }

    public Integer getUId() {
        return uId;
    }

    public void setUId(Integer uId) {
        Integer oldUId = this.uId;
        this.uId = uId;
        changeSupport.firePropertyChange("UId", oldUId, uId);
    }

    public String getUName() {
        return uName;
    }

    public void setUName(String uName) {
        String oldUName = this.uName;
        this.uName = uName;
        changeSupport.firePropertyChange("UName", oldUName, uName);
    }

    public String getUEmail() {
        return uEmail;
    }

    public void setUEmail(String uEmail) {
        String oldUEmail = this.uEmail;
        this.uEmail = uEmail;
        changeSupport.firePropertyChange("UEmail", oldUEmail, uEmail);
    }

    public int getUContact() {
        return uContact;
    }

    public void setUContact(int uContact) {
        int oldUContact = this.uContact;
        this.uContact = uContact;
        changeSupport.firePropertyChange("UContact", oldUContact, uContact);
    }

    public String getUPassword() {
        return uPassword;
    }

    public void setUPassword(String uPassword) {
        String oldUPassword = this.uPassword;
        this.uPassword = uPassword;
        changeSupport.firePropertyChange("UPassword", oldUPassword, uPassword);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uId != null ? uId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.uId == null && other.uId != null) || (this.uId != null && !this.uId.equals(other.uId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "main.User[ uId=" + uId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
