import Exeption.EtudiantNotFoundException;
import Exeption.FormationNotCorresponding;
import Exeption.KeyInvalidExeption;
import Exeption.NoNoteExeption;

import java.util.*;

public class Groupe {

    private List<Etudiant> etudiants;  // liste d'etudiants
    private Formation formation;   // formation a laquelle ils participent

    public Groupe(Formation formation) {
        this.etudiants = new ArrayList<Etudiant>();
        this.formation = formation;
    }

    /**
     * methode qui ajoute un etudiant a la liste d'etudiants
     * @param etudiant  etudiant a ajouter
     * @return      true si l'etudiant a ete ajoute, false sinon
     */
    public boolean ajouterEtudiant(Etudiant etudiant) throws FormationNotCorresponding {
        boolean res =false;
        if(etudiant.getFormation().equals(this.formation)){
            etudiants.add(etudiant);
            res = true;
        }else {
            throw new FormationNotCorresponding();
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



    public double  calculerMoyenneGroupeMatiere(String matiere) throws KeyInvalidExeption, EtudiantNotFoundException {
        double res = -1;
        double moyenne=0;
        int nbEtudiants = 0;
        if (!formation.getMatiere().containsKey(matiere)){
            throw new KeyInvalidExeption();
        }else if (this.etudiants.isEmpty()){
            throw new EtudiantNotFoundException();
        }else
        {
            for(Etudiant e : etudiants){
                try
                {
                    if (e.calculMoyenneMatiere(matiere) > -1) {
                        moyenne += e.calculMoyenneMatiere(matiere);
                        nbEtudiants++;
                    }
                    res = moyenne/nbEtudiants;
                }catch (NoNoteExeption n)
                {
                    System.out.println(" L'étudiant "+e+" n'a pas de note pour la matière" + " " + matiere);
                }

            }
        }
        return res;
    }

    public double calculerMoyenneGroupe() {
        double moyenne = 0;
        int nbEtudiants = 0;
        for (Etudiant e : etudiants) {
            moyenne += e.calculMoyenneGenerale();
            nbEtudiants++;
        }
        return moyenne / nbEtudiants;
    }
}
