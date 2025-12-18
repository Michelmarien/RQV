package Projet.service;

import Projet.Observer.*;
import Projet.utilisateur.ObjetsTrouves;
import java.util.ArrayList;
import java.util.List;

public class SystemeObjetsTrouves implements Subject {
    private List<Observer> observateurs = new ArrayList<>();
    private List<ObjetsTrouves> objetsTrouves = new ArrayList<>();

    @Override
    public void attacher(Observer observateur) {
        observateurs.add(observateur);
        System.out.println("Observateur ajouté au système de notifications");
    }

    @Override
    public void detacher(Observer observateur) {
        observateurs.remove(observateur);
    }

    @Override
    public void notifier() {
        System.out.println("\n = NOTIFICATION EN COURS =");
        for (Observer obs : observateurs) {
            for (ObjetsTrouves objet : objetsTrouves) {
                obs.update(objet);
            }
        }
    }

    public void ajouterObjetTrouve(ObjetsTrouves objet) {
        objetsTrouves.add(objet);
        System.out.println("Objet trouvé enregistré : " + objet.getDescription());
        notifier(); // Notification automatique
    }

    public List<ObjetsTrouves> getObjetsTrouves() {
        return objetsTrouves;
    }
}
