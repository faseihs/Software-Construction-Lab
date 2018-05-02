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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "car", catalog = "car_rent", schema = "")
@NamedQueries({
    @NamedQuery(name = "Car.findAll", query = "SELECT c FROM Car c")
    , @NamedQuery(name = "Car.findByCId", query = "SELECT c FROM Car c WHERE c.cId = :cId")
    , @NamedQuery(name = "Car.findByCModel", query = "SELECT c FROM Car c WHERE c.cModel = :cModel")
    , @NamedQuery(name = "Car.findByCBrand", query = "SELECT c FROM Car c WHERE c.cBrand = :cBrand")
    , @NamedQuery(name = "Car.findByCColor", query = "SELECT c FROM Car c WHERE c.cColor = :cColor")
    , @NamedQuery(name = "Car.findByCInUse", query = "SELECT c FROM Car c WHERE c.cInUse = :cInUse")})
public class Car implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "c_id")
    private Integer cId;
    @Basic(optional = false)
    @Column(name = "c_model")
    private String cModel;
    @Basic(optional = false)
    @Column(name = "c_brand")
    private String cBrand;
    @Basic(optional = false)
    @Column(name = "c_color")
    private String cColor;
    @Basic(optional = false)
    @Column(name = "c_in_use")
    private boolean cInUse;

    public Car() {
    }

    public Car(Integer cId) {
        this.cId = cId;
    }

    public Car(Integer cId, String cModel, String cBrand, String cColor, boolean cInUse) {
        this.cId = cId;
        this.cModel = cModel;
        this.cBrand = cBrand;
        this.cColor = cColor;
        this.cInUse = cInUse;
    }

    public Integer getCId() {
        return cId;
    }

    public void setCId(Integer cId) {
        Integer oldCId = this.cId;
        this.cId = cId;
        changeSupport.firePropertyChange("CId", oldCId, cId);
    }

    public String getCModel() {
        return cModel;
    }

    public void setCModel(String cModel) {
        String oldCModel = this.cModel;
        this.cModel = cModel;
        changeSupport.firePropertyChange("CModel", oldCModel, cModel);
    }

    public String getCBrand() {
        return cBrand;
    }

    public void setCBrand(String cBrand) {
        String oldCBrand = this.cBrand;
        this.cBrand = cBrand;
        changeSupport.firePropertyChange("CBrand", oldCBrand, cBrand);
    }

    public String getCColor() {
        return cColor;
    }

    public void setCColor(String cColor) {
        String oldCColor = this.cColor;
        this.cColor = cColor;
        changeSupport.firePropertyChange("CColor", oldCColor, cColor);
    }

    public boolean getCInUse() {
        return cInUse;
    }

    public void setCInUse(boolean cInUse) {
        boolean oldCInUse = this.cInUse;
        this.cInUse = cInUse;
        changeSupport.firePropertyChange("CInUse", oldCInUse, cInUse);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cId != null ? cId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Car)) {
            return false;
        }
        Car other = (Car) object;
        if ((this.cId == null && other.cId != null) || (this.cId != null && !this.cId.equals(other.cId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "main.Car[ cId=" + cId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
