import com.sun.source.tree.LineMap;
import jdk.jshell.execution.StreamingExecutionControl;

import java.util.Map;

public class Formation {
    private int id;
    private Map<String, Integer> matiere;

    public Formation(int id, Map<String, Integer> mat){
        this.id = id;
        this.matiere = mat;
    }

    public void supprimer(String matiere){
        this.matiere.remove(matiere);
    }

    public void ajouter(String matiere, int coef){
        this.matiere.put(matiere,coef);
    }

    public void getCoef(String matiere){

        this.matiere.get(matiere);
    }


}
