package ma.project.services;

import java.util.Date;
import ma.project.dao.IDao;
import ma.project.classes.Commande;
import java.util.List;
import ma.project.classes.LigneCommande;
import ma.project.classes.Produit;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import ma.project.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author a
 */
public class CommandeService implements IDao<Commande> {

    @Override
    public boolean create(Commande o) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(o);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return false;
    }

    @Override
    public boolean delete(Commande o) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(o);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return false;
    }

    @Override
    public boolean update(Commande o) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(o);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return false;
    }

    @Override
    public Commande findById(int id) {
        Session session = null;
        Commande e  = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            e = (Commande) session.get(Commande.class, id);
            session.getTransaction().commit();
            return e;
        } catch (HibernateException ex) {
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return e;
    }

    @Override
    public List<Commande> findAll() {
        Session session = null;
        List<Commande>  commandes = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            commandes = session.createQuery("from Commande").list();
            session.getTransaction().commit();
            return commandes;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return commandes;
    }
    
    public List<Commande> getCommandesBetweenDates(Date startDate, Date endDate) {
        Session session = null;
        List<Commande> commandes = null;
        
        try  {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            // Utilisation de Criteria pour filtrer les commandes entre les deux dates
            Criteria criteria = session.createCriteria(Commande.class);
            criteria.add(Restrictions.ge("dateCommande", startDate)); 
            criteria.add(Restrictions.le("dateCommande", endDate)); 
            
            commandes = criteria.list();
            session.getTransaction().commit();
            return commandes;

         } catch (HibernateException e) {
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return commandes;
   
    }
    
    public void afficherProduitsParCommande(int commandeId) {
         Session session = null;
         session = HibernateUtil.getSessionFactory().openSession();
         session.beginTransaction();

        
        try {
            
            Commande commande = (Commande) session.get(Commande.class, commandeId);

            if (commande != null && commande.getLignesCommande() != null) {
                System.out.println("Commande : " + commande.getId() + " Date : " + commande.getDate());
                System.out.println("Liste des produits :");
                System.out.println("Référence\tPrix\tQuantité");

                for (LigneCommande ligne : commande.getLignesCommande()) {
                    System.out.println(ligne.getProduit().getReference() + "\t" +
                                       ligne.getProduit().getPrix() + " DH\t" +
                                       ligne.getQuantite());
                }
            } else {
                System.out.println("Commande non trouvée ou pas de produits dans la commande.");
            }

           session.getTransaction().commit();
           

         } catch (HibernateException e) {
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        
   
    }
    }

    


