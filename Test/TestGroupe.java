import Exeption.EtudiantNotFoundException;
import Exeption.FormationNotCorresponding;
import Exeption.KeyInvalidExeption;
import Exeption.ValueExeption;
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
    public void preparerTest() throws ValueExeption, KeyInvalidExeption {

        formation = new Formation(254);
        formation.ajouter("Anglais", 2);
        formation.ajouter("Français",1);
        formation.ajouter("Mathématiques",1);
        formation.ajouter("SVT",2);


        Identite id = new Identite("BASTIEN", "Cedran", "125455225");
        etudiant = new Etudiant(id,formation);

        Identite id1 = new Identite("TRAN", "Maëva", "125455245");
        etudiant1 = new Etudiant(id1,formation);

        Identite id2 = new Identite("RAOULT", "Juliette", "125455248");
        etudiant2 = new Etudiant(id2,formation);

        g = new Groupe(formation);
    }

    @Test
    public void Test_AjouterEtudiant() throws FormationNotCorresponding {
        //methode teste
        g.ajouterEtudiant(etudiant);

        //test
        Assertions.assertTrue(g.getEtudiants().contains(etudiant));
    }

    @Test
    public void test_ajouterEtudiant_Exeption(){
        //preparation
        Formation f = new Formation(455);
        Etudiant e = new Etudiant(new Identite("55","5555","fsdf555"),f);

        //test
        Assertions.assertThrows(FormationNotCorresponding.class,()->g.ajouterEtudiant(e));
    }

    @Test
    public void Test_supprimerEtudiant() throws EtudiantNotFoundException, FormationNotCorresponding {
        //methode teste
        g.ajouterEtudiant(etudiant);
        g.supprimerEtudiant(etudiant);

        //test
        Assertions.assertTrue(!g.getEtudiants().contains(etudiant));
    }

    @Test
    public void Test_supprimerEtudiant_Exeption(){

        Assertions.assertThrows(EtudiantNotFoundException.class,()->g.supprimerEtudiant(etudiant));
    }

    @Test
    public void Test_triAlpha() throws FormationNotCorresponding {
        g.ajouterEtudiant(etudiant);
        g.ajouterEtudiant(etudiant1);
        g.ajouterEtudiant(etudiant2);

        g.triAlpha();

        Assertions.assertEquals(etudiant,g.getEtudiants().get(0));
        Assertions.assertEquals(etudiant2,g.getEtudiants().get(1));
        Assertions.assertEquals(etudiant1,g.getEtudiants().get(2));
    }

    @Test
    public void Test_triAntiAlpha() throws FormationNotCorresponding {
        g.ajouterEtudiant(etudiant);
        g.ajouterEtudiant(etudiant1);
        g.ajouterEtudiant(etudiant2);

        g.triAntiAlpha();

        Assertions.assertEquals(etudiant,g.getEtudiants().get(2));
        Assertions.assertEquals(etudiant2,g.getEtudiants().get(1));
        Assertions.assertEquals(etudiant1,g.getEtudiants().get(0));
    }


    @Test
    public void test_triParMerite() throws ValueExeption, KeyInvalidExeption, FormationNotCorresponding {
        etudiant.ajouterNote("Français",20);
        etudiant.ajouterNote("Anglais",20);
        etudiant.ajouterNote("Mathématiques",20);
        etudiant.ajouterNote("SVT",20);

        etudiant1.ajouterNote("Français",15);
        etudiant1.ajouterNote("Anglais",15);
        etudiant1.ajouterNote("Mathématiques",15);
        etudiant1.ajouterNote("SVT",15);

        etudiant2.ajouterNote("Français",10);
        etudiant2.ajouterNote("Anglais",10);
        etudiant2.ajouterNote("Mathématiques",10);
        etudiant2.ajouterNote("SVT",10);

        g.ajouterEtudiant(etudiant);
        g.ajouterEtudiant(etudiant1);
        g.ajouterEtudiant(etudiant2);

        g.triParMerite();

        Assertions.assertEquals(etudiant,g.getEtudiants().get(0));
        Assertions.assertEquals(etudiant1,g.getEtudiants().get(1));
        Assertions.assertEquals(etudiant2,g.getEtudiants().get(2));

    }

}
