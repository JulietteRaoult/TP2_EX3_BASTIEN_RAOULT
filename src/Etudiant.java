import java.util.*;

public class Etudiant {

    private Identite identite;
    private Formation formation;
    private Map<String, List<Integer>> resultat;

    public Etudiant(Identite id, Formation form, Map <String,List<Integer>> res){
        this.identite=id;
        this.formation = form;
        this.resultat = res;
    }

    /**
     * methode qui ajoute une note
     * @param matiere
     * @param note
     * @return
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


    public float calculMoyenneMatiere(String matiere){
        float res =0;
        int j = 0;
        if(resultat.containsKey(matiere)){
            for (int i = 0; i < resultat.get(matiere).size(); i++) {
                res += resultat.get(matiere).get(i);
                j++;
            }
            res = res/j;
        }
        return res;
    }

    public float calculMoyenneGenerale() throws KeyInvalidExeption {
        float res = 0;
        float moyenne;
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
        return res;
    }


    public Identite getIdentite() {
        return identite;
    }

    public Formation getFormation() {
        return formation;
    }

    public Map<String, List<Integer>> getResultat() {
        return resultat;
    }
}
