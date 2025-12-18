package Projet.utilisateur;

import java.util.Date;
import java.util.List;

public class Declaration {
    private static int compteur = 0;

    private int numeroDossier;
    private Date dateDepot;
    private Date dateDerniereModification;
    private Victime victime;
    private Temoin temoin;
    private Role role;
    private Lieu lieu;
    private List<ObjetsVoles> objetsVoles;
    private EtatDeclaration etat;

    // CONSTRUCTEUR
    public Declaration(Role role, Victime victime, Temoin temoin, Lieu lieu, List<ObjetsVoles> objetsVoles) {
        this.numeroDossier = ++compteur;
        this.dateDepot = new Date();
        this.dateDerniereModification = this.dateDepot;
        this.role = role;
        this.victime = victime;
        this.temoin = temoin;
        this.lieu = lieu;
        this.objetsVoles = objetsVoles;
        this.etat = EtatDeclaration.NOUVELLE;


        if (victime != null) {
            victime.ajouterDeclaration(this);
        }
    }


    public void modifierEtat(EtatDeclaration nouvelEtat) {
        this.etat = nouvelEtat;
        this.dateDerniereModification = new Date();
        System.out.println(" État du dossier " + numeroDossier + " modifié : " + nouvelEtat);
    }


    public void modifierDeclaration(Lieu nouveauLieu, List<ObjetsVoles> nouveauxObjets) {
        if (nouveauLieu != null) {
            this.lieu = nouveauLieu;
        }
        if (nouveauxObjets != null) {
            this.objetsVoles = nouveauxObjets;
        }
        this.dateDerniereModification = new Date();
        if (this.etat == EtatDeclaration.NOUVELLE) {
            this.etat = EtatDeclaration.MODIFIEE;
        }
    }


    public void marquerResolue() {
        this.etat = EtatDeclaration.RESOLUE;
        this.dateDerniereModification = new Date();
    }


    public void afficherDeclaration() {
        System.out.println("[      DÉCLARATION DE VOL N° " + numeroDossier + "    ]");
        System.out.println("  Date de dépôt          : " + dateDepot);
        System.out.println("  Dernière modification  : " + dateDerniereModification);
        System.out.println("  État                   : " + etat);
        System.out.println("  Rôle du déclarant      : " + role);

        System.out.println("\n INFORMATIONS VICTIME");
        if (victime != null) {
            victime.sePresenter();
        } else {
            System.out.println(" Aucune victime identifiée");
        }

        if (temoin != null) {
            System.out.println("\nINFORMATIONS TÉMOIN");
            temoin.sePresenter();
        }

        System.out.println("\nLIEU DU VOL");
        lieu.descriptionLieu();

        System.out.println("\n OBJETS VOLÉS");
        for (ObjetsVoles objet : objetsVoles) {
            objet.afficherDetails();
        }

    }

    public void afficherDossier() {
        System.out.println("\n DÉCLARATION N°" + numeroDossier);
        System.out.println("Date : " + dateDepot);
        System.out.println("État : " + etat);
        System.out.println("Rôle : " + role);

        if (victime != null) {
            System.out.println("- Victime -");
            victime.sePresenter();
        }

        System.out.println("- Lieu -");
        lieu.descriptionLieu();

        System.out.println("-Objets volés -");
        for (ObjetsVoles obj : objetsVoles) {
            obj.afficherDetails();
        }
    }


    public int getNumeroDossier() { return numeroDossier; }
    public String getNumeroDossierString() { return String.valueOf(numeroDossier); }
    public Date getDateDepot() { return dateDepot; }
    public Date getDateDerniereModification() { return dateDerniereModification; }
    public EtatDeclaration getEtat() { return etat; }
    public Role getRole() { return role; }
    public Victime getVictime() { return victime; }
    public Temoin getTemoin() { return temoin; }
    public Lieu getLieu() { return lieu; }


    public List<ObjetsVoles> getObjetsVoles() {
        return objetsVoles;
    }
}
