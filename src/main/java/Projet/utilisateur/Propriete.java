package Projet.utilisateur;

public abstract class Propriete {
    protected String couleur;
    protected String marque;
    protected String description;

    public Propriete(String couleur, String marque, String description) {
        this.couleur = couleur;
        this.marque = marque;
        this.description = description;
    }

    public abstract String getDetails();


    public String getCouleur() {
        return couleur;
    }

    public String getMarque() {
        return marque;
    }

    public String getDescription() {
        return description;
    }
}
