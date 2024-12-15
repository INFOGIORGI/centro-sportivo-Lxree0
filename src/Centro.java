import java.util.HashMap;
import java.util.LinkedList;


public class Centro {
    private HashMap<String,Istruttore> istruttori;
    private HashMap<String,Socio> soci;
    private LinkedList<Attivita> listaAttivita;
    public Centro() {

        istruttori= new HashMap<>();
        soci=new HashMap<>();
        listaAttivita = new LinkedList<>();
    }


    public boolean addSocio(String nome,String cognome,String codice){
        if(!soci.containsKey(codice)){
            Socio s = new Socio(nome, cognome, codice);
            soci.put(codice, s);
            return true;

        }
        return false;
    }

    public boolean addIstruttore(String nome,String cognome,String codice){
        if(!istruttori.containsKey(codice)){
            Istruttore s = new Istruttore(nome, cognome, codice);
            istruttori.put(codice, s);
            return true;

        }
        return false;
    }


    public boolean removeSocio(String codice){
        if(soci.containsKey(codice)==true && soci.get(codice).getSize()==0){
            soci.remove(codice);
            return true;
        }
        return false;
    }

    
    public boolean removeIstruttore(String codice){
        if(istruttori.containsKey(codice)==true && istruttori.get(codice).getSize()==0){
            istruttori.remove(codice);
            return true;
        }
        return false;
    }

    public String getSoci(String codIstruttore){
        return istruttori.get(codIstruttore).getSoci();
            
        
    }

    public boolean assegna(String codSocio,String codIstruttore){
        
        if(istruttori.containsKey(codIstruttore)&&soci.containsKey(codSocio)){
            Socio s = soci.get(codSocio);
            Istruttore i = istruttori.get(codIstruttore);

            if(i.addSocio(s)==true && s.addIstruttore(i)==true){
                i.addSocio(s);
                s.addIstruttore(i);
                return true;

            }
            
        }
        return false;
        
    }

    public boolean removeAssegnazione(String codSocio,String codIstruttore){
        if(istruttori.containsKey(codIstruttore)&&soci.containsKey(codSocio)){
            if(istruttori.get(codIstruttore).removeSocio(codSocio)==true){
                istruttori.get(codIstruttore).removeSocio(codSocio);
                return true;
            }
        }
        return false;
    }


    public boolean addAttività(String codSocio,String codIstruttore,String data,String oraI,String oraF){
        Attivita a = new Attivita(soci.get(codSocio),istruttori.get(codIstruttore), data, oraI, oraF);
        if(istruttori.get(codIstruttore).checkSocio(codSocio)){
            for (Attivita att : listaAttivita) {
                if(att.getData().equals(data)){
                    if(att.getOraInizio().compareTo(oraI)>=0&&att.getOraFine().compareTo(oraF)<=0||att.getOraInizio().compareTo(oraI)<=0 && att.getOraFine().compareTo(oraI)>=0||att.getOraInizio().compareTo(oraF)<=0&&att.getOraFine().compareTo(oraF)>=0){
                        return false;
                    }else{
                        listaAttivita.add(a);
                        return true;
                    }
                        
                    
                }
            }
            listaAttivita.add(a);
            return true;
            
            
        }
        return false;
    }


    



}
