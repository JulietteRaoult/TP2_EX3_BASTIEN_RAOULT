import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestCalculMoyenneGroupe {

    @Test
    public void test_calculMoyenneGroupeMatiere(){
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("Anglais", 2);
        map.put("Francais",1);

        Formation form = new Formation(254, map);

        Identite id = new Identite("BASTIEN", "Cedran", "125455225");
        Identite id1 = new Identite("RAOULT", "Juliette", "157795252");
        Identite id2 = new Identite("PIERRE", "Titouan", "174632485");

        Map<String, List<Integer>> result = new HashMap<String, List<Integer>>();
        List<Integer> note =new ArrayList<Integer>();
        result.put("Anglais",note);
        List<Integer> noteF =new ArrayList<Integer>();
        result.put("Francais",noteF);

        Map<String, List<Integer>> result2 = new HashMap<String, List<Integer>>();
        List<Integer> note2 =new ArrayList<Integer>();
        result.put("Anglais",note);
        List<Integer> noteF2 =new ArrayList<Integer>();
        result.put("Francais",noteF);

        Map<String, List<Integer>> result3 = new HashMap<String, List<Integer>>();
        List<Integer> note3 =new ArrayList<Integer>();
        result.put("Anglais",note);
        List<Integer> noteF3 =new ArrayList<Integer>();
        result.put("Francais",noteF);

        Etudiant etudiant1 = new Etudiant(id,form,result);
        Etudiant etudiant2 = new Etudiant(id1,form,result2);
        Etudiant etudiant3 = new Etudiant(id2,form,result3);

        etudiant1.ajouterNote("Francais",15);
        etudiant1.ajouterNote("Francais",16);
        etudiant1.ajouterNote("Anglais",10);

        etudiant2.ajouterNote("Francais",15);
        etudiant2.ajouterNote("Francais",16);
        etudiant2.ajouterNote("Anglais",10);

        etudiant3.ajouterNote("Francais",15);
        etudiant3.ajouterNote("Francais",16);
        etudiant3.ajouterNote("Anglais",10);

    }
}
