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
    public void preparation_test(){

        Formation form = new Formation(254);
        form.getMatiere().put("Anglais", 2);
        form.getMatiere().put("Francais",1);

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
        result2.put("Anglais",note2);
        List<Integer> noteF2 =new ArrayList<Integer>();
        result2.put("Francais",noteF2);

        Map<String, List<Integer>> result3 = new HashMap<String, List<Integer>>();
        List<Integer> note3 =new ArrayList<Integer>();
        result3.put("Anglais",note3);
        List<Integer> noteF3 =new ArrayList<Integer>();
        result3.put("Francais",noteF3);

        Etudiant etudiant1 = new Etudiant(id,form,result);
        Etudiant etudiant2 = new Etudiant(id1,form,result2);
        Etudiant etudiant3 = new Etudiant(id2,form,result3);

        etudiant1.ajouterNote("Francais",15);
        etudiant1.ajouterNote("Francais",16);
        etudiant1.ajouterNote("Anglais",10);

        etudiant2.ajouterNote("Francais",15);
        etudiant2.ajouterNote("Francais",16);
        etudiant2.ajouterNote("Anglais",15);

        etudiant3.ajouterNote("Francais",15);
        etudiant3.ajouterNote("Francais",16);
        etudiant3.ajouterNote("Anglais",20);


        //groupe = new Groupe();
        groupe.setFormation(form);
        groupe.ajouterEtudiant(etudiant1);
        groupe.ajouterEtudiant(etudiant2);
        groupe.ajouterEtudiant(etudiant3);

        System.out.println(etudiant1);
    }

    @Test
    public void test_calculMoyenneMatiere() throws KeyInvalidExeption {
        double moyenneMatiere = groupe.calculerMoyenneGroupeMatiere("Anglais");
        Assertions.assertEquals(15,moyenneMatiere,0.01);
        Assertions.assertEquals(15.5, groupe.calculerMoyenneGroupeMatiere("Francais"),0.01);
    }


    @Test
    public void test_calculMoyenneGenerale() throws KeyInvalidExeption {
        Assertions.assertEquals(((35.5/3)+(45.5/3)+(55.5/3))/3,groupe.calculerMoyenneGroupe(),0.01);
    }


}
