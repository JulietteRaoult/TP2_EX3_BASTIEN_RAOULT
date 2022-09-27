import com.sun.source.tree.LineMap;
import jdk.jshell.execution.StreamingExecutionControl;

import java.util.Map;

public class Formation {

    private int id;         // id de la formation
    private Map<String, Integer> matiere;       //table des matieres avec leur coefficient

    /**
     * constructeur d'une formation
     * @param id      id de la formation
     * @param mat     table des matiere
     */
    public Formation(int id, Map<String, Integer> mat){
        this.id = id;
        this.matiere = mat;
    }

    /**
     * methode qui supprime un element de la table matiere
     * @param matiere matiere a supprimer
     */


    public void supprimer(String matiere){
        this.matiere.remove(matiere);
    }

    /**
     * methode qui ajouter une matiere a la table des matieres
     * @param matiere   matiere a ajouter
     * @param coef      coef de la matiere
     */
    public void ajouter(String matiere, int coef){
        this.matiere.put(matiere,coef);
    }

    /**
     * methode qui retourne le coef d'une matiere donnee
     * @param matiere   matiere dont on veut le coef
     * @return      coef de la matiere passee en parametre
     * @throws KeyInvalidExeption
     */
    public int getCoef(String matiere) throws KeyInvalidExeption {
        if (!this.matiere.containsKey(matiere)){
            throw new KeyInvalidExeption();
        }
        else {
            return this.matiere.get(matiere);
        }
    }


    public int getId() {
        return id;
    }

    public Map<String, Integer> getMatiere() {
        return matiere;
    }

    @Override
    public boolean equals(Object obj) {
        Formation f = (Formation) obj;
        return this.id == f.id;
    }
}
