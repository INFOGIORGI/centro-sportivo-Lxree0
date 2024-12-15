import java.io.File;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        String path = "";
        Centro c = new Centro();
        input(path, c);
        String fileName = "output.txt";
        String content = "Questo è un messaggio di esempio.";

        // Chiama il metodo per scrivere nel file
        writeToFile(fileName, content);

        System.out.println("Scrittura completata su " + fileName);



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

     // Metodo per scrivere su un file di testo
     public static void writeToFile(String fileName, String content) {
        // Usa un BufferedWriter per migliorare le prestazioni di scrittura
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            // Scrive il contenuto nel file
            writer.write(content);
            writer.newLine(); // Aggiunge una nuova linea dopo il contenuto
        } catch (IOException e) {
            // Gestisce le eccezioni di I/O
            System.err.println("Errore durante la scrittura su file: " + e.getMessage());
        }
    }
}