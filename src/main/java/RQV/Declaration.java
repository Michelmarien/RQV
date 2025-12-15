package RQV;

public class Declaration{
    private int id;
    private date dateVole;
    private String heure;
    private String lieu;
    private date dateDernierModification;
    private statut statutDeclaration;

    public Declaration(int id, date dateVole, String heure, String lieu, date dateDernierModification, statut statutDeclaration){
        this.id = id;
        this.dateVole = dateVole;
        this.heure = heure;
        this.lieu = lieu;
        this.dateDernierModification = dateDernierModification;
        this.statutDeclaration = statutDeclaration;

    }

    //Méthode à implémenter
    /*
    * public sauvergarder(){}
    * */

}
