import Exeption.KeyInvalidExeption;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TestCalculMoyenneGroupe {

    Groupe groupe;
    @BeforeEach
    public void preparation_test() throws KeyInvalidExeption {

        Formation form = new Formation(254);
        form.getMatiere().put("Anglais", 2);
        form.getMatiere().put("Francais",1);
        form.getMatiere().put("Mathématiques",1);
        form.getMatiere().put("SVT",2);

        Identite id = new Identite("BASTIEN", "Cedran", "125455225");
        Identite id1 = new Identite("RAOULT", "Juliette", "157795252");
        Identite id2 = new Identite("PIERRE", "Titouan", "174632485");

        Map<String, List<Integer>> result = new HashMap<String, List<Integer>>();
        List<Integer> note =new ArrayList<Integer>();
        result.put("Anglais",note);
        List<Integer> noteF =new ArrayList<Integer>();
        result.put("Francais",noteF);
        List<Integer> noteM  = new ArrayList<Integer>();
        result.put("Mathématiques",noteM);
        List<Integer> noteS = new ArrayList<Integer>();
        result.put("SVT",noteS);

        Map<String, List<Integer>> result2 = new HashMap<String, List<Integer>>();
        List<Integer> note2 =new ArrayList<Integer>();
        result2.put("Anglais",note2);
        List<Integer> noteF2 =new ArrayList<Integer>();
        result2.put("Francais",noteF2);
        List<Integer> noteM2  = new ArrayList<Integer>();
        result2.put("Mathématiques",noteM2);
        List<Integer> noteS2 = new ArrayList<Integer>();
        result2.put("SVT",noteS2);

        Map<String, List<Integer>> result3 = new HashMap<String, List<Integer>>();
        List<Integer> note3 =new ArrayList<Integer>();
        result3.put("Anglais",note3);
        List<Integer> noteF3 =new ArrayList<Integer>();
        result3.put("Francais",noteF3);
        List<Integer> noteM3  = new ArrayList<Integer>();
        result3.put("Mathématiques",noteM3);
        List<Integer> noteS3 = new ArrayList<Integer>();
        result3.put("SVT",noteS3);

        Etudiant etudiant1 = new Etudiant(id,form,result);
        Etudiant etudiant2 = new Etudiant(id1,form,result2);
        Etudiant etudiant3 = new Etudiant(id2,form,result3);

        etudiant1.ajouterNote("Francais",15);
        etudiant1.ajouterNote("Francais",16);
        etudiant1.ajouterNote("Anglais",10);
        etudiant1.ajouterNote("Mathématiques",16);
        etudiant1.ajouterNote("SVT",10);

        etudiant2.ajouterNote("Francais",15);
        etudiant2.ajouterNote("Francais",16);
        etudiant2.ajouterNote("Anglais",15);
        etudiant2.ajouterNote("Mathématiques",14);
        etudiant2.ajouterNote("SVT",13);

        etudiant3.ajouterNote("Francais",15);
        etudiant3.ajouterNote("Francais",16);
        etudiant3.ajouterNote("Anglais",20);
        etudiant3.ajouterNote("Mathématiques",12);
        etudiant3.ajouterNote("SVT",16);


        groupe = new Groupe(form);
        
        groupe.ajouterEtudiant(etudiant1);
        groupe.ajouterEtudiant(etudiant2);
        groupe.ajouterEtudiant(etudiant3);
    }

    @Test
    public void test_calculMoyenneMatiere() throws KeyInvalidExeption {
        double moyenneMatiere = groupe.calculerMoyenneGroupeMatiere("Anglais");
        Assertions.assertEquals(15,moyenneMatiere,0.01);
        Assertions.assertEquals(15.5, groupe.calculerMoyenneGroupeMatiere("Francais"),0.01);
        Assertions.assertEquals(14,groupe.calculerMoyenneGroupeMatiere("Mathématiques"),0.01);
        Assertions.assertEquals(13,groupe.calculerMoyenneGroupeMatiere("SVT"),0.01);
    }


    @Test
    public void test_calculMoyenneGenerale() throws KeyInvalidExeption {

        Assertions.assertEquals(groupe.calculerMoyenneGroupe(),((71.5/6)+(85.5/6)+(99.5/6))/3,0.02);
    }


}
