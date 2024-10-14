/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.project.Test;


/**
 *
 * @author Pc
 */
import java.text.SimpleDateFormat;
import java.util.Date;
import ma.project.classes.Categorie;
import ma.project.classes.Commande;
import ma.project.classes.LigneCommande;
import ma.project.classes.Produit;
import ma.project.services.CategorieService;
import ma.project.services.CommandeService;
import ma.project.services.LigneCommandeService;
import ma.project.services.ProduitService;
import ma.project.util.HibernateUtil;

public class Exo2 {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        HibernateUtil.getSessionFactory().openSession();
        LigneCommandeService lc = new LigneCommandeService();
        CategorieService ct = new CategorieService();
        ProduitService pr = new ProduitService();
         CommandeService co = new CommandeService();
        
        Categorie C1 =  new Categorie("CAT01", "Électronique");
        Categorie C2 =  new Categorie("CAT02", "Meubles");
        
        ct.create(C2);
        ct.create(C1);
        
         Produit produit1 = new Produit("REF001", 1200.50f, C1);
         Produit produit2 = new Produit("REF003", 450.99f,C1 );
         Produit produit3 = new Produit("REF005", 990.99f,C2 );
        pr.create(produit1);
        pr.create(produit2);
        pr.create(produit3);
        
        
        Commande commande1 = new Commande(new Date());
        Commande commande2 = new Commande(new Date());
        co.create(commande1);
        co.create(commande2);
        
        LigneCommande ligne1 = new LigneCommande(7,produit1, commande1);  
        LigneCommande ligne2 = new LigneCommande(15,produit2, commande1); 
        LigneCommande ligne3 = new LigneCommande(3,produit3, commande2); 
        
        lc.create(ligne1);
        lc.create(ligne2);
        lc.create(ligne3);
        co.afficherProduitsParCommande(commande1.getId());
        pr.findByCategory(2);
        
        
    }
    }
    
