import java.util.HashMap;


public class Centro {
    private HashMap<String,Istruttore> istruttori;
    private HashMap<String,Socio> soci;
    private HashMap<String,Attivita> listaAttivita;
    public Centro() {

        istruttori= new HashMap<>();
        soci=new HashMap<>();
        listaAttivita = new HashMap<>();
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
        if(istruttori.get(codIstruttore).checkSocio(codSocio)){
            if(listaAttivita.containsKey(data)){
                if(!listaAttivita.get(data).controlloOra(oraI, oraF)){
                    Attivita a = new Attivita(soci.get(codSocio),istruttori.get(codIstruttore), data, oraI, oraF);
                    listaAttivita.put(data, a);
                    return true;
                }
                
            }
            Attivita a = new Attivita(soci.get(codSocio),istruttori.get(codIstruttore), data, oraI, oraF);
            listaAttivita.put(data, a);
            return true;
            
            
        }
        return false;
    }


    



}
