import java.util.*;

public class Groupe {

    private List<Etudiant> etudiants;  // liste d'etudiants
    private Formation formation;   // formation a laquelle ils participent

    public Groupe(List<Etudiant> etudiants, Formation formation) {
        this.etudiants = etudiants;
        this.formation = formation;
    }

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

    public void triAlpha(){
        this.etudiants.sort(new Comparator<Etudiant>() {
            @Override
            public int compare(Etudiant o1, Etudiant o2) {
                return o1.getIdentite().getNom().compareTo(o2.getIdentite().getNom());
            }
        });

    }


    public void triAntiAlpha(){
        this.etudiants.sort(new Comparator<Etudiant>() {
            @Override
            public int compare(Etudiant o1, Etudiant o2) {
                return (o1.getIdentite().getNom().compareTo(o2.getIdentite().getNom()))*-1;
            }
        });
    }

    public List<Etudiant> getEtudiants() {
        return etudiants;
    }

    public Formation getFormation() {
        return formation;
    }
}
