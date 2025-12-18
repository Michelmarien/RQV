package Projet.utilisateur;

public abstract class Personne {
    protected String nom;
    protected String prenom;
    protected String adresse;
    protected String telephone;
    protected String email;

    // CONSTRUCTEUR
    public Personne(String nom, String prenom, String adresse, String telephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.telephone = telephone;
        this.email = prenom.toLowerCase() + "." + nom.toLowerCase() + "@email.com"; // Email auto-généré
    }


    public abstract void sePresenter();
    public abstract void afficherRole();

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getEmail() {
        return email;
    }


    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNomComplet() {
        return prenom + " " + nom;
    }
}
