package Projet.utilisateur;

public class Lieu {
    private String adresse;
    private String ville;
    private String codePostal;

    public Lieu(String adresse, String ville, String codePostal) {
        this.adresse = adresse;
        this.ville = ville;
        this.codePostal = codePostal;
    }

    public void descriptionLieu() {
        System.out.println("    Adresse : " + adresse);
        System.out.println("    Ville : " + ville + " (" + codePostal + ")");
    }


    @Override
    public String toString() {
        return adresse + ", " + codePostal + " " + ville;
    }
}
