import Exeption.KeyInvalidExeption;
import Exeption.NoNoteExeption;
import Exeption.ValueExeption;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestEtudiant {
    Etudiant etudiant;


    /**
     * Before each pour tout les tests,
     * creation d'un formation avec 4 matieres et creation d'un etudiant avec des notes
     * @throws ValueExeption
     * @throws KeyInvalidExeption
     */
    @BeforeEach
    public void preparationTest() throws ValueExeption, KeyInvalidExeption {
        //creation de la formation
        Formation form = new Formation(254);
        form.ajouter("Anglais", 2);
        form.ajouter("Francais",1);
        form.ajouter("Mathématiques",1);
        form.ajouter("SVT",2);
        form.ajouter("EPS",1);

        //ceration de l'identité d'un etudiant
        Identite id = new Identite("BASTIEN", "Cedran", "125455225");

        //creation des resultat de l'etudiant


        etudiant = new Etudiant(id,form);

        //ajout des resultat de l'etudiant
        etudiant.ajouterNote("Francais",15);
        etudiant.ajouterNote("Francais",16);
        etudiant.ajouterNote("Anglais",10);
        etudiant.ajouterNote("Mathématiques",15);
        etudiant.ajouterNote("SVT",12);
    }

    /**
     * test d'ajout de note
     */
    @Test
    public void Test_ajout(){
        //test
        Assertions.assertEquals(15,etudiant.getResultat().get("Francais").get(0));
        Assertions.assertEquals(16,etudiant.getResultat().get("Francais").get(1));
    }


    /**
     * test de la methode calcul moyenne general
     * @throws KeyInvalidExeption
     */
    @Test
    public void Test_CalculeMoyenneGeneral() throws KeyInvalidExeption {
        //methode
        double avg = etudiant.calculMoyenneGenerale();
        Assertions.assertEquals(74.5/6,avg,0.01);
    }

    /**
     * test exception calcul moyenne mais matiere n'a pas de note
     */
    @Test
    public void test_calculeMoyenne_MatSansNote(){
        Assertions.assertThrows(NoNoteExeption.class,()->etudiant.calculMoyenneMatiere("EPS"));
    }

    /**
     * test exception calcul moyenne mais matiere n'existe pas
     */
    @Test
    public void Test_CalculeMoyenne_keyInvalidExeption(){
        Assertions.assertThrows(KeyInvalidExeption.class,()-> etudiant.calculMoyenneMatiere("math"));
    }

    /**
     * test exception note invalide
     */
    @Test
    public void test_CalculeMoyenne_noteNonValide(){
        Assertions.assertThrows(ValueExeption.class,()-> etudiant.ajouterNote("Anglais",-5));
        Assertions.assertThrows(ValueExeption.class,()-> etudiant.ajouterNote("Anglais",25));
    }

    /**
     * test de la methode toString
     */
    @Test
    public void test_ToString(){
        Assertions.assertEquals("BASTIEN\n" +
                "SVT : [12]\n" +
                "Anglais : [10]\n" +
                "Mathématiques : [15]\n" +
                "Francais : [15, 16]"
                ,etudiant.toString());
    }
}
