package Projet.utilisateur;

import Projet.Observer.Observer;
import java.util.ArrayList;
import java.util.List;

public class Victime extends Personne implements Observer {
    private List<Declaration> declarations = new ArrayList<>();

    // CONSTRUCTEUR
    public Victime(String nom, String prenom, String adresse, String telephone) {
        super(nom, prenom, adresse, telephone);
    }

    @Override
    public void sePresenter() {
        System.out.println(" Victime : " + this.getPrenom() + " " + this.getNom());
        System.out.println(" Email   : " + this.getEmail());
        System.out.println(" Tél.    : " + this.getTelephone());
        System.out.println(" Adresse : " + this.getAdresse());
    }

    @Override
    public void update(ObjetsTrouves objetTrouve) {

        System.out.println("   NOTIFICATION POUR " + this.getNom().toUpperCase() + " " + this.getPrenom().toUpperCase());


        boolean correspondanceTrouvee = false;

        // Parcourir toutes les déclarations de cette victime
        for (Declaration decl : declarations) {
            // Parcourir tous les objets volés de chaque déclaration
            for (ObjetsVoles objVole : decl.getObjetsVoles()) {
                // Vérifier la correspondance
                if (objetTrouve.correspondA(objVole)) {
                    correspondanceTrouvee = true;

                    System.out.println("CORRESPONDANCE TROUVÉE !");
                    System.out.println("Dossier concerné : N°" + decl.getNumeroDossier());
                    System.out.println("\n Votre objet déclaré volé ");
                    objVole.afficherDetails();
                    System.out.println("\nObjet retrouvé ");
                    objetTrouve.afficherDetails();
                    System.out.println("\nACTION REQUISE :");
                    System.out.println("   Présentez-vous au commissariat avec :");
                    System.out.println("   • Une pièce d'identité");
                    System.out.println("   • Le numéro de dossier : " + decl.getNumeroDossier());
                    System.out.println("   • Une preuve de propriété si possible");

                    return;
                }
            }
        }

        // Si aucune correspondance
        if (!correspondanceTrouvee) {
            System.out.println("Un objet a été retrouvé, mais il ne correspond");
            System.out.println("   à aucun de vos objets déclarés volés.");
            System.out.println("   Type : " + objetTrouve.getType());
            System.out.println("   Couleur : " + objetTrouve.getCouleur());

        }
    }


    public void ajouterDeclaration(Declaration declaration) {
        this.declarations.add(declaration);
        System.out.println("Déclaration ajoutée pour " + this.getNom());
    }


    public List<Declaration> getDeclarations() {
        return declarations;
    }


    public void afficherMesDeclarations() {
        if (declarations.isEmpty()) {
            System.out.println("Aucune déclaration enregistrée.");
            return;
        }


        System.out.println("  MES DÉCLARATIONS - " + this.getNom().toUpperCase());


        for (int i = 0; i < declarations.size(); i++) {
            Declaration d = declarations.get(i);
            System.out.println("\n[" + (i + 1) + "] Dossier N°" + d.getNumeroDossier());
            System.out.println("    État : " + d.getEtat());
            System.out.println("    Date : " + d.getDateDepot());
            System.out.println("    Objets volés : " + d.getObjetsVoles().size());
        }

    }

    @Override
    public void afficherRole() {
        System.out.println("Rôle : VICTIME");
        sePresenter();
    }


    public String getNomComplet() {
        return this.getPrenom() + " " + this.getNom();
    }
}
