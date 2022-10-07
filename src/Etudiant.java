import java.util.*;

public class Etudiant {


    private Identite identite;              // identite de l'etudiant
    private Formation formation;                    // formation de l'etudiant
    private Map<String, List<Integer>> resultat;            // Table resultat d'un etudiant, qui associe une matière avec sa liste de notes

    /**
     * constructeur d'un etudiant
     * @param id    id de l'etudiant
     * @param form  formation de l'eutidant
     * @param res   resultat de l'etudiant
     */

    public Etudiant(Identite id, Formation form, Map <String,List<Integer>> res){
        this.identite=id;
        this.formation = form;
        this.resultat = res;
    }

    /**
     * methode qui ajoute une note
     * @param matiere   matiere a laquelle on ajoute la note
     * @param note      note a ajouter dans la matiere
     * @return  true si ajoute, false sinon
     */
    public boolean ajouterNote(String matiere, int note){
        boolean res = false;
        if(note >= 0 && note <=20 ){
            if(resultat.containsKey(matiere)){
                resultat.get(matiere).add(note);
                res=true;
            }else{
                resultat.put(matiere,new ArrayList<Integer>(note));
            }
        }
        return res;
    }



    /**
     * methode qui calcul la moyenne d'un etudiant dans un matiere donnee
     * @param matiere dans laquelle on calcule la moyenne
     * @return  la moyenne de l'etudiant dans la matiere donnee
     */
        public double calculMoyenneMatiere(String matiere) throws KeyInvalidExeption {
            double res = 0.0;
            int nb = 0;
            if (resultat.containsKey(matiere))
            {
                for (int i = 0; i < resultat.get(matiere).size(); i++)
                {
                    res += resultat.get(matiere).get(i);
                    nb++;
                }
                if (nb != 0) {
                    return res/nb;
                }
            }
            return -1;
    }


    /**
     * methode qui calcul la moyenne generale d'un etudiant
     * @return  moyenne generale de l'etudiant
     * @throws KeyInvalidExeption
     */
    public double calculMoyenneGenerale() throws KeyInvalidExeption {
        double res = 0;
        double moyenne;

        int coeff;
        int nbcoeff = 0;
        Set<String> set = formation.getMatiere().keySet();
        for(String s : set){
            moyenne = calculMoyenneMatiere(s);
            coeff = formation.getCoef(s);
            moyenne = moyenne *coeff;
            nbcoeff += coeff;
            res += moyenne;
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


    public int compareTo(Object object) {
        Etudiant et = (Etudiant) object;
        return this.identite.getNom().compareTo(et.identite.getNom());


    }
        public String toString() {
        String res = " ";
        for (String n : resultat.keySet())
        {
            res += n+ " : "+ this.resultat.get(n)+ " \n";
        }

        return res;
    }
}
