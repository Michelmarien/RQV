package Projet.service;

import Projet.utilisateur.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommissariatService {

    private List<Declaration> dossierVictimes = new ArrayList<>();
    private List<Temoignage> dossierTemoins = new ArrayList<>();

    private final String AGENT_LOGIN = "agent";
    private final String AGENT_PASSWORD = "police";

    private SystemeObjetsTrouves systemeObjetsTrouves = new SystemeObjetsTrouves();

    public boolean authentifierAgent(String login, String password) {
        return login.equals(AGENT_LOGIN) && password.equals(AGENT_PASSWORD);
    }

    public void enregistrerDeclaration(Declaration d) {
        dossierVictimes.add(d);
        System.out.println("Déclaration de victime enregistrée.");
    }

    public void enregistrerTemoignage(Temoignage t) {
        dossierTemoins.add(t);
        System.out.println("Témoignage enregistré au dossier.");
    }

    public void afficherToutLeDossier() {
        System.out.println("[   DOSSIER CENTRAL - CONFIDENTIEL      ]");


        System.out.println("\n--- 1. PLAINTES DES VICTIMES (" + dossierVictimes.size() + ")");
        if (dossierVictimes.isEmpty()) {
            System.out.println("Aucune plainte.");
        }
        for (Declaration d : dossierVictimes) {
            d.afficherDossier();
            System.out.println("-------------------------");
        }

        System.out.println("\n--- 2. RAPPORTS DES TÉMOINS (" + dossierTemoins.size() + ") ---");
        if (dossierTemoins.isEmpty()) {
            System.out.println("Aucun témoignage.");
        }
        for (Temoignage t : dossierTemoins) {
            t.afficherTemoignage();
            System.out.println("-------------------------");
        }

    }

    //  1. Enregistrer un objet trouvé
    public void enregistrerObjetTrouve(String type, String couleur,String marque, String description, String lieu) {
        ObjetsTrouves objet = new ObjetsTrouves(type, couleur,marque, description, lieu);
        systemeObjetsTrouves.ajouterObjetTrouve(objet);
        verifierCorrespondances(objet);
    }

    //  2. Vérifier les correspondances automatiquement
    private void verifierCorrespondances(ObjetsTrouves objet) {
        System.out.println("\n Recherche de correspondances...");
        boolean correspondanceTrouvee = false;

        for (Declaration d : dossierVictimes) {
            for (ObjetsVoles objVole : d.getObjetsVoles()) {
                if (objet.correspondA(objVole)) {
                    d.modifierEtat(EtatDeclaration.RESOLUE);
                    System.out.println(" Correspondance trouvée !");
                    System.out.println("   Dossier " + d.getNumeroDossier() + " → RÉSOLU");
                    correspondanceTrouvee = true;
                }
            }
        }

        if (!correspondanceTrouvee) {
            System.out.println(" Aucune correspondance trouvée.");
        }
    }

    //  3. Modifier l'état d'une déclaration manuellement
    public void modifierEtatDeclaration(int numeroDossier, EtatDeclaration nouvelEtat) {
        for (Declaration d : dossierVictimes) {
            if (d.getNumeroDossier() == numeroDossier) {
                d.modifierEtat(nouvelEtat);
                return;
            }
        }
        System.out.println(" Dossier introuvable : " + numeroDossier);
    }

    //  4. Générer le RQV
    public String genererRQV() {
        RQV rqv = new RQV(new Date(), dossierVictimes);
        return rqv.genererRapport();
    }

    //  5. Inscrire une victime au système de notifications
    public void inscrireVictimeAuxNotifications(Victime victime) {
        systemeObjetsTrouves.attacher(victime);
    }

    //  6. Rechercher une déclaration
    public Declaration rechercherDeclaration(int numeroDossier) {
        for (Declaration d : dossierVictimes) {
            if (d.getNumeroDossier() == numeroDossier) {
                return d;
            }
        }
        return null;
    }


    public List<Declaration> getDossierVictimes() {
        return dossierVictimes;
    }
}
