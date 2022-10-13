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


public class TestCalculMoyenneGroupe {

    Groupe groupe;
    @BeforeEach
    public void preparation_test() throws ValueExeption, KeyInvalidExeption, FormationNotCorresponding {

        Formation form = new Formation(254);
        form.ajouter("Anglais", 2);
        form.ajouter("Francais",1);

        Identite id = new Identite("BASTIEN", "Cedran", "125455225");
        Identite id1 = new Identite("RAOULT", "Juliette", "157795252");
        Identite id2 = new Identite("PIERRE", "Titouan", "174632485");

        Etudiant etudiant1 = new Etudiant(id,form);
        Etudiant etudiant2 = new Etudiant(id1,form);
        Etudiant etudiant3 = new Etudiant(id2,form);

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
