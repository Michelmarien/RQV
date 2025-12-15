package RQV;

public abstract class Personne {
    private String nom;
    private String prenom;
    private String adresse;
    private String telephone;

    public Personne(String nom, String prenom, String adresse, String telephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.telephone = telephone;
    }

    public abstract void update(String message);
}
