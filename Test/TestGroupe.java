import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestGroupe {
    Etudiant etudiant;
    Formation formation;
    Groupe g;

    @BeforeEach
    public void preparerTest(){
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("Anglais", 2);
        map.put("Francais",1);

        formation = new Formation(254, map);

        Identite id = new Identite("BASTIEN", "Cedran", "125455225");

        Map<String, List<Integer>> result = new HashMap<String, List<Integer>>();
        List<Integer> note =new ArrayList<Integer>();
        result.put("Anglais",note);
        List<Integer> noteF =new ArrayList<Integer>();
        result.put("Francais",noteF);

        etudiant = new Etudiant(id,formation,result);

        g = new Groupe(new ArrayList<Etudiant>(),formation);
    }

    @Test
    public void Test_AjouterEtudiant(){
        //methode teste
        g.ajouterEtudiant(etudiant);

        //test
        Assertions.assertTrue(g.getEtudiants().contains(etudiant));
    }

    @Test
    public void Test_supprimerEtudiant() throws EtudiantNotFoundException {
        //methode teste
        g.supprimerEtudiant(etudiant);

        //test
        Assertions.assertTrue(!g.getEtudiants().contains(etudiant));
    }

    @Test
    public void Test_supprimerEtudiant_Exeption(){

        Assertions.assertThrows(EtudiantNotFoundException.class,()->g.supprimerEtudiant(etudiant));
    }

}
