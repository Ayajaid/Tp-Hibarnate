/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ma.project.test;

import java.util.Date;
import ma.project.entities.Employe;
import ma.project.entities.EmployeTache;
import ma.project.entities.Projet;
import ma.project.entities.Tache;
import ma.project.service.EmployeService;
import ma.project.service.EmployeTacheService;
import ma.project.service.ProjetService;
import ma.project.service.TacheService;
import ma.project.util.HibernateUtil;



/**
 *
 * @author ACER
 */
public class Test {
    public static void main(String[] args) {
         
   HibernateUtil.getSessionFactory().openSession();
        EmployeService em = new EmployeService();
        ProjetService ps = new ProjetService();
        TacheService ts = new TacheService();
        EmployeTacheService ets = new EmployeTacheService();
        
        ////L'ajout dem employee////
        em.create(new Employe("Faroki","Karim","0621549633"));
        em.create(new Employe("Salman","Rabiaa","0655238466"));
        em.create(new Employe("elwifaqui","Jalal","0647218576"));

        
      
ps.create(new Projet("ProjetAlpha", new Date(24,1,15), new Date(24,5,10), em.getById(1)));
ps.create(new Projet("ProjetBeta", new Date(24,3,25), new Date(24,7,14), em.getById(2)));
ps.create(new Projet("ProjetGamma", new Date(24,4,5), new Date(24,8,30), em.getById(3)));


ts.create(new Tache("TacheAlpha", new Date(24,2,1), new Date(24,4,15), 4000, ps.getById(1)));
ts.create(new Tache("TacheBeta", new Date(24,3,10), new Date(24,6,10), 2200, ps.getById(1)));
ts.create(new Tache("TacheGamma", new Date(24,4,18), new Date(24,7,20), 1500, ps.getById(2)));
ts.create(new Tache("TacheDelta", new Date(24,5,5), new Date(24,8,25), 3200, ps.getById(3)));


ets.create(new EmployeTache(new Date(24,2,5), new Date(24,4,14), em.getById(1), ts.getById(1)));
ets.create(new EmployeTache(new Date(24,3,12), new Date(24,6,9), em.getById(2), ts.getById(3)));
ets.create(new EmployeTache(new Date(24,4,20), new Date(24,7,19), em.getById(3), ts.getById(4)));

        
        
       
for(Tache tache : em.getEmployeTaches(em.getById(1))){
    System.out.println(tache.getNom());
}


for(Projet projet : em.getEmployeProjets(em.getById(3))){
    System.out.println(projet.getNom()); 
}


for(Tache tache : ps.getProjetTachesPlanifier(ps.getById(1))){
    System.out.println(tache.getId() + "  " + tache.getNom());
}


ps.getProjetTachesRealisees(ps.getById(2));


for(Tache tache : ts.getTacheSupAPrix(1000)){
    System.out.println(tache.getNom() + " : " + tache.getPrix() + " DH");
}

        
        
    
    }
    }
