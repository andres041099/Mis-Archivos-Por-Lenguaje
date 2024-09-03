
import java.io.BufferedReader;
import java.io.FileReader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Virginia
 */
public class AbrirArchivo {
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("C:\\Users\\Virginia\\Documents\\programacionII202110\\programacionII202110\\src\\datos");
                    BufferedReader br = new BufferedReader(fr);
                    String archivo;
                   while ((archivo= br.readLine())!=null){
                       System.out.println(""+archivo);
                
                    }
        } catch (Exception e) {
        }
    }
}
