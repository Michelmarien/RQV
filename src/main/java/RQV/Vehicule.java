package RQV;

public abstract class Vehicule {
    private String marque;
    private String couleur;
    private String description;

    public Vehicule(String marque, String couleur, String description) {
        this.marque = marque;
        this.couleur = couleur;
        this.description = description;
    }
}
