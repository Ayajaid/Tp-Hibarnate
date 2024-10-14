/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.project.entities;

import java.util.Date;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author ACER
 */
@Entity
public class EmployeTache {

    @EmbeddedId
    private EmployeTacheId id;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateDebutReelle;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateFinReelle;

    @JoinColumn(name = "employe_id", insertable = false, updatable = false)
    @ManyToOne
    private Employe employe;

    @JoinColumn(name = "tache_id", insertable = false, updatable = false)
    @ManyToOne
    private Tache tache;

    public EmployeTache() {
    }

    public EmployeTache(Date dateDebutReelle, Date dateFinReelle, Employe employe, Tache tache) {
        EmployeTacheId id = new EmployeTacheId(employe.getId(),tache.getId());
        this.id = id;
        this.dateDebutReelle = dateDebutReelle;
        this.dateFinReelle = dateFinReelle;
        this.employe = employe;
        this.tache = tache;
    }

    @Override
    public String toString() {
        return "EmployeTache{" + "id=" + id + ", dateDebutReelle=" + dateDebutReelle + ", dateFinReelle=" + dateFinReelle + ", tache=" + tache + '}';
    }

    public EmployeTacheId getId() {
        return id;
    }

    public void setId(EmployeTacheId id) {
        this.id = id;
    }

    public Date getDateDebutReelle() {
        return dateDebutReelle;
    }

    public void setDateDebutReelle(Date dateDebutReelle) {
        this.dateDebutReelle = dateDebutReelle;
    }

    public Date getDateFinReelle() {
        return dateFinReelle;
    }

    public void setDateFinReelle(Date dateFinReelle) {
        this.dateFinReelle = dateFinReelle;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public Tache getTache() {
        return tache;
    }

    public void setTache(Tache tache) {
        this.tache = tache;
    }
    
    

    
    
    

}
