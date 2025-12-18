package Projet.Observer;

public interface Subject {
    void attacher(Observer observateur);
    void detacher(Observer observateur);
    void notifier();
}
