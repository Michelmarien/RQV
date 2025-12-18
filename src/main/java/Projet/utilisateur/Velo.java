package Projet.utilisateur;

public class Velo extends Propriete {
    private String numeroSerie;
    private String type; // VTT, route, ville...

    public Velo(String couleur, String marque, String numeroSerie, String type, String description) {
        super(couleur, marque, description);
        this.numeroSerie = numeroSerie;
        this.type = type;
    }

    @Override
    public String getDetails() {
        return " VÉLO\n" +
                "   Marque       : " + marque + "\n" +
                "   Type         : " + type + "\n" +
                "   Couleur      : " + couleur + "\n" +
                "   N° de série  : " + numeroSerie + "\n" +
                "   Description  : " + description;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public String getType() {
        return type;
    }
}
