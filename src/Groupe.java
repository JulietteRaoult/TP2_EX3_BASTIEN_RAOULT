import java.util.ArrayList;

public class Groupe {

    private ArrayList<Etudiant> etudiants;  // liste d'etudiants
    private Formation formation;            // formation a laquelle ils participent

    /**
     * methode qui ajoute un etudiant a la liste d'etudiants
     * @param etudiant  etudiant a ajouter
     * @return      true si l'etudiant a ete ajoute, false sinon
     */
    public boolean ajouterEtudiant(Etudiant etudiant){
        boolean res =false;
        if(etudiant.equals(this.formation)){
            etudiants.add(etudiant);
            res = true;
        }
        return res;
    }

    public void supprimerEtudiant(Etudiant etudiant){
        etudiants.remove(etudiant);
    }
}
