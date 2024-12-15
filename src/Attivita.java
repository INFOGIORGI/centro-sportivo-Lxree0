public class Attivita {
    private Socio s;
    private Istruttore i;
    private String data;
    private String oraInizio;
    private String oraFine;
    private String Descrizione;
    public Attivita(Socio s, Istruttore i, String data, String oraInizio, String oraFine) {
        this.s = s;
        this.i = i;
        this.data = data;
        this.oraInizio = oraInizio.replace(":","");
        this.oraFine = oraFine.replace(":","");
    }

    public String getOraFine() {
        return oraFine;
    }
    public String getOraInizio() {
        return oraInizio;
    }

    public boolean controlloOra(String ora1,String ora2){
        String newdataI = ora1.replace(":", "");
        String newdataf = ora2.replace(":", "");
        if(ora1.compareTo(newdataI)<0 && ora2.compareTo(newdataf)>0){
            return true;
        }
        return false;
    }
    public String getData() {
        return data;
    }
   


}
    






