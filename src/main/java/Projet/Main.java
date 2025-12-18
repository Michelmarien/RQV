package Projet;

import Projet.utilisateur.*;
import Projet.service.CommissariatService;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CommissariatService commissariat = new CommissariatService();

        boolean systemeActif = true;

        while (systemeActif) {

            System.out.println("[COMMISSARIAT - GESTION DES VOLS]");
            System.out.println("\nQui êtes-vous ?");
            System.out.println("1. Citoyen (Victime/Témoin) - Déclarer un vol");
            System.out.println("2. Agent de police - Accéder au système");
            System.out.println("3. Quitter");
            System.out.print("\nVotre choix : ");
            int choixPrincipal = scanner.nextInt();
            scanner.nextLine();

            switch (choixPrincipal) {
                case 1:
                    //ESPACE CITOYEN
                    System.out.println("\n Nouveau Vol - Informations du déclarant");
                    System.out.println("Vous êtes :");
                    System.out.println("1. Victime uniquement");
                    System.out.println("2. Témoin uniquement");
                    System.out.println("3. Victime ET témoin");
                    System.out.print("Votre choix : ");
                    int choixRole = scanner.nextInt();
                    scanner.nextLine();

                    Role role;
                    Victime victime = null;
                    Temoin temoin = null;

                    // Demander les infos communes
                    System.out.print("Nom : ");
                    String nom = scanner.nextLine();
                    System.out.print("Prénom : ");
                    String prenom = scanner.nextLine();
                    System.out.print("Email : ");
                    String email = scanner.nextLine();
                    System.out.print("Téléphone : ");
                    String telephone = scanner.nextLine();

                    switch (choixRole) {
                        case 1:
                            role = Role.VICTIME;
                            victime = new Victime(nom, prenom, email, telephone);
                            break;
                        case 2:
                            role = Role.TEMOIN;
                            temoin = new Temoin(nom, prenom, email, telephone);
                            break;
                        case 3:
                            role = Role.VICTIME_ET_TEMOIN;
                            victime = new Victime(nom, prenom, email, telephone);
                            temoin = new Temoin(nom, prenom, email, telephone);
                            break;
                        default:
                            System.out.println("Choix invalide");
                            continue;
                    }

                    System.out.println("\n Lieu du vol");
                    System.out.print("Adresse : ");
                    String adresse = scanner.nextLine();
                    System.out.print("Ville : ");
                    String ville = scanner.nextLine();
                    System.out.print("Code postal : ");
                    String codePostal = scanner.nextLine();

                    Lieu lieu = new Lieu(adresse, ville, codePostal);


                    List<ObjetsVoles> objetsVoles = new ArrayList<>();
                    boolean ajouterAutreObjet = true;

                    while (ajouterAutreObjet) {
                        System.out.println("\n Objet volé");
                        System.out.print("Type d'objet (ex: vélo, véhicule à moteur) : ");
                        String typeObjet = scanner.nextLine();
                        System.out.print("Description : ");
                        String description = scanner.nextLine();
                        System.out.print("Couleur : ");
                        String couleur = scanner.nextLine();
                        System.out.print("Marque : ");
                        String marque = scanner.nextLine();

                        ObjetsVoles objet = new ObjetsVoles(typeObjet, description, couleur, marque);
                        objetsVoles.add(objet);

                        System.out.print("\nAjouter un autre objet volé ? (o/n) : ");
                        String reponse = scanner.nextLine();
                        ajouterAutreObjet = reponse.equalsIgnoreCase("o");
                    }

                    if (role == Role.VICTIME || role == Role.VICTIME_ET_TEMOIN) {
                        Declaration declaration = new Declaration(role, victime, temoin, lieu, objetsVoles);
                        commissariat.enregistrerDeclaration(declaration);
                        System.out.println("\nVotre déclaration a été enregistrée !");
                        System.out.println("Numéro de dossier : " + declaration.getNumeroDossier());
                    }

                    if (role == Role.TEMOIN || role == Role.VICTIME_ET_TEMOIN) {
                        System.out.print("\nDescription détaillée de ce que vous avez vu : ");
                        String recit = scanner.nextLine();
                        Temoignage temoignage = new Temoignage(temoin, recit, lieu);
                        commissariat.enregistrerTemoignage(temoignage);
                    }

                    break;

                case 2:
                    System.out.println("[AUTHENTIFICATION AGENT]");

                    System.out.print("Matricule : ");
                    String matricule = scanner.nextLine();

                    System.out.print("Mot de passe : ");
                    String motDePasse = scanner.nextLine();


                    boolean agentConnecte = commissariat.authentifierAgent(matricule, motDePasse);

                    if (agentConnecte == false) {
                        System.out.println("ÉCHEC D'AUTHENTIFICATION");

                    }
                    // Dans le case 2 (Menu Agent), remplacer par :
                    boolean sessionAgent = true;
                    while (sessionAgent) {
                        System.out.println("║      ESPACE AGENT - MENU PRINCIPAL     ║");
                        System.out.println("1. Consulter tous les dossiers");
                        System.out.println("2. Rechercher un dossier spécifique");
                        System.out.println("3. Enregistrer un objet trouvé");
                        System.out.println("4. Modifier l'état d'une déclaration");
                        System.out.println("5. Générer le RQV (Rapport Quotidien)");
                        System.out.println("6. Se déconnecter");
                        System.out.print("\nVotre choix : ");
                        int choixAgent = scanner.nextInt();
                        scanner.nextLine();

                        switch (choixAgent) {
                            case 1:
                                commissariat.afficherToutLeDossier();
                                break;

                            case 2:
                                System.out.print("Numéro de dossier : ");
                                String numRecherche = scanner.nextLine();
                                Declaration d = commissariat.rechercherDeclaration(Integer.parseInt(numRecherche));
                                if (d != null) {
                                    d.afficherDossier();
                                } else {
                                    System.out.println("Dossier introuvable.");
                                }
                                break;

                            case 3:
                                System.out.println("\n Enregistrer un objet trouvé");
                                System.out.println("Type d'objet :");
                                System.out.println("1. Véhicule motorisé");
                                System.out.println("2. Vélo");
                                System.out.print("Choix : ");
                                int typeObjet = scanner.nextInt();
                                scanner.nextLine();

                                String type = (typeObjet == 1) ? "VEHICULE_MOTEUR" : "VELO";

                                System.out.print("Couleur : ");
                                String couleurObjet = scanner.nextLine();
                                System.out.print("marque : ");
                                String marqueObjet = scanner.nextLine();
                                System.out.print("Description : ");
                                String descObjet = scanner.nextLine();
                                System.out.print("Lieu de découverte : ");
                                String lieuObjet = scanner.nextLine();
                                System.out.print("Date de découverte : ");
                                String dateObjet = scanner.nextLine();

                                commissariat.enregistrerObjetTrouve( couleurObjet,marqueObjet, descObjet, lieuObjet,dateObjet);
                                break;

                            case 4:
                                System.out.print("Numéro de dossier à modifier : ");
                                String numModif = scanner.nextLine();
                                System.out.println("Nouvel état :");
                                System.out.println("1. EN_COURS");
                                System.out.println("2. MODIFIEE");
                                System.out.println("3. RESOLUE");
                                System.out.print("Choix : ");
                                int choixEtat = scanner.nextInt();
                                scanner.nextLine();

                                EtatDeclaration nouvelEtat = EtatDeclaration.NOUVELLE;
                                switch (choixEtat) {
                                    case 1: nouvelEtat = EtatDeclaration.NOUVELLE; break;
                                    case 2: nouvelEtat = EtatDeclaration.MODIFIEE; break;
                                    case 3: nouvelEtat = EtatDeclaration.RESOLUE; break;
                                }

                                commissariat.modifierEtatDeclaration(Integer.parseInt(numModif), nouvelEtat);
                                break;

                            case 5:
                                System.out.println(commissariat.genererRQV());
                                break;

                            case 6:
                                sessionAgent = false;
                                System.out.println("Déconnexion réussie !");
                                break;

                            default:
                                System.out.println("Choix invalide !");
                        }
                    }

                case 3:
                    // ========== QUITTER ==========
                    systemeActif = false;
                    System.out.println("\nMerci d'avoir utilisé le système RQV !");
                    break;

                default:
                    System.out.println("Choix invalide !");
            }
        }
        scanner.close();
    }
}
