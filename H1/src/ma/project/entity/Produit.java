/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.project.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Produit")
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int id;
    
    private String marque;
    private String référence;
    
    @Temporal(TemporalType.DATE)
    private Date DateAchat;

    private Double Prix;
    private String designation;
    
    public Produit() {
    }

    public Produit(String marque, String référence, Date DateAchat, Double Prix, String designation) {
        this.marque = marque;
        this.référence = référence;
        this.DateAchat = DateAchat;
        this.Prix = Prix;
        this.designation = designation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getRéférence() {
        return référence;
    }

    public void setRéférence(String référence) {
        this.référence = référence;
    }

    public Date getDateAchat() {
        return DateAchat;
    }

    public void setDateAchat(Date DateAchat) {
        this.DateAchat = DateAchat;
    }

    public Double getPrix() {
        return Prix;
    }

    public void setPrix(Double Prix) {
        this.Prix = Prix;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public String toString() {
        return "Produit{" + "marque=" + marque + ", r\u00e9f\u00e9rence=" + référence + ", DateAchat=" + DateAchat + ", Prix=" + Prix + ", designation=" + designation + '}';
    }

    
    
    
    
}
