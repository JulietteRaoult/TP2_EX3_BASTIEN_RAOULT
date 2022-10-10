import Exeption.KeyInvalidExeption;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestEtudiant {
    Etudiant etudiant;


    @BeforeEach
    public void preparationTest(){
        //creation de la formation
        Formation form = new Formation(254);
        form.getMatiere().put("Anglais", 2);
        form.getMatiere().put("Francais",1);

        //ceration de l'identité d'un etudiant
        Identite id = new Identite("BASTIEN", "Cedran", "125455225");

        //creation des resultat de l'etudiant
        Map<String, List<Integer>> result = new HashMap<String, List<Integer>>();
        List<Integer> note =new ArrayList<Integer>();
        result.put("Anglais",note);
        List<Integer> noteF =new ArrayList<Integer>();
        result.put("Francais",noteF);

        etudiant = new Etudiant(id,form,result);

        //ajout des resultat de l'etudiant
        etudiant.ajouterNote("Francais",15);
        etudiant.ajouterNote("Francais",16);
        etudiant.ajouterNote("Anglais",10);
    }

    @Test
    public void Test_ajout(){
        //test
        Assertions.assertEquals(15,etudiant.getResultat().get("Francais").get(0));
        Assertions.assertEquals(16,etudiant.getResultat().get("Francais").get(1));
    }


    @Test
    public void Test_CalculeMoyenneGeneral() throws KeyInvalidExeption {
        //methode
        double avg = etudiant.calculMoyenneGenerale();
        Assertions.assertEquals(35.5/3,avg,0.01);
    }

    @Test
    public void Test_CalculeMoyenne_Exeption(){
        Assertions.assertThrows(KeyInvalidExeption.class,()-> etudiant.calculMoyenneMatiere("math"));
    }
}
