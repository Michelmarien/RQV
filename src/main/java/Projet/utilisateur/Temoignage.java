package Projet.utilisateur;

public class Temoignage {
    private Temoin temoin;
    private String recit;
    private Lieu lieu;

    public Temoignage(Temoin temoin, String recit, Lieu lieu) {
        this.temoin = temoin;
        this.recit = recit;
        this.lieu = lieu;
    }

    public void afficherTemoignage() {
        System.out.println("\n TÉMOIGNAGE");
        temoin.sePresenter();
        System.out.println("Récit : " + recit);
        System.out.println("Lieu : ");
        lieu.descriptionLieu();
    }
}
