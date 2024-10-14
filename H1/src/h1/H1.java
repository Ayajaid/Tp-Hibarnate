/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package h1;

import java.util.Date;
import ma.project.entity.Produit;
import ma.project.services.ProduitService;
import org.hibernate.Hibernate;
import ma.project.util.HibernateUtil;

/**
 *
 * @author Pc
 */
public class H1 {

    
    public static void main(String[] args) {
        
        HibernateUtil.getSessionFactory().openSession();
       ProduitService pr =new ProduitService();
//       pr.create(new Produit("Samsung","AABE",new Date(),5000.00,"phone"));
//       pr.create(new Produit("Samsung","AANZ",new Date(),90.00,"Chargeur"));
//       pr.create(new Produit("Dell","POBE",new Date(),10000.00,"Pc"));
//       pr.create(new Produit ("Apple","FEBE",new Date(),8000.00,"phone"));
//       pr.create(new Produit("Apple","FEZZ",new Date(),12000.00,"Pc"));
        System.out.println("Marque: " + pr.findById(2).getMarque() + 
                   ", Prix: " + pr.findById(2).getPrix() + 
                   ", Date d'achat: " + pr.findById(2).getDateAchat());

//       pr.delete(pr.findById(3));
       
    }
    
    
}
