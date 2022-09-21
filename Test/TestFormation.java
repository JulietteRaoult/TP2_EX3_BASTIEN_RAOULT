import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestFormation {

    @Test
    public void test_supprimer(){
        Map<String,Integer> map = new HashMap<String, Integer>();
        map.put("Maths",3);
        map.put("SVT",2);
        Formation f = new Formation(1,map);
        Map<String,Integer> map2 = new HashMap<String, Integer>();
        map2.put("SVT",2);
        f.supprimer("Maths");
        assertEquals(map,map2);
    }

    @Test
    public void test_ajouter(){
        Map<String,Integer> map2 = new HashMap<String, Integer>();
        map2.put("SVT",2);

        Map<String,Integer> map = new HashMap<String, Integer>();
        map.put("Maths",3);
        map.put("SVT",2);

        Formation f = new Formation(1,map2);
        f.ajouter("Maths",3);
        assertEquals(map,map2);
    }

    @Test
    public void test_getCoeff() throws KeyInvalidExeption {
        Map<String,Integer> map = new HashMap<String, Integer>();
        map.put("SVT",2);
        Formation f = new Formation(2,map);
        int coeff= f.getCoef("SVT");
        assertEquals(coeff,2);
    }

}