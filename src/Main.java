import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String path = "input.txt";
        Centro c = new Centro();
        input(path, c);

        



    }
    public static void input(String percorso, Centro c){
        File file = new File(percorso);
        try {
            Scanner tScanner = new Scanner(file);
            while (tScanner.hasNextLine()) {
                String s = tScanner.nextLine();
                String []sp = s.split(";");
                if(sp[1]=="I"){
                    
                    c.addIstruttore(sp[2], sp[3], sp[4]);
                }
                if(sp[1]=="S"){
                    
                    c.addIstruttore(sp[2], sp[3], sp[4]);
                }
            }
            tScanner.close();
            
        } catch (Exception e) {
            // TODO: handle exception
        }
        
    }
}