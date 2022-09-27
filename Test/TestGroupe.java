import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestGroupe {

    @Test
    public void Test_AjouterEtudiant(){
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

        Etudiant etudiant = new Etudiant(id,form,result);

        Groupe g = new Groupe(new ArrayList<Etudiant>(),form);
    }
}
