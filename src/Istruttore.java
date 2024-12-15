import java.util.HashMap;
import java.util.LinkedList;

public class Istruttore {
    private String nome;
    private String cognome;
    private String codiceIstruttore;
    private HashMap<String,Socio> listaSoci;
    private LinkedList<Attivita> listActivitiesI;
    public Istruttore(String nome, String cognome, String codiceIstruttore) {
        this.nome = nome;
        this.cognome = cognome;
        this.codiceIstruttore = codiceIstruttore;
        listaSoci = new HashMap<>();
        listActivitiesI= new LinkedList<>();
    }


    public int getSize(){
        return listaSoci.size();
    }

    public Istruttore getIstruttore(){
        return this;
    }

    public boolean addSocio(Socio s){
        if(!listaSoci.containsValue(s)){
            listaSoci.put(s.getCodiceSocio(), s);
            return true;
        }
        return false;
        
    }

    public String getCodiceIstruttore() {
        return codiceIstruttore;
    }

    public boolean removeSocio(String codiceSocio){
        if(listaSoci.containsKey(codiceSocio)){
            listaSoci.remove(codiceSocio);
            return true;

        }
        return false;
    }

    public boolean checkSocio(String s){
        return listaSoci.containsKey(s);
    }

    public String getSoci(){
        String retValue="";
        for (Socio s : listaSoci.values()) {
            retValue+=s;
        }
        return retValue;
    }
    
    public void addAttività(Attivita a){
        listActivitiesI.add(a);
    }
    
    


    
    
}