package RQV;

public class Declarant extends Personne {

    private String numroCNI;

    public Declarant(String nom, String prenom, String adresse, String telephone,  String numroCNI) {
        super(nom, prenom, adresse, telephone);
        this.numroCNI = numroCNI;
    }

   // Méthode à implémenter
    /*
    * public creerDeclaration(){}
    * public modifierDeclaration(){}
    * */
    @Override
    public void update(String message) {

    }

}
