package tar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import ma.projet.beans.Femme;
import ma.projet.beans.Homme;
import ma.projet.beans.HommeFemmePk;
import ma.projet.beans.Mariage;
import ma.projet.service.FemmeService;
import ma.projet.service.HommeService;
import ma.projet.service.MariageService;
import ma.projet.util.HibernateUtil;

public class TAR {

    private static Object femmeService;

    
    private static String formatDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
        return sdf.format(date);
    }

                     
    private static Date entrerDate(String prompt) {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
        Date date = null;
        boolean dateValide = false;

        while (!dateValide) {
            try {
                System.out.println(prompt);
                String input = scanner.nextLine();
                date = dateFormat.parse(input);
                dateValide = true;
            } catch (ParseException e) {
                System.out.println("Date invalide. Veuillez entrer une date au format dd/MM/yy.");
            }
        }

        return date;
    }

    public static void main(String[] args) throws ParseException {

        HommeService ho = new HommeService();
        FemmeService fe = new FemmeService();
        MariageService ma = new MariageService();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");

       
        fe.create(new Femme("Bousserhane","Sofia","0671234567","Rabat",sdf.parse("15/03/1980")));
        fe.create(new Femme("Elhousni","Khadija","0669876543","Tanger",sdf.parse("22/01/1990")));
        fe.create(new Femme("Zarouali","Nadia","0654321098","Casablanca",sdf.parse("08/05/1995")));
        fe.create(new Femme("Safi","Amal","0634567890","Agadir",sdf.parse("14/11/1988")));
        fe.create(new Femme("Mellouki","Amina","0623456789","Fes",sdf.parse("27/02/1992")));
        fe.create(new Femme("Brahimi","Yasmina","0612345678","Marrakech",sdf.parse("30/06/1993")));
        fe.create(new Femme("Aouad","Hanane","0609876543","Oujda",sdf.parse("18/09/1996")));
        fe.create(new Femme("Khatib","Sara","0643210987","Meknes",sdf.parse("25/12/1985")));
        fe.create(new Femme("Benabbou","Fatma","0687654321","Safi",sdf.parse("03/04/1982")));
        fe.create(new Femme("Ait El Haj","Nour","0698765432","Taza",sdf.parse("19/08/1978")));
        ho.create(new Homme("Fassi","Youssef","0754321098","El Jadida",sdf.parse("10/10/1980")));
        ho.create(new Homme("Lahrach","Ali","0743210987","Ouarzazate",sdf.parse("15/05/1985")));
        ho.create(new Homme("Alaoui","Samir","0732109876","Tanger",sdf.parse("20/11/1990")));
        ho.create(new Homme("Chraibi","Hamid","0721098765","Agadir",sdf.parse("28/02/1987")));
        ho.create(new Homme("Elamiri","Said","0710987654","Marrakech",sdf.parse("01/01/1983")));
        
        // Créer des mariages
        Mariage m1 = new Mariage(ho.findById(1), fe.findById(1), new Date(), new Date(), 5);
        m1.setPk(new HommeFemmePk(1, 1, new Date()));
        ma.create(m1);
        Mariage m2 = new Mariage(ho.findById(2), fe.findById(2), sdf.parse("15/06/2020"), null, 3);
        m2.setPk(new HommeFemmePk(2, 2, new Date()));
        ma.create(m2);

       
        Date dateDebut = entrerDate("Entrez la date de début (format dd/MM/yyyy) : ");
        Date dateFin = entrerDate("Entrez la date de fin (format dd/MM/yyyy) : ");

        
        List<Femme> femmes = fe.findAll();
        if (femmes != null) {
            for (Femme femme : femmes) {
                System.out.println(femme.getNom() + " " + femme.getPrenom());
            }
        } else {
            System.out.println("Erreur lors de la récupération des femmes.");
        }

       
        femmes.sort((f1, f2) -> f1.getDateNaissance().compareTo(f2.getDateNaissance()));
        Femme plusAgee = femmes.get(0);
        System.out.println("Femme la plus âgée: " + plusAgee.getNom() + " née le " + formatDate(plusAgee.getDateNaissance()));

        
        List<Mariage> mariages = ho.getEpousesEntreDates(ho.findById(1), dateDebut, dateFin);
        mariages.forEach(m -> System.out.println("Femme : " + m.getFemme().getNom() + " Date Début : " + formatDate(m.getDateDebut())));

        
        long nombreEnfants = fe.getNombreEnfantsEntreDates(fe.findById(1), dateDebut, dateFin);
        System.out.println("Nombre d'enfants: " + nombreEnfants);

        
        List<Femme> femmesMarieesDeuxFois = fe.getFemmesMarieesDeuxFoisOuPlus();
        femmesMarieesDeuxFois.forEach(f -> System.out.println(f.getNom()));

       
        long nombreHommesMariees = ho.getNombreHommesMarieParQuatreFemmesEntreDates(dateDebut, dateFin);
        System.out.println("Nombre d'hommes mariés par quatre femmes: " + nombreHommesMariees);

        
        Homme homme = ho.findById(1);
        if (homme != null) {
            ho.afficherMariages(homme);
        } else {
            System.out.println("Aucun homme trouvé avec cet ID.");
        }

        Homme homme1 = ho.findById(2);
        if (homme1 != null) {
            ho.afficherMariages(homme1);
        } else {
            System.out.println("Aucun homme trouvé avec cet ID.");
        }
    }

}

