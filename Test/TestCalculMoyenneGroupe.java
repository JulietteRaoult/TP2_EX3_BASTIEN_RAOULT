import Exeption.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TestCalculMoyenneGroupe {

    Groupe groupe;
    @BeforeEach
    public void preparation_test() throws ValueExeption, KeyInvalidExeption, FormationNotCorresponding {

        Formation form = new Formation(254);
        form.ajouter("Anglais", 2);
        form.ajouter("Francais",1);
        form.ajouter("Mathématiques",1);
        form.ajouter("SVT",2);

        Identite id = new Identite("BASTIEN", "Cedran", "125455225");
        Identite id1 = new Identite("RAOULT", "Juliette", "157795252");
        Identite id2 = new Identite("PIERRE", "Titouan", "174632485");

        Etudiant etudiant1 = new Etudiant(id,form);
        Etudiant etudiant2 = new Etudiant(id1,form);
        Etudiant etudiant3 = new Etudiant(id2,form);

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
    public void test_calculMoyenneMatiere() throws KeyInvalidExeption, EtudiantNotFoundException {
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

    // test is empty voir formation

    @Test
    public void test_calculMoyennePasEtudiants() throws ValueExeption, KeyInvalidExeption {

        Formation f = new Formation(34);
        f.ajouter("Math",2);
        Groupe g = new Groupe(f);

        Assertions.assertThrows(EtudiantNotFoundException.class,()->g.calculerMoyenneGroupeMatiere("Math"));
    }


}
