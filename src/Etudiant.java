import Exeption.KeyInvalidExeption;
import Exeption.NoNoteExeption;
import Exeption.ValueExeption;

import java.security.Key;
import java.util.*;

public class Etudiant {


    private Identite identite;              // identite de l'etudiant
    private Formation formation;                    // formation de l'etudiant
    private Map<String, List<Integer>> resultat;            // Table resultat d'un etudiant, qui associe une matière avec sa liste de notes

    /**
     * constructeur d'un etudiant
     *      cree la map resulta avec les matirer de la formation
     * @param id    id de l'etudiant
     * @param form  formation de l'etidiant
     */

    public Etudiant(Identite id, Formation form){
        this.identite=id;
        this.formation = form;

        //creation de la liste de resultat
        this.resultat = new HashMap<String, List<Integer>>();
        Set<String> s =  form.getMatiere().keySet();
        for (String v : s){
            this.resultat.put(v,new ArrayList<Integer>());
        }

    }

    /**
     * methode qui ajoute une note
     * @param matiere   matiere a laquelle on ajoute la note
     * @param note      note a ajouter dans la matiere
     * @return  true si ajoute, false sinon
     */
    public boolean ajouterNote(String matiere, int note) throws ValueExeption, KeyInvalidExeption {
        boolean res = false;
        if(note >= 0 && note <=20 ){    //verification que la note est valide
            if(resultat.containsKey(matiere)){      //verification que la matiere existe
                resultat.get(matiere).add(note);
                res=true;
            }else{
                throw new KeyInvalidExeption();
            }
        }else{
            throw new ValueExeption();
        }
        return res;
    }



    /**
     * methode qui calcul la moyenne d'un etudiant dans un matiere donnee
     * @param matiere dans laquelle on calcule la moyenne
     * @return  la moyenne de l'etudiant dans la matiere donnee
     */
    public double calculMoyenneMatiere(String matiere) throws KeyInvalidExeption, NoNoteExeption {
        double res = 0.0;
        int nb = 0;
        if (resultat.containsKey(matiere))      //verification que la matiere existe
        {
            for (int i = 0; i < resultat.get(matiere).size(); i++)
            {
                res += resultat.get(matiere).get(i);
                nb++;
            }
            if (nb != 0) {
                return res/nb;
            }
            else
            {
                throw new NoNoteExeption();             //si aucune note n'a ete trouve

            }
        }
        else {
            throw new KeyInvalidExeption();     // si la matiere n'existe pas
        }

    }


    /**
     * methode qui calcul la moyenne generale d'un etudiant
     * @return  moyenne generale de l'etudiant
     * @throws KeyInvalidExeption
     */
    public double calculMoyenneGenerale() {
        double res = 0;
        double moyenne;

        int coeff;
        int nbcoeff = 0;
        Set<String> set = formation.getMatiere().keySet();
        for(String s : set){
            try
            {
                moyenne = calculMoyenneMatiere(s);
                coeff = formation.getCoef(s);
                moyenne = moyenne *coeff;
                nbcoeff += coeff;
                res += moyenne;
            }catch (NoNoteExeption n)
            {
                System.out.println("Pas de note pour la matière " + s);
            }catch (KeyInvalidExeption k){
                System.out.println("la matiere"+ s +"n'est as presente pour cette etudiant");
           }
        }
        return res/nbcoeff;
    }

    ////////////////////////
    //      GETTER        //
    ////////////////////////

    public Identite getIdentite() {
        return identite;
    }

    public Formation getFormation() {
        return formation;
    }

    public Map<String, List<Integer>> getResultat() {
        return resultat;
    }


        public String toString() {
        String res = this.identite.getNom();
        for (String n : resultat.keySet())
        {
            res += "\n"+n+ " : "+ this.resultat.get(n);
        }

        return res;
    }
}
