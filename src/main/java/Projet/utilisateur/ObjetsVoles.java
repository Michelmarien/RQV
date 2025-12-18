package Projet.utilisateur;

public class ObjetsVoles {
    private String typeObjet;
    private String description;
    private String couleur;
    private String marque;

    public ObjetsVoles(String typeObjet, String description, String couleur, String marque) {
        this.typeObjet = typeObjet;
        this.description = description;
        this.couleur = couleur;
        this.marque = marque;
    }


    public void afficherDetails() {
        System.out.println("    • Type    : " + typeObjet);
        System.out.println("      Couleur : " + couleur);
        System.out.println("      Marque  : " + marque);
        System.out.println("      Détails : " + description);
        System.out.println();
    }

    public String getTypeObjet() { return typeObjet; }
    public String getDescription() { return description; }
    public String getCouleur() { return couleur; }
    public String getMarque() { return marque; }
}
