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

    /**
     * test exception, supprimer une matiere qui n'est pas presente dans la formation
     * @throws ValueExeption
     * @throws KeyInvalidExeption
     */
    @Test
    public void test_supprimerException() throws ValueExeption, KeyInvalidExeption {
        Formation f = new Formation(2);
        f.ajouter("SVT",2);
        Map<String,Integer> map2 = new HashMap<>();

        Assertions.assertThrows(KeyInvalidExeption.class,()-> f.supprimer("Maths"));
    }

    /**
     * test de la methode ajouter
     * @throws ValueExeption
     * @throws KeyInvalidExeption
     */
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

    /**
     * test exception, ajouter une matiere deja presente dans la formation
     * @throws ValueExeption
     * @throws KeyInvalidExeption
     */
    @Test
    public void test_ajouterException() throws ValueExeption, KeyInvalidExeption {
        Formation f = new Formation(2);
        f.ajouter("SVT",2);
        f.ajouter("Maths",3);

        Assertions.assertThrows(KeyInvalidExeption.class,()-> f.ajouter("Maths",3));

    }

    /**
     * test du getter de coefficient d'une matiere
     * @throws KeyInvalidExeption
     * @throws ValueExeption
     */
    @Test
    public void test_getCoeff() throws KeyInvalidExeption, ValueExeption {
        Formation f = new Formation(1);
        f.ajouter("SVT",2);
        int coeff= f.getCoef("SVT");
        assertEquals(coeff,2);
    }

    /**
     * test exception, cherche un coef d'une matiere non presente
     * @throws ValueExeption
     * @throws KeyInvalidExeption
     */
    @Test
    public void test_exceptionCoeff_matiere_non_existante() throws ValueExeption, KeyInvalidExeption {
        Formation f = new Formation(1);
        f.ajouter("SVT",2);
        assertThrows(KeyInvalidExeption.class, () ->
              f.getCoef("Fran??ais") );
    }

    /**
     * test exception, ajout d'une matiere avec un coef negatif
     */
    @Test
    public void test_exeption_ajout_Coeff_negatif(){
        Formation f = new Formation(1);
        assertThrows(ValueExeption.class,()->f.ajouter("francais",-2));
    }

    /**
     * test de la methode equals
     * @throws ValueExeption
     * @throws KeyInvalidExeption
     */
    @Test
    public void test_equals() throws ValueExeption, KeyInvalidExeption {
        Formation f = new Formation(1);
        f.ajouter("SVT",2);
        Formation f2 = new Formation(1);
        f.ajouter("SVT",2);
        assertTrue(f.equals(f2));
    }

    /**
     *test que l'instatiation d'une formation se fait correctement
     *      table des matiere vide a la creation
     *      ajout corect des amtiere dans cette table
     */
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
