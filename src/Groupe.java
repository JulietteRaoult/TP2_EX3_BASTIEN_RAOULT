import java.util.ArrayList;

public class Groupe {

    private ArrayList<Etudiant> etudiants = new ArrayList<Etudiant>();  // liste d'etudiants
    private Formation formation;            // formation a laquelle ils participent

    /**
     * methode qui ajoute un etudiant a la liste d'etudiants
     * @param etudiant  etudiant a ajouter
     * @return      true si l'etudiant a ete ajoute, false sinon
     */
    public boolean ajouterEtudiant(Etudiant etudiant){
        boolean res =false;
        if(etudiant.getFormation().equals(this.formation)){
            etudiants.add(etudiant);
            res = true;
        }
        return res;
    }

    public void supprimerEtudiant(Etudiant etudiant) throws EtudiantNotFoundException {
        if(etudiants.contains(etudiant)) {
            etudiants.remove(etudiant);
        }else{
            throw new EtudiantNotFoundException();
        }
    }

    public double  calculerMoyenneGroupeMatiere(String matiere) throws KeyInvalidExeption {
        double moyenne=0;
        int nbEtudiants = 0;
        for(Etudiant e : etudiants){
            if (e.calculMoyenneMatiere(matiere) > -1) {
                moyenne += e.calculMoyenneMatiere(matiere);
                nbEtudiants++;
            }
        }
        return moyenne/nbEtudiants;

    }

    public double calculerMoyenneGroupe() throws KeyInvalidExeption {
        double moyenne = 0;
        int nbEtudiants = 0;
        for (Etudiant e : etudiants) {
            moyenne += e.calculMoyenneGenerale();
            nbEtudiants++;
        }
        return moyenne / nbEtudiants;
    }

    public void setFormation(Formation formation) {
        this.formation = formation;
    }
}
