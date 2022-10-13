import Exeption.KeyInvalidExeption;
import Exeption.ValueExeption;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class TestFormation {

    /**
     * test de la methode supprimer
     */
    @Test
    public void test_supprimer() throws KeyInvalidExeption, ValueExeption {
        Formation f = new Formation(1);
        f.ajouter("Maths",3);
        f.ajouter("SVT",2);
        Map<String,Integer> map2 = new HashMap<String, Integer>();
        map2.put("SVT",2);
        f.supprimer("Maths");
        assertEquals(f.getMatiere(),map2);
    }
    @Test
    public void test_supprimerException() throws ValueExeption, KeyInvalidExeption {
        Formation f = new Formation(2);
        f.ajouter("SVT",2);
        Map<String,Integer> map2 = new HashMap<>();

        Assertions.assertThrows(KeyInvalidExeption.class,()-> f.supprimer("Maths"));
    }

    @Test
    public void test_ajouter() throws ValueExeption, KeyInvalidExeption {
        Map<String,Integer> map2 = new HashMap<String, Integer>();
        map2.put("SVT",2);
        map2.put("Maths",3);
        Formation f = new Formation(1);

        f.ajouter("SVT",2);
        f.ajouter("Maths",3);
        assertEquals(f.getMatiere(),map2);
    }

    @Test
    public void test_ajouterException() throws ValueExeption, KeyInvalidExeption {
        Formation f = new Formation(2);
        f.ajouter("SVT",2);
        f.ajouter("Maths",3);

        Assertions.assertThrows(KeyInvalidExeption.class,()-> f.ajouter("Maths",3));

    }

    @Test
    public void test_getCoeff() throws KeyInvalidExeption {
        Formation f = new Formation(1);
        f.getMatiere().put("SVT",2);
        int coeff= f.getCoef("SVT");
        assertEquals(coeff,2);
    }

    @Test
    public void test_exceptionCoeff_matiere_non_existante(){
        Formation f = new Formation(1);
        f.getMatiere().put("SVT",2);
        assertThrows(KeyInvalidExeption.class, () ->
              f.getCoef("Français") );
    }

    @Test
    public void test_exeption_ajout_Coeff_negatif(){
        Formation f = new Formation(1);
        assertThrows(ValueExeption.class,()->f.ajouter("francais",-2));
    }

    @Test
    public void test_equals(){
        Formation f = new Formation(1);
        f.getMatiere().put("SVT",2);
        Formation f2 = new Formation(1);
        f.getMatiere().put("SVT",2);
        assertTrue(f.equals(f2));
    }

    @Test
    public void test_instanciation_formation(){
        Formation f = new Formation(1);
        Assertions.assertEquals(true,f.getMatiere().isEmpty());

        f.getMatiere().put("SVT",2);
        f.getMatiere().put("Anglais",1);
        Assertions.assertEquals(false,f.getMatiere().isEmpty());
        Assertions.assertEquals(true,f.getMatiere().get("SVT")!=null);
        Assertions.assertEquals(true,f.getMatiere().get("Anglais")!=null);
    }
}
