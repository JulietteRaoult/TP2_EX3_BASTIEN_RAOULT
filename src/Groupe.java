import java.util.ArrayList;

public class Groupe {

    private ArrayList<Etudiant> etudiants;
    private Formation formation;

    public boolean ajouterEtudiant(Etudiant etudiant){
        boolean res =false;
        if(etudiant.equals(this.formation)){
            etudiants.add(etudiant);
            res = true;
        }
        return res;
    }
}
