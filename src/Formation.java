import Exeption.KeyInvalidExeption;
import Exeption.ValueExeption;

import java.util.HashMap;
import java.util.Map;

public class Formation {

    private int id;         // id de la formation
    private Map<String, Integer> matiere;       //table des matieres avec leur coefficient

    /**
     * constructeur d'une formation
     * @param id      id de la formation
     */
    public Formation(int id){
        this.id = id;
        this.matiere = new HashMap<String, Integer>();
    }

    /**
     * methode qui supprime un element de la table matiere
     * @param matiere matiere a supprimer
     */
    public void supprimer(String matiere) throws KeyInvalidExeption{
        if(this.matiere.containsKey(matiere)){
            this.matiere.remove(matiere);
        }
        else{
            throw new KeyInvalidExeption();         // si la matiere n'existe pas
        }
    }

    /**
     * methode qui ajouter une matiere a la table des matieres
     * @param matiere   matiere a ajouter
     * @param coef      coef de la matiere
     */
    public void ajouter(String matiere, int coef) throws ValueExeption, KeyInvalidExeption {
        if (coef<0){
            throw new ValueExeption();          // coef incorrect
        }else if(!this.matiere.containsKey(matiere)){
            this.matiere.put(matiere,coef);
        }else{
            throw new KeyInvalidExeption();         // si la matiere existe deja
        }

    }

    /**
     * methode qui retourne le coef d'une matiere donnee
     * @param matiere   matiere dont on veut le coef
     * @return      coef de la matiere passee en parametre
     * @throws KeyInvalidExeption
     */
    public int getCoef(String matiere) throws KeyInvalidExeption {
        if (!this.matiere.containsKey(matiere)){            //si la matiere n'existe pas
            throw new KeyInvalidExeption();
        }
        else {
            return this.matiere.get(matiere);
        }
    }

    /**
     * methode equals qui compare deux formation est indique si elles sont egales
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        Formation f = (Formation) obj;
        return this.id == f.id;
    }


    /**
     * getter de la table matiere
     * @return la table matiere
     */
    public Map<String, Integer> getMatiere() {
        return matiere;
    }


}
