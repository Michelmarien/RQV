package Projet.utilisateur;

public class VehiculeMoteur extends Propriete{
    private String matricule;
    private String modele;

    public VehiculeMoteur(String couleur, String marque, String matricule, String modele, String description) {
        super(couleur, marque, description);
        this.matricule = matricule;
        this.modele = modele;
    }

    @Override
    public String getDetails() {
        return " VÉHICULE MOTEUR\n" +
                "   Marque      : " + marque + "\n" +
                "   Modèle      : " + modele + "\n" +
                "   Couleur     : " + couleur + "\n" +
                "   Matricule   : " + matricule + "\n" +
                "   Description : " + description;
    }

    public String getMatricule() {
        return matricule;
    }

    public String getModele() {
        return modele;
    }
}
