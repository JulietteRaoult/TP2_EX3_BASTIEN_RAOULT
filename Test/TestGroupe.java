import Exeption.EtudiantNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestGroupe {
    Etudiant etudiant;
    Etudiant etudiant1;
    Etudiant etudiant2;
    Formation formation;
    Groupe g;

    @BeforeEach
    public void preparerTest(){

        formation = new Formation(254);
        formation.getMatiere().put("Anglais", 2);
        formation.getMatiere().put("Francais",1);


        Map<String, List<Integer>> result = new HashMap<String, List<Integer>>();
        List<Integer> note =new ArrayList<Integer>();
        result.put("Anglais",note);
        List<Integer> noteF =new ArrayList<Integer>();
        result.put("Francais",noteF);

        Identite id = new Identite("BASTIEN", "Cedran", "125455225");
        etudiant = new Etudiant(id,formation,result);

        Identite id1 = new Identite("TRAN", "Maëva", "125455245");
        etudiant1 = new Etudiant(id1,formation,result);

        Identite id2 = new Identite("RAOULT", "Juliette", "125455248");
        etudiant2 = new Etudiant(id2,formation,result);

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

    @Test
    public void Test_triAlpha(){
        g.ajouterEtudiant(etudiant);
        g.ajouterEtudiant(etudiant1);
        g.ajouterEtudiant(etudiant2);

        g.triAlpha();

        Assertions.assertEquals(etudiant,g.getEtudiants().get(0));
        Assertions.assertEquals(etudiant2,g.getEtudiants().get(1));
        Assertions.assertEquals(etudiant1,g.getEtudiants().get(2));
    }

    @Test
    public void Test_triAntiAlpha(){
        g.ajouterEtudiant(etudiant);
        g.ajouterEtudiant(etudiant1);
        g.ajouterEtudiant(etudiant2);

        g.triAntiAlpha();

        Assertions.assertEquals(etudiant,g.getEtudiants().get(2));
        Assertions.assertEquals(etudiant2,g.getEtudiants().get(1));
        Assertions.assertEquals(etudiant1,g.getEtudiants().get(0));
    }

}
