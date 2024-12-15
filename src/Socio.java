
import java.util.HashMap;
import java.util.LinkedList;

public class Socio {
    private String nome;
    private String cognome;
    private String codiceSocio;
    private HashMap<String,Istruttore>istruttori;
    private LinkedList<Attivita> listActivitiesS;

    public Socio(String nome, String cognome, String codice) {
        this.nome = nome;
        this.cognome = cognome;
        this.codiceSocio = codice;
        istruttori= new HashMap<>();
        listActivitiesS = new LinkedList<>();
    }

    public Socio getSocio(){
        return this;
    }

    public int getSize(){
        return istruttori.size();
    }
    public String getCodiceSocio() {
        return codiceSocio;
    }

    public boolean addIstruttore(Istruttore i){
        if(!istruttori.containsValue(i)){
            istruttori.put(i.getCodiceIstruttore(), i);
            return true;
        }
        return false;
    }

   
    public String toString() {
        return this.nome+this.cognome+this.codiceSocio;
    }
    
    public void addAttività(Attivita a){
        listActivitiesS.add(a);
    }
    

    
}