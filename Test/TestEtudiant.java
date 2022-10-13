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


    @BeforeEach
    public void preparationTest() throws ValueExeption, KeyInvalidExeption {
        //creation de la formation
        Formation form = new Formation(254);
        form.ajouter("Anglais", 2);
        form.ajouter("Francais",1);
        form.ajouter("Math",1);

        //ceration de l'identité d'un etudiant
        Identite id = new Identite("BASTIEN", "Cedran", "125455225");


        etudiant = new Etudiant(id,form);

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
    public void test_calculeMoyenne_MatSansNote(){
        Assertions.assertThrows(NoNoteExeption.class,()->etudiant.calculMoyenneMatiere("Math"));
    }

    @Test
    public void Test_CalculeMoyenne_keyInvalidExeption(){
        Assertions.assertThrows(KeyInvalidExeption.class,()-> etudiant.calculMoyenneMatiere("math"));
    }

    @Test
    public void test_CalculeMoyenne_noteNonValide(){
        Assertions.assertThrows(ValueExeption.class,()-> etudiant.ajouterNote("Anglais",-5));
        Assertions.assertThrows(ValueExeption.class,()-> etudiant.ajouterNote("Anglais",25));
    }

//    @Test
//    public void test_
}
