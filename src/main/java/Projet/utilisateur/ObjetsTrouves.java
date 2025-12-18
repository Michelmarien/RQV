package Projet.utilisateur;

public class ObjetsTrouves {
    private String type;        // ex: "vélo", "téléphone", "sac"
    private String couleur;
    private String description;
    private String lieuTrouve;
    private String marque;

    // CONSTRUCTEUR
    public ObjetsTrouves(String type, String couleur, String description, String lieuTrouve, String marque) {
        this.type = type;
        this.couleur = couleur;
        this.description = description;
        this.lieuTrouve = lieuTrouve;
        this.marque = marque;
    }


    public boolean correspondA(ObjetsVoles objetVole) {
        // Comparaison insensible à la casse
        boolean typeCorrespond = this.type.equalsIgnoreCase(objetVole.getTypeObjet());
        boolean couleurCorrespond = this.couleur.equalsIgnoreCase(objetVole.getCouleur());

        // Si type ET couleur correspondent → C'est un match !
        return typeCorrespond && couleurCorrespond;
    }

    // AFFICHAGE
    public void afficherDetails() {
        System.out.println(" Objet trouvé :");
        System.out.println("  Type        : " + type);
        System.out.println(" Couleur     : " + couleur);
        System.out.println("  Description : " + description);
        System.out.println("  Lieu        : " + lieuTrouve);
        System.out.println(" marque      : " + marque);
    }

    // GETTERS
    public String getType() {
        return type;
    }

    public String getCouleur() {
        return couleur;
    }

    public String getDescription() {
        return description;
    }

    public String getLieuTrouve() {
        return lieuTrouve;
    }


    public void setType(String type) {
        this.type = type;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLieuTrouve(String lieuTrouve) {
        this.lieuTrouve = lieuTrouve;
    }

    public void setMarque(String marque){
        this.marque = marque;
    }

    @Override
    public String toString() {
        return type + " " + couleur + " (trouvé à " + lieuTrouve + ")";
    }
}
