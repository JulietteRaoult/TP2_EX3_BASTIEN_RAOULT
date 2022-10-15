import Exeption.EtudiantNotFoundException;
import Exeption.FormationNotCorresponding;
import Exeption.KeyInvalidExeption;
import Exeption.NoNoteExeption;

import java.util.*;

public class Groupe {

    private List<Etudiant> etudiants;  // liste d'etudiants
    private Formation formation;   // formation a laquelle ils participent

    /**
     * constructeur d'un groupe
     * @param formation   formation en parametre
     */
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
        if(etudiant.getFormation().equals(this.formation)){         // si l'etudiant a ajouter a bien la meme formation que le groupe
            etudiants.add(etudiant);
            res = true;
        }else {
            throw new FormationNotCorresponding();
        }
        return res;
    }


    /**
     * methode qui supprime un etudiant du groupe
     * @param etudiant etudiant a supprimer
     * @throws EtudiantNotFoundException    si l'etudiant n'existe pas dans le groupe
     */
    public void supprimerEtudiant(Etudiant etudiant) throws EtudiantNotFoundException {
        if(etudiants.contains(etudiant)) {          //si l'etudiant est present
            etudiants.remove(etudiant);             // on l'enleve
        }else{
            throw new EtudiantNotFoundException();      //sinon exception
        }
    }


    /**
     * methode qui trie les etudiants du groupe en fonction de leur nom de famille dans l'ordre alphabetique
     */
    public void triAlpha(){
        this.etudiants.sort(new Comparator<Etudiant>() {
            @Override
            public int compare(Etudiant o1, Etudiant o2) {
                return o1.getIdentite().getNom().compareTo(o2.getIdentite().getNom());
            }
        });

    }

    /**
     * methode qui trie les etudiants du groupe en fonction de leur nom de famille dans l'ordre inverse de l'alphabet
     */
    public void triAntiAlpha(){
        this.etudiants.sort(new Comparator<Etudiant>() {
            @Override
            public int compare(Etudiant o1, Etudiant o2) {
                return (o1.getIdentite().getNom().compareTo(o2.getIdentite().getNom()))*-1;
            }
        });
    }

    /**
     * getter de la liste d'etudiants
     * @return      la liste d'etudiants
     */
    public List<Etudiant> getEtudiants() {
        return etudiants;
    }


    /**
     * getter de la formation du groupe
     * @return la formation
     */
    public Formation getFormation() {
        return formation;
    }


    /**
     * methode qui calcul la moyenne du groupe dans une matiere donnee
     * @param matiere   matiere donnee
     * @return  la moyenne du groupe dans cette matiere
     * @throws KeyInvalidExeption
     * @throws EtudiantNotFoundException
     */
    public double  calculerMoyenneGroupeMatiere(String matiere) throws KeyInvalidExeption, EtudiantNotFoundException {
        double res = -1;
        double moyenne=0;
        int nbEtudiants = 0;
        if (!formation.getMatiere().containsKey(matiere)){          // si la matiere n'est pas presente dans la formation
            throw new KeyInvalidExeption();
        }else if (this.etudiants.isEmpty()){                    // si la liste d'etudiants est vide
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


    /**
     * methode qui tri les etudiants d'un groupe en fonction de leur moyenne general, meilleur moyenne en premier
     */
    public void triParMerite(){
        this.etudiants.sort(new Comparator<Etudiant>() {
            @Override
            public int compare(Etudiant o1, Etudiant o2) {
                int res = -5000;
                double moyenneO1 = o1.calculMoyenneGenerale();
                double moyenne02 = o2.calculMoyenneGenerale();
                if (moyenneO1==moyenne02){
                    res = 0;
                }else if (moyenneO1>moyenne02){
                    res = -1;
                }else {
                    res =1;
                }
                return res;
            }
        });
    }

    /**
     * methode qui calcul la moyenne general d'un groupe
     * @return   moyenne general d'un groupe
     */
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
