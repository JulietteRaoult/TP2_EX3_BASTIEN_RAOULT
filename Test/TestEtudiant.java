import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledForJreRange;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestEtudiant {
    Etudiant etudiant;


    @BeforeEach
    public void preparationTest(){
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("Anglais", 2);
        map.put("Francais",1);

        Formation form = new Formation(254, map);

        Identite id = new Identite("BASTIEN", "Cedran", "125455225");

        Map<String, List<Integer>> result = new HashMap<String, List<Integer>>();
        List<Integer> note =new ArrayList<Integer>();
        result.put("Anglais",note);
        List<Integer> noteF =new ArrayList<Integer>();
        result.put("Francais",noteF);

        etudiant = new Etudiant(id,form,result);

        etudiant.ajouterNote("Francais",15);
        etudiant.ajouterNote("Francais",16);
        etudiant.ajouterNote("Anglais",10);
    }

    @Test
    public void Test_ajout(){
        etudiant.ajouterNote("Francais",15);
        etudiant.ajouterNote("Francais",16);
        Assertions.assertEquals(15,etudiant.getResultat().get("Francais").get(0));
        Assertions.assertEquals(16,etudiant.getResultat().get("Francais").get(1));
    }


    @Test
    public void Test_CalculeMoyenneGeneral() throws KeyInvalidExeption {

        double avg = etudiant.calculMoyenneGenerale();
        Assertions.assertEquals(12.75,avg);
    }
}
