package RQV;

public class Policier extends Personne implements Observer {
    private String login;
    private String password;

    public Policier(String nom, String prenom, String adresse, String telephone,String login, String password) {
        super(nom, prenom, adresse, telephone);
        this.login = login;
        this.password = password;
    }

    public void authentification(String login, String password) {
        this.login = login;
        this.password = password;
    }

    // Méthode à implémenter
    /* public String setEtatDeclaration(){

    }

    public void getEtatDeclaration(){

    }

    public String genererRQV(String rapport){

    } */
    @Override
    public void update(String message) {

    }
}
