package Projet.service;

import Projet.utilisateur.Declaration;
import Projet.utilisateur.EtatDeclaration;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class RQV {
    private String id;
    private Date dateRapport;
    private List<Declaration> nouvellesDeclarations;
    private List<Declaration> declarationsModifiees;
    private List<Declaration> declarationsResolues;

    public RQV(Date dateRapport, List<Declaration> toutesDeclarations) {
        this.id = "RQV-" + System.currentTimeMillis();
        this.dateRapport = dateRapport;

        // Filtrer les déclarations par état
        this.nouvellesDeclarations = toutesDeclarations.stream()
                .filter(d -> d.getEtat() == EtatDeclaration.NOUVELLE)
                .collect(Collectors.toList());

        this.declarationsModifiees = toutesDeclarations.stream()
                .filter(d -> d.getEtat() == EtatDeclaration.MODIFIEE)
                .collect(Collectors.toList());

        this.declarationsResolues = toutesDeclarations.stream()
                .filter(d -> d.getEtat() == EtatDeclaration.RESOLUE)
                .collect(Collectors.toList());
    }

    public String genererRapport() {
        StringBuilder rapport = new StringBuilder();

        rapport.append("[   RAPPORT QUOTIDIEN DES VOLS (RQV)     ]\n");

        rapport.append("Date : ").append(dateRapport).append("\n");
        rapport.append("ID Rapport : ").append(id).append("\n\n");

        // Détails des nouvelles déclarations
        if (!nouvellesDeclarations.isEmpty()) {
            rapport.append("[NOUVELLES DÉCLARATIONS :]\n");

            for (Declaration d : nouvellesDeclarations) {
                rapport.append("  • Dossier ").append(d.getNumeroDossier())
                        .append(" - ").append(d.getVictime().getNom())
                        .append(" (").append(d.getLieu()).append(")\n");
            }
        }

        // Affaires résolues
        if (!declarationsResolues.isEmpty()) {
            rapport.append("[AFFAIRES RÉSOLUES :]\n");

            for (Declaration d : declarationsResolues) {
                rapport.append("  • Dossier ").append(d.getNumeroDossier())
                        .append(" - RÉSOLU\n");
            }
        }


        return rapport.toString();
    }

    // Getters
    public String getId() { return id; }
    public Date getDateRapport() { return dateRapport; }
}
