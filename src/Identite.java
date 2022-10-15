public class Identite {

    private String nom;     // nom de l'etudiant
    private String prenom;  // prenom de l'etudiant
    private String NIP;     // numero de l'etudiant

    /**
     * constructeur d'une identite
     * @param n nom de l'etudiant
     * @param p prenom de l'etudiant
     * @param NIP numero de l'etudiant
     */
    public Identite(String n, String p , String NIP){
        this.nom = n;
        this.prenom = p;
        this.NIP=NIP;
    }


    ////////////////////////
    //      GETTER        //
    ////////////////////////


    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNIP() {
        return NIP;
    }
}
