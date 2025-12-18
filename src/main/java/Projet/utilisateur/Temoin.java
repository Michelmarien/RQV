package Projet.utilisateur;

public class Temoin extends Personne {

    // CONSTRUCTEUR
    public Temoin(String nom, String prenom, String adresse, String telephone) {
        super(nom, prenom, adresse, telephone);
    }


    @Override
    public void sePresenter() {
        System.out.println(" Témoin : " + this.getPrenom() + " " + this.getNom());
        System.out.println(" Email  : " + this.getEmail());
        System.out.println("  Tél.   : " + this.getTelephone());
        System.out.println(" Adresse: " + this.getAdresse());
    }


    @Override
    public void afficherRole() {
        System.out.println("Rôle : TÉMOIN");
        sePresenter();
    }


    public Temoignage deposerTemoignage(String recit, Lieu lieu) {
        System.out.println("Témoignage déposé par " + this.getNomComplet());
        return new Temoignage(this, recit, lieu);
    }


    public void afficherInfosTemoin() {
        System.out.println("  INFORMATIONS DU TÉMOIN");
        afficherRole();
    }

    @Override
    public String toString() {
        return "Témoin: " + getNomComplet() + " (" + getEmail() + ")";
    }
}
