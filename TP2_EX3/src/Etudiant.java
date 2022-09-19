import java.util.List;
import java.util.Map;

public class Etudiant {

    private Identite identite;
    private Formation formation;
    private Map<String, List<Integer>> resultat;

    public Etudiant(Identite id, Formation form, Map <String,Integer> res){
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
            }
        }
        return res;
    }

    
}
